package com.baidu.tieba.aiapps.apps;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar;
import d.b.g0.a.i2.h0;
import d.b.g0.i.n;
/* loaded from: classes4.dex */
public class TbSwanAppBaseActivity extends BaseActivity<TbSwanAppBaseActivity> {
    public SwanAppBdActionBar mActionBar;
    public d.b.g0.a.y0.e.b mLaunchInfo;
    public d.b.h0.r.f0.a mLoadingDialog;
    public RelativeLayout mRootView;
    public n mToolMenu;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbSwanAppBaseActivity.this.onActionBarBackPressed();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbSwanAppBaseActivity.this.onActionBarBackPressed();
        }
    }

    private View createStateBarFillView() {
        View view = new View(this);
        view.setId(R.id.navigation_bar_status_bar);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        view.setBackgroundResource(R.color.aiapps_empty_layout_backgroud);
        return view;
    }

    private void initActionBar() {
        SwanAppBdActionBar swanAppBdActionBar = this.mActionBar;
        if (swanAppBdActionBar == null) {
            return;
        }
        swanAppBdActionBar.setLeftTitleInvalidate(true);
        this.mActionBar.setRightTxtZone1Visibility(8);
        this.mActionBar.setLeftZoneOnClickListener(new a());
        this.mActionBar.setRightExitViewVisibility(false);
        this.mActionBar.setRightMenuVisibility(false);
        this.mActionBar.setLeftZoneImageSrcMinWidth(h0.e(this, 38.0f));
        this.mActionBar.setLeftZoneOnClickListener(new b());
    }

    public void dismissLoading() {
        this.mLoadingDialog.h(false);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.mActionBar;
    }

    public void onActionBarBackPressed() {
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.b.h0.r.f0.a aVar = new d.b.h0.r.f0.a(getPageContext());
        this.mLoadingDialog = aVar;
        aVar.j("加载中...");
        this.mLoadingDialog.f(true);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    public void showLoading() {
        this.mLoadingDialog.h(true);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        View inflate = getLayoutInflater().inflate(R.layout.tb_swan_app_base_layout, (ViewGroup) null);
        this.mActionBar = (SwanAppBdActionBar) inflate.findViewById(R.id.ai_apps_title_bar);
        this.mRootView = (RelativeLayout) inflate.findViewById(R.id.delivery_root);
        this.mRootView.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky(this);
            ((LinearLayout) inflate.findViewById(R.id.ai_apps_title_bar_container)).addView(createStateBarFillView(), 0);
        }
        initActionBar();
        super.setContentView(inflate);
    }
}
