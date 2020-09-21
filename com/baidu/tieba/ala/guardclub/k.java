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
    private boolean aFD;
    private String aVs;
    private CommonEmptyView bsN;
    private BaseActivity byl;
    CustomMessageListener fTe;
    private com.baidu.tieba.ala.guardclub.model.g geF;
    private BdListView geG;
    private LoadMoreFooter geH;
    private LinearLayout geI;
    private TextView geJ;
    private HeadImageView geK;
    private TbImageView geL;
    private TextView geM;
    private TextView geN;
    private TextView geO;
    private View geP;
    private View geQ;
    private i geR;
    private boolean geS;
    private boolean geT;
    private View.OnClickListener geU;
    private final boolean geq;
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
        if (this.geR != null) {
            this.geR.a(fVar);
        }
        if (z && !this.aFD && fVar != null && !this.geq) {
            this.geI.setVisibility(0);
            this.geJ.setText(fVar.rank);
            if (hz(fVar.rank)) {
                this.geJ.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.geJ.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.geM.setText(fVar.userName);
            if (fVar.bam > 0) {
                this.geN.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.bam));
            } else {
                this.geN.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.geK.startLoad(fVar.baJ, 12, false);
            String ev = com.baidu.live.guardclub.g.IP().ev(fVar.bal);
            if (!TextUtils.isEmpty(ev)) {
                this.geL.startLoad(ev, 10, false);
                this.geL.setVisibility(0);
            } else {
                this.geL.setVisibility(4);
            }
            if (!this.isFullScreen && !this.geT) {
                z2 = false;
            }
            this.geO.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.geP.getLayoutParams();
                layoutParams.rightMargin = this.geP.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.geP.setLayoutParams(layoutParams);
            }
            this.geQ.setVisibility(0);
            this.geQ.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.geQ.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.bam;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.bam <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.geQ.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.geQ.setLayoutParams(layoutParams2);
                }
            });
            this.geO.setOnClickListener(this.geU);
            return;
        }
        this.geI.setVisibility(8);
    }

    private boolean hz(String str) {
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
        this.geU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.byl != null) {
                    if (!k.this.isFullScreen) {
                        k.this.byl.getActivity().setResult(-1);
                        k.this.byl.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.NN().bhy.aId) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.byl.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.geR != null) {
                        k.this.geR.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.byl = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.geq = z3;
        this.isFullScreen = z4;
        this.geS = z2;
        this.aFD = z;
        this.mRootView = LayoutInflater.from(this.byl).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.geG = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.bsN = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.geI = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        FQ();
        this.geJ = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.geK = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.geL = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.geM = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.geN = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.geO = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.geP = this.mRootView.findViewById(a.g.view_contribution_max);
        this.geQ = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.geK.setIsRound(true);
        this.geK.setAutoChangeStyle(false);
        this.geR = new i(baseActivity, bdUniqueId, z, z3);
        this.geR.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.byl, k.this.byl.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.byl.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aVs, k.this.otherParams, true)));
                }
            }
        });
        this.geG.setAdapter((ListAdapter) this.geR);
        if (z3) {
            this.geH = new LoadMoreFooter(this.byl);
            this.geH.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.geH.createView();
            this.geG.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.geH.isLoading() && k.this.geF.bLw() && i + i2 > i3 - 2 && k.this.geF.bLw()) {
                        k.this.geF.bLy();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fTe);
    }

    public void setFeedId(String str) {
        this.aVs = str;
    }

    public final void FQ() {
        if (this.geI != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.byl.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.geI.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.geI.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.byl.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.geI.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void lu(boolean z) {
        this.geT = z;
    }

    public void completePullRefresh() {
        if (this.geG != null) {
            this.geG.completePullRefresh();
        }
    }

    public void bLs() {
        if (this.geH != null) {
            this.geH.endLoadData();
            this.geG.setNextPage(null);
        }
    }

    public void lv(boolean z) {
        if (z) {
            if (this.geH != null) {
                this.geG.setNextPage(null);
            }
        } else if (this.geH != null) {
            if (this.geH.getView().getParent() == null) {
                this.geG.setNextPage(this.geH);
            }
            this.geH.showNoMoreData();
        }
    }

    public void bHj() {
        if (this.geH != null) {
            if (this.geH.getView().getParent() == null) {
                this.geG.setNextPage(this.geH);
            }
            this.geH.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.geR != null) {
            this.geR.setOtherParams(str);
        }
    }

    private void bHr() {
        bF(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.geF = gVar;
        this.geF.bLx();
    }

    public void bT(List<com.baidu.live.guardclub.f> list) {
        if (this.geR != null && list != null && !list.isEmpty()) {
            bF(0, 8);
            this.geR.bT(list);
            return;
        }
        bHr();
    }

    public void bLt() {
        bET();
    }

    public void bET() {
        this.bsN.reset();
        this.bsN.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bsN.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.geF != null) {
                    k.this.geF.bLx();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bsN.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bsN.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bsN.setVisibility(0);
        this.geG.setVisibility(8);
        this.geI.setVisibility(8);
    }

    private void bF(int i, int i2) {
        this.geG.setVisibility(i);
        if (i2 == 0) {
            this.bsN.reset();
            if (this.aFD) {
                this.bsN.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.bsN.setTitle(a.i.guard_member_list_empty);
            }
            this.bsN.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bsN.setVisibility(0);
            return;
        }
        this.bsN.setVisibility(8);
    }

    public void bU(List<com.baidu.live.guardclub.f> list) {
        if (this.geR != null && this.geq) {
            this.geR.bU(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bLq() {
        if (this.geR != null) {
            this.geR.bLq();
        }
        MessageManager.getInstance().unRegisterListener(this.fTe);
    }
}
