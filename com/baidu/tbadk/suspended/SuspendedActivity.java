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
    protected TextView bOb;
    private TranView fwK;
    private SusPendedView fwQ;
    private NoNetworkView fwR;
    private LinearLayout fwS;
    private a fwT;
    private NoNetworkView.a fwU = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bCq();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bCq();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fwQ = (SusPendedView) findViewById(R.id.root_view);
        bCn();
        bCo();
        bCp();
        Xh();
        this.fwQ.setNavigationBar(this.fwS);
        this.fwQ.setTranView(this.fwK);
        this.fwQ.setContentView(this.mContentView);
        this.fwQ.show();
    }

    private void bCn() {
        this.fwK = new TranView(getPageContext().getPageActivity());
        this.fwK.setVisibility(0);
    }

    private void bCo() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bOb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bOb.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fwS = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fwS.addView(this.fwK, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bCp() {
        this.fwR = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fwR.a(this.fwU);
    }

    private void Xh() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fwT = a(this.mContentView, this.mNavigationBar);
        if (this.fwT != null) {
            this.fwQ.setContentViewTop(this.fwT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fwR.onChangeSkinType(getPageContext(), i);
        this.fwQ.onChangeSkinType(i);
        ap.setBackgroundColor(this.fwQ, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
        ap.setViewTextColor(this.bOb, R.color.CAM_X0105);
        if (this.fwT != null) {
            this.fwT.sm(i);
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
        if (this.fwT == null || this.fwT.bCl()) {
            if (this.fwK != null) {
                this.fwQ.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fwT != null) {
            Intent bCm = this.fwT.bCm();
            if (bCm != null) {
                setResult(-1, bCm);
            }
            if (this.fwK != null && !this.fwQ.getIsFinish()) {
                this.fwQ.onFinish();
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
        if (this.fwQ != null) {
            this.fwQ.onDestroy();
        }
    }
}
