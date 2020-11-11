package com.baidu.tieba.ala.live.personcenter.guardian;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.NavigationBar;
import com.baidu.live.tbadk.core.view.NoNetworkView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.live.personcenter.guardian.e;
/* loaded from: classes4.dex */
public class AlaGuardianListActivity extends BaseActivity<AlaGuardianListActivity> {
    private CommonEmptyView bFa;
    private NoNetworkView gPz;
    private int gQc;
    private int gQd;
    private e gRs;
    private d gRt;
    private String gvg;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private TextView mTitleView;
    private String mUserId;
    private BdListView gRq = null;
    private b gRr = null;
    private boolean gQb = true;
    public e.a gRu = new e.a() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.2
        @Override // com.baidu.tieba.ala.live.personcenter.guardian.e.a
        public void HC(String str) {
            AlaGuardianListActivity.this.bVH();
            if (!TextUtils.isEmpty(str)) {
                AlaGuardianListActivity.this.showToast(str);
            }
        }

        @Override // com.baidu.tieba.ala.live.personcenter.guardian.e.a
        public c b(c cVar) {
            AlaGuardianListActivity.this.hideNoDataView();
            if (cVar != null) {
                AlaGuardianListActivity.this.a(cVar);
                return null;
            }
            return null;
        }
    };
    View.OnClickListener gww = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (AlaGuardianListActivity.this.gRr != null && (aVar = (a) AlaGuardianListActivity.this.gRr.getItem(intValue)) != null && aVar.gRl != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(AlaGuardianListActivity.this.getPageContext().getPageActivity(), aVar.gRl, aVar.userName, aVar.portrait, aVar.sex, aVar.levelId, null, null, 0L, aVar.fansCount, aVar.followCount, aVar.userStatus, null, null, false, null, null, aVar.nickName, "")));
                }
            }
        }
    };
    View.OnClickListener gwx = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (AlaGuardianListActivity.this.gRr != null && ViewHelper.checkUpIsLogin(AlaGuardianListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) AlaGuardianListActivity.this.gRr.getItem(intValue)) != null && aVar.gRl != null) {
                    boolean z = aVar.followStatus != 0;
                    aVar.followStatus = z ? 0 : 1;
                    AlaGuardianListActivity.this.gRr.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(aVar.gRl);
                    fVar.setPortrait(aVar.portrait);
                    fVar.setPageId(AlaGuardianListActivity.this.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_guardian_list");
                    com.baidu.live.view.a.Wx().a(aVar.gRl, fVar);
                }
            }
        }
    };
    private CustomMessageListener gvc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (AlaGuardianListActivity.this.gRr != null) {
                        AlaGuardianListActivity.this.gRr.az(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(AlaGuardianListActivity.this.getUniqueId())) {
                        AlaGuardianListActivity.this.showToast(updateAttentionMessage.getData().errorString);
                        return;
                    }
                    return;
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(AlaGuardianListActivity.this.getUniqueId()) && updateAttentionMessage.getData().isAttention) {
                    AlaGuardianListActivity.this.showToast(AlaGuardianListActivity.this.getResources().getString(a.h.sdk_attention_success_toast));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.mRootView = (RelativeLayout) View.inflate(getPageContext().getPageActivity(), a.g.sdk_prc_person_center_guardian_layout, null);
            setContentView(this.mRootView);
            setUseStyleImmersiveSticky(true);
            initData();
            bVG();
            initUI();
            registerListener(this.gvc);
        }
    }

    private void initData() {
        this.gvg = getIntent().getStringExtra("charm_value");
        this.mUserId = getIntent().getStringExtra("user_id");
        this.gRs = new e(this, this.gRu);
        this.gRs.HE(this.mUserId);
        this.gQc = (int) getResources().getDimension(a.d.sdk_ds246);
        this.gQd = (int) getResources().getDimension(a.d.sdk_ds98);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(a.f.view_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.h.sdk_prc_guardian_list_title);
        this.mNavigationBar.showBottomLine(false);
        this.gPz = (NoNetworkView) this.mRootView.findViewById(a.f.ala_guardian_list_no_network_view);
        this.gRq = (BdListView) this.mRootView.findViewById(a.f.list);
        this.gRt = new d(getPageContext().getPageActivity());
        this.gRt.HD(this.gvg);
        this.gRq.addHeaderView(this.gRt.bVx());
        this.gRr = new b(this);
        this.gRr.n(this.gwx);
        this.gRq.setAdapter((ListAdapter) this.gRr);
        this.gRq.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AlaGuardianListActivity.this.bVv();
                AlaGuardianListActivity.this.bVw();
            }
        });
    }

    private void bVG() {
        this.gRs.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gRs != null) {
            this.gRs.onDestroy();
        }
        if (this.gRr != null) {
            this.gRr = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (this.gRr != null) {
            if (cVar != null && cVar.bVI().size() <= 0) {
                showNoDataView();
            } else {
                hideNoDataView();
            }
            this.gRr.c(cVar);
            this.gRr.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVv() {
        if (Build.VERSION.SDK_INT >= 11 && this.gRt != null) {
            int i = this.gQc - (-this.gRt.bVx().getTop());
            if (i < this.gQd) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.gQd && i <= this.gQd * 2) {
                float f = 1.0f - (((i - this.gQd) * 1.0f) / this.gQd);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.gQd * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.gRq.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVw() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.gQb) {
                this.gQb = true;
            }
        } else if (this.gQb) {
            this.gQb = false;
        }
        a(alpha, this.gQb ? false : true);
    }

    protected void a(float f, boolean z) {
        if (z) {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.e.sdk_icon_return_bg_s, a.e.sdk_icon_return_bg);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.c.sdk_cp_cont_b, a.c.sdk_s_navbar_title_color);
        } else {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.e.sdk_prc_btn_sml_back_selector_s, a.e.sdk_prc_btn_sml_back_selector_s);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.c.sdk_cp_cont_i, a.c.sdk_cp_cont_i);
        }
        this.mTitleView.setAlpha(f);
        this.mBackImageView.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(getResources(), SkinManager.getBitmapLowQuality(a.e.sdk_s_navbar_bg)));
        if (this.gRt != null) {
            this.gRt.a(this, i);
        }
        if (this.gPz != null) {
            this.gPz.onChangeSkinType(getPageContext(), i);
        }
        if (this.gRr != null) {
            this.gRr.notifyDataSetChanged();
        }
    }

    private void showNoDataView() {
        if (this.bFa == null) {
            this.bFa = new CommonEmptyView(getPageContext().getPageActivity());
            this.bFa.addToParent(this.mRootView);
        }
        this.bFa.reset();
        this.bFa.setTitle(a.h.sdk_prc_not_contribute);
        this.bFa.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
        this.bFa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVH() {
        if (this.bFa == null) {
            this.bFa = new CommonEmptyView(getPageContext().getPageActivity());
            this.bFa.addToParent(this.mRootView);
        }
        this.bFa.reset();
        this.bFa.setRefreshButton(a.h.sdk_net_refresh_btn_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGuardianListActivity.this.gRs.loadData();
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bFa.setTitle(a.h.sdk_net_fail_tip);
            this.bFa.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bFa.setTitle(a.h.sdk_network_not_available);
            this.bFa.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bFa.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bFa != null) {
            this.bFa.setVisibility(8);
        }
    }
}
