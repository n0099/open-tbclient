package com.baidu.tieba.aiapps.apps;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsBdActionBar;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class TbAiAppsBaseActivity extends BaseActivity<TbAiAppsBaseActivity> {
    private AiAppsBdActionBar bBC;
    private d beC;
    private RelativeLayout mRootView;

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        View inflate = getLayoutInflater().inflate(e.h.delivery_base_layout, (ViewGroup) null);
        this.bBC = (AiAppsBdActionBar) inflate.findViewById(e.g.ai_apps_title_bar);
        this.mRootView = (RelativeLayout) inflate.findViewById(e.g.delivery_root);
        this.mRootView.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky(this);
            ((LinearLayout) inflate.findViewById(e.g.ai_apps_title_bar_container)).addView(createStateBarFillView(), 0);
        }
        Wn();
        super.setContentView(inflate);
    }

    private View createStateBarFillView() {
        View view = new View(this);
        view.setId(e.g.navigation_bar_status_bar);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        view.setBackgroundResource(e.d.aiapps_empty_layout_backgroud);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.beC = new d(getPageContext());
        this.beC.fS("加载中...");
        this.beC.setCancelable(true);
    }

    private void Wn() {
        if (this.bBC != null) {
            this.bBC.setLeftTitleInvalidate(true);
            this.bBC.setRightTxtZone1Visibility(8);
            this.bBC.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbAiAppsBaseActivity.this.onActionBarBackPressed();
                }
            });
            this.bBC.setRightExitViewVisibility(false);
            this.bBC.setRightMenuVisibility(false);
            this.bBC.setLeftZoneImageSrcMinWidth(AiAppsUIUtils.dip2px(this, 38.0f));
            this.bBC.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbAiAppsBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbAiAppsBaseActivity.this.onActionBarBackPressed();
                }
            });
        }
    }

    protected void onActionBarBackPressed() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AiAppsBdActionBar Wo() {
        return this.bBC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        this.beC.bz(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissLoading() {
        this.beC.bz(false);
    }
}
