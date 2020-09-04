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
/* loaded from: classes7.dex */
public class k extends BdBaseView<GuardClubMemberListActivity> {
    private boolean aEy;
    private String aTe;
    private CommonEmptyView bpE;
    private BaseActivity buW;
    CustomMessageListener fPT;
    private TextView gbA;
    private TextView gbB;
    private View gbC;
    private View gbD;
    private i gbE;
    private boolean gbF;
    private boolean gbG;
    private View.OnClickListener gbH;
    private final boolean gbd;
    private com.baidu.tieba.ala.guardclub.model.g gbs;
    private BdListView gbt;
    private LoadMoreFooter gbu;
    private LinearLayout gbv;
    private TextView gbw;
    private HeadImageView gbx;
    private TbImageView gby;
    private TextView gbz;
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
        if (this.gbE != null) {
            this.gbE.a(fVar);
        }
        if (z && !this.aEy && fVar != null && !this.gbd) {
            this.gbv.setVisibility(0);
            this.gbw.setText(fVar.rank);
            if (hj(fVar.rank)) {
                this.gbw.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.gbw.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.gbz.setText(fVar.userName);
            if (fVar.aXP > 0) {
                this.gbA.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aXP));
            } else {
                this.gbA.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.gbx.startLoad(fVar.aYm, 12, false);
            String er = com.baidu.live.guardclub.g.Im().er(fVar.aXO);
            if (!TextUtils.isEmpty(er)) {
                this.gby.startLoad(er, 10, false);
                this.gby.setVisibility(0);
            } else {
                this.gby.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gbG) {
                z2 = false;
            }
            this.gbB.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gbC.getLayoutParams();
                layoutParams.rightMargin = this.gbC.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.gbC.setLayoutParams(layoutParams);
            }
            this.gbD.setVisibility(0);
            this.gbD.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.gbD.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aXP;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aXP <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.gbD.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.gbD.setLayoutParams(layoutParams2);
                }
            });
            this.gbB.setOnClickListener(this.gbH);
            return;
        }
        this.gbv.setVisibility(8);
    }

    private boolean hj(String str) {
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
        this.gbH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.buW != null) {
                    if (!k.this.isFullScreen) {
                        k.this.buW.getActivity().setResult(-1);
                        k.this.buW.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beJ.aGO) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.buW.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.gbE != null) {
                        k.this.gbE.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.buW = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gbd = z3;
        this.isFullScreen = z4;
        this.gbF = z2;
        this.aEy = z;
        this.mRootView = LayoutInflater.from(this.buW).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.gbt = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.bpE = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.gbv = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        Fq();
        this.gbw = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.gbx = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.gby = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.gbz = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.gbA = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.gbB = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.gbC = this.mRootView.findViewById(a.g.view_contribution_max);
        this.gbD = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.gbx.setIsRound(true);
        this.gbx.setAutoChangeStyle(false);
        this.gbE = new i(baseActivity, bdUniqueId, z, z3);
        this.gbE.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.buW, k.this.buW.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.buW.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aYk ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aTe, k.this.otherParams, true)));
                }
            }
        });
        this.gbt.setAdapter((ListAdapter) this.gbE);
        if (z3) {
            this.gbu = new LoadMoreFooter(this.buW);
            this.gbu.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.gbu.createView();
            this.gbt.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.gbu.isLoading() && k.this.gbs.bKm() && i + i2 > i3 - 2 && k.this.gbs.bKm()) {
                        k.this.gbs.bKo();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fPT);
    }

    public void setFeedId(String str) {
        this.aTe = str;
    }

    public final void Fq() {
        if (this.gbv != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.buW.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gbv.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gbv.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.buW.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gbv.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void ls(boolean z) {
        this.gbG = z;
    }

    public void completePullRefresh() {
        if (this.gbt != null) {
            this.gbt.completePullRefresh();
        }
    }

    public void bKi() {
        if (this.gbu != null) {
            this.gbu.endLoadData();
            this.gbt.setNextPage(null);
        }
    }

    public void lt(boolean z) {
        if (z) {
            if (this.gbu != null) {
                this.gbt.setNextPage(null);
            }
        } else if (this.gbu != null) {
            if (this.gbu.getView().getParent() == null) {
                this.gbt.setNextPage(this.gbu);
            }
            this.gbu.showNoMoreData();
        }
    }

    public void bFT() {
        if (this.gbu != null) {
            if (this.gbu.getView().getParent() == null) {
                this.gbt.setNextPage(this.gbu);
            }
            this.gbu.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gbE != null) {
            this.gbE.setOtherParams(str);
        }
    }

    private void bGb() {
        bF(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gbs = gVar;
        this.gbs.bKn();
    }

    public void bO(List<com.baidu.live.guardclub.f> list) {
        if (this.gbE != null && list != null && !list.isEmpty()) {
            bF(0, 8);
            this.gbE.bO(list);
            return;
        }
        bGb();
    }

    public void bKj() {
        bDG();
    }

    public void bDG() {
        this.bpE.reset();
        this.bpE.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bpE.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gbs != null) {
                    k.this.gbs.bKn();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bpE.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bpE.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bpE.setVisibility(0);
        this.gbt.setVisibility(8);
        this.gbv.setVisibility(8);
    }

    private void bF(int i, int i2) {
        this.gbt.setVisibility(i);
        if (i2 == 0) {
            this.bpE.reset();
            if (this.aEy) {
                this.bpE.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.bpE.setTitle(a.i.guard_member_list_empty);
            }
            this.bpE.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bpE.setVisibility(0);
            return;
        }
        this.bpE.setVisibility(8);
    }

    public void bP(List<com.baidu.live.guardclub.f> list) {
        if (this.gbE != null && this.gbd) {
            this.gbE.bP(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bKg() {
        if (this.gbE != null) {
            this.gbE.bKg();
        }
        MessageManager.getInstance().unRegisterListener(this.fPT);
    }
}
