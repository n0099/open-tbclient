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
    private SwanAppBdActionBar cQW;
    private com.baidu.tbadk.core.view.b csM;
    private RelativeLayout mRootView;

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        View inflate = getLayoutInflater().inflate(d.h.tb_swan_app_base_layout, (ViewGroup) null);
        this.cQW = (SwanAppBdActionBar) inflate.findViewById(d.g.ai_apps_title_bar);
        this.mRootView = (RelativeLayout) inflate.findViewById(d.g.delivery_root);
        this.mRootView.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky(this);
            ((LinearLayout) inflate.findViewById(d.g.ai_apps_title_bar_container)).addView(createStateBarFillView(), 0);
        }
        axT();
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
        this.csM = new com.baidu.tbadk.core.view.b(getPageContext());
        this.csM.nm("加载中...");
        this.csM.setCancelable(true);
    }

    private void axT() {
        if (this.cQW != null) {
            this.cQW.setLeftTitleInvalidate(true);
            this.cQW.setRightTxtZone1Visibility(8);
            this.cQW.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbSwanAppBaseActivity.this.yd();
                }
            });
            this.cQW.setRightExitViewVisibility(false);
            this.cQW.setRightMenuVisibility(false);
            this.cQW.setLeftZoneImageSrcMinWidth(x.dip2px(this, 38.0f));
            this.cQW.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbSwanAppBaseActivity.this.yd();
                }
            });
        }
    }

    protected void yd() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwanAppBdActionBar axU() {
        return this.cQW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        this.csM.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissLoading() {
        this.csM.dJ(false);
    }
}
