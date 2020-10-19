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
    private boolean aIH;
    private String aYD;
    private BaseActivity bEO;
    private CommonEmptyView bwB;
    CustomMessageListener gfx;
    private final boolean gqF;
    private com.baidu.tieba.ala.guardclub.model.g gqU;
    private BdListView gqV;
    private LoadMoreFooter gqW;
    private LinearLayout gqX;
    private TextView gqY;
    private HeadImageView gqZ;
    private TbImageView gra;
    private TextView grb;
    private TextView grc;
    private TextView grd;
    private View gre;
    private View grf;
    private i grg;
    private boolean grh;
    private boolean gri;
    private View.OnClickListener grj;
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
        if (this.grg != null) {
            this.grg.a(fVar);
        }
        if (z && !this.aIH && fVar != null && !this.gqF) {
            this.gqX.setVisibility(0);
            this.gqY.setText(fVar.rank);
            if (hQ(fVar.rank)) {
                this.gqY.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.gqY.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.grb.setText(fVar.userName);
            if (fVar.bdH > 0) {
                this.grc.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.bdH));
            } else {
                this.grc.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.gqZ.startLoad(fVar.bed, 12, false);
            String eA = com.baidu.live.guardclub.g.JM().eA(fVar.bdG);
            if (!TextUtils.isEmpty(eA)) {
                this.gra.startLoad(eA, 10, false);
                this.gra.setVisibility(0);
            } else {
                this.gra.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gri) {
                z2 = false;
            }
            this.grd.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gre.getLayoutParams();
                layoutParams.rightMargin = this.gre.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.gre.setLayoutParams(layoutParams);
            }
            this.grf.setVisibility(0);
            this.grf.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.grf.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.bdH;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.bdH <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.grf.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.grf.setLayoutParams(layoutParams2);
                }
            });
            this.grd.setOnClickListener(this.grj);
            return;
        }
        this.gqX.setVisibility(8);
    }

    private boolean hQ(String str) {
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
        this.grj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bEO != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bEO.getActivity().setResult(-1);
                        k.this.bEO.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.x.a.OS().blo.aLh) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bEO.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.grg != null) {
                        k.this.grg.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bEO = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gqF = z3;
        this.isFullScreen = z4;
        this.grh = z2;
        this.aIH = z;
        this.mRootView = LayoutInflater.from(this.bEO).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.gqV = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.bwB = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.gqX = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        GM();
        this.gqY = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.gqZ = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.gra = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.grb = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.grc = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.grd = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.gre = this.mRootView.findViewById(a.g.view_contribution_max);
        this.grf = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.gqZ.setIsRound(true);
        this.gqZ.setAutoChangeStyle(false);
        this.grg = new i(baseActivity, bdUniqueId, z, z3);
        this.grg.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bEO, k.this.bEO.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bEO.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aYD, k.this.otherParams, true)));
                }
            }
        });
        this.gqV.setAdapter((ListAdapter) this.grg);
        if (z3) {
            this.gqW = new LoadMoreFooter(this.bEO);
            this.gqW.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.gqW.createView();
            this.gqV.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.gqW.isLoading() && k.this.gqU.bOg() && i + i2 > i3 - 2 && k.this.gqU.bOg()) {
                        k.this.gqU.bOi();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gfx);
    }

    public void setFeedId(String str) {
        this.aYD = str;
    }

    public final void GM() {
        if (this.gqX != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bEO.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gqX.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gqX.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bEO.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gqX.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void lS(boolean z) {
        this.gri = z;
    }

    public void completePullRefresh() {
        if (this.gqV != null) {
            this.gqV.completePullRefresh();
        }
    }

    public void bOc() {
        if (this.gqW != null) {
            this.gqW.endLoadData();
            this.gqV.setNextPage(null);
        }
    }

    public void lT(boolean z) {
        if (z) {
            if (this.gqW != null) {
                this.gqV.setNextPage(null);
            }
        } else if (this.gqW != null) {
            if (this.gqW.getView().getParent() == null) {
                this.gqV.setNextPage(this.gqW);
            }
            this.gqW.showNoMoreData();
        }
    }

    public void bJV() {
        if (this.gqW != null) {
            if (this.gqW.getView().getParent() == null) {
                this.gqV.setNextPage(this.gqW);
            }
            this.gqW.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.grg != null) {
            this.grg.setOtherParams(str);
        }
    }

    private void bKc() {
        bE(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gqU = gVar;
        this.gqU.bOh();
    }

    public void bW(List<com.baidu.live.guardclub.f> list) {
        if (this.grg != null && list != null && !list.isEmpty()) {
            bE(0, 8);
            this.grg.bW(list);
            return;
        }
        bKc();
    }

    public void bOd() {
        bHF();
    }

    public void bHF() {
        this.bwB.reset();
        this.bwB.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bwB.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gqU != null) {
                    k.this.gqU.bOh();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bwB.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bwB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bwB.setVisibility(0);
        this.gqV.setVisibility(8);
        this.gqX.setVisibility(8);
    }

    private void bE(int i, int i2) {
        this.gqV.setVisibility(i);
        if (i2 == 0) {
            this.bwB.reset();
            if (this.aIH) {
                this.bwB.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.bwB.setTitle(a.i.guard_member_list_empty);
            }
            this.bwB.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bwB.setVisibility(0);
            return;
        }
        this.bwB.setVisibility(8);
    }

    public void bX(List<com.baidu.live.guardclub.f> list) {
        if (this.grg != null && this.gqF) {
            this.grg.bX(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOa() {
        if (this.grg != null) {
            this.grg.bOa();
        }
        MessageManager.getInstance().unRegisterListener(this.gfx);
    }
}
