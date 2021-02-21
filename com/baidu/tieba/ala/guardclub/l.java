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
    private boolean aJC;
    private CommonEmptyView bMk;
    private BaseActivity bVA;
    private String bdj;
    CustomMessageListener gNG;
    private com.baidu.tieba.ala.guardclub.model.g gZH;
    private BdListView gZI;
    private LoadMoreFooter gZJ;
    private LinearLayout gZK;
    private TextView gZL;
    private HeadImageView gZM;
    private TbImageView gZN;
    private TextView gZO;
    private TextView gZP;
    private TextView gZQ;
    private View gZR;
    private View gZS;
    private j gZT;
    private boolean gZU;
    private boolean gZV;
    private View.OnClickListener gZW;
    private final boolean gZt;
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
        if (this.gZT != null) {
            this.gZT.a(fVar);
        }
        if (z && !this.aJC && fVar != null && !this.gZt) {
            this.gZK.setVisibility(0);
            this.gZL.setText(fVar.rank);
            if (isNumeric(fVar.rank)) {
                this.gZL.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.gZL.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.gZO.setText(fVar.userName);
            if (fVar.biQ > 0) {
                this.gZP.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.biQ));
            } else {
                this.gZP.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.gZM.startLoad(fVar.aVj, 12, false);
            Bitmap a2 = com.baidu.live.aj.b.a(this.gZN.getContext(), fVar.guardName, fVar.guardLevel, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                this.gZN.setImageBitmap(a2);
                this.gZN.setVisibility(0);
            } else {
                this.gZN.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gZV) {
                z2 = false;
            }
            this.gZQ.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gZR.getLayoutParams();
                layoutParams.rightMargin = this.gZR.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.gZR.setLayoutParams(layoutParams);
            }
            this.gZS.setVisibility(0);
            this.gZS.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.l.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) l.this.gZS.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.biQ;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.biQ <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = l.this.gZS.getLayoutParams();
                    layoutParams2.width = i;
                    l.this.gZS.setLayoutParams(layoutParams2);
                }
            });
            this.gZQ.setOnClickListener(this.gZW);
            return;
        }
        this.gZK.setVisibility(8);
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
        this.gZW = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.bVA != null) {
                    if (!l.this.isFullScreen) {
                        l.this.bVA.getActivity().setResult(-1);
                        l.this.bVA.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.Qj().buX.aMw) {
                        com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(l.this.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(l.this.bVA.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(l.this.liveId, String.valueOf(l.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(l.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
                    }
                }
            }
        };
        this.gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    l.this.otherParams = str;
                    if (l.this.gZT != null) {
                        l.this.gZT.setOtherParams(l.this.otherParams);
                    }
                }
            }
        };
        this.bVA = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gZt = z3;
        this.isFullScreen = z4;
        this.gZU = z2;
        this.aJC = z;
        this.mRootView = LayoutInflater.from(this.bVA).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.gZI = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bMk = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.gZK = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        FN();
        this.gZL = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.gZM = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.gZN = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.gZO = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.gZP = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.gZQ = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.gZR = this.mRootView.findViewById(a.f.view_contribution_max);
        this.gZS = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.gZM.setIsRound(true);
        this.gZM.setAutoChangeStyle(false);
        this.gZT = new j(baseActivity, bdUniqueId, z, z3);
        this.gZT.a(new j.b() { // from class: com.baidu.tieba.ala.guardclub.l.2
            @Override // com.baidu.tieba.ala.guardclub.j.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(l.this.bVA, l.this.bVA.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(l.this.bVA.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName);
                    alaPersonCardActivityConfig.setOtherParams(l.this.otherParams);
                    alaPersonCardActivityConfig.setVid(l.this.bdj);
                    alaPersonCardActivityConfig.setIsFromGuardClub(true);
                    alaPersonCardActivityConfig.setExtInfo(fVar.extInfoJson);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                }
            }
        });
        this.gZI.setAdapter((ListAdapter) this.gZT);
        if (z3) {
            this.gZJ = new LoadMoreFooter(this.bVA);
            this.gZJ.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.gZJ.createView();
            this.gZI.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.l.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!l.this.gZJ.isLoading() && l.this.gZH.bVO() && i + i2 > i3 - 2 && l.this.gZH.bVO()) {
                        l.this.gZH.bVQ();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gNG);
    }

    public void setFeedId(String str) {
        this.bdj = str;
    }

    public final void FN() {
        if (this.gZK != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bVA.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gZK.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gZK.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bVA.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gZK.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void no(boolean z) {
        this.gZV = z;
    }

    public void completePullRefresh() {
        if (this.gZI != null) {
            this.gZI.completePullRefresh();
        }
    }

    public void bVL() {
        if (this.gZJ != null) {
            this.gZJ.endLoadData();
            this.gZI.setNextPage(null);
        }
    }

    public void np(boolean z) {
        if (z) {
            if (this.gZJ != null) {
                this.gZI.setNextPage(null);
            }
        } else if (this.gZJ != null) {
            if (this.gZJ.getView().getParent() == null) {
                this.gZI.setNextPage(this.gZJ);
            }
            this.gZJ.showNoMoreData();
        }
    }

    public void bRy() {
        if (this.gZJ != null) {
            if (this.gZJ.getView().getParent() == null) {
                this.gZI.setNextPage(this.gZJ);
            }
            this.gZJ.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gZT != null) {
            this.gZT.setOtherParams(str);
        }
    }

    private void bRF() {
        bH(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gZH = gVar;
        this.gZH.bVP();
    }

    public void ct(List<com.baidu.live.guardclub.f> list) {
        if (this.gZT != null && list != null && !list.isEmpty()) {
            bH(0, 8);
            this.gZT.ct(list);
            return;
        }
        bRF();
    }

    public void Sh() {
        bOp();
    }

    public void bOp() {
        this.bMk.reset();
        this.bMk.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bMk.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gZH != null) {
                    l.this.gZH.bVP();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bMk.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bMk.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bMk.setVisibility(0);
        this.gZI.setVisibility(8);
        this.gZK.setVisibility(8);
    }

    private void bH(int i, int i2) {
        this.gZI.setVisibility(i);
        if (i2 == 0) {
            this.bMk.reset();
            if (this.aJC) {
                this.bMk.setTitle(a.h.guard_member_list_empty_host);
            } else {
                this.bMk.setTitle(a.h.guard_member_list_empty);
            }
            this.bMk.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bMk.setVisibility(0);
            return;
        }
        this.bMk.setVisibility(8);
    }

    public void cu(List<com.baidu.live.guardclub.f> list) {
        if (this.gZT != null && this.gZt) {
            this.gZT.cu(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVJ() {
        if (this.gZT != null) {
            this.gZT.bVJ();
        }
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }
}
