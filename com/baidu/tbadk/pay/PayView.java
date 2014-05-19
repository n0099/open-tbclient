package com.baidu.tbadk.pay;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.base.e;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class PayView extends e {
    private BaseActivity mActivity;
    private ProgressBar mProgressBar;
    private View mRoot;

    public PayView(BaseActivity baseActivity) {
        super(baseActivity);
        this.mActivity = baseActivity;
        initUI();
    }

    private void initUI() {
        this.mActivity.setContentView(s.pay_activity);
        this.mRoot = this.mActivity.findViewById(r.container);
        this.mProgressBar = (ProgressBar) this.mActivity.findViewById(r.pay_progress);
    }

    public void showProgress() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgress() {
        this.mProgressBar.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().a(i == 1);
        this.mActivity.getLayoutMode().a(this.mRoot);
    }
}
