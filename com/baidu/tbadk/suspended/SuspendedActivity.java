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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    protected TextView dQH;
    private TranView fje;
    private SusPendedView fjk;
    private NoNetworkView fjl;
    private LinearLayout fjm;
    private a fjn;
    private NoNetworkView.a fjo = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.byF();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void byF();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fjk = (SusPendedView) findViewById(R.id.root_view);
        byC();
        byD();
        byE();
        Yn();
        this.fjk.setNavigationBar(this.fjm);
        this.fjk.setTranView(this.fje);
        this.fjk.setContentView(this.mContentView);
        this.fjk.show();
    }

    private void byC() {
        this.fje = new TranView(getPageContext().getPageActivity());
        this.fje.setVisibility(0);
    }

    private void byD() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.dQH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.dQH.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fjm = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fjm.addView(this.fje, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void byE() {
        this.fjl = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fjl.a(this.fjo);
    }

    private void Yn() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fjn = a(this.mContentView, this.mNavigationBar);
        if (this.fjn != null) {
            this.fjk.setContentViewTop(this.fjn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fjl.onChangeSkinType(getPageContext(), i);
        this.fjk.onChangeSkinType(i);
        ap.setBackgroundColor(this.fjk, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dQH, R.color.cp_cont_b);
        if (this.fjn != null) {
            this.fjn.rt(i);
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
        if (this.fjn == null || this.fjn.byA()) {
            if (this.fje != null) {
                this.fjk.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fjn != null) {
            Intent byB = this.fjn.byB();
            if (byB != null) {
                setResult(-1, byB);
            }
            if (this.fje != null && !this.fjk.getIsFinish()) {
                this.fjk.onFinish();
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
        if (this.fjk != null) {
            this.fjk.onDestroy();
        }
    }
}
