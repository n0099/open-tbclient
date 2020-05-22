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
    CustomMessageListener fnT;
    private BdListView fyA;
    private LoadMoreFooter fyB;
    private LinearLayout fyC;
    private TextView fyD;
    private HeadImageView fyE;
    private TbImageView fyF;
    private TextView fyG;
    private TextView fyH;
    private TextView fyI;
    private View fyJ;
    private View fyK;
    private i fyL;
    private boolean fyM;
    private boolean fyN;
    private View.OnClickListener fyO;
    private final boolean fyk;
    private com.baidu.tieba.ala.guardclub.model.g fyz;
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
        if (this.fyL != null) {
            this.fyL.a(fVar);
        }
        if (z && !this.avR && fVar != null && !this.fyk) {
            this.fyC.setVisibility(0);
            this.fyD.setText(fVar.rank);
            if (fI(fVar.rank)) {
                this.fyD.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.fyD.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.fyG.setText(fVar.userName);
            if (fVar.aOA > 0) {
                this.fyH.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score + "/" + fVar.aOA));
            } else {
                this.fyH.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), fVar.score));
            }
            this.fyE.startLoad(fVar.aOX, 12, false);
            String cn = com.baidu.live.guardclub.g.BH().cn(fVar.aOz);
            if (!TextUtils.isEmpty(cn)) {
                this.fyF.startLoad(cn, 10, false);
                this.fyF.setVisibility(0);
            } else {
                this.fyF.setVisibility(4);
            }
            if (!this.isFullScreen && !this.fyN) {
                z2 = false;
            }
            this.fyI.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fyJ.getLayoutParams();
                layoutParams.rightMargin = this.fyJ.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.fyJ.setLayoutParams(layoutParams);
            }
            this.fyK.setVisibility(0);
            this.fyK.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.k.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) k.this.fyK.getParent()).getWidth();
                    double parseLong = (Long.parseLong(fVar.score) * 1.0d) / fVar.aOA;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (fVar.aOA <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = k.this.fyK.getLayoutParams();
                    layoutParams2.width = i;
                    k.this.fyK.setLayoutParams(layoutParams2);
                }
            });
            this.fyI.setOnClickListener(this.fyO);
            return;
        }
        this.fyC.setVisibility(8);
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
        this.fyO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.5
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
        this.fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.k.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    k.this.otherParams = str;
                    if (k.this.fyL != null) {
                        k.this.fyL.setOtherParams(k.this.otherParams);
                    }
                }
            }
        };
        this.bjI = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.fyk = z3;
        this.isFullScreen = z4;
        this.fyM = z2;
        this.avR = z;
        this.mRootView = LayoutInflater.from(this.bjI).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.fyA = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.beq = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.fyC = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        yL();
        this.fyD = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.fyE = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.fyF = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.fyG = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.fyH = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.fyI = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.fyJ = this.mRootView.findViewById(a.g.view_contribution_max);
        this.fyK = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.fyE.setIsRound(true);
        this.fyE.setAutoChangeStyle(false);
        this.fyL = new i(baseActivity, bdUniqueId, z, z3);
        this.fyL.a(new i.b() { // from class: com.baidu.tieba.ala.guardclub.k.2
            @Override // com.baidu.tieba.ala.guardclub.i.b
            public void d(com.baidu.live.guardclub.f fVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(k.this.bjI, k.this.bjI.getString(a.i.sdk_neterror));
                } else if (fVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(k.this.bjI.getActivity(), String.valueOf(fVar.userId), fVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, fVar.aOV ? 1 : 0, "", "", false, null, null, fVar.userName, k.this.aJO, k.this.otherParams, true)));
                }
            }
        });
        this.fyA.setAdapter((ListAdapter) this.fyL);
        if (z3) {
            this.fyB = new LoadMoreFooter(this.bjI);
            this.fyB.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.fyB.createView();
            this.fyA.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.k.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!k.this.fyB.isLoading() && k.this.fyz.buD() && i + i2 > i3 - 2 && k.this.fyz.buD()) {
                        k.this.fyz.buF();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.fnT);
    }

    public void setFeedId(String str) {
        this.aJO = str;
    }

    public final void yL() {
        if (this.fyC != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.bjI.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.fyC.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.fyC.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.bjI.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.fyC.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void jY(boolean z) {
        this.fyN = z;
    }

    public void completePullRefresh() {
        if (this.fyA != null) {
            this.fyA.completePullRefresh();
        }
    }

    public void buy() {
        if (this.fyB != null) {
            this.fyB.endLoadData();
            this.fyA.setNextPage(null);
        }
    }

    public void jZ(boolean z) {
        if (z) {
            if (this.fyB != null) {
                this.fyA.setNextPage(null);
            }
        } else if (this.fyB != null) {
            if (this.fyB.getView().getParent() == null) {
                this.fyA.setNextPage(this.fyB);
            }
            this.fyB.showNoMoreData();
        }
    }

    public void bqK() {
        if (this.fyB != null) {
            if (this.fyB.getView().getParent() == null) {
                this.fyA.setNextPage(this.fyB);
            }
            this.fyB.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fyL != null) {
            this.fyL.setOtherParams(str);
        }
    }

    private void bqS() {
        bq(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.g gVar) {
        this.fyz = gVar;
        this.fyz.buE();
    }

    public void bA(List<com.baidu.live.guardclub.f> list) {
        if (this.fyL != null && list != null && !list.isEmpty()) {
            bq(0, 8);
            this.fyL.bA(list);
            return;
        }
        bqS();
    }

    public void buz() {
        bpb();
    }

    public void bpb() {
        this.beq.reset();
        this.beq.setTitle(a.i.sdk_net_fail_tip_rank);
        this.beq.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.fyz != null) {
                    k.this.fyz.buE();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.beq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.beq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.beq.setVisibility(0);
        this.fyA.setVisibility(8);
        this.fyC.setVisibility(8);
    }

    private void bq(int i, int i2) {
        this.fyA.setVisibility(i);
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
        if (this.fyL != null && this.fyk) {
            this.fyL.bB(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buw() {
        if (this.fyL != null) {
            this.fyL.buw();
        }
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }
}
