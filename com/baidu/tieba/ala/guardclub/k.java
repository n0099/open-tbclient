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
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.i;
import java.util.List;
/* loaded from: classes3.dex */
public class k extends BdBaseView<GuardClubMemberListActivity> {
    private boolean Yr;
    private CommonEmptyView aCX;
    private BaseActivity aGe;
    private com.baidu.tieba.ala.guardclub.model.g eFK;
    private BdListView eFL;
    private LoadMoreFooter eFM;
    private LinearLayout eFN;
    private TextView eFO;
    private HeadImageView eFP;
    private TbImageView eFQ;
    private TextView eFR;
    private TextView eFS;
    private TextView eFT;
    private View eFU;
    private View eFV;
    private i eFW;
    private boolean eFX;
    private boolean eFY;
    private View.OnClickListener eFZ;
    private final boolean eFv;
    CustomMessageListener evL;
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
        if (this.eFW != null) {
            this.eFW.a(fVar);
        }
        if (z && !this.Yr && fVar != null && !this.eFv) {
            this.eFN.setVisibility(0);
            this.eFO.setText(fVar.rank);
            if (ee(fVar.rank)) {
                this.eFO.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.eFO.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.eFR.setText(fVar.userName);
            if (fVar.apR > 0) {
                this.eFS.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.apR));
            } else {
                this.eFS.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.eFP.startLoad(fVar.aqo, 12, false);
            String bR = com.baidu.live.guardclub.g.vH().bR(fVar.apQ);
            if (!TextUtils.isEmpty(bR)) {
                this.eFQ.startLoad(bR, 10, false);
                this.eFQ.setVisibility(0);
            } else {
                this.eFQ.setVisibility(4);
            }
            if (!this.isFullScreen && !this.eFY) {
                z2 = false;
            }
            this.eFT.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFU.getLayoutParams();
                layoutParams.rightMargin = this.eFU.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.eFU.setLayoutParams(layoutParams);
            }
            this.eFV.setVisibility(0);
            this.eFV.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.eFV.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.apR;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.apR <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.eFV.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.eFV.setLayoutParams(layoutParams2);
                }
            });
            this.eFT.setOnClickListener(this.eFZ);
            return;
        }
        this.eFN.setVisibility(8);
    }

    private boolean ee(String str) {
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
        this.eFZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aGe != null) {
                    if (!k.this.isFullScreen) {
                        k.this.aGe.getActivity().setResult(-1);
                        k.this.aGe.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zl().awB.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.aGe.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.eFW != null) {
                        k.this.eFW.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.aGe = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.eFv = z3;
        this.isFullScreen = z4;
        this.eFX = z2;
        this.Yr = z;
        this.mRootView = LayoutInflater.from(this.aGe).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.eFL = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aCX = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.eFN = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        ta();
        this.eFO = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.eFP = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.eFQ = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.eFR = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.eFS = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.eFT = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.eFU = this.mRootView.findViewById(a.g.view_contribution_max);
        this.eFV = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.eFP.setIsRound(true);
        this.eFP.setAutoChangeStyle(false);
        this.eFW = new i(baseActivity, bdUniqueId, z, z3);
        this.eFW.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.aGe, k.this.aGe.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.aGe.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aqm ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.otherParams, true)));
                }
            }
        });
        this.eFL.setAdapter((ListAdapter) this.eFW);
        if (z3) {
            this.eFM = new LoadMoreFooter(this.aGe);
            this.eFM.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.eFM.createView();
            this.eFL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.eFM.isLoading() && k.this.eFK.bfq() && i + i2 > i3 - 2 && k.this.eFK.bfq()) {
                        k.this.eFK.bfs();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.evL);
    }

    public final void ta() {
        if (this.eFN != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.aGe.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.eFN.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.eFN.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.aGe.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.eFN.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void iC(boolean z) {
        this.eFY = z;
    }

    public void completePullRefresh() {
        if (this.eFL != null) {
            this.eFL.completePullRefresh();
        }
    }

    public void bfl() {
        if (this.eFM != null) {
            this.eFM.endLoadData();
            this.eFL.setNextPage(null);
        }
    }

    public void iD(boolean z) {
        if (z) {
            if (this.eFM != null) {
                this.eFL.setNextPage(null);
            }
        } else if (this.eFM != null) {
            if (this.eFM.getView().getParent() == null) {
                this.eFL.setNextPage(this.eFM);
            }
            this.eFM.showNoMoreData();
        }
    }

    public void bcu() {
        if (this.eFM != null) {
            if (this.eFM.getView().getParent() == null) {
                this.eFL.setNextPage(this.eFM);
            }
            this.eFM.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eFW != null) {
            this.eFW.setOtherParams(str);
        }
    }

    private void aiu() {
        bh(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.eFK = gVar;
        this.eFK.bfr();
    }

    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (this.eFW != null && list != null && !list.isEmpty()) {
            bh(0, 8);
            this.eFW.bu(list);
            return;
        }
        aiu();
    }

    public void bfm() {
        bbB();
    }

    public void bbB() {
        this.aCX.reset();
        this.aCX.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aCX.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.eFK != null) {
                    k.this.eFK.bfr();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aCX.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aCX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aCX.setVisibility(0);
        this.eFL.setVisibility(8);
        this.eFN.setVisibility(8);
    }

    private void bh(int i, int i2) {
        this.eFL.setVisibility(i);
        if (i2 == 0) {
            this.aCX.reset();
            if (this.Yr) {
                this.aCX.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aCX.setTitle(a.i.guard_member_list_empty);
            }
            this.aCX.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aCX.setVisibility(0);
            return;
        }
        this.aCX.setVisibility(8);
    }

    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (this.eFW != null && this.eFv) {
            this.eFW.bv(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfj() {
        if (this.eFW != null) {
            this.eFW.bfj();
        }
        MessageManager.getInstance().unRegisterListener(this.evL);
    }
}
