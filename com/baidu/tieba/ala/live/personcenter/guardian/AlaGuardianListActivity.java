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
    private CommonEmptyView bIx;
    private String gDy;
    private int gYY;
    private int gYZ;
    private NoNetworkView gYv;
    private e hao;
    private d hap;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private TextView mTitleView;
    private String mUserId;
    private BdListView ham = null;
    private b han = null;
    private boolean gYX = true;
    public e.a haq = new e.a() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.2
        @Override // com.baidu.tieba.ala.live.personcenter.guardian.e.a
        public void HR(String str) {
            AlaGuardianListActivity.this.bYK();
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
    View.OnClickListener gEO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (AlaGuardianListActivity.this.han != null && (aVar = (a) AlaGuardianListActivity.this.han.getItem(intValue)) != null && aVar.hah != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(AlaGuardianListActivity.this.getPageContext().getPageActivity(), aVar.hah, aVar.userName, aVar.portrait, aVar.sex, aVar.levelId, null, null, 0L, aVar.fansCount, aVar.followCount, aVar.userStatus, null, null, false, null, null, aVar.nickName, "")));
                }
            }
        }
    };
    View.OnClickListener gEP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (AlaGuardianListActivity.this.han != null && ViewHelper.checkUpIsLogin(AlaGuardianListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) AlaGuardianListActivity.this.han.getItem(intValue)) != null && aVar.hah != null) {
                    boolean z = aVar.followStatus != 0;
                    aVar.followStatus = z ? 0 : 1;
                    AlaGuardianListActivity.this.han.notifyDataSetChanged();
                    f fVar = new f();
                    fVar.setUserId(aVar.hah);
                    fVar.setPortrait(aVar.portrait);
                    fVar.setPageId(AlaGuardianListActivity.this.getUniqueId());
                    fVar.setIsAttention(z ? false : true);
                    fVar.setFrom("source_guardian_list");
                    com.baidu.live.view.a.Yo().a(aVar.hah, fVar);
                }
            }
        }
    };
    private CustomMessageListener gDu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (AlaGuardianListActivity.this.han != null) {
                        AlaGuardianListActivity.this.han.aA(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
            bYJ();
            initUI();
            registerListener(this.gDu);
        }
    }

    private void initData() {
        this.gDy = getIntent().getStringExtra("charm_value");
        this.mUserId = getIntent().getStringExtra("user_id");
        this.hao = new e(this, this.haq);
        this.hao.HT(this.mUserId);
        this.gYY = (int) getResources().getDimension(a.d.sdk_ds246);
        this.gYZ = (int) getResources().getDimension(a.d.sdk_ds98);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(a.f.view_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.f.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.h.sdk_prc_guardian_list_title);
        this.mNavigationBar.showBottomLine(false);
        this.gYv = (NoNetworkView) this.mRootView.findViewById(a.f.ala_guardian_list_no_network_view);
        this.ham = (BdListView) this.mRootView.findViewById(a.f.list);
        this.hap = new d(getPageContext().getPageActivity());
        this.hap.HS(this.gDy);
        this.ham.addHeaderView(this.hap.bYA());
        this.han = new b(this);
        this.han.n(this.gEP);
        this.ham.setAdapter((ListAdapter) this.han);
        this.ham.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AlaGuardianListActivity.this.bYy();
                AlaGuardianListActivity.this.bYz();
            }
        });
    }

    private void bYJ() {
        this.hao.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.hao != null) {
            this.hao.onDestroy();
        }
        if (this.han != null) {
            this.han = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (this.han != null) {
            if (cVar != null && cVar.bYL().size() <= 0) {
                showNoDataView();
            } else {
                hideNoDataView();
            }
            this.han.c(cVar);
            this.han.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYy() {
        if (Build.VERSION.SDK_INT >= 11 && this.hap != null) {
            int i = this.gYY - (-this.hap.bYA().getTop());
            if (i < this.gYZ) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.gYZ && i <= this.gYZ * 2) {
                float f = 1.0f - (((i - this.gYZ) * 1.0f) / this.gYZ);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.gYZ * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.ham.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYz() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.gYX) {
                this.gYX = true;
            }
        } else if (this.gYX) {
            this.gYX = false;
        }
        a(alpha, this.gYX ? false : true);
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
        if (this.hap != null) {
            this.hap.a(this, i);
        }
        if (this.gYv != null) {
            this.gYv.onChangeSkinType(getPageContext(), i);
        }
        if (this.han != null) {
            this.han.notifyDataSetChanged();
        }
    }

    private void showNoDataView() {
        if (this.bIx == null) {
            this.bIx = new CommonEmptyView(getPageContext().getPageActivity());
            this.bIx.addToParent(this.mRootView);
        }
        this.bIx.reset();
        this.bIx.setTitle(a.h.sdk_prc_not_contribute);
        this.bIx.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
        this.bIx.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYK() {
        if (this.bIx == null) {
            this.bIx = new CommonEmptyView(getPageContext().getPageActivity());
            this.bIx.addToParent(this.mRootView);
        }
        this.bIx.reset();
        this.bIx.setRefreshButton(a.h.sdk_net_refresh_btn_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGuardianListActivity.this.hao.loadData();
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bIx.setTitle(a.h.sdk_net_fail_tip);
            this.bIx.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bIx.setTitle(a.h.sdk_network_not_available);
            this.bIx.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bIx.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bIx != null) {
            this.bIx.setVisibility(8);
        }
    }
}
