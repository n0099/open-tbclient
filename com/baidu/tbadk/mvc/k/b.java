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
    private e<?, ?, ?> afB;
    private View afC;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public b(e<?, ?, ?> eVar) {
        this.afB = null;
        this.afB = eVar;
        this.padding = this.afB.getResources().getDimensionPixelSize(u.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jy() {
        this.mRoot = com.baidu.adp.lib.g.b.ei().inflate(this.afB.getPageContext().getPageActivity(), x.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(w.pb_more_text);
        this.afC = this.mRoot.findViewById(w.pb_more_view);
        this.afC.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(w.progress);
        a(this.afB.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.afC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.afB.getLayoutMode().h(this.afC);
        return true;
    }

    public void hide() {
        this.afC.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void yR() {
        this.afC.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void dS(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.afC.setVisibility(0);
    }

    public void dT(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void dR(int i) {
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
