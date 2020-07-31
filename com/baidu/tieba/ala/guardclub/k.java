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
import com.baidu.live.sdk.a;
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
import com.baidu.tieba.ala.guardclub.i;
import java.util.List;
/* loaded from: classes4.dex */
public class k extends BdBaseView<GuardClubMemberListActivity> {
    private String aNP;
    private boolean azm;
    private CommonEmptyView bjW;
    private BaseActivity bpg;
    CustomMessageListener fEy;
    private View fPA;
    private i fPB;
    private boolean fPC;
    private boolean fPD;
    private View.OnClickListener fPE;
    private final boolean fPa;
    private com.baidu.tieba.ala.guardclub.model.g fPp;
    private BdListView fPq;
    private LoadMoreFooter fPr;
    private LinearLayout fPs;
    private TextView fPt;
    private HeadImageView fPu;
    private TbImageView fPv;
    private TextView fPw;
    private TextView fPx;
    private TextView fPy;
    private View fPz;
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
        if (this.fPB != null) {
            this.fPB.a(fVar);
        }
        if (z && !this.azm && fVar != null && !this.fPa) {
            this.fPs.setVisibility(0);
            this.fPt.setText(fVar.rank);
            if (fO(fVar.rank)) {
                this.fPt.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.fPt.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.fPw.setText(fVar.userName);
            if (fVar.aSz > 0) {
                this.fPx.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aSz));
            } else {
                this.fPx.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.fPu.startLoad(fVar.aSW, 12, false);
            String cB = com.baidu.live.guardclub.g.CJ().cB(fVar.aSy);
            if (!TextUtils.isEmpty(cB)) {
                this.fPv.startLoad(cB, 10, false);
                this.fPv.setVisibility(0);
            } else {
                this.fPv.setVisibility(4);
            }
            if (!this.isFullScreen && !this.fPD) {
                z2 = false;
            }
            this.fPy.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fPz.getLayoutParams();
                layoutParams.rightMargin = this.fPz.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.fPz.setLayoutParams(layoutParams);
            }
            this.fPA.setVisibility(0);
            this.fPA.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.fPA.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aSz;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aSz <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.fPA.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.fPA.setLayoutParams(layoutParams2);
                }
            });
            this.fPy.setOnClickListener(this.fPE);
            return;
        }
        this.fPs.setVisibility(8);
    }

    private boolean fO(String str) {
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
        this.fPE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bpg != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bpg.getActivity().setResult(-1);
                        k.this.bpg.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hs().aZn.aBC) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bpg.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.fPB != null) {
                        k.this.fPB.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bpg = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.fPa = z3;
        this.isFullScreen = z4;
        this.fPC = z2;
        this.azm = z;
        this.mRootView = LayoutInflater.from(this.bpg).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.fPq = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.bjW = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.fPs = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        zN();
        this.fPt = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.fPu = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.fPv = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.fPw = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.fPx = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.fPy = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.fPz = this.mRootView.findViewById(a.g.view_contribution_max);
        this.fPA = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.fPu.setIsRound(true);
        this.fPu.setAutoChangeStyle(false);
        this.fPB = new i(baseActivity, bdUniqueId, z, z3);
        this.fPB.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bpg, k.this.bpg.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bpg.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aSU ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aNP, k.this.otherParams, true)));
                }
            }
        });
        this.fPq.setAdapter((ListAdapter) this.fPB);
        if (z3) {
            this.fPr = new LoadMoreFooter(this.bpg);
            this.fPr.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.fPr.createView();
            this.fPq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.fPr.isLoading() && k.this.fPp.bAR() && i + i2 > i3 - 2 && k.this.fPp.bAR()) {
                        k.this.fPp.bAT();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fEy);
    }

    public void setFeedId(String str) {
        this.aNP = str;
    }

    public final void zN() {
        if (this.fPs != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bpg.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.fPs.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.fPs.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bpg.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.fPs.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void kQ(boolean z) {
        this.fPD = z;
    }

    public void completePullRefresh() {
        if (this.fPq != null) {
            this.fPq.completePullRefresh();
        }
    }

    public void bAM() {
        if (this.fPr != null) {
            this.fPr.endLoadData();
            this.fPq.setNextPage(null);
        }
    }

    public void kR(boolean z) {
        if (z) {
            if (this.fPr != null) {
                this.fPq.setNextPage(null);
            }
        } else if (this.fPr != null) {
            if (this.fPr.getView().getParent() == null) {
                this.fPq.setNextPage(this.fPr);
            }
            this.fPr.showNoMoreData();
        }
    }

    public void bwT() {
        if (this.fPr != null) {
            if (this.fPr.getView().getParent() == null) {
                this.fPq.setNextPage(this.fPr);
            }
            this.fPr.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fPB != null) {
            this.fPB.setOtherParams(str);
        }
    }

    private void bxb() {
        bx(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.fPp = gVar;
        this.fPp.bAS();
    }

    public void bN(List<com.baidu.live.guardclub.f> list) {
        if (this.fPB != null && list != null && !list.isEmpty()) {
            bx(0, 8);
            this.fPB.bN(list);
            return;
        }
        bxb();
    }

    public void bAN() {
        buK();
    }

    public void buK() {
        this.bjW.reset();
        this.bjW.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bjW.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fPp != null) {
                    k.this.fPp.bAS();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bjW.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bjW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bjW.setVisibility(0);
        this.fPq.setVisibility(8);
        this.fPs.setVisibility(8);
    }

    private void bx(int i, int i2) {
        this.fPq.setVisibility(i);
        if (i2 == 0) {
            this.bjW.reset();
            if (this.azm) {
                this.bjW.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.bjW.setTitle(a.i.guard_member_list_empty);
            }
            this.bjW.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bjW.setVisibility(0);
            return;
        }
        this.bjW.setVisibility(8);
    }

    public void bO(List<com.baidu.live.guardclub.f> list) {
        if (this.fPB != null && this.fPa) {
            this.fPB.bO(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bAK() {
        if (this.fPB != null) {
            this.fPB.bAK();
        }
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }
}
