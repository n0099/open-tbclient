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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    protected TextView bYR;
    private TranView fOe;
    private SusPendedView fOk;
    private NoNetworkView fOl;
    private LinearLayout fOm;
    private a fOn;
    private NoNetworkView.a fOo = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bIn();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bIn();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fOk = (SusPendedView) findViewById(R.id.root_view);
        bIk();
        bIl();
        bIm();
        abo();
        this.fOk.setNavigationBar(this.fOm);
        this.fOk.setTranView(this.fOe);
        this.fOk.setContentView(this.mContentView);
        this.fOk.show();
    }

    private void bIk() {
        this.fOe = new TranView(getPageContext().getPageActivity());
        this.fOe.setVisibility(0);
    }

    private void bIl() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bYR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bYR.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fOm = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fOm.addView(this.fOe, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bIm() {
        this.fOl = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fOl.a(this.fOo);
    }

    private void abo() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fOn = a(this.mContentView, this.mNavigationBar);
        if (this.fOn != null) {
            this.fOk.setContentViewTop(this.fOn);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fOl.onChangeSkinType(getPageContext(), i);
        this.fOk.onChangeSkinType(i);
        ao.setBackgroundColor(this.fOk, R.color.CAM_X0608);
        ao.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
        ao.setViewTextColor(this.bYR, R.color.CAM_X0105);
        if (this.fOn != null) {
            this.fOn.sY(i);
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
        if (this.fOn == null || this.fOn.bIi()) {
            if (this.fOe != null) {
                this.fOk.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fOn != null) {
            Intent bIj = this.fOn.bIj();
            if (bIj != null) {
                setResult(-1, bIj);
            }
            if (this.fOe != null && !this.fOk.getIsFinish()) {
                this.fOk.onFinish();
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
        if (this.fOk != null) {
            this.fOk.onDestroy();
        }
    }
}
