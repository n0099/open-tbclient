package com.baidu.tbadk.suspended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    protected TextView dmF;
    private TranView eDd;
    private SusPendedView eDj;
    private NoNetworkView eDk;
    private LinearLayout eDl;
    private a eDm;
    private NoNetworkView.a eDn = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bis();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bis();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.eDj = (SusPendedView) findViewById(R.id.root_view);
        bip();
        biq();
        bir();
        Px();
        this.eDj.setNavigationBar(this.eDl);
        this.eDj.setTranView(this.eDd);
        this.eDj.setContentView(this.mContentView);
        this.eDj.show();
    }

    private void bip() {
        this.eDd = new TranView(getPageContext().getPageActivity());
        this.eDd.setVisibility(0);
    }

    private void biq() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.dmF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.dmF.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmF.getLayoutParams();
        layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds46);
        this.dmF.setLayoutParams(layoutParams);
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.eDl = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.eDl.addView(this.eDd, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bir() {
        this.eDk = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eDk.a(this.eDn);
    }

    private void Px() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.eDm = a(this.mContentView, this.mNavigationBar);
        if (this.eDm != null) {
            this.eDj.setContentViewTop(this.eDm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eDk.onChangeSkinType(getPageContext(), i);
        this.eDj.onChangeSkinType(i);
        an.setBackgroundColor(this.eDj, R.color.cp_mask_b_alpha66);
        an.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        an.setViewTextColor(this.dmF, (int) R.color.cp_cont_b);
        if (this.eDm != null) {
            this.eDm.ob(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    protected void close() {
        if (this.eDm == null || this.eDm.bin()) {
            if (this.eDd != null) {
                this.eDj.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.eDm != null) {
            Intent bio = this.eDm.bio();
            if (bio != null) {
                setResult(-1, bio);
            }
            if (this.eDd != null && !this.eDj.getIsFinish()) {
                this.eDj.onFinish();
                return;
            } else {
                super.finish();
                return;
            }
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eDj != null) {
            this.eDj.onDestroy();
        }
    }
}
