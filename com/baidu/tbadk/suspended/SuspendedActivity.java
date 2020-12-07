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
    protected TextView bTh;
    private SusPendedView fEF;
    private NoNetworkView fEG;
    private LinearLayout fEH;
    private a fEI;
    private NoNetworkView.a fEJ = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bFR();
            }
        }
    };
    private TranView fEz;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bFR();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fEF = (SusPendedView) findViewById(R.id.root_view);
        bFO();
        bFP();
        bFQ();
        ZG();
        this.fEF.setNavigationBar(this.fEH);
        this.fEF.setTranView(this.fEz);
        this.fEF.setContentView(this.mContentView);
        this.fEF.show();
    }

    private void bFO() {
        this.fEz = new TranView(getPageContext().getPageActivity());
        this.fEz.setVisibility(0);
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bTh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bTh.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fEH = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fEH.addView(this.fEz, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bFQ() {
        this.fEG = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fEG.a(this.fEJ);
    }

    private void ZG() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fEI = a(this.mContentView, this.mNavigationBar);
        if (this.fEI != null) {
            this.fEF.setContentViewTop(this.fEI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fEG.onChangeSkinType(getPageContext(), i);
        this.fEF.onChangeSkinType(i);
        ap.setBackgroundColor(this.fEF, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
        ap.setViewTextColor(this.bTh, R.color.CAM_X0105);
        if (this.fEI != null) {
            this.fEI.sN(i);
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
        if (this.fEI == null || this.fEI.bFM()) {
            if (this.fEz != null) {
                this.fEF.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fEI != null) {
            Intent bFN = this.fEI.bFN();
            if (bFN != null) {
                setResult(-1, bFN);
            }
            if (this.fEz != null && !this.fEF.getIsFinish()) {
                this.fEF.onFinish();
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
        if (this.fEF != null) {
            this.fEF.onDestroy();
        }
    }
}
