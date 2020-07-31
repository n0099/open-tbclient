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
    private CommonEmptyView bjW;
    private String fEq;
    private int fUV;
    private int fUW;
    private NoNetworkView fUs;
    private e fWo;
    private d fWp;
    private ImageView mBackImageView;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;
    private TextView mTitleView;
    private String mUserId;
    private BdListView fWm = null;
    private b fWn = null;
    private boolean fUU = true;
    public e.a fWq = new e.a() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.2
        @Override // com.baidu.tieba.ala.live.personcenter.guardian.e.a
        public void Dm(String str) {
            AlaGuardianListActivity.this.bCp();
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
    View.OnClickListener fFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (AlaGuardianListActivity.this.fWn != null && (aVar = (a) AlaGuardianListActivity.this.fWn.getItem(intValue)) != null && aVar.fWg != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(AlaGuardianListActivity.this.getPageContext().getPageActivity(), aVar.fWg, aVar.userName, aVar.portrait, aVar.sex, aVar.levelId, null, null, 0L, aVar.fansCount, aVar.followCount, aVar.userStatus, null, null, false, null, null, aVar.nickName, "")));
                }
            }
        }
    };
    View.OnClickListener fFH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            if (view != null && (view.getTag() instanceof Integer)) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (AlaGuardianListActivity.this.fWn != null && ViewHelper.checkUpIsLogin(AlaGuardianListActivity.this.getPageContext().getPageActivity()) && (aVar = (a) AlaGuardianListActivity.this.fWn.getItem(intValue)) != null && aVar.fWg != null) {
                    boolean z = aVar.followStatus != 0;
                    aVar.followStatus = z ? 0 : 1;
                    AlaGuardianListActivity.this.fWn.notifyDataSetChanged();
                    com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                    dVar.setUserId(aVar.fWg);
                    dVar.setPortrait(aVar.portrait);
                    dVar.setPageId(AlaGuardianListActivity.this.getUniqueId());
                    dVar.setIsAttention(z ? false : true);
                    dVar.setFrom("source_guardian_list");
                    com.baidu.live.view.a.KF().a(aVar.fWg, dVar);
                }
            }
        }
    };
    private CustomMessageListener fEm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (!updateAttentionMessage.getData().isSucc) {
                    if (AlaGuardianListActivity.this.fWn != null) {
                        AlaGuardianListActivity.this.fWn.ap(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
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
                    AlaGuardianListActivity.this.showToast(AlaGuardianListActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.mRootView = (RelativeLayout) View.inflate(getPageContext().getPageActivity(), a.h.sdk_prc_person_center_guardian_layout, null);
            setContentView(this.mRootView);
            setUseStyleImmersiveSticky(true);
            initData();
            bCo();
            initUI();
            registerListener(this.fEm);
        }
    }

    private void initData() {
        this.fEq = getIntent().getStringExtra("charm_value");
        this.mUserId = getIntent().getStringExtra("user_id");
        this.fWo = new e(this, this.fWq);
        this.fWo.Do(this.mUserId);
        this.fUV = (int) getResources().getDimension(a.e.sdk_ds246);
        this.fUW = (int) getResources().getDimension(a.e.sdk_ds98);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(a.g.view_navigation_bar);
        this.mBackImageView = (ImageView) this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(a.g.widget_navi_back_button);
        this.mTitleView = this.mNavigationBar.setTitleText(a.i.sdk_prc_guardian_list_title);
        this.mNavigationBar.showBottomLine(false);
        this.fUs = (NoNetworkView) this.mRootView.findViewById(a.g.ala_guardian_list_no_network_view);
        this.fWm = (BdListView) this.mRootView.findViewById(a.g.list);
        this.fWp = new d(getPageContext().getPageActivity());
        this.fWp.Dn(this.fEq);
        this.fWm.addHeaderView(this.fWp.bCf());
        this.fWn = new b(this);
        this.fWn.m(this.fFH);
        this.fWm.setAdapter((ListAdapter) this.fWn);
        this.fWm.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AlaGuardianListActivity.this.bCd();
                AlaGuardianListActivity.this.bCe();
            }
        });
    }

    private void bCo() {
        this.fWo.loadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fWo != null) {
            this.fWo.onDestroy();
        }
        if (this.fWn != null) {
            this.fWn = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (this.fWn != null) {
            if (cVar != null && cVar.bCq().size() <= 0) {
                showNoDataView();
            } else {
                hideNoDataView();
            }
            this.fWn.c(cVar);
            this.fWn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCd() {
        if (Build.VERSION.SDK_INT >= 11 && this.fWp != null) {
            int i = this.fUV - (-this.fWp.bCf().getTop());
            if (i < this.fUW) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                    this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
                }
            } else if (i >= this.fUW && i <= this.fUW * 2) {
                float f = 1.0f - (((i - this.fUW) * 1.0f) / this.fUW);
                this.mNavigationBar.getBarBgView().setAlpha(f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
            } else if (i > this.fUW * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
            }
            if (this.fWm.getFirstVisiblePosition() > 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCe() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            alpha = 1.0f - alpha;
            if (!this.fUU) {
                this.fUU = true;
            }
        } else if (this.fUU) {
            this.fUU = false;
        }
        a(alpha, this.fUU ? false : true);
    }

    protected void a(float f, boolean z) {
        if (z) {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.f.sdk_icon_return_bg_s, a.f.sdk_icon_return_bg);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.d.sdk_cp_cont_b, a.d.sdk_s_navbar_title_color);
        } else {
            SkinManager.setNavbarIconSrc(this.mBackImageView, a.f.sdk_prc_btn_sml_back_selector_s, a.f.sdk_prc_btn_sml_back_selector_s);
            SkinManager.setNavbarTitleColor(this.mTitleView, a.d.sdk_cp_cont_i, a.d.sdk_cp_cont_i);
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
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(getResources(), SkinManager.getBitmapLowQuality(a.f.sdk_s_navbar_bg)));
        if (this.fWp != null) {
            this.fWp.a(this, i);
        }
        if (this.fUs != null) {
            this.fUs.onChangeSkinType(getPageContext(), i);
        }
        if (this.fWn != null) {
            this.fWn.notifyDataSetChanged();
        }
    }

    private void showNoDataView() {
        if (this.bjW == null) {
            this.bjW = new CommonEmptyView(getPageContext().getPageActivity());
            this.bjW.addToParent(this.mRootView);
        }
        this.bjW.reset();
        this.bjW.setTitle(a.i.sdk_prc_not_contribute);
        this.bjW.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
        this.bjW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCp() {
        if (this.bjW == null) {
            this.bjW = new CommonEmptyView(getPageContext().getPageActivity());
            this.bjW.addToParent(this.mRootView);
        }
        this.bjW.reset();
        this.bjW.setRefreshButton(a.i.sdk_net_refresh_btn_text, new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.guardian.AlaGuardianListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGuardianListActivity.this.fWo.loadData();
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bjW.setTitle(a.i.sdk_net_fail_tip);
            this.bjW.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.LIGHT);
        } else {
            this.bjW.setTitle(a.i.sdk_network_not_available);
            this.bjW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
        }
        this.bjW.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNoDataView() {
        if (this.bjW != null) {
            this.bjW.setVisibility(8);
        }
    }
}
