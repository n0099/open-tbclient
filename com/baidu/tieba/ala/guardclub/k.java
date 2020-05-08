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
    private CommonEmptyView aWY;
    private boolean aqR;
    private BaseActivity bci;
    CustomMessageListener faq;
    private final boolean fkE;
    private com.baidu.tieba.ala.guardclub.model.g fkT;
    private BdListView fkU;
    private LoadMoreFooter fkV;
    private LinearLayout fkW;
    private TextView fkX;
    private HeadImageView fkY;
    private TbImageView fkZ;
    private TextView fla;
    private TextView flb;
    private TextView flc;
    private View fld;
    private View fle;
    private i flf;
    private boolean flg;
    private boolean flh;
    private View.OnClickListener fli;
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
        if (this.flf != null) {
            this.flf.a(fVar);
        }
        if (z && !this.aqR && fVar != null && !this.fkE) {
            this.fkW.setVisibility(0);
            this.fkX.setText(fVar.rank);
            if (eW(fVar.rank)) {
                this.fkX.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.fkX.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.fla.setText(fVar.userName);
            if (fVar.aIR > 0) {
                this.flb.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aIR));
            } else {
                this.flb.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.fkY.startLoad(fVar.aJo, 12, false);
            String cg = com.baidu.live.guardclub.g.Ar().cg(fVar.aIQ);
            if (!TextUtils.isEmpty(cg)) {
                this.fkZ.startLoad(cg, 10, false);
                this.fkZ.setVisibility(0);
            } else {
                this.fkZ.setVisibility(4);
            }
            if (!this.isFullScreen && !this.flh) {
                z2 = false;
            }
            this.flc.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fld.getLayoutParams();
                layoutParams.rightMargin = this.fld.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.fld.setLayoutParams(layoutParams);
            }
            this.fle.setVisibility(0);
            this.fle.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.fle.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aIR;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aIR <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.fle.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.fle.setLayoutParams(layoutParams2);
                }
            });
            this.flc.setOnClickListener(this.fli);
            return;
        }
        this.fkW.setVisibility(8);
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
        this.fli = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bci != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bci.getActivity().setResult(-1);
                        k.this.bci.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.En().aQu.ata) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bci.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.flf != null) {
                        k.this.flf.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bci = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.fkE = z3;
        this.isFullScreen = z4;
        this.flg = z2;
        this.aqR = z;
        this.mRootView = LayoutInflater.from(this.bci).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.fkU = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aWY = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.fkW = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        xx();
        this.fkX = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.fkY = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.fkZ = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.fla = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.flb = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.flc = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.fld = this.mRootView.findViewById(a.g.view_contribution_max);
        this.fle = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.fkY.setIsRound(true);
        this.fkY.setAutoChangeStyle(false);
        this.flf = new i(baseActivity, bdUniqueId, z, z3);
        this.flf.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bci, k.this.bci.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bci.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aJm ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.otherParams, true)));
                }
            }
        });
        this.fkU.setAdapter((ListAdapter) this.flf);
        if (z3) {
            this.fkV = new LoadMoreFooter(this.bci);
            this.fkV.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.fkV.createView();
            this.fkU.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.fkV.isLoading() && k.this.fkT.boL() && i + i2 > i3 - 2 && k.this.fkT.boL()) {
                        k.this.fkT.boN();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.faq);
    }

    public final void xx() {
        if (this.fkW != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bci.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.fkW.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.fkW.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bci.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.fkW.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void jF(boolean z) {
        this.flh = z;
    }

    public void completePullRefresh() {
        if (this.fkU != null) {
            this.fkU.completePullRefresh();
        }
    }

    public void boG() {
        if (this.fkV != null) {
            this.fkV.endLoadData();
            this.fkU.setNextPage(null);
        }
    }

    public void jG(boolean z) {
        if (z) {
            if (this.fkV != null) {
                this.fkU.setNextPage(null);
            }
        } else if (this.fkV != null) {
            if (this.fkV.getView().getParent() == null) {
                this.fkU.setNextPage(this.fkV);
            }
            this.fkV.showNoMoreData();
        }
    }

    public void blo() {
        if (this.fkV != null) {
            if (this.fkV.getView().getParent() == null) {
                this.fkU.setNextPage(this.fkV);
            }
            this.fkV.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.flf != null) {
            this.flf.setOtherParams(str);
        }
    }

    private void aqE() {
        bn(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.fkT = gVar;
        this.fkT.boM();
    }

    public void bD(List<com.baidu.live.guardclub.f> list) {
        if (this.flf != null && list != null && !list.isEmpty()) {
            bn(0, 8);
            this.flf.bD(list);
            return;
        }
        aqE();
    }

    public void boH() {
        bjH();
    }

    public void bjH() {
        this.aWY.reset();
        this.aWY.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aWY.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fkT != null) {
                    k.this.fkT.boM();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aWY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aWY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aWY.setVisibility(0);
        this.fkU.setVisibility(8);
        this.fkW.setVisibility(8);
    }

    private void bn(int i, int i2) {
        this.fkU.setVisibility(i);
        if (i2 == 0) {
            this.aWY.reset();
            if (this.aqR) {
                this.aWY.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aWY.setTitle(a.i.guard_member_list_empty);
            }
            this.aWY.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aWY.setVisibility(0);
            return;
        }
        this.aWY.setVisibility(8);
    }

    public void bE(List<com.baidu.live.guardclub.f> list) {
        if (this.flf != null && this.fkE) {
            this.flf.bE(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void boE() {
        if (this.flf != null) {
            this.flf.boE();
        }
        MessageManager.getInstance().unRegisterListener(this.faq);
    }
}
