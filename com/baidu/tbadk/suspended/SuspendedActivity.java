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
    protected TextView bZE;
    private TranView fNi;
    private SusPendedView fNo;
    private NoNetworkView fNp;
    private LinearLayout fNq;
    private a fNr;
    private NoNetworkView.a fNs = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bER();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bER();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fNo = (SusPendedView) findViewById(R.id.root_view);
        bEO();
        bEP();
        bEQ();
        Zo();
        this.fNo.setNavigationBar(this.fNq);
        this.fNo.setTranView(this.fNi);
        this.fNo.setContentView(this.mContentView);
        this.fNo.show();
    }

    private void bEO() {
        this.fNi = new TranView(getPageContext().getPageActivity());
        this.fNi.setVisibility(0);
    }

    private void bEP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bZE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bZE.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fNq = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fNq.addView(this.fNi, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bEQ() {
        this.fNp = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fNp.a(this.fNs);
    }

    private void Zo() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fNr = a(this.mContentView, this.mNavigationBar);
        if (this.fNr != null) {
            this.fNo.setContentViewTop(this.fNr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fNp.onChangeSkinType(getPageContext(), i);
        this.fNo.onChangeSkinType(i);
        ap.setBackgroundColor(this.fNo, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
        ap.setViewTextColor(this.bZE, R.color.CAM_X0105);
        if (this.fNr != null) {
            this.fNr.rz(i);
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
        if (this.fNr == null || this.fNr.bEM()) {
            if (this.fNi != null) {
                this.fNo.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fNr != null) {
            Intent bEN = this.fNr.bEN();
            if (bEN != null) {
                setResult(-1, bEN);
            }
            if (this.fNi != null && !this.fNo.getIsFinish()) {
                this.fNo.onFinish();
                return;
            } else {
                super.finish();
                return;
            }
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fNo != null) {
            this.fNo.onDestroy();
        }
    }
}
