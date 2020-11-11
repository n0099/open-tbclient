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
    private boolean aKf;
    private CommonEmptyView bFa;
    private BaseActivity bNs;
    private String bbt;
    private com.baidu.tieba.ala.guardclub.model.g gGM;
    private BdListView gGN;
    private LoadMoreFooter gGO;
    private LinearLayout gGP;
    private TextView gGQ;
    private HeadImageView gGR;
    private TbImageView gGS;
    private TextView gGT;
    private TextView gGU;
    private TextView gGV;
    private View gGW;
    private View gGX;
    private i gGY;
    private boolean gGZ;
    private final boolean gGy;
    private boolean gHa;
    private View.OnClickListener gHb;
    CustomMessageListener gvo;
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
        if (this.gGY != null) {
            this.gGY.a(fVar);
        }
        if (z && !this.aKf && fVar != null && !this.gGy) {
            this.gGP.setVisibility(0);
            this.gGQ.setText(fVar.rank);
            if (iA(fVar.rank)) {
                this.gGQ.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36));
            } else {
                this.gGQ.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_fontsize20));
            }
            this.gGT.setText(fVar.userName);
            if (fVar.bgt > 0) {
                this.gGU.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score + "/" + fVar.bgt));
            } else {
                this.gGU.setText(String.format(this.mContext.getString(a.h.guard_member_list_contribution), fVar.score));
            }
            this.gGR.startLoad(fVar.bgP, 12, false);
            String eB = com.baidu.live.guardclub.g.KF().eB(fVar.bgr);
            if (!TextUtils.isEmpty(eB)) {
                this.gGS.startLoad(eB, 10, false);
                this.gGS.setVisibility(0);
            } else {
                this.gGS.setVisibility(4);
            }
            if (!this.isFullScreen && !this.gHa) {
                z2 = false;
            }
            this.gGV.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGW.getLayoutParams();
                layoutParams.rightMargin = this.gGW.getResources().getDimensionPixelOffset(a.d.sdk_ds148);
                this.gGW.setLayoutParams(layoutParams);
            }
            this.gGX.setVisibility(0);
            this.gGX.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.gGX.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.bgt;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.bgt <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.gGX.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.gGX.setLayoutParams(layoutParams2);
                }
            });
            this.gGV.setOnClickListener(this.gHb);
            return;
        }
        this.gGP.setVisibility(8);
    }

    private boolean iA(String str) {
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
        this.gHb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bNs != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bNs.getActivity().setResult(-1);
                        k.this.bNs.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.aa.a.PQ().bod.aML) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bNs.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.gGY != null) {
                        k.this.gGY.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bNs = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.gGy = z3;
        this.isFullScreen = z4;
        this.gGZ = z2;
        this.aKf = z;
        this.mRootView = LayoutInflater.from(this.bNs).inflate(a.g.layout_guard_club_member_list, (ViewGroup) null);
        this.gGN = (BdListView) this.mRootView.findViewById(a.f.list_guard_club_member);
        this.bFa = (CommonEmptyView) this.mRootView.findViewById(a.f.guard_club_member_empty_view);
        this.gGP = (LinearLayout) this.mRootView.findViewById(a.f.layout_guard_user_info);
        HJ();
        this.gGQ = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_rank);
        this.gGR = (HeadImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_header);
        this.gGS = (TbImageView) this.mRootView.findViewById(a.f.img_guard_club_list_user_medal);
        this.gGT = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_name);
        this.gGU = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_num);
        this.gGV = (TextView) this.mRootView.findViewById(a.f.tv_guard_club_list_user_followed);
        this.gGW = this.mRootView.findViewById(a.f.view_contribution_max);
        this.gGX = this.mRootView.findViewById(a.f.view_guard_user_contribution);
        this.gGR.setIsRound(true);
        this.gGR.setAutoChangeStyle(false);
        this.gGY = new i(baseActivity, bdUniqueId, z, z3);
        this.gGY.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bNs, k.this.bNs.getString(a.h.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bNs.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.isFollowed ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.bbt, k.this.otherParams, true)));
                }
            }
        });
        this.gGN.setAdapter((ListAdapter) this.gGY);
        if (z3) {
            this.gGO = new LoadMoreFooter(this.bNs);
            this.gGO.setBackgroundColor(this.mContext.getResources().getColor(a.c.live_gcb_primary));
            this.gGO.createView();
            this.gGN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.gGO.isLoading() && k.this.gGM.bTk() && i + i2 > i3 - 2 && k.this.gGM.bTk()) {
                        k.this.gGM.bTm();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.gvo);
    }

    public void setFeedId(String str) {
        this.bbt = str;
    }

    public final void HJ() {
        if (this.gGP != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bNs.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.gGP.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.gGP.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bNs.getPageContext().getResources().getDimensionPixelOffset(a.d.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.gGP.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void mr(boolean z) {
        this.gHa = z;
    }

    public void completePullRefresh() {
        if (this.gGN != null) {
            this.gGN.completePullRefresh();
        }
    }

    public void bTh() {
        if (this.gGO != null) {
            this.gGO.endLoadData();
            this.gGN.setNextPage(null);
        }
    }

    public void ms(boolean z) {
        if (z) {
            if (this.gGO != null) {
                this.gGN.setNextPage(null);
            }
        } else if (this.gGO != null) {
            if (this.gGO.getView().getParent() == null) {
                this.gGN.setNextPage(this.gGO);
            }
            this.gGO.showNoMoreData();
        }
    }

    public void bOX() {
        if (this.gGO != null) {
            if (this.gGO.getView().getParent() == null) {
                this.gGN.setNextPage(this.gGO);
            }
            this.gGO.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gGY != null) {
            this.gGY.setOtherParams(str);
        }
    }

    private void bPe() {
        bG(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.gGM = gVar;
        this.gGM.bTl();
    }

    public void cn(List<com.baidu.live.guardclub.f> list) {
        if (this.gGY != null && list != null && !list.isEmpty()) {
            bG(0, 8);
            this.gGY.cn(list);
            return;
        }
        bPe();
    }

    public void Ry() {
        bLV();
    }

    public void bLV() {
        this.bFa.reset();
        this.bFa.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bFa.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gGM != null) {
                    k.this.gGM.bTl();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bFa.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bFa.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bFa.setVisibility(0);
        this.gGN.setVisibility(8);
        this.gGP.setVisibility(8);
    }

    private void bG(int i, int i2) {
        this.gGN.setVisibility(i);
        if (i2 == 0) {
            this.bFa.reset();
            if (this.aKf) {
                this.bFa.setTitle(a.h.guard_member_list_empty_host);
            } else {
                this.bFa.setTitle(a.h.guard_member_list_empty);
            }
            this.bFa.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.bFa.setVisibility(0);
            return;
        }
        this.bFa.setVisibility(8);
    }

    public void co(List<com.baidu.live.guardclub.f> list) {
        if (this.gGY != null && this.gGy) {
            this.gGY.co(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bTf() {
        if (this.gGY != null) {
            this.gGY.bTf();
        }
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }
}
