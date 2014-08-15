package com.baidu.tbadk.pay;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.base.f;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class PayView extends f {
    private BaseActivity mActivity;
    private ProgressBar mProgressBar;
    private View mRoot;

    public PayView(BaseActivity baseActivity) {
        super(baseActivity);
        this.mActivity = baseActivity;
        initUI();
    }

    private void initUI() {
        this.mActivity.setContentView(v.pay_activity);
        this.mRoot = this.mActivity.findViewById(u.container);
        this.mProgressBar = (ProgressBar) this.mActivity.findViewById(u.pay_progress);
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
