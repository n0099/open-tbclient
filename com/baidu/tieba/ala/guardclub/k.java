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
/* loaded from: classes3.dex */
public class k extends BdBaseView<GuardClubMemberListActivity> {
    private String aMu;
    private boolean axZ;
    private CommonEmptyView bjC;
    private BaseActivity boL;
    private final boolean fJF;
    private com.baidu.tieba.ala.guardclub.model.g fJU;
    private BdListView fJV;
    private LoadMoreFooter fJW;
    private LinearLayout fJX;
    private TextView fJY;
    private HeadImageView fJZ;
    private TbImageView fKa;
    private TextView fKb;
    private TextView fKc;
    private TextView fKd;
    private View fKe;
    private View fKf;
    private i fKg;
    private boolean fKh;
    private boolean fKi;
    private View.OnClickListener fKj;
    CustomMessageListener fzr;
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
        if (this.fKg != null) {
            this.fKg.a(fVar);
        }
        if (z && !this.axZ && fVar != null && !this.fJF) {
            this.fJX.setVisibility(0);
            this.fJY.setText(fVar.rank);
            if (fQ(fVar.rank)) {
                this.fJY.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.fJY.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.fKb.setText(fVar.userName);
            if (fVar.aRg > 0) {
                this.fKc.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aRg));
            } else {
                this.fKc.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.fJZ.startLoad(fVar.aRD, 12, false);
            String cv = com.baidu.live.guardclub.g.Ch().cv(fVar.aRf);
            if (!TextUtils.isEmpty(cv)) {
                this.fKa.startLoad(cv, 10, false);
                this.fKa.setVisibility(0);
            } else {
                this.fKa.setVisibility(4);
            }
            if (!this.isFullScreen && !this.fKi) {
                z2 = false;
            }
            this.fKd.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fKe.getLayoutParams();
                layoutParams.rightMargin = this.fKe.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.fKe.setLayoutParams(layoutParams);
            }
            this.fKf.setVisibility(0);
            this.fKf.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.fKf.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aRg;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aRg <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.fKf.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.fKf.setLayoutParams(layoutParams2);
                }
            });
            this.fKd.setOnClickListener(this.fKj);
            return;
        }
        this.fJX.setVisibility(8);
    }

    private boolean fQ(String str) {
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
        this.fKj = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.boL != null) {
                    if (!k.this.isFullScreen) {
                        k.this.boL.getActivity().setResult(-1);
                        k.this.boL.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Hm().aZp.aAp) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.boL.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.fKg != null) {
                        k.this.fKg.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.boL = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.fJF = z3;
        this.isFullScreen = z4;
        this.fKh = z2;
        this.axZ = z;
        this.mRootView = LayoutInflater.from(this.boL).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.fJV = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.bjC = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.fJX = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        zl();
        this.fJY = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.fJZ = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.fKa = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.fKb = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.fKc = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.fKd = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.fKe = this.mRootView.findViewById(a.g.view_contribution_max);
        this.fKf = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.fJZ.setIsRound(true);
        this.fJZ.setAutoChangeStyle(false);
        this.fKg = new i(baseActivity, bdUniqueId, z, z3);
        this.fKg.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.boL, k.this.boL.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.boL.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aRB ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aMu, k.this.otherParams, true)));
                }
            }
        });
        this.fJV.setAdapter((ListAdapter) this.fKg);
        if (z3) {
            this.fJW = new LoadMoreFooter(this.boL);
            this.fJW.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.fJW.createView();
            this.fJV.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.fJW.isLoading() && k.this.fJU.bxB() && i + i2 > i3 - 2 && k.this.fJU.bxB()) {
                        k.this.fJU.bxD();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fzr);
    }

    public void setFeedId(String str) {
        this.aMu = str;
    }

    public final void zl() {
        if (this.fJX != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.boL.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.fJX.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.fJX.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.boL.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.fJX.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void km(boolean z) {
        this.fKi = z;
    }

    public void completePullRefresh() {
        if (this.fJV != null) {
            this.fJV.completePullRefresh();
        }
    }

    public void bxw() {
        if (this.fJW != null) {
            this.fJW.endLoadData();
            this.fJV.setNextPage(null);
        }
    }

    public void kn(boolean z) {
        if (z) {
            if (this.fJW != null) {
                this.fJV.setNextPage(null);
            }
        } else if (this.fJW != null) {
            if (this.fJW.getView().getParent() == null) {
                this.fJV.setNextPage(this.fJW);
            }
            this.fJW.showNoMoreData();
        }
    }

    public void btK() {
        if (this.fJW != null) {
            if (this.fJW.getView().getParent() == null) {
                this.fJV.setNextPage(this.fJW);
            }
            this.fJW.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fKg != null) {
            this.fKg.setOtherParams(str);
        }
    }

    private void btS() {
        bu(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.fJU = gVar;
        this.fJU.bxC();
    }

    public void bJ(List<com.baidu.live.guardclub.f> list) {
        if (this.fKg != null && list != null && !list.isEmpty()) {
            bu(0, 8);
            this.fKg.bJ(list);
            return;
        }
        btS();
    }

    public void bxx() {
        brE();
    }

    public void brE() {
        this.bjC.reset();
        this.bjC.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bjC.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fJU != null) {
                    k.this.fJU.bxC();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bjC.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bjC.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bjC.setVisibility(0);
        this.fJV.setVisibility(8);
        this.fJX.setVisibility(8);
    }

    private void bu(int i, int i2) {
        this.fJV.setVisibility(i);
        if (i2 == 0) {
            this.bjC.reset();
            if (this.axZ) {
                this.bjC.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.bjC.setTitle(a.i.guard_member_list_empty);
            }
            this.bjC.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bjC.setVisibility(0);
            return;
        }
        this.bjC.setVisibility(8);
    }

    public void bK(List<com.baidu.live.guardclub.f> list) {
        if (this.fKg != null && this.fJF) {
            this.fKg.bK(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bxu() {
        if (this.fKg != null) {
            this.fKg.bxu();
        }
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }
}
