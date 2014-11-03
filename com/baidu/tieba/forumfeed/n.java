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
    private View auW;
    private BaseFragmentActivity aye;
    final /* synthetic */ j ayv;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public n(j jVar, BaseFragmentActivity baseFragmentActivity) {
        this.ayv = jVar;
        this.aye = null;
        this.aye = baseFragmentActivity;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.aye, w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.aye.getResources().getDimensionPixelSize(t.listview_item_margin), 0, this.aye.getResources().getDimensionPixelSize(t.listview_item_margin));
        this.mTextView = (TextView) this.mRoot.findViewById(v.pb_more_text);
        this.auW = this.mRoot.findViewById(v.pb_more_view);
        this.auW.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(v.progress);
        cu(TbadkApplication.m251getInst().getSkinType());
        this.auW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public void cu(int i) {
        com.baidu.tbadk.core.view.o oVar;
        this.aye.getLayoutMode().h(this.auW);
        oVar = this.ayv.ahX;
        oVar.onChangeSkinType(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void hide() {
        this.mRoot.setVisibility(8);
    }

    public void Bc() {
        this.mRoot.setVisibility(0);
    }

    public void DH() {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(this.aye.getText(y.loading));
        this.auW.setVisibility(0);
    }

    public void Er() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(y.no_more_to_load);
    }

    public void DI() {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(y.load_more);
    }

    public void Ex() {
        this.auW.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
