package com.baidu.tbadk.pay;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.base.g;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PayView extends g {
    private BaseActivity mActivity;
    private ProgressBar mProgressBar;
    private View mRoot;

    public PayView(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mActivity = baseActivity;
        initUI();
    }

    private void initUI() {
        this.mActivity.setContentView(r.pay_activity);
        this.mRoot = this.mActivity.findViewById(q.container);
        this.mProgressBar = (ProgressBar) this.mActivity.findViewById(q.pay_progress);
    }

    public void showProgress() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgress() {
        this.mProgressBar.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().j(this.mRoot);
    }
}
