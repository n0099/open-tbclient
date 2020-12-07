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
/* loaded from: classes4.dex */
public class l extends BdBaseView<GuardClubMemberListActivity> {
    private boolean aLj;
    private CommonEmptyView bIx;
    private BaseActivity bQN;
    private String bdh;
    CustomMessageListener gDE;
    private com.baidu.tieba.ala.guardclub.model.g gPA;
    private BdListView gPB;
    private LoadMoreFooter gPC;
    private LinearLayout gPD;
    private TextView gPE;
    private HeadImageView gPF;
    private TbImageView gPG;
    private TextView gPH;
    private TextView gPI;
    private TextView gPJ;
    private View gPK;
    private View gPL;
    private j gPM;
    private boolean gPN;
    private boolean gPO;
    private View.OnClickListener gPP;
    private final boolean gPm;
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
        if (this.gPM != null) {
            this.gPM.a(fVar);
        }
        if (z && !this.aLj && fVar != null && !this.gPm) {
            this.gPD.setVisibility(0);
            this.gPE.setText(fVar.rank);
            if (iY(fVar.rank)) {
                this.gPE.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.gPE.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.gPH.setText(fVar.userName);
            if (fVar.biS > 0) {
                this.gPI.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.biS));
            } else {
                this.gPI.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.gPF.startLoad(fVar.bjs, 12, false);
            Bitmap a2 = com.baidu.live.ak.b.a(this.gPG.getContext(), fVar.guardName, fVar.guardLevel, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                this.gPG.setImageBitmap(a2);
                this.gPG.setVisibility(0);
            } else {
                this.gPG.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gPO) {
                z2 = false;
            }
            this.gPJ.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gPK.getLayoutParams();
                layoutParams.rightMargin = this.gPK.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.gPK.setLayoutParams(layoutParams);
            }
            this.gPL.setVisibility(0);
            this.gPL.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.l.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) l.this.gPL.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.biS;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.biS <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = l.this.gPL.getLayoutParams();
                    layoutParams2.width = i;
                    l.this.gPL.setLayoutParams(layoutParams2);
                }
            });
            this.gPJ.setOnClickListener(this.gPP);
            return;
        }
        this.gPD.setVisibility(8);
    }

    private boolean iY(String str) {
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
        this.gPP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.bQN != null) {
                    if (!l.this.isFullScreen) {
                        l.this.bQN.getActivity().setResult(-1);
                        l.this.bQN.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.ae.a.RB().brA.aNV) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(l.this.bQN.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(l.this.liveId, String.valueOf(l.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(l.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    l.this.otherParams = str;
                    if (l.this.gPM != null) {
                        l.this.gPM.setOtherParams(l.this.otherParams);
                    }
                }
            }
        };
        this.bQN = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gPm = z3;
        this.isFullScreen = z4;
        this.gPN = z2;
        this.aLj = z;
        this.mRootView = LayoutInflater.from(this.bQN).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.gPB = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bIx = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.gPD = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        IR();
        this.gPE = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.gPF = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.gPG = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.gPH = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.gPI = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.gPJ = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.gPK = this.mRootView.findViewById(a.f.view_contribution_max);
        this.gPL = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.gPF.setIsRound(true);
        this.gPF.setAutoChangeStyle(false);
        this.gPM = new j(baseActivity, bdUniqueId, z, z3);
        this.gPM.a(new j.b() { // from class: com.baidu.tieba.ala.guardclub.l.2
            @Override // com.baidu.tieba.ala.guardclub.j.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(l.this.bQN, l.this.bQN.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(l.this.bQN.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName, l.this.bdh, l.this.otherParams, true)));
                }
            }
        });
        this.gPB.setAdapter((ListAdapter) this.gPM);
        if (z3) {
            this.gPC = new LoadMoreFooter(this.bQN);
            this.gPC.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.gPC.createView();
            this.gPB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.l.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!l.this.gPC.isLoading() && l.this.gPA.bWn() && i + i2 > i3 - 2 && l.this.gPA.bWn()) {
                        l.this.gPA.bWp();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gDE);
    }

    public void setFeedId(String str) {
        this.bdh = str;
    }

    public final void IR() {
        if (this.gPD != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bQN.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gPD.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gPD.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bQN.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gPD.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void mN(boolean z) {
        this.gPO = z;
    }

    public void completePullRefresh() {
        if (this.gPB != null) {
            this.gPB.completePullRefresh();
        }
    }

    public void bWk() {
        if (this.gPC != null) {
            this.gPC.endLoadData();
            this.gPB.setNextPage(null);
        }
    }

    public void mO(boolean z) {
        if (z) {
            if (this.gPC != null) {
                this.gPB.setNextPage(null);
            }
        } else if (this.gPC != null) {
            if (this.gPC.getView().getParent() == null) {
                this.gPB.setNextPage(this.gPC);
            }
            this.gPC.showNoMoreData();
        }
    }

    public void bSb() {
        if (this.gPC != null) {
            if (this.gPC.getView().getParent() == null) {
                this.gPB.setNextPage(this.gPC);
            }
            this.gPC.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gPM != null) {
            this.gPM.setOtherParams(str);
        }
    }

    private void bSi() {
        bK(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gPA = gVar;
        this.gPA.bWo();
    }

    public void cr(List<com.baidu.live.guardclub.f> list) {
        if (this.gPM != null && list != null && !list.isEmpty()) {
            bK(0, 8);
            this.gPM.cr(list);
            return;
        }
        bSi();
    }

    public void Tn() {
        bOX();
    }

    public void bOX() {
        this.bIx.reset();
        this.bIx.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bIx.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gPA != null) {
                    l.this.gPA.bWo();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bIx.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bIx.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bIx.setVisibility(0);
        this.gPB.setVisibility(8);
        this.gPD.setVisibility(8);
    }

    private void bK(int i, int i2) {
        this.gPB.setVisibility(i);
        if (i2 == 0) {
            this.bIx.reset();
            if (this.aLj) {
                this.bIx.setTitle(a.h.guard_member_list_empty_host);
            } else {
                this.bIx.setTitle(a.h.guard_member_list_empty);
            }
            this.bIx.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bIx.setVisibility(0);
            return;
        }
        this.bIx.setVisibility(8);
    }

    public void cs(List<com.baidu.live.guardclub.f> list) {
        if (this.gPM != null && this.gPm) {
            this.gPM.cs(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bWi() {
        if (this.gPM != null) {
            this.gPM.bWi();
        }
        MessageManager.getInstance().unRegisterListener(this.gDE);
    }
}
