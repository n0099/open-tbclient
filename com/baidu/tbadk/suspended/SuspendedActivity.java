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
    protected TextView bPL;
    private SusPendedView fxB;
    private NoNetworkView fxC;
    private LinearLayout fxD;
    private a fxE;
    private NoNetworkView.a fxF = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bCX();
            }
        }
    };
    private TranView fxv;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bCX();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fxB = (SusPendedView) findViewById(R.id.root_view);
        bCU();
        bCV();
        bCW();
        XQ();
        this.fxB.setNavigationBar(this.fxD);
        this.fxB.setTranView(this.fxv);
        this.fxB.setContentView(this.mContentView);
        this.fxB.show();
    }

    private void bCU() {
        this.fxv = new TranView(getPageContext().getPageActivity());
        this.fxv.setVisibility(0);
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bPL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bPL.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fxD = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fxD.addView(this.fxv, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bCW() {
        this.fxC = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fxC.a(this.fxF);
    }

    private void XQ() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fxE = a(this.mContentView, this.mNavigationBar);
        if (this.fxE != null) {
            this.fxB.setContentViewTop(this.fxE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fxC.onChangeSkinType(getPageContext(), i);
        this.fxB.onChangeSkinType(i);
        ap.setBackgroundColor(this.fxB, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.bPL, R.color.cp_cont_b);
        if (this.fxE != null) {
            this.fxE.rO(i);
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
        if (this.fxE == null || this.fxE.bCS()) {
            if (this.fxv != null) {
                this.fxB.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fxE != null) {
            Intent bCT = this.fxE.bCT();
            if (bCT != null) {
                setResult(-1, bCT);
            }
            if (this.fxv != null && !this.fxB.getIsFinish()) {
                this.fxB.onFinish();
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
        if (this.fxB != null) {
            this.fxB.onDestroy();
        }
    }
}
