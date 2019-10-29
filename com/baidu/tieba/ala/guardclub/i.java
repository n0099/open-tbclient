package com.baidu.tieba.ala.guardclub;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardclub.g;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends BdBaseView<GuardClubMemberListActivity> {
    private boolean PW;
    private CommonEmptyView aqz;
    private BaseActivity atC;
    CustomMessageListener dFq;
    private final boolean dMA;
    private com.baidu.tieba.ala.guardclub.model.l dMP;
    private BdListView dMQ;
    private LoadMoreFooter dMR;
    private LinearLayout dMS;
    private TextView dMT;
    private HeadImageView dMU;
    private TbImageView dMV;
    private TextView dMW;
    private TextView dMX;
    private TextView dMY;
    private View dMZ;
    private View dNa;
    private g dNb;
    private boolean dNc;
    private boolean dNd;
    private View.OnClickListener dNe;
    private boolean isFullScreen;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;

    public View getView() {
        return this.mRootView;
    }

    public void a(boolean z, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        boolean z2 = true;
        if (this.dNb != null) {
            this.dNb.a(kVar);
        }
        if (z && !this.PW && kVar != null && !this.dMA) {
            this.dMS.setVisibility(0);
            this.dMT.setText(kVar.rank);
            if (cU(kVar.rank)) {
                this.dMT.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.dMT.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.dMW.setText(kVar.userName);
            if (kVar.dOd > 0) {
                this.dMX.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score + "/" + kVar.dOd));
            } else {
                this.dMX.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score));
            }
            this.dMU.startLoad(kVar.dmo, 12, false);
            String mM = m.aLx().mM(kVar.dOc);
            if (!TextUtils.isEmpty(mM)) {
                this.dMV.startLoad(mM, 10, false);
                this.dMV.setVisibility(0);
            } else {
                this.dMV.setVisibility(4);
            }
            if (!this.isFullScreen && !this.dNd) {
                z2 = false;
            }
            this.dMY.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dMZ.getLayoutParams();
                layoutParams.rightMargin = this.dMZ.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.dMZ.setLayoutParams(layoutParams);
            }
            this.dNa.setVisibility(0);
            this.dNa.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) i.this.dNa.getParent()).getWidth();
                    double parseLong = (Long.parseLong(kVar.score) * 1.0d) / kVar.dOd;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (kVar.dOd <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = i.this.dNa.getLayoutParams();
                    layoutParams2.width = i;
                    i.this.dNa.setLayoutParams(layoutParams2);
                }
            });
            this.dMY.setOnClickListener(this.dNe);
            return;
        }
        this.dMS.setVisibility(8);
    }

    private boolean cU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public i(BaseActivity baseActivity, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.dNe = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.atC != null) {
                    if (!i.this.isFullScreen) {
                        i.this.atC.getActivity().setResult(-1);
                        i.this.atC.getActivity().finish();
                        return;
                    }
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(i.this.atC.getActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(i.this.liveId, String.valueOf(i.this.roomId), TbConfig.getLiveEnterFrom());
                    alaLiveRoomActivityConfig.addExtraByParams(i.this.otherParams);
                    alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        };
        this.dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.i.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    i.this.otherParams = str;
                    if (i.this.dNb != null) {
                        i.this.dNb.setOtherParams(i.this.otherParams);
                    }
                }
            }
        };
        this.atC = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.dMA = z3;
        this.isFullScreen = z4;
        this.dNc = z2;
        this.PW = z;
        this.mRootView = LayoutInflater.from(this.atC).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.dMQ = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aqz = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.dMS = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        pZ();
        this.dMT = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.dMU = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.dMV = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.dMW = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.dMX = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.dMY = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.dMZ = this.mRootView.findViewById(a.g.view_contribution_max);
        this.dNa = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.dMU.setIsRound(true);
        this.dMU.setAutoChangeStyle(false);
        this.dNb = new g(baseActivity, bdUniqueId, z, z3);
        this.dNb.a(new g.b() { // from class: com.baidu.tieba.ala.guardclub.i.2
            @Override // com.baidu.tieba.ala.guardclub.g.b
            public void d(com.baidu.tieba.ala.guardclub.model.k kVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(i.this.atC, i.this.atC.getString(a.i.sdk_neterror));
                } else if (kVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(i.this.atC.getActivity(), String.valueOf(kVar.userId), kVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, kVar.dHB ? 1 : 0, "", "", false, null, null, kVar.userName, i.this.otherParams, true)));
                }
            }
        });
        this.dMQ.setAdapter((ListAdapter) this.dNb);
        if (z3) {
            this.dMR = new LoadMoreFooter(this.atC);
            this.dMR.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.dMR.createView();
            this.dMQ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!i.this.dMR.isLoading() && i.this.dMP.aLE() && i + i2 > i3 - 2 && i.this.dMP.aLE()) {
                        i.this.dMP.aLG();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.dFq);
    }

    public final void pZ() {
        if (this.dMS != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.atC.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.dMS.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.dMS.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.atC.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.dMS.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void he(boolean z) {
        this.dNd = z;
    }

    public void completePullRefresh() {
        if (this.dMQ != null) {
            this.dMQ.completePullRefresh();
        }
    }

    public void aLr() {
        if (this.dMR != null) {
            this.dMR.endLoadData();
            this.dMQ.setNextPage(null);
        }
    }

    public void hf(boolean z) {
        if (z) {
            if (this.dMR != null) {
                this.dMQ.setNextPage(null);
            }
        } else if (this.dMR != null) {
            if (this.dMR.getView().getParent() == null) {
                this.dMQ.setNextPage(this.dMR);
            }
            this.dMR.showNoMoreData();
        }
    }

    public void aJl() {
        if (this.dMR != null) {
            if (this.dMR.getView().getParent() == null) {
                this.dMQ.setNextPage(this.dMR);
            }
            this.dMR.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.dNb != null) {
            this.dNb.setOtherParams(str);
        }
    }

    private void aFU() {
        aP(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.l lVar) {
        this.dMP = lVar;
        this.dMP.aLF();
    }

    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.dNb != null && list != null && !list.isEmpty()) {
            aP(0, 8);
            this.dNb.bv(list);
            return;
        }
        aFU();
    }

    public void aLs() {
        aLt();
    }

    public void aLt() {
        this.aqz.reset();
        this.aqz.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aqz.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.dMP != null) {
                    i.this.dMP.aLF();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aqz.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aqz.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aqz.setVisibility(0);
        this.dMQ.setVisibility(8);
        this.dMS.setVisibility(8);
    }

    private void aP(int i, int i2) {
        this.dMQ.setVisibility(i);
        if (i2 == 0) {
            this.aqz.reset();
            if (this.PW) {
                this.aqz.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aqz.setTitle(a.i.guard_member_list_empty);
            }
            this.aqz.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aqz.setVisibility(0);
            return;
        }
        this.aqz.setVisibility(8);
    }

    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.dNb != null && this.dMA) {
            this.dNb.bw(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLp() {
        if (this.dNb != null) {
            this.dNb.aLp();
        }
        MessageManager.getInstance().unRegisterListener(this.dFq);
    }
}
