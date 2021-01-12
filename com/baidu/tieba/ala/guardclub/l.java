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
    private boolean aGY;
    private CommonEmptyView bIA;
    private BaseActivity bRI;
    private String bac;
    CustomMessageListener gKM;
    private com.baidu.tieba.ala.guardclub.model.g gWJ;
    private BdListView gWK;
    private LoadMoreFooter gWL;
    private LinearLayout gWM;
    private TextView gWN;
    private HeadImageView gWO;
    private TbImageView gWP;
    private TextView gWQ;
    private TextView gWR;
    private TextView gWS;
    private View gWT;
    private View gWU;
    private j gWV;
    private boolean gWW;
    private boolean gWX;
    private View.OnClickListener gWY;
    private final boolean gWv;
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
        if (this.gWV != null) {
            this.gWV.a(fVar);
        }
        if (z && !this.aGY && fVar != null && !this.gWv) {
            this.gWM.setVisibility(0);
            this.gWN.setText(fVar.rank);
            if (hC(fVar.rank)) {
                this.gWN.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.gWN.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.gWQ.setText(fVar.userName);
            if (fVar.bfH > 0) {
                this.gWR.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.bfH));
            } else {
                this.gWR.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.gWO.startLoad(fVar.aSf, 12, false);
            Bitmap a2 = com.baidu.live.al.b.a(this.gWP.getContext(), fVar.guardName, fVar.guardLevel, fVar.isGold(), fVar.guardGoldenType);
            if (a2 != null) {
                this.gWP.setImageBitmap(a2);
                this.gWP.setVisibility(0);
            } else {
                this.gWP.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gWX) {
                z2 = false;
            }
            this.gWS.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gWT.getLayoutParams();
                layoutParams.rightMargin = this.gWT.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.gWT.setLayoutParams(layoutParams);
            }
            this.gWU.setVisibility(0);
            this.gWU.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.l.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) l.this.gWU.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.bfH;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.bfH <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = l.this.gWU.getLayoutParams();
                    layoutParams2.width = i;
                    l.this.gWU.setLayoutParams(layoutParams2);
                }
            });
            this.gWS.setOnClickListener(this.gWY);
            return;
        }
        this.gWM.setVisibility(8);
    }

    private boolean hC(String str) {
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
        this.gWY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.bRI != null) {
                    if (!l.this.isFullScreen) {
                        l.this.bRI.getActivity().setResult(-1);
                        l.this.bRI.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.af.a.OJ().bru.aJM) {
                        com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(l.this.liveId)));
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(l.this.bRI.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(l.this.liveId, String.valueOf(l.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(l.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
                    }
                }
            }
        };
        this.gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.l.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    l.this.otherParams = str;
                    if (l.this.gWV != null) {
                        l.this.gWV.setOtherParams(l.this.otherParams);
                    }
                }
            }
        };
        this.bRI = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gWv = z3;
        this.isFullScreen = z4;
        this.gWW = z2;
        this.aGY = z;
        this.mRootView = LayoutInflater.from(this.bRI).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.gWK = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bIA = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.gWM = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        Ex();
        this.gWN = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.gWO = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.gWP = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.gWQ = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.gWR = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.gWS = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.gWT = this.mRootView.findViewById(a.f.view_contribution_max);
        this.gWU = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.gWO.setIsRound(true);
        this.gWO.setAutoChangeStyle(false);
        this.gWV = new j(baseActivity, bdUniqueId, z, z3);
        this.gWV.a(new j.b() { // from class: com.baidu.tieba.ala.guardclub.l.2
            @Override // com.baidu.tieba.ala.guardclub.j.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(l.this.bRI, l.this.bRI.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(l.this.bRI.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName);
                    alaPersonCardActivityConfig.setOtherParams(l.this.otherParams);
                    alaPersonCardActivityConfig.setVid(l.this.bac);
                    alaPersonCardActivityConfig.setIsFromGuardClub(true);
                    alaPersonCardActivityConfig.setExtInfo(fVar.extInfoJson);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                }
            }
        });
        this.gWK.setAdapter((ListAdapter) this.gWV);
        if (z3) {
            this.gWL = new LoadMoreFooter(this.bRI);
            this.gWL.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.gWL.createView();
            this.gWK.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.l.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!l.this.gWL.isLoading() && l.this.gWJ.bVc() && i + i2 > i3 - 2 && l.this.gWJ.bVc()) {
                        l.this.gWJ.bVe();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gKM);
    }

    public void setFeedId(String str) {
        this.bac = str;
    }

    public final void Ex() {
        if (this.gWM != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bRI.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gWM.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gWM.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bRI.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gWM.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void nj(boolean z) {
        this.gWX = z;
    }

    public void completePullRefresh() {
        if (this.gWK != null) {
            this.gWK.completePullRefresh();
        }
    }

    public void bUZ() {
        if (this.gWL != null) {
            this.gWL.endLoadData();
            this.gWK.setNextPage(null);
        }
    }

    public void nk(boolean z) {
        if (z) {
            if (this.gWL != null) {
                this.gWK.setNextPage(null);
            }
        } else if (this.gWL != null) {
            if (this.gWL.getView().getParent() == null) {
                this.gWK.setNextPage(this.gWL);
            }
            this.gWL.showNoMoreData();
        }
    }

    public void bQN() {
        if (this.gWL != null) {
            if (this.gWL.getView().getParent() == null) {
                this.gWK.setNextPage(this.gWL);
            }
            this.gWL.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gWV != null) {
            this.gWV.setOtherParams(str);
        }
    }

    private void bQU() {
        bJ(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gWJ = gVar;
        this.gWJ.bVd();
    }

    public void cy(List<com.baidu.live.guardclub.f> list) {
        if (this.gWV != null && list != null && !list.isEmpty()) {
            bJ(0, 8);
            this.gWV.cy(list);
            return;
        }
        bQU();
    }

    public void Qx() {
        bNH();
    }

    public void bNH() {
        this.bIA.reset();
        this.bIA.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bIA.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.gWJ != null) {
                    l.this.gWJ.bVd();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bIA.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bIA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bIA.setVisibility(0);
        this.gWK.setVisibility(8);
        this.gWM.setVisibility(8);
    }

    private void bJ(int i, int i2) {
        this.gWK.setVisibility(i);
        if (i2 == 0) {
            this.bIA.reset();
            if (this.aGY) {
                this.bIA.setTitle(a.h.guard_member_list_empty_host);
            } else {
                this.bIA.setTitle(a.h.guard_member_list_empty);
            }
            this.bIA.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bIA.setVisibility(0);
            return;
        }
        this.bIA.setVisibility(8);
    }

    public void cz(List<com.baidu.live.guardclub.f> list) {
        if (this.gWV != null && this.gWv) {
            this.gWV.cz(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bUX() {
        if (this.gWV != null) {
            this.gWV.bUX();
        }
        MessageManager.getInstance().unRegisterListener(this.gKM);
    }
}
