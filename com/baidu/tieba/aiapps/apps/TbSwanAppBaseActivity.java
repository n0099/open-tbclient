package com.baidu.tieba.aiapps.apps;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.view.SwanAppBdActionBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class TbSwanAppBaseActivity extends BaseActivity<TbSwanAppBaseActivity> {
    private SwanAppBdActionBar cQU;
    private com.baidu.tbadk.core.view.b csK;
    private RelativeLayout mRootView;

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        View inflate = getLayoutInflater().inflate(d.h.tb_swan_app_base_layout, (ViewGroup) null);
        this.cQU = (SwanAppBdActionBar) inflate.findViewById(d.g.ai_apps_title_bar);
        this.mRootView = (RelativeLayout) inflate.findViewById(d.g.delivery_root);
        this.mRootView.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky(this);
            ((LinearLayout) inflate.findViewById(d.g.ai_apps_title_bar_container)).addView(createStateBarFillView(), 0);
        }
        axW();
        super.setContentView(inflate);
    }

    private View createStateBarFillView() {
        View view = new View(this);
        view.setId(d.g.navigation_bar_status_bar);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        view.setBackgroundResource(d.C0277d.aiapps_empty_layout_backgroud);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.csK = new com.baidu.tbadk.core.view.b(getPageContext());
        this.csK.nl("加载中...");
        this.csK.setCancelable(true);
    }

    private void axW() {
        if (this.cQU != null) {
            this.cQU.setLeftTitleInvalidate(true);
            this.cQU.setRightTxtZone1Visibility(8);
            this.cQU.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbSwanAppBaseActivity.this.ye();
                }
            });
            this.cQU.setRightExitViewVisibility(false);
            this.cQU.setRightMenuVisibility(false);
            this.cQU.setLeftZoneImageSrcMinWidth(x.dip2px(this, 38.0f));
            this.cQU.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbSwanAppBaseActivity.this.ye();
                }
            });
        }
    }

    protected void ye() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwanAppBdActionBar axX() {
        return this.cQU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        this.csK.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissLoading() {
        this.csK.dJ(false);
    }
}
