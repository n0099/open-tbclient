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
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.i;
import java.util.List;
/* loaded from: classes3.dex */
public class k extends BdBaseView<GuardClubMemberListActivity> {
    private CommonEmptyView aWT;
    private boolean aqL;
    private BaseActivity bcd;
    CustomMessageListener fal;
    private com.baidu.tieba.ala.guardclub.model.g fkO;
    private BdListView fkP;
    private LoadMoreFooter fkQ;
    private LinearLayout fkR;
    private TextView fkS;
    private HeadImageView fkT;
    private TbImageView fkU;
    private TextView fkV;
    private TextView fkW;
    private TextView fkX;
    private View fkY;
    private View fkZ;
    private final boolean fkz;
    private i fla;
    private boolean flb;
    private boolean flc;
    private View.OnClickListener fld;
    private boolean isFullScreen;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;

    public View getView() {
        return this.mRootView;
    }

    public void a(boolean z, final com.baidu.live.guardclub.f fVar) {
        boolean z2 = true;
        if (this.fla != null) {
            this.fla.a(fVar);
        }
        if (z && !this.aqL && fVar != null && !this.fkz) {
            this.fkR.setVisibility(0);
            this.fkS.setText(fVar.rank);
            if (eW(fVar.rank)) {
                this.fkS.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.fkS.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.fkV.setText(fVar.userName);
            if (fVar.aIL > 0) {
                this.fkW.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aIL));
            } else {
                this.fkW.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.fkT.startLoad(fVar.aJi, 12, false);
            String cg = com.baidu.live.guardclub.g.As().cg(fVar.aIK);
            if (!TextUtils.isEmpty(cg)) {
                this.fkU.startLoad(cg, 10, false);
                this.fkU.setVisibility(0);
            } else {
                this.fkU.setVisibility(4);
            }
            if (!this.isFullScreen && !this.flc) {
                z2 = false;
            }
            this.fkX.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkY.getLayoutParams();
                layoutParams.rightMargin = this.fkY.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.fkY.setLayoutParams(layoutParams);
            }
            this.fkZ.setVisibility(0);
            this.fkZ.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.fkZ.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aIL;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aIL <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.fkZ.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.fkZ.setLayoutParams(layoutParams2);
                }
            });
            this.fkX.setOnClickListener(this.fld);
            return;
        }
        this.fkR.setVisibility(8);
    }

    private boolean eW(String str) {
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

    public k(BaseActivity baseActivity, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.fld = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bcd != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bcd.getActivity().setResult(-1);
                        k.this.bcd.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Eo().aQp.asU) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bcd.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.fla != null) {
                        k.this.fla.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bcd = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.fkz = z3;
        this.isFullScreen = z4;
        this.flb = z2;
        this.aqL = z;
        this.mRootView = LayoutInflater.from(this.bcd).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.fkP = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aWT = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.fkR = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        xy();
        this.fkS = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.fkT = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.fkU = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.fkV = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.fkW = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.fkX = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.fkY = this.mRootView.findViewById(a.g.view_contribution_max);
        this.fkZ = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.fkT.setIsRound(true);
        this.fkT.setAutoChangeStyle(false);
        this.fla = new i(baseActivity, bdUniqueId, z, z3);
        this.fla.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bcd, k.this.bcd.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bcd.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aJg ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.otherParams, true)));
                }
            }
        });
        this.fkP.setAdapter((ListAdapter) this.fla);
        if (z3) {
            this.fkQ = new LoadMoreFooter(this.bcd);
            this.fkQ.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.fkQ.createView();
            this.fkP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.fkQ.isLoading() && k.this.fkO.boN() && i + i2 > i3 - 2 && k.this.fkO.boN()) {
                        k.this.fkO.boP();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fal);
    }

    public final void xy() {
        if (this.fkR != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bcd.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.fkR.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.fkR.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bcd.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.fkR.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void jF(boolean z) {
        this.flc = z;
    }

    public void completePullRefresh() {
        if (this.fkP != null) {
            this.fkP.completePullRefresh();
        }
    }

    public void boI() {
        if (this.fkQ != null) {
            this.fkQ.endLoadData();
            this.fkP.setNextPage(null);
        }
    }

    public void jG(boolean z) {
        if (z) {
            if (this.fkQ != null) {
                this.fkP.setNextPage(null);
            }
        } else if (this.fkQ != null) {
            if (this.fkQ.getView().getParent() == null) {
                this.fkP.setNextPage(this.fkQ);
            }
            this.fkQ.showNoMoreData();
        }
    }

    public void blq() {
        if (this.fkQ != null) {
            if (this.fkQ.getView().getParent() == null) {
                this.fkP.setNextPage(this.fkQ);
            }
            this.fkQ.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fla != null) {
            this.fla.setOtherParams(str);
        }
    }

    private void aqF() {
        bn(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.fkO = gVar;
        this.fkO.boO();
    }

    public void bD(List<com.baidu.live.guardclub.f> list) {
        if (this.fla != null && list != null && !list.isEmpty()) {
            bn(0, 8);
            this.fla.bD(list);
            return;
        }
        aqF();
    }

    public void boJ() {
        bjJ();
    }

    public void bjJ() {
        this.aWT.reset();
        this.aWT.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aWT.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fkO != null) {
                    k.this.fkO.boO();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aWT.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aWT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aWT.setVisibility(0);
        this.fkP.setVisibility(8);
        this.fkR.setVisibility(8);
    }

    private void bn(int i, int i2) {
        this.fkP.setVisibility(i);
        if (i2 == 0) {
            this.aWT.reset();
            if (this.aqL) {
                this.aWT.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aWT.setTitle(a.i.guard_member_list_empty);
            }
            this.aWT.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aWT.setVisibility(0);
            return;
        }
        this.aWT.setVisibility(8);
    }

    public void bE(List<com.baidu.live.guardclub.f> list) {
        if (this.fla != null && this.fkz) {
            this.fla.bE(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void boG() {
        if (this.fla != null) {
            this.fla.boG();
        }
        MessageManager.getInstance().unRegisterListener(this.fal);
    }
}
