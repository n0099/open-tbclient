package com.baidu.tbadk.mvc.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.c;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes.dex */
public class a extends c implements t {
    private TbPageContextSupport<?> axg;
    private View axh;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.axg = null;
        this.axg = tbPageContextSupport;
        this.padding = this.axg.getPageContext().getResources().getDimensionPixelSize(n.d.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nv() {
        this.mRoot = LayoutInflater.from(this.axg.getPageContext().getPageActivity()).inflate(n.g.new_pb_list_more, (ViewGroup) null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(n.f.pb_more_text);
        this.axh = this.mRoot.findViewById(n.f.pb_more_view);
        this.axh.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(n.f.progress);
        a(this.axg.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.axh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.axg.getPageContext().getLayoutMode().k(this.axh);
        return true;
    }

    public void hide() {
        this.axh.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void oD() {
        this.axh.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void eF(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.axh.setVisibility(0);
    }

    public void eG(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void eH(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
