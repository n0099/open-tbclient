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
    private boolean aIu;
    private String aZH;
    private CommonEmptyView bDp;
    private BaseActivity bLI;
    private TextView gGA;
    private TextView gGB;
    private TextView gGC;
    private View gGD;
    private View gGE;
    private i gGF;
    private boolean gGG;
    private boolean gGH;
    private View.OnClickListener gGI;
    private final boolean gGf;
    private com.baidu.tieba.ala.guardclub.model.g gGt;
    private BdListView gGu;
    private LoadMoreFooter gGv;
    private LinearLayout gGw;
    private TextView gGx;
    private HeadImageView gGy;
    private TbImageView gGz;
    CustomMessageListener guV;
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
        if (this.gGF != null) {
            this.gGF.a(fVar);
        }
        if (z && !this.aIu && fVar != null && !this.gGf) {
            this.gGw.setVisibility(0);
            this.gGx.setText(fVar.rank);
            if (iu(fVar.rank)) {
                this.gGx.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.gGx.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.gGA.setText(fVar.userName);
            if (fVar.beF > 0) {
                this.gGB.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.beF));
            } else {
                this.gGB.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.gGy.startLoad(fVar.bfc, 12, false);
            String ex = com.baidu.live.guardclub.g.JW().ex(fVar.beE);
            if (!TextUtils.isEmpty(ex)) {
                this.gGz.startLoad(ex, 10, false);
                this.gGz.setVisibility(0);
            } else {
                this.gGz.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gGH) {
                z2 = false;
            }
            this.gGC.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGD.getLayoutParams();
                layoutParams.rightMargin = this.gGD.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.gGD.setLayoutParams(layoutParams);
            }
            this.gGE.setVisibility(0);
            this.gGE.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.gGE.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.beF;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.beF <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.gGE.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.gGE.setLayoutParams(layoutParams2);
                }
            });
            this.gGC.setOnClickListener(this.gGI);
            return;
        }
        this.gGw.setVisibility(8);
    }

    private boolean iu(String str) {
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
        this.gGI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bLI != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bLI.getActivity().setResult(-1);
                        k.this.bLI.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.Ph().bms.aLa) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bLI.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.gGF != null) {
                        k.this.gGF.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bLI = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gGf = z3;
        this.isFullScreen = z4;
        this.gGG = z2;
        this.aIu = z;
        this.mRootView = LayoutInflater.from(this.bLI).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.gGu = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bDp = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.gGw = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        Ha();
        this.gGx = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.gGy = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.gGz = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.gGA = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.gGB = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.gGC = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.gGD = this.mRootView.findViewById(a.f.view_contribution_max);
        this.gGE = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.gGy.setIsRound(true);
        this.gGy.setAutoChangeStyle(false);
        this.gGF = new i(baseActivity, bdUniqueId, z, z3);
        this.gGF.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bLI, k.this.bLI.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bLI.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aZH, k.this.otherParams, true)));
                }
            }
        });
        this.gGu.setAdapter((ListAdapter) this.gGF);
        if (z3) {
            this.gGv = new LoadMoreFooter(this.bLI);
            this.gGv.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.gGv.createView();
            this.gGu.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.gGv.isLoading() && k.this.gGt.bSD() && i + i2 > i3 - 2 && k.this.gGt.bSD()) {
                        k.this.gGt.bSF();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.guV);
    }

    public void setFeedId(String str) {
        this.aZH = str;
    }

    public final void Ha() {
        if (this.gGw != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bLI.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gGw.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gGw.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bLI.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gGw.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void ms(boolean z) {
        this.gGH = z;
    }

    public void completePullRefresh() {
        if (this.gGu != null) {
            this.gGu.completePullRefresh();
        }
    }

    public void bSA() {
        if (this.gGv != null) {
            this.gGv.endLoadData();
            this.gGu.setNextPage(null);
        }
    }

    public void mt(boolean z) {
        if (z) {
            if (this.gGv != null) {
                this.gGu.setNextPage(null);
            }
        } else if (this.gGv != null) {
            if (this.gGv.getView().getParent() == null) {
                this.gGu.setNextPage(this.gGv);
            }
            this.gGv.showNoMoreData();
        }
    }

    public void bOq() {
        if (this.gGv != null) {
            if (this.gGv.getView().getParent() == null) {
                this.gGu.setNextPage(this.gGv);
            }
            this.gGv.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gGF != null) {
            this.gGF.setOtherParams(str);
        }
    }

    private void bOx() {
        bG(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gGt = gVar;
        this.gGt.bSE();
    }

    public void cn(List<com.baidu.live.guardclub.f> list) {
        if (this.gGF != null && list != null && !list.isEmpty()) {
            bG(0, 8);
            this.gGF.cn(list);
            return;
        }
        bOx();
    }

    public void QP() {
        bLo();
    }

    public void bLo() {
        this.bDp.reset();
        this.bDp.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bDp.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gGt != null) {
                    k.this.gGt.bSE();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bDp.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bDp.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bDp.setVisibility(0);
        this.gGu.setVisibility(8);
        this.gGw.setVisibility(8);
    }

    private void bG(int i, int i2) {
        this.gGu.setVisibility(i);
        if (i2 == 0) {
            this.bDp.reset();
            if (this.aIu) {
                this.bDp.setTitle(a.h.guard_member_list_empty_host);
            } else {
                this.bDp.setTitle(a.h.guard_member_list_empty);
            }
            this.bDp.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bDp.setVisibility(0);
            return;
        }
        this.bDp.setVisibility(8);
    }

    public void co(List<com.baidu.live.guardclub.f> list) {
        if (this.gGF != null && this.gGf) {
            this.gGF.co(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSy() {
        if (this.gGF != null) {
            this.gGF.bSy();
        }
        MessageManager.getInstance().unRegisterListener(this.guV);
    }
}
