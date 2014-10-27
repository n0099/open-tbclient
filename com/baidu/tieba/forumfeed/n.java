package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.h {
    private View auN;
    private BaseFragmentActivity axV;
    final /* synthetic */ j aym;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public n(j jVar, BaseFragmentActivity baseFragmentActivity) {
        this.aym = jVar;
        this.axV = null;
        this.axV = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.axV, w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.axV.getResources().getDimensionPixelSize(t.listview_item_margin), 0, this.axV.getResources().getDimensionPixelSize(t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(v.pb_more_text);
        this.auN = this.mRoot.findViewById(v.pb_more_view);
        this.auN.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(v.progress);
        cu(TbadkApplication.m251getInst().getSkinType());
        this.auN.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cu(int i) {
        com.baidu.tbadk.core.view.o oVar;
        this.axV.getLayoutMode().h(this.auN);
        oVar = this.aym.ahO;
        oVar.onChangeSkinType(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void hide() {
        this.mRoot.setVisibility(8);
    }

    public void Ba() {
        this.mRoot.setVisibility(0);
    }

    public void DF() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.axV.getText(y.loading));
        this.auN.setVisibility(0);
    }

    public void Ep() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(y.no_more_to_load);
    }

    public void DG() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(y.load_more);
    }

    public void Ev() {
        this.auN.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
