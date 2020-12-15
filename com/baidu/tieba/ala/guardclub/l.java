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
    CustomMessageListener gDG;
    private com.baidu.tieba.ala.guardclub.model.g gPC;
    private BdListView gPD;
    private LoadMoreFooter gPE;
    private LinearLayout gPF;
    private TextView gPG;
    private HeadImageView gPH;
    private TbImageView gPI;
    private TextView gPJ;
    private TextView gPK;
    private TextView gPL;
    private View gPM;
    private View gPN;
    private j gPO;
    private boolean gPP;
    private boolean gPQ;
    private View.OnClickListener gPR;
    private final boolean gPo;
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
        if (this.gPO != null) {
            this.gPO.a(fVar);
        }
        if (z && !this.aLj && fVar != null && !this.gPo) {
            this.gPF.setVisibility(0);
            this.gPG.setText(fVar.rank);
            if (iY(fVar.rank)) {
                this.gPG.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.gPG.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.gPJ.setText(fVar.userName);
            if (fVar.biS > 0) {
                this.gPK.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.biS));
            } else {
                this.gPK.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.gPH.startLoad(fVar.bjs, 12, false);
            Bitmap a2 = com.baidu.live.ak.b.a(this.gPI.getContext(), fVar.guardName, fVar.guardLevel, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                this.gPI.setImageBitmap(a2);
                this.gPI.setVisibility(0);
            } else {
                this.gPI.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gPQ) {
                z2 = false;
            }
            this.gPL.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gPM.getLayoutParams();
                layoutParams.rightMargin = this.gPM.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.gPM.setLayoutParams(layoutParams);
            }
            this.gPN.setVisibility(0);
            this.gPN.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.l.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) l.this.gPN.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.biS;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.biS <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = l.this.gPN.getLayoutParams();
                    layoutParams2.width = i;
                    l.this.gPN.setLayoutParams(layoutParams2);
                }
            });
            this.gPL.setOnClickListener(this.gPR);
            return;
        }
        this.gPF.setVisibility(8);
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
        this.gPR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.5
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
        this.gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    l.this.otherParams = str;
                    if (l.this.gPO != null) {
                        l.this.gPO.setOtherParams(l.this.otherParams);
                    }
                }
            }
        };
        this.bQN = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gPo = z3;
        this.isFullScreen = z4;
        this.gPP = z2;
        this.aLj = z;
        this.mRootView = LayoutInflater.from(this.bQN).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.gPD = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bIx = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.gPF = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        IR();
        this.gPG = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.gPH = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.gPI = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.gPJ = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.gPK = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.gPL = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.gPM = this.mRootView.findViewById(a.f.view_contribution_max);
        this.gPN = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.gPH.setIsRound(true);
        this.gPH.setAutoChangeStyle(false);
        this.gPO = new j(baseActivity, bdUniqueId, z, z3);
        this.gPO.a(new j.b() { // from class: com.baidu.tieba.ala.guardclub.l.2
            @Override // com.baidu.tieba.ala.guardclub.j.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(l.this.bQN, l.this.bQN.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(l.this.bQN.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName, l.this.bdh, l.this.otherParams, true)));
                }
            }
        });
        this.gPD.setAdapter((ListAdapter) this.gPO);
        if (z3) {
            this.gPE = new LoadMoreFooter(this.bQN);
            this.gPE.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.gPE.createView();
            this.gPD.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.l.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!l.this.gPE.isLoading() && l.this.gPC.bWo() && i + i2 > i3 - 2 && l.this.gPC.bWo()) {
                        l.this.gPC.bWq();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gDG);
    }

    public void setFeedId(String str) {
        this.bdh = str;
    }

    public final void IR() {
        if (this.gPF != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bQN.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gPF.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gPF.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bQN.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gPF.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void mN(boolean z) {
        this.gPQ = z;
    }

    public void completePullRefresh() {
        if (this.gPD != null) {
            this.gPD.completePullRefresh();
        }
    }

    public void bWl() {
        if (this.gPE != null) {
            this.gPE.endLoadData();
            this.gPD.setNextPage(null);
        }
    }

    public void mO(boolean z) {
        if (z) {
            if (this.gPE != null) {
                this.gPD.setNextPage(null);
            }
        } else if (this.gPE != null) {
            if (this.gPE.getView().getParent() == null) {
                this.gPD.setNextPage(this.gPE);
            }
            this.gPE.showNoMoreData();
        }
    }

    public void bSc() {
        if (this.gPE != null) {
            if (this.gPE.getView().getParent() == null) {
                this.gPD.setNextPage(this.gPE);
            }
            this.gPE.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gPO != null) {
            this.gPO.setOtherParams(str);
        }
    }

    private void bSj() {
        bK(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gPC = gVar;
        this.gPC.bWp();
    }

    public void cr(List<com.baidu.live.guardclub.f> list) {
        if (this.gPO != null && list != null && !list.isEmpty()) {
            bK(0, 8);
            this.gPO.cr(list);
            return;
        }
        bSj();
    }

    public void Tn() {
        bOY();
    }

    public void bOY() {
        this.bIx.reset();
        this.bIx.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bIx.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gPC != null) {
                    l.this.gPC.bWp();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bIx.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bIx.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bIx.setVisibility(0);
        this.gPD.setVisibility(8);
        this.gPF.setVisibility(8);
    }

    private void bK(int i, int i2) {
        this.gPD.setVisibility(i);
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
        if (this.gPO != null && this.gPo) {
            this.gPO.cs(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bWj() {
        if (this.gPO != null) {
            this.gPO.bWj();
        }
        MessageManager.getInstance().unRegisterListener(this.gDG);
    }
}
