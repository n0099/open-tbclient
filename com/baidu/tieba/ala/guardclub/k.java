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
    private CommonEmptyView aCW;
    private BaseActivity aGd;
    private com.baidu.tieba.ala.guardclub.model.g eFJ;
    private BdListView eFK;
    private LoadMoreFooter eFL;
    private LinearLayout eFM;
    private TextView eFN;
    private HeadImageView eFO;
    private TbImageView eFP;
    private TextView eFQ;
    private TextView eFR;
    private TextView eFS;
    private View eFT;
    private View eFU;
    private i eFV;
    private boolean eFW;
    private boolean eFX;
    private View.OnClickListener eFY;
    private final boolean eFu;
    CustomMessageListener evK;
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
        if (this.eFV != null) {
            this.eFV.a(fVar);
        }
        if (z && !this.Yr && fVar != null && !this.eFu) {
            this.eFM.setVisibility(0);
            this.eFN.setText(fVar.rank);
            if (ee(fVar.rank)) {
                this.eFN.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.eFN.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.eFQ.setText(fVar.userName);
            if (fVar.apR > 0) {
                this.eFR.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.apR));
            } else {
                this.eFR.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.eFO.startLoad(fVar.aqo, 12, false);
            String bR = com.baidu.live.guardclub.g.vH().bR(fVar.apQ);
            if (!TextUtils.isEmpty(bR)) {
                this.eFP.startLoad(bR, 10, false);
                this.eFP.setVisibility(0);
            } else {
                this.eFP.setVisibility(4);
            }
            if (!this.isFullScreen && !this.eFX) {
                z2 = false;
            }
            this.eFS.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFT.getLayoutParams();
                layoutParams.rightMargin = this.eFT.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.eFT.setLayoutParams(layoutParams);
            }
            this.eFU.setVisibility(0);
            this.eFU.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.eFU.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.apR;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.apR <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.eFU.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.eFU.setLayoutParams(layoutParams2);
                }
            });
            this.eFS.setOnClickListener(this.eFY);
            return;
        }
        this.eFM.setVisibility(8);
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
        this.eFY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.aGd != null) {
                    if (!k.this.isFullScreen) {
                        k.this.aGd.getActivity().setResult(-1);
                        k.this.aGd.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.zj().awA.aav) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.aGd.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.eFV != null) {
                        k.this.eFV.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.aGd = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.eFu = z3;
        this.isFullScreen = z4;
        this.eFW = z2;
        this.Yr = z;
        this.mRootView = LayoutInflater.from(this.aGd).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.eFK = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aCW = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.eFM = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        ta();
        this.eFN = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.eFO = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.eFP = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.eFQ = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.eFR = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.eFS = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.eFT = this.mRootView.findViewById(a.g.view_contribution_max);
        this.eFU = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.eFO.setIsRound(true);
        this.eFO.setAutoChangeStyle(false);
        this.eFV = new i(baseActivity, bdUniqueId, z, z3);
        this.eFV.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.aGd, k.this.aGd.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.aGd.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aqm ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.otherParams, true)));
                }
            }
        });
        this.eFK.setAdapter((ListAdapter) this.eFV);
        if (z3) {
            this.eFL = new LoadMoreFooter(this.aGd);
            this.eFL.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.eFL.createView();
            this.eFK.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.eFL.isLoading() && k.this.eFJ.bfo() && i + i2 > i3 - 2 && k.this.eFJ.bfo()) {
                        k.this.eFJ.bfq();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.evK);
    }

    public final void ta() {
        if (this.eFM != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.aGd.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.eFM.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.eFM.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.aGd.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.eFM.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void iC(boolean z) {
        this.eFX = z;
    }

    public void completePullRefresh() {
        if (this.eFK != null) {
            this.eFK.completePullRefresh();
        }
    }

    public void bfj() {
        if (this.eFL != null) {
            this.eFL.endLoadData();
            this.eFK.setNextPage(null);
        }
    }

    public void iD(boolean z) {
        if (z) {
            if (this.eFL != null) {
                this.eFK.setNextPage(null);
            }
        } else if (this.eFL != null) {
            if (this.eFL.getView().getParent() == null) {
                this.eFK.setNextPage(this.eFL);
            }
            this.eFL.showNoMoreData();
        }
    }

    public void bcs() {
        if (this.eFL != null) {
            if (this.eFL.getView().getParent() == null) {
                this.eFK.setNextPage(this.eFL);
            }
            this.eFL.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.eFV != null) {
            this.eFV.setOtherParams(str);
        }
    }

    private void ais() {
        bh(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.eFJ = gVar;
        this.eFJ.bfp();
    }

    public void bu(List<com.baidu.live.guardclub.f> list) {
        if (this.eFV != null && list != null && !list.isEmpty()) {
            bh(0, 8);
            this.eFV.bu(list);
            return;
        }
        ais();
    }

    public void bfk() {
        bbz();
    }

    public void bbz() {
        this.aCW.reset();
        this.aCW.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aCW.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.eFJ != null) {
                    k.this.eFJ.bfp();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aCW.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aCW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aCW.setVisibility(0);
        this.eFK.setVisibility(8);
        this.eFM.setVisibility(8);
    }

    private void bh(int i, int i2) {
        this.eFK.setVisibility(i);
        if (i2 == 0) {
            this.aCW.reset();
            if (this.Yr) {
                this.aCW.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aCW.setTitle(a.i.guard_member_list_empty);
            }
            this.aCW.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aCW.setVisibility(0);
            return;
        }
        this.aCW.setVisibility(8);
    }

    public void bv(List<com.baidu.live.guardclub.f> list) {
        if (this.eFV != null && this.eFu) {
            this.eFV.bv(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfh() {
        if (this.eFV != null) {
            this.eFV.bfh();
        }
        MessageManager.getInstance().unRegisterListener(this.evK);
    }
}
