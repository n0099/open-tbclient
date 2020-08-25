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
    private boolean aEw;
    private String aTc;
    private CommonEmptyView bpB;
    private BaseActivity buT;
    CustomMessageListener fPP;
    private final boolean gaZ;
    private i gbA;
    private boolean gbB;
    private boolean gbC;
    private View.OnClickListener gbD;
    private com.baidu.tieba.ala.guardclub.model.g gbo;
    private BdListView gbp;
    private LoadMoreFooter gbq;
    private LinearLayout gbr;
    private TextView gbs;
    private HeadImageView gbt;
    private TbImageView gbu;
    private TextView gbv;
    private TextView gbw;
    private TextView gbx;
    private View gby;
    private View gbz;
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
        if (this.gbA != null) {
            this.gbA.a(fVar);
        }
        if (z && !this.aEw && fVar != null && !this.gaZ) {
            this.gbr.setVisibility(0);
            this.gbs.setText(fVar.rank);
            if (hi(fVar.rank)) {
                this.gbs.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.gbs.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.gbv.setText(fVar.userName);
            if (fVar.aXN > 0) {
                this.gbw.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aXN));
            } else {
                this.gbw.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.gbt.startLoad(fVar.aYk, 12, false);
            String er = com.baidu.live.guardclub.g.Im().er(fVar.aXM);
            if (!TextUtils.isEmpty(er)) {
                this.gbu.startLoad(er, 10, false);
                this.gbu.setVisibility(0);
            } else {
                this.gbu.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gbC) {
                z2 = false;
            }
            this.gbx.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gby.getLayoutParams();
                layoutParams.rightMargin = this.gby.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.gby.setLayoutParams(layoutParams);
            }
            this.gbz.setVisibility(0);
            this.gbz.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.gbz.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aXN;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aXN <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.gbz.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.gbz.setLayoutParams(layoutParams2);
                }
            });
            this.gbx.setOnClickListener(this.gbD);
            return;
        }
        this.gbr.setVisibility(8);
    }

    private boolean hi(String str) {
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
        this.gbD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.buT != null) {
                    if (!k.this.isFullScreen) {
                        k.this.buT.getActivity().setResult(-1);
                        k.this.buT.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.w.a.Nk().beH.aGM) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.buT.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.gbA != null) {
                        k.this.gbA.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.buT = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gaZ = z3;
        this.isFullScreen = z4;
        this.gbB = z2;
        this.aEw = z;
        this.mRootView = LayoutInflater.from(this.buT).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.gbp = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.bpB = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.gbr = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        Fq();
        this.gbs = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.gbt = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.gbu = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.gbv = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.gbw = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.gbx = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.gby = this.mRootView.findViewById(a.g.view_contribution_max);
        this.gbz = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.gbt.setIsRound(true);
        this.gbt.setAutoChangeStyle(false);
        this.gbA = new i(baseActivity, bdUniqueId, z, z3);
        this.gbA.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.buT, k.this.buT.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.buT.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aYi ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aTc, k.this.otherParams, true)));
                }
            }
        });
        this.gbp.setAdapter((ListAdapter) this.gbA);
        if (z3) {
            this.gbq = new LoadMoreFooter(this.buT);
            this.gbq.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.gbq.createView();
            this.gbp.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.gbq.isLoading() && k.this.gbo.bKl() && i + i2 > i3 - 2 && k.this.gbo.bKl()) {
                        k.this.gbo.bKn();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fPP);
    }

    public void setFeedId(String str) {
        this.aTc = str;
    }

    public final void Fq() {
        if (this.gbr != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.buT.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gbr.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gbr.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.buT.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gbr.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void lq(boolean z) {
        this.gbC = z;
    }

    public void completePullRefresh() {
        if (this.gbp != null) {
            this.gbp.completePullRefresh();
        }
    }

    public void bKh() {
        if (this.gbq != null) {
            this.gbq.endLoadData();
            this.gbp.setNextPage(null);
        }
    }

    public void lr(boolean z) {
        if (z) {
            if (this.gbq != null) {
                this.gbp.setNextPage(null);
            }
        } else if (this.gbq != null) {
            if (this.gbq.getView().getParent() == null) {
                this.gbp.setNextPage(this.gbq);
            }
            this.gbq.showNoMoreData();
        }
    }

    public void bFS() {
        if (this.gbq != null) {
            if (this.gbq.getView().getParent() == null) {
                this.gbp.setNextPage(this.gbq);
            }
            this.gbq.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gbA != null) {
            this.gbA.setOtherParams(str);
        }
    }

    private void bGa() {
        bF(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gbo = gVar;
        this.gbo.bKm();
    }

    public void bO(List<com.baidu.live.guardclub.f> list) {
        if (this.gbA != null && list != null && !list.isEmpty()) {
            bF(0, 8);
            this.gbA.bO(list);
            return;
        }
        bGa();
    }

    public void bKi() {
        bDF();
    }

    public void bDF() {
        this.bpB.reset();
        this.bpB.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bpB.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gbo != null) {
                    k.this.gbo.bKm();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bpB.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bpB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bpB.setVisibility(0);
        this.gbp.setVisibility(8);
        this.gbr.setVisibility(8);
    }

    private void bF(int i, int i2) {
        this.gbp.setVisibility(i);
        if (i2 == 0) {
            this.bpB.reset();
            if (this.aEw) {
                this.bpB.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.bpB.setTitle(a.i.guard_member_list_empty);
            }
            this.bpB.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bpB.setVisibility(0);
            return;
        }
        this.bpB.setVisibility(8);
    }

    public void bP(List<com.baidu.live.guardclub.f> list) {
        if (this.gbA != null && this.gaZ) {
            this.gbA.bP(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bKf() {
        if (this.gbA != null) {
            this.gbA.bKf();
        }
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }
}
