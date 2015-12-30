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
    private TbPageContextSupport<?> ayK;
    private View ayL;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.ayK = null;
        this.ayK = tbPageContextSupport;
        this.padding = this.ayK.getPageContext().getResources().getDimensionPixelSize(n.e.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View mT() {
        this.mRoot = LayoutInflater.from(this.ayK.getPageContext().getPageActivity()).inflate(n.h.new_pb_list_more, (ViewGroup) null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(n.g.pb_more_text);
        this.ayL = this.mRoot.findViewById(n.g.pb_more_view);
        this.ayL.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(n.g.progress);
        a(this.ayK.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.ayL.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.ayK.getPageContext().getLayoutMode().k(this.ayL);
        return true;
    }

    public void hide() {
        this.ayL.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void ob() {
        this.ayL.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void ez(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.ayL.setVisibility(0);
    }

    public void eA(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void eB(int i) {
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
