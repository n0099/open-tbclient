package com.baidu.tbadk.mvc.k;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.core.e;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class b extends i implements y {
    private e<?, ?, ?> afe;
    private View aff;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public b(e<?, ?, ?> eVar) {
        this.afe = null;
        this.afe = eVar;
        this.padding = this.afe.getResources().getDimensionPixelSize(u.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jx() {
        this.mRoot = com.baidu.adp.lib.g.b.ek().inflate(this.afe.getPageContext().getPageActivity(), x.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(w.pb_more_text);
        this.aff = this.mRoot.findViewById(w.pb_more_view);
        this.aff.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(w.progress);
        a(this.afe.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.aff.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.afe.getLayoutMode().h(this.aff);
        return true;
    }

    public void hide() {
        this.aff.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void yB() {
        this.aff.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void dM(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aff.setVisibility(0);
    }

    public void dN(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void dL(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
