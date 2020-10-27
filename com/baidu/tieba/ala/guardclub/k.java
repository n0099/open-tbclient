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
    private boolean aJi;
    private BaseActivity bHN;
    private String baa;
    private CommonEmptyView byP;
    private final boolean gAK;
    private com.baidu.tieba.ala.guardclub.model.g gAY;
    private BdListView gAZ;
    private LoadMoreFooter gBa;
    private LinearLayout gBb;
    private TextView gBc;
    private HeadImageView gBd;
    private TbImageView gBe;
    private TextView gBf;
    private TextView gBg;
    private TextView gBh;
    private View gBi;
    private View gBj;
    private i gBk;
    private boolean gBl;
    private boolean gBm;
    private View.OnClickListener gBn;
    CustomMessageListener gpA;
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
        if (this.gBk != null) {
            this.gBk.a(fVar);
        }
        if (z && !this.aJi && fVar != null && !this.gAK) {
            this.gBb.setVisibility(0);
            this.gBc.setText(fVar.rank);
            if (ih(fVar.rank)) {
                this.gBc.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.gBc.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.gBf.setText(fVar.userName);
            if (fVar.beX > 0) {
                this.gBg.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.beX));
            } else {
                this.gBg.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.gBd.startLoad(fVar.bfv, 12, false);
            String eB = com.baidu.live.guardclub.g.Kf().eB(fVar.beW);
            if (!TextUtils.isEmpty(eB)) {
                this.gBe.startLoad(eB, 10, false);
                this.gBe.setVisibility(0);
            } else {
                this.gBe.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gBm) {
                z2 = false;
            }
            this.gBh.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBi.getLayoutParams();
                layoutParams.rightMargin = this.gBi.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.gBi.setLayoutParams(layoutParams);
            }
            this.gBj.setVisibility(0);
            this.gBj.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.gBj.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.beX;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.beX <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.gBj.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.gBj.setLayoutParams(layoutParams2);
                }
            });
            this.gBh.setOnClickListener(this.gBn);
            return;
        }
        this.gBb.setVisibility(8);
    }

    private boolean ih(String str) {
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
        this.gBn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bHN != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bHN.getActivity().setResult(-1);
                        k.this.bHN.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.z.a.Pq().bmJ.aLL) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bHN.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.gBk != null) {
                        k.this.gBk.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bHN = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gAK = z3;
        this.isFullScreen = z4;
        this.gBl = z2;
        this.aJi = z;
        this.mRootView = LayoutInflater.from(this.bHN).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.gAZ = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.byP = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.gBb = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        Hi();
        this.gBc = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.gBd = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.gBe = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.gBf = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.gBg = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.gBh = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.gBi = this.mRootView.findViewById(a.g.view_contribution_max);
        this.gBj = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.gBd.setIsRound(true);
        this.gBd.setAutoChangeStyle(false);
        this.gBk = new i(baseActivity, bdUniqueId, z, z3);
        this.gBk.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bHN, k.this.bHN.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bHN.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.baa, k.this.otherParams, true)));
                }
            }
        });
        this.gAZ.setAdapter((ListAdapter) this.gBk);
        if (z3) {
            this.gBa = new LoadMoreFooter(this.bHN);
            this.gBa.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.gBa.createView();
            this.gAZ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.gBa.isLoading() && k.this.gAY.bQL() && i + i2 > i3 - 2 && k.this.gAY.bQL()) {
                        k.this.gAY.bQN();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gpA);
    }

    public void setFeedId(String str) {
        this.baa = str;
    }

    public final void Hi() {
        if (this.gBb != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bHN.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gBb.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gBb.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bHN.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gBb.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void mi(boolean z) {
        this.gBm = z;
    }

    public void completePullRefresh() {
        if (this.gAZ != null) {
            this.gAZ.completePullRefresh();
        }
    }

    public void bQH() {
        if (this.gBa != null) {
            this.gBa.endLoadData();
            this.gAZ.setNextPage(null);
        }
    }

    public void mj(boolean z) {
        if (z) {
            if (this.gBa != null) {
                this.gAZ.setNextPage(null);
            }
        } else if (this.gBa != null) {
            if (this.gBa.getView().getParent() == null) {
                this.gAZ.setNextPage(this.gBa);
            }
            this.gBa.showNoMoreData();
        }
    }

    public void bMx() {
        if (this.gBa != null) {
            if (this.gBa.getView().getParent() == null) {
                this.gAZ.setNextPage(this.gBa);
            }
            this.gBa.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gBk != null) {
            this.gBk.setOtherParams(str);
        }
    }

    private void bME() {
        bG(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gAY = gVar;
        this.gAY.bQM();
    }

    public void cg(List<com.baidu.live.guardclub.f> list) {
        if (this.gBk != null && list != null && !list.isEmpty()) {
            bG(0, 8);
            this.gBk.cg(list);
            return;
        }
        bME();
    }

    public void bQI() {
        bJw();
    }

    public void bJw() {
        this.byP.reset();
        this.byP.setTitle(a.i.sdk_net_fail_tip_rank);
        this.byP.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gAY != null) {
                    k.this.gAY.bQM();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.byP.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.byP.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.byP.setVisibility(0);
        this.gAZ.setVisibility(8);
        this.gBb.setVisibility(8);
    }

    private void bG(int i, int i2) {
        this.gAZ.setVisibility(i);
        if (i2 == 0) {
            this.byP.reset();
            if (this.aJi) {
                this.byP.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.byP.setTitle(a.i.guard_member_list_empty);
            }
            this.byP.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.byP.setVisibility(0);
            return;
        }
        this.byP.setVisibility(8);
    }

    public void ch(List<com.baidu.live.guardclub.f> list) {
        if (this.gBk != null && this.gAK) {
            this.gBk.ch(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bQF() {
        if (this.gBk != null) {
            this.gBk.bQF();
        }
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }
}
