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
    protected TextView dsB;
    private LinearLayout eJA;
    private a eJB;
    private NoNetworkView.a eJC = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bmd();
            }
        }
    };
    private TranView eJs;
    private SusPendedView eJy;
    private NoNetworkView eJz;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bmd();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.eJy = (SusPendedView) findViewById(R.id.root_view);
        bma();
        bmb();
        bmc();
        PM();
        this.eJy.setNavigationBar(this.eJA);
        this.eJy.setTranView(this.eJs);
        this.eJy.setContentView(this.mContentView);
        this.eJy.show();
    }

    private void bma() {
        this.eJs = new TranView(getPageContext().getPageActivity());
        this.eJs.setVisibility(0);
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.dsB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.dsB.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dsB.getLayoutParams();
        layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds46);
        this.dsB.setLayoutParams(layoutParams);
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.eJA = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.eJA.addView(this.eJs, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bmc() {
        this.eJz = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eJz.a(this.eJC);
    }

    private void PM() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.eJB = a(this.mContentView, this.mNavigationBar);
        if (this.eJB != null) {
            this.eJy.setContentViewTop(this.eJB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eJz.onChangeSkinType(getPageContext(), i);
        this.eJy.onChangeSkinType(i);
        ao.setBackgroundColor(this.eJy, R.color.cp_mask_b_alpha66);
        ao.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.dsB, R.color.cp_cont_b);
        if (this.eJB != null) {
            this.eJB.ot(i);
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
        if (this.eJB == null || this.eJB.blY()) {
            if (this.eJs != null) {
                this.eJy.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.eJB != null) {
            Intent blZ = this.eJB.blZ();
            if (blZ != null) {
                setResult(-1, blZ);
            }
            if (this.eJs != null && !this.eJy.getIsFinish()) {
                this.eJy.onFinish();
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
        if (this.eJy != null) {
            this.eJy.onDestroy();
        }
    }
}
