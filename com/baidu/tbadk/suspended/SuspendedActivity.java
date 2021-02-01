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
    protected TextView bYe;
    private TranView fLI;
    private SusPendedView fLO;
    private NoNetworkView fLP;
    private LinearLayout fLQ;
    private a fLR;
    private NoNetworkView.a fLS = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bEN();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bEN();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fLO = (SusPendedView) findViewById(R.id.root_view);
        bEK();
        bEL();
        bEM();
        Zl();
        this.fLO.setNavigationBar(this.fLQ);
        this.fLO.setTranView(this.fLI);
        this.fLO.setContentView(this.mContentView);
        this.fLO.show();
    }

    private void bEK() {
        this.fLI = new TranView(getPageContext().getPageActivity());
        this.fLI.setVisibility(0);
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bYe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bYe.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fLQ = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fLQ.addView(this.fLI, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bEM() {
        this.fLP = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fLP.a(this.fLS);
    }

    private void Zl() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fLR = a(this.mContentView, this.mNavigationBar);
        if (this.fLR != null) {
            this.fLO.setContentViewTop(this.fLR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fLP.onChangeSkinType(getPageContext(), i);
        this.fLO.onChangeSkinType(i);
        ap.setBackgroundColor(this.fLO, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
        ap.setViewTextColor(this.bYe, R.color.CAM_X0105);
        if (this.fLR != null) {
            this.fLR.rx(i);
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
        if (this.fLR == null || this.fLR.bEI()) {
            if (this.fLI != null) {
                this.fLO.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fLR != null) {
            Intent bEJ = this.fLR.bEJ();
            if (bEJ != null) {
                setResult(-1, bEJ);
            }
            if (this.fLI != null && !this.fLO.getIsFinish()) {
                this.fLO.onFinish();
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
        if (this.fLO != null) {
            this.fLO.onDestroy();
        }
    }
}
