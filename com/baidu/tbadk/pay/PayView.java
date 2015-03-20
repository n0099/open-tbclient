package com.baidu.tbadk.pay;

import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.base.g;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
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
        this.mActivity.setContentView(w.pay_activity);
        this.mRoot = this.mActivity.findViewById(v.container);
        this.mProgressBar = (ProgressBar) this.mActivity.findViewById(v.pay_progress);
    }

    public void showProgress() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgress() {
        this.mProgressBar.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().X(i == 1);
        this.mActivity.getLayoutMode().h(this.mRoot);
    }
}
