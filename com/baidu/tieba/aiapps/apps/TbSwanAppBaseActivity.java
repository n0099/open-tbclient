package com.baidu.tieba.aiapps.apps;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.an.z;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.widget.SwanAppBdActionBar;
/* loaded from: classes4.dex */
public class TbSwanAppBaseActivity extends BaseActivity<TbSwanAppBaseActivity> {
    private com.baidu.tbadk.core.view.b cOA;
    private SwanAppBdActionBar dme;
    private RelativeLayout mRootView;

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        setContentView(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        View inflate = getLayoutInflater().inflate(R.layout.tb_swan_app_base_layout, (ViewGroup) null);
        this.dme = (SwanAppBdActionBar) inflate.findViewById(R.id.ai_apps_title_bar);
        this.mRootView = (RelativeLayout) inflate.findViewById(R.id.delivery_root);
        this.mRootView.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky(this);
            ((LinearLayout) inflate.findViewById(R.id.ai_apps_title_bar_container)).addView(createStateBarFillView(), 0);
        }
        aFj();
        super.setContentView(inflate);
    }

    private View createStateBarFillView() {
        View view = new View(this);
        view.setId(R.id.navigation_bar_status_bar);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        view.setBackgroundResource(R.color.aiapps_empty_layout_backgroud);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cOA = new com.baidu.tbadk.core.view.b(getPageContext());
        this.cOA.setTipString("加载中...");
        this.cOA.setCancelable(true);
    }

    private void aFj() {
        if (this.dme != null) {
            this.dme.setLeftTitleInvalidate(true);
            this.dme.setRightTxtZone1Visibility(8);
            this.dme.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbSwanAppBaseActivity.this.ED();
                }
            });
            this.dme.setRightExitViewVisibility(false);
            this.dme.setRightMenuVisibility(false);
            this.dme.setLeftZoneImageSrcMinWidth(z.dip2px(this, 38.0f));
            this.dme.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.TbSwanAppBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TbSwanAppBaseActivity.this.ED();
                }
            });
        }
    }

    protected void ED() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SwanAppBdActionBar aFk() {
        return this.dme;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showLoading() {
        this.cOA.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFl() {
        this.cOA.setDialogVisiable(false);
    }
}
