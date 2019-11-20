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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.guardclub.g;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends BdBaseView<GuardClubMemberListActivity> {
    private boolean Pr;
    private CommonEmptyView aqh;
    private BaseActivity atk;
    CustomMessageListener dEz;
    private final boolean dLJ;
    private com.baidu.tieba.ala.guardclub.model.l dLY;
    private BdListView dLZ;
    private LoadMoreFooter dMa;
    private LinearLayout dMb;
    private TextView dMc;
    private HeadImageView dMd;
    private TbImageView dMe;
    private TextView dMf;
    private TextView dMg;
    private TextView dMh;
    private View dMi;
    private View dMj;
    private g dMk;
    private boolean dMl;
    private boolean dMm;
    private View.OnClickListener dMn;
    private boolean isFullScreen;
    private long liveId;
    private View mRootView;
    private String otherParams;
    private long roomId;

    public View getView() {
        return this.mRootView;
    }

    public void a(boolean z, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        boolean z2 = true;
        if (this.dMk != null) {
            this.dMk.a(kVar);
        }
        if (z && !this.Pr && kVar != null && !this.dLJ) {
            this.dMb.setVisibility(0);
            this.dMc.setText(kVar.rank);
            if (cU(kVar.rank)) {
                this.dMc.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36));
            } else {
                this.dMc.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_fontsize20));
            }
            this.dMf.setText(kVar.userName);
            if (kVar.dNm > 0) {
                this.dMg.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score + "/" + kVar.dNm));
            } else {
                this.dMg.setText(String.format(this.mContext.getString(a.i.guard_member_list_contribution), kVar.score));
            }
            this.dMd.startLoad(kVar.dlx, 12, false);
            String mL = m.aLv().mL(kVar.dNl);
            if (!TextUtils.isEmpty(mL)) {
                this.dMe.startLoad(mL, 10, false);
                this.dMe.setVisibility(0);
            } else {
                this.dMe.setVisibility(4);
            }
            if (!this.isFullScreen && !this.dMm) {
                z2 = false;
            }
            this.dMh.setVisibility(z2 ? 8 : 0);
            if (z2) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dMi.getLayoutParams();
                layoutParams.rightMargin = this.dMi.getResources().getDimensionPixelOffset(a.e.sdk_ds148);
                this.dMi.setLayoutParams(layoutParams);
            }
            this.dMj.setVisibility(0);
            this.dMj.post(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.i.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = ((View) i.this.dMj.getParent()).getWidth();
                    double parseLong = (Long.parseLong(kVar.score) * 1.0d) / kVar.dNm;
                    if (parseLong < 0.05d) {
                        parseLong = 0.05000000074505806d;
                    }
                    int i = (int) (parseLong * width);
                    if (kVar.dNm <= 0) {
                        i = width;
                    }
                    ViewGroup.LayoutParams layoutParams2 = i.this.dMj.getLayoutParams();
                    layoutParams2.width = i;
                    i.this.dMj.setLayoutParams(layoutParams2);
                }
            });
            this.dMh.setOnClickListener(this.dMn);
            return;
        }
        this.dMb.setVisibility(8);
    }

    private boolean cU(String str) {
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

    public i(BaseActivity baseActivity, long j, long j2, boolean z, boolean z2, boolean z3, boolean z4, BdUniqueId bdUniqueId) {
        super(baseActivity.getPageContext());
        this.dMn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.atk != null) {
                    if (!i.this.isFullScreen) {
                        i.this.atk.getActivity().setResult(-1);
                        i.this.atk.getActivity().finish();
                        return;
                    }
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(i.this.atk.getActivity());
                    alaLiveRoomActivityConfig.addExtraByLiveId(i.this.liveId, String.valueOf(i.this.roomId), TbConfig.getLiveEnterFrom());
                    alaLiveRoomActivityConfig.addExtraByParams(i.this.otherParams);
                    alaLiveRoomActivityConfig.getIntent().putExtra("FROM_GUARD_CLUB_MEMBER_LIST", true);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                }
            }
        };
        this.dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.i.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    String str = (String) customResponsedMessage.getData();
                    if (str == null) {
                        str = "";
                    }
                    i.this.otherParams = str;
                    if (i.this.dMk != null) {
                        i.this.dMk.setOtherParams(i.this.otherParams);
                    }
                }
            }
        };
        this.atk = baseActivity;
        this.liveId = j;
        this.roomId = j2;
        this.dLJ = z3;
        this.isFullScreen = z4;
        this.dMl = z2;
        this.Pr = z;
        this.mRootView = LayoutInflater.from(this.atk).inflate(a.h.layout_guard_club_member_list, (ViewGroup) null);
        this.dLZ = (BdListView) this.mRootView.findViewById(a.g.list_guard_club_member);
        this.aqh = (CommonEmptyView) this.mRootView.findViewById(a.g.guard_club_member_empty_view);
        this.dMb = (LinearLayout) this.mRootView.findViewById(a.g.layout_guard_user_info);
        qa();
        this.dMc = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_rank);
        this.dMd = (HeadImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_header);
        this.dMe = (TbImageView) this.mRootView.findViewById(a.g.img_guard_club_list_user_medal);
        this.dMf = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_name);
        this.dMg = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_num);
        this.dMh = (TextView) this.mRootView.findViewById(a.g.tv_guard_club_list_user_followed);
        this.dMi = this.mRootView.findViewById(a.g.view_contribution_max);
        this.dMj = this.mRootView.findViewById(a.g.view_guard_user_contribution);
        this.dMd.setIsRound(true);
        this.dMd.setAutoChangeStyle(false);
        this.dMk = new g(baseActivity, bdUniqueId, z, z3);
        this.dMk.a(new g.b() { // from class: com.baidu.tieba.ala.guardclub.i.2
            @Override // com.baidu.tieba.ala.guardclub.g.b
            public void d(com.baidu.tieba.ala.guardclub.model.k kVar) {
                if (!BdUtilHelper.isNetOk()) {
                    BdUtilHelper.showToast(i.this.atk, i.this.atk.getString(a.i.sdk_neterror));
                } else if (kVar != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(i.this.atk.getActivity(), String.valueOf(kVar.userId), kVar.userName, null, 0, 0, null, null, 0L, 0L, 0L, kVar.dGK ? 1 : 0, "", "", false, null, null, kVar.userName, i.this.otherParams, true)));
                }
            }
        });
        this.dLZ.setAdapter((ListAdapter) this.dMk);
        if (z3) {
            this.dMa = new LoadMoreFooter(this.atk);
            this.dMa.setBackgroundColor(this.mContext.getResources().getColor(a.d.live_gcb_primary));
            this.dMa.createView();
            this.dLZ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.i.3
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (!i.this.dMa.isLoading() && i.this.dLY.aLC() && i + i2 > i3 - 2 && i.this.dLY.aLC()) {
                        i.this.dLY.aLE();
                    }
                }
            });
        }
        MessageManager.getInstance().registerListener(this.dEz);
    }

    public final void qa() {
        if (this.dMb != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.atk.getPageContext().getPageActivity()) == 2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (this.isFullScreen) {
                this.dMb.setBackgroundColor(Color.parseColor("#FF201443"));
            } else {
                this.dMb.setBackgroundColor(Color.parseColor("#FF322149"));
            }
            float dimensionPixelOffset = this.atk.getPageContext().getResources().getDimensionPixelOffset(a.e.sdk_ds26);
            if (z) {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
            } else {
                gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            this.dMb.setBackgroundDrawable(gradientDrawable);
        }
    }

    public void he(boolean z) {
        this.dMm = z;
    }

    public void completePullRefresh() {
        if (this.dLZ != null) {
            this.dLZ.completePullRefresh();
        }
    }

    public void aLp() {
        if (this.dMa != null) {
            this.dMa.endLoadData();
            this.dLZ.setNextPage(null);
        }
    }

    public void hf(boolean z) {
        if (z) {
            if (this.dMa != null) {
                this.dLZ.setNextPage(null);
            }
        } else if (this.dMa != null) {
            if (this.dMa.getView().getParent() == null) {
                this.dLZ.setNextPage(this.dMa);
            }
            this.dMa.showNoMoreData();
        }
    }

    public void aJj() {
        if (this.dMa != null) {
            if (this.dMa.getView().getParent() == null) {
                this.dLZ.setNextPage(this.dMa);
            }
            this.dMa.showLoadView();
        }
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.dMk != null) {
            this.dMk.setOtherParams(str);
        }
    }

    private void aFS() {
        aN(8, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tieba.ala.guardclub.model.l lVar) {
        this.dLY = lVar;
        this.dLY.aLD();
    }

    public void bv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.dMk != null && list != null && !list.isEmpty()) {
            aN(0, 8);
            this.dMk.bv(list);
            return;
        }
        aFS();
    }

    public void aLq() {
        aLr();
    }

    public void aLr() {
        this.aqh.reset();
        this.aqh.setTitle(a.i.sdk_net_fail_tip_rank);
        this.aqh.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.i.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i.this.dLY != null) {
                    i.this.dLY.aLD();
                }
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.aqh.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.aqh.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.aqh.setVisibility(0);
        this.dLZ.setVisibility(8);
        this.dMb.setVisibility(8);
    }

    private void aN(int i, int i2) {
        this.dLZ.setVisibility(i);
        if (i2 == 0) {
            this.aqh.reset();
            if (this.Pr) {
                this.aqh.setTitle(a.i.guard_member_list_empty_host);
            } else {
                this.aqh.setTitle(a.i.guard_member_list_empty);
            }
            this.aqh.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.DARK);
            this.aqh.setVisibility(0);
            return;
        }
        this.aqh.setVisibility(8);
    }

    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.dMk != null && this.dLJ) {
            this.dMk.bw(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aLn() {
        if (this.dMk != null) {
            this.dMk.aLn();
        }
        MessageManager.getInstance().unRegisterListener(this.dEz);
    }
}
