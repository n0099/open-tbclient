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
/* loaded from: classes10.dex */
public class l extends BdBaseView<GuardClubMemberListActivity> {
    private boolean aLc;
    private CommonEmptyView bNK;
    private BaseActivity bXa;
    private String beL;
    CustomMessageListener gPp;
    private View hbA;
    private View hbB;
    private j hbC;
    private boolean hbD;
    private boolean hbE;
    private View.OnClickListener hbF;
    private final boolean hbc;
    private com.baidu.tieba.ala.guardclub.model.g hbq;
    private BdListView hbr;
    private LoadMoreFooter hbs;
    private LinearLayout hbt;
    private TextView hbu;
    private HeadImageView hbv;
    private TbImageView hbw;
    private TextView hbx;
    private TextView hby;
    private TextView hbz;
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
        if (this.hbC != null) {
            this.hbC.a(fVar);
        }
        if (z && !this.aLc && fVar != null && !this.hbc) {
            this.hbt.setVisibility(0);
            this.hbu.setText(fVar.rank);
            if (isNumeric(fVar.rank)) {
                this.hbu.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.hbu.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.hbx.setText(fVar.userName);
            if (fVar.bkq > 0) {
                this.hby.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.bkq));
            } else {
                this.hby.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.hbv.startLoad(fVar.aWJ, 12, false);
            Bitmap a2 = com.baidu.live.aj.b.a(this.hbw.getContext(), fVar.guardName, fVar.guardLevel, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                this.hbw.setImageBitmap(a2);
                this.hbw.setVisibility(0);
            } else {
                this.hbw.setVisibility(4);
            }
            if (!this.isFullScreen && !this.hbE) {
                z2 = false;
            }
            this.hbz.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbA.getLayoutParams();
                layoutParams.rightMargin = this.hbA.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.hbA.setLayoutParams(layoutParams);
            }
            this.hbB.setVisibility(0);
            this.hbB.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.l.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) l.this.hbB.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.bkq;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.bkq <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = l.this.hbB.getLayoutParams();
                    layoutParams2.width = i;
                    l.this.hbB.setLayoutParams(layoutParams2);
                }
            });
            this.hbz.setOnClickListener(this.hbF);
            return;
        }
        this.hbt.setVisibility(8);
    }

    private boolean isNumeric(String str) {
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
        this.hbF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.bXa != null) {
                    if (!l.this.isFullScreen) {
                        l.this.bXa.getActivity().setResult(-1);
                        l.this.bXa.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qm().bwx.aNW) {
                        com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(l.this.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(l.this.bXa.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(l.this.liveId, String.valueOf(l.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(l.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
                    }
                }
            }
        };
        this.gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    l.this.otherParams = str;
                    if (l.this.hbC != null) {
                        l.this.hbC.setOtherParams(l.this.otherParams);
                    }
                }
            }
        };
        this.bXa = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.hbc = z3;
        this.isFullScreen = z4;
        this.hbD = z2;
        this.aLc = z;
        this.mRootView = LayoutInflater.from(this.bXa).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.hbr = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bNK = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.hbt = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        FQ();
        this.hbu = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.hbv = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.hbw = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.hbx = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.hby = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.hbz = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.hbA = this.mRootView.findViewById(a.f.view_contribution_max);
        this.hbB = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.hbv.setIsRound(true);
        this.hbv.setAutoChangeStyle(false);
        this.hbC = new j(baseActivity, bdUniqueId, z, z3);
        this.hbC.a(new j.b() { // from class: com.baidu.tieba.ala.guardclub.l.2
            @Override // com.baidu.tieba.ala.guardclub.j.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(l.this.bXa, l.this.bXa.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(l.this.bXa.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName);
                    alaPersonCardActivityConfig.setOtherParams(l.this.otherParams);
                    alaPersonCardActivityConfig.setVid(l.this.beL);
                    alaPersonCardActivityConfig.setIsFromGuardClub(true);
                    alaPersonCardActivityConfig.setExtInfo(fVar.extInfoJson);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                }
            }
        });
        this.hbr.setAdapter((ListAdapter) this.hbC);
        if (z3) {
            this.hbs = new LoadMoreFooter(this.bXa);
            this.hbs.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.hbs.createView();
            this.hbr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.l.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!l.this.hbs.isLoading() && l.this.hbq.bVU() && i + i2 > i3 - 2 && l.this.hbq.bVU()) {
                        l.this.hbq.bVW();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gPp);
    }

    public void setFeedId(String str) {
        this.beL = str;
    }

    public final void FQ() {
        if (this.hbt != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bXa.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.hbt.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.hbt.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bXa.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.hbt.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void no(boolean z) {
        this.hbE = z;
    }

    public void completePullRefresh() {
        if (this.hbr != null) {
            this.hbr.completePullRefresh();
        }
    }

    public void bVR() {
        if (this.hbs != null) {
            this.hbs.endLoadData();
            this.hbr.setNextPage(null);
        }
    }

    public void np(boolean z) {
        if (z) {
            if (this.hbs != null) {
                this.hbr.setNextPage(null);
            }
        } else if (this.hbs != null) {
            if (this.hbs.getView().getParent() == null) {
                this.hbr.setNextPage(this.hbs);
            }
            this.hbs.showNoMoreData();
        }
    }

    public void bRE() {
        if (this.hbs != null) {
            if (this.hbs.getView().getParent() == null) {
                this.hbr.setNextPage(this.hbs);
            }
            this.hbs.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hbC != null) {
            this.hbC.setOtherParams(str);
        }
    }

    private void bRL() {
        bH(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.hbq = gVar;
        this.hbq.bVV();
    }

    public void ct(List<com.baidu.live.guardclub.f> list) {
        if (this.hbC != null && list != null && !list.isEmpty()) {
            bH(0, 8);
            this.hbC.ct(list);
            return;
        }
        bRL();
    }

    public void Sk() {
        bOv();
    }

    public void bOv() {
        this.bNK.reset();
        this.bNK.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bNK.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.hbq != null) {
                    l.this.hbq.bVV();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bNK.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bNK.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bNK.setVisibility(0);
        this.hbr.setVisibility(8);
        this.hbt.setVisibility(8);
    }

    private void bH(int i, int i2) {
        this.hbr.setVisibility(i);
        if (i2 == 0) {
            this.bNK.reset();
            if (this.aLc) {
                this.bNK.setTitle(a.h.guard_member_list_empty_host);
            } else {
                this.bNK.setTitle(a.h.guard_member_list_empty);
            }
            this.bNK.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bNK.setVisibility(0);
            return;
        }
        this.bNK.setVisibility(8);
    }

    public void cu(List<com.baidu.live.guardclub.f> list) {
        if (this.hbC != null && this.hbc) {
            this.hbC.cu(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVP() {
        if (this.hbC != null) {
            this.hbC.bVP();
        }
        MessageManager.getInstance().unRegisterListener(this.gPp);
    }
}
