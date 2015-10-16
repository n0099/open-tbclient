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
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public class a extends c implements s {
    private TbPageContextSupport<?> awo;
    private View awp;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.awo = null;
        this.awo = tbPageContextSupport;
        this.padding = this.awo.getPageContext().getResources().getDimensionPixelSize(i.d.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View no() {
        this.mRoot = LayoutInflater.from(this.awo.getPageContext().getPageActivity()).inflate(i.g.new_pb_list_more, (ViewGroup) null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(i.f.pb_more_text);
        this.awp = this.mRoot.findViewById(i.f.pb_more_view);
        this.awp.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        a(this.awo.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.awp.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.awo.getPageContext().getLayoutMode().k(this.awp);
        return true;
    }

    public void hide() {
        this.awp.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void ow() {
        this.awp.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void et(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.awp.setVisibility(0);
    }

    public void eu(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void ev(int i) {
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
