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
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes.dex */
public class a extends c implements r {
    private TbPageContextSupport<?> awg;
    private View awh;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.awg = null;
        this.awg = tbPageContextSupport;
        this.padding = this.awg.getPageContext().getResources().getDimensionPixelSize(i.d.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nq() {
        this.mRoot = LayoutInflater.from(this.awg.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
        this.awh = this.mRoot.findViewById(i.f.pb_more_view);
        this.awh.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        a(this.awg.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.awh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.awg.getPageContext().getLayoutMode().k(this.awh);
        return true;
    }

    public void hide() {
        this.awh.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void oy() {
        this.awh.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void ek(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.awh.setVisibility(0);
    }

    public void el(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void em(int i) {
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
