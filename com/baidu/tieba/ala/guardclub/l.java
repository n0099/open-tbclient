package com.baidu.tieba.ala.guardclub;

import android.graphics.Bitmap;
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
import com.baidu.tieba.ala.guardclub.j;
import java.util.List;
/* loaded from: classes11.dex */
public class l extends BdBaseView<GuardClubMemberListActivity> {
    private boolean aLL;
    private CommonEmptyView bNm;
    private BaseActivity bWu;
    private String beS;
    CustomMessageListener gPs;
    private View hbA;
    private j hbB;
    private boolean hbC;
    private boolean hbD;
    private View.OnClickListener hbE;
    private final boolean hbb;
    private com.baidu.tieba.ala.guardclub.model.g hbp;
    private BdListView hbq;
    private LoadMoreFooter hbr;
    private LinearLayout hbs;
    private TextView hbt;
    private HeadImageView hbu;
    private TbImageView hbv;
    private TextView hbw;
    private TextView hbx;
    private TextView hby;
    private View hbz;
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
        if (this.hbB != null) {
            this.hbB.a(fVar);
        }
        if (z && !this.aLL && fVar != null && !this.hbb) {
            this.hbs.setVisibility(0);
            this.hbt.setText(fVar.rank);
            if (iN(fVar.rank)) {
                this.hbt.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.hbt.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.hbw.setText(fVar.userName);
            if (fVar.bkx > 0) {
                this.hbx.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.bkx));
            } else {
                this.hbx.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.hbu.startLoad(fVar.aWS, 12, false);
            Bitmap a2 = com.baidu.live.al.b.a(this.hbv.getContext(), fVar.guardName, fVar.guardLevel, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                this.hbv.setImageBitmap(a2);
                this.hbv.setVisibility(0);
            } else {
                this.hbv.setVisibility(4);
            }
            if (!this.isFullScreen && !this.hbD) {
                z2 = false;
            }
            this.hby.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbz.getLayoutParams();
                layoutParams.rightMargin = this.hbz.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.hbz.setLayoutParams(layoutParams);
            }
            this.hbA.setVisibility(0);
            this.hbA.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.l.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) l.this.hbA.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.bkx;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.bkx <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = l.this.hbA.getLayoutParams();
                    layoutParams2.width = i;
                    l.this.hbA.setLayoutParams(layoutParams2);
                }
            });
            this.hby.setOnClickListener(this.hbE);
            return;
        }
        this.hbs.setVisibility(8);
    }

    private boolean iN(String str) {
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

    public l(BaseActivity baseActivity, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.hbE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.bWu != null) {
                    if (!l.this.isFullScreen) {
                        l.this.bWu.getActivity().setResult(-1);
                        l.this.bWu.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.SE().bwi.aOz) {
                        com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(l.this.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(l.this.bWu.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(l.this.liveId, String.valueOf(l.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(l.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
                    }
                }
            }
        };
        this.gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    l.this.otherParams = str;
                    if (l.this.hbB != null) {
                        l.this.hbB.setOtherParams(l.this.otherParams);
                    }
                }
            }
        };
        this.bWu = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.hbb = z3;
        this.isFullScreen = z4;
        this.hbC = z2;
        this.aLL = z;
        this.mRootView = LayoutInflater.from(this.bWu).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.hbq = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bNm = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.hbs = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        Is();
        this.hbt = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.hbu = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.hbv = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.hbw = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.hbx = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.hby = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.hbz = this.mRootView.findViewById(a.f.view_contribution_max);
        this.hbA = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.hbu.setIsRound(true);
        this.hbu.setAutoChangeStyle(false);
        this.hbB = new j(baseActivity, bdUniqueId, z, z3);
        this.hbB.a(new j.b() { // from class: com.baidu.tieba.ala.guardclub.l.2
            @Override // com.baidu.tieba.ala.guardclub.j.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(l.this.bWu, l.this.bWu.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(l.this.bWu.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName);
                    alaPersonCardActivityConfig.setOtherParams(l.this.otherParams);
                    alaPersonCardActivityConfig.setVid(l.this.beS);
                    alaPersonCardActivityConfig.setIsFromGuardClub(true);
                    alaPersonCardActivityConfig.setExtInfo(fVar.extInfoJson);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                }
            }
        });
        this.hbq.setAdapter((ListAdapter) this.hbB);
        if (z3) {
            this.hbr = new LoadMoreFooter(this.bWu);
            this.hbr.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.hbr.createView();
            this.hbq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.l.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!l.this.hbr.isLoading() && l.this.hbp.bYT() && i + i2 > i3 - 2 && l.this.hbp.bYT()) {
                        l.this.hbp.bYV();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gPs);
    }

    public void setFeedId(String str) {
        this.beS = str;
    }

    public final void Is() {
        if (this.hbs != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bWu.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.hbs.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.hbs.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bWu.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.hbs.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void nn(boolean z) {
        this.hbD = z;
    }

    public void completePullRefresh() {
        if (this.hbq != null) {
            this.hbq.completePullRefresh();
        }
    }

    public void bYQ() {
        if (this.hbr != null) {
            this.hbr.endLoadData();
            this.hbq.setNextPage(null);
        }
    }

    public void no(boolean z) {
        if (z) {
            if (this.hbr != null) {
                this.hbq.setNextPage(null);
            }
        } else if (this.hbr != null) {
            if (this.hbr.getView().getParent() == null) {
                this.hbq.setNextPage(this.hbr);
            }
            this.hbr.showNoMoreData();
        }
    }

    public void bUE() {
        if (this.hbr != null) {
            if (this.hbr.getView().getParent() == null) {
                this.hbq.setNextPage(this.hbr);
            }
            this.hbr.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hbB != null) {
            this.hbB.setOtherParams(str);
        }
    }

    private void bUL() {
        bJ(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.hbp = gVar;
        this.hbp.bYU();
    }

    public void cy(List<com.baidu.live.guardclub.f> list) {
        if (this.hbB != null && list != null && !list.isEmpty()) {
            bJ(0, 8);
            this.hbB.cy(list);
            return;
        }
        bUL();
    }

    public void Us() {
        bRy();
    }

    public void bRy() {
        this.bNm.reset();
        this.bNm.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bNm.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hbp != null) {
                    l.this.hbp.bYU();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bNm.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bNm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bNm.setVisibility(0);
        this.hbq.setVisibility(8);
        this.hbs.setVisibility(8);
    }

    private void bJ(int i, int i2) {
        this.hbq.setVisibility(i);
        if (i2 == 0) {
            this.bNm.reset();
            if (this.aLL) {
                this.bNm.setTitle(a.h.guard_member_list_empty_host);
            } else {
                this.bNm.setTitle(a.h.guard_member_list_empty);
            }
            this.bNm.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bNm.setVisibility(0);
            return;
        }
        this.bNm.setVisibility(8);
    }

    public void cz(List<com.baidu.live.guardclub.f> list) {
        if (this.hbB != null && this.hbb) {
            this.hbB.cz(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYO() {
        if (this.hbB != null) {
            this.hbB.bYO();
        }
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }
}
