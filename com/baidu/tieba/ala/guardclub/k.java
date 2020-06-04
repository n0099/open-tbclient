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
    private String aJO;
    private boolean avR;
    private CommonEmptyView beq;
    private BaseActivity bjI;
    CustomMessageListener foe;
    private com.baidu.tieba.ala.guardclub.model.g fyK;
    private BdListView fyL;
    private LoadMoreFooter fyM;
    private LinearLayout fyN;
    private TextView fyO;
    private HeadImageView fyP;
    private TbImageView fyQ;
    private TextView fyR;
    private TextView fyS;
    private TextView fyT;
    private View fyU;
    private View fyV;
    private i fyW;
    private boolean fyX;
    private boolean fyY;
    private View.OnClickListener fyZ;
    private final boolean fyv;
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
        if (this.fyW != null) {
            this.fyW.a(fVar);
        }
        if (z && !this.avR && fVar != null && !this.fyv) {
            this.fyN.setVisibility(0);
            this.fyO.setText(fVar.rank);
            if (fI(fVar.rank)) {
                this.fyO.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.fyO.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.fyR.setText(fVar.userName);
            if (fVar.aOA > 0) {
                this.fyS.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aOA));
            } else {
                this.fyS.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.fyP.startLoad(fVar.aOX, 12, false);
            String cp = com.baidu.live.guardclub.g.BH().cp(fVar.aOz);
            if (!TextUtils.isEmpty(cp)) {
                this.fyQ.startLoad(cp, 10, false);
                this.fyQ.setVisibility(0);
            } else {
                this.fyQ.setVisibility(4);
            }
            if (!this.isFullScreen && !this.fyY) {
                z2 = false;
            }
            this.fyT.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyU.getLayoutParams();
                layoutParams.rightMargin = this.fyU.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.fyU.setLayoutParams(layoutParams);
            }
            this.fyV.setVisibility(0);
            this.fyV.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.fyV.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aOA;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aOA <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.fyV.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.fyV.setLayoutParams(layoutParams2);
                }
            });
            this.fyT.setOnClickListener(this.fyZ);
            return;
        }
        this.fyN.setVisibility(8);
    }

    private boolean fI(String str) {
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
        this.fyZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.bjI != null) {
                    if (!k.this.isFullScreen) {
                        k.this.bjI.getActivity().setResult(-1);
                        k.this.bjI.getActivity().finish();
                    } else if (!TbadkCoreApplication.getInst().isMobileBaidu() || com.baidu.live.v.a.Ge().aWF.aya) {
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(k.this.bjI.getActivity());
                        alaLiveRoomActivityConfig.addExtraByLiveId(k.this.liveId, String.valueOf(k.this.roomId), TbConfig.getLiveEnterFrom());
                        alaLiveRoomActivityConfig.addExtraByParams(k.this.otherParams);
                        alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    }
                }
            }
        };
        this.foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.fyW != null) {
                        k.this.fyW.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bjI = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.fyv = z3;
        this.isFullScreen = z4;
        this.fyX = z2;
        this.avR = z;
        this.mRootView = LayoutInflater.from(this.bjI).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.fyL = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.beq = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.fyN = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        yL();
        this.fyO = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.fyP = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.fyQ = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.fyR = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.fyS = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.fyT = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.fyU = this.mRootView.findViewById(a.g.view_contribution_max);
        this.fyV = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.fyP.setIsRound(true);
        this.fyP.setAutoChangeStyle(false);
        this.fyW = new i(baseActivity, bdUniqueId, z, z3);
        this.fyW.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bjI, k.this.bjI.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bjI.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aOV ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aJO, k.this.otherParams, true)));
                }
            }
        });
        this.fyL.setAdapter((ListAdapter) this.fyW);
        if (z3) {
            this.fyM = new LoadMoreFooter(this.bjI);
            this.fyM.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.fyM.createView();
            this.fyL.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.fyM.isLoading() && k.this.fyK.buF() && i + i2 > i3 - 2 && k.this.fyK.buF()) {
                        k.this.fyK.buH();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.foe);
    }

    public void setFeedId(String str) {
        this.aJO = str;
    }

    public final void yL() {
        if (this.fyN != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bjI.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.fyN.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.fyN.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bjI.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.fyN.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void jY(boolean z) {
        this.fyY = z;
    }

    public void completePullRefresh() {
        if (this.fyL != null) {
            this.fyL.completePullRefresh();
        }
    }

    public void buA() {
        if (this.fyM != null) {
            this.fyM.endLoadData();
            this.fyL.setNextPage(null);
        }
    }

    public void jZ(boolean z) {
        if (z) {
            if (this.fyM != null) {
                this.fyL.setNextPage(null);
            }
        } else if (this.fyM != null) {
            if (this.fyM.getView().getParent() == null) {
                this.fyL.setNextPage(this.fyM);
            }
            this.fyM.showNoMoreData();
        }
    }

    public void bqM() {
        if (this.fyM != null) {
            if (this.fyM.getView().getParent() == null) {
                this.fyL.setNextPage(this.fyM);
            }
            this.fyM.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fyW != null) {
            this.fyW.setOtherParams(str);
        }
    }

    private void bqU() {
        bq(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.fyK = gVar;
        this.fyK.buG();
    }

    public void bA(List<com.baidu.live.guardclub.f> list) {
        if (this.fyW != null && list != null && !list.isEmpty()) {
            bq(0, 8);
            this.fyW.bA(list);
            return;
        }
        bqU();
    }

    public void buB() {
        bpd();
    }

    public void bpd() {
        this.beq.reset();
        this.beq.setTitle(a.i.sdk_net_fail_tip_rank);
        this.beq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fyK != null) {
                    k.this.fyK.buG();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.beq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.beq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.beq.setVisibility(0);
        this.fyL.setVisibility(8);
        this.fyN.setVisibility(8);
    }

    private void bq(int i, int i2) {
        this.fyL.setVisibility(i);
        if (i2 == 0) {
            this.beq.reset();
            if (this.avR) {
                this.beq.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.beq.setTitle(a.i.guard_member_list_empty);
            }
            this.beq.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.beq.setVisibility(0);
            return;
        }
        this.beq.setVisibility(8);
    }

    public void bB(List<com.baidu.live.guardclub.f> list) {
        if (this.fyW != null && this.fyv) {
            this.fyW.bB(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buy() {
        if (this.fyW != null) {
            this.fyW.buy();
        }
        MessageManager.getInstance().unRegisterListener(this.foe);
    }
}
