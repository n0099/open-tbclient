package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends com.baidu.adp.widget.ListView.h {
    private View auW;
    final /* synthetic */ bq auX;
    private final BaseActivity mActivity;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View mRoot = null;

    public br(bq bqVar, BaseActivity baseActivity) {
        this.auX = bqVar;
        this.mActivity = baseActivity;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, ca.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.mActivity.getResources().getDimensionPixelSize(bx.listview_item_margin), 0, this.mActivity.getResources().getDimensionPixelSize(bx.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(bz.pb_more_text);
        this.auW = this.mRoot.findViewById(bz.pb_more_view);
        this.auW.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(bz.progress);
        cu(TbadkApplication.m251getInst().getSkinType());
        this.auW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cu(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.auW);
    }

    public void hide() {
        this.mRoot.setVisibility(8);
    }

    public void Bc() {
        this.mRoot.setVisibility(0);
    }

    public void DH() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.mActivity.getText(cb.loading));
        this.auW.setVisibility(0);
    }

    public void DI() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(cb.load_more);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
    }
}
