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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public class a extends c implements s {
    private TbPageContextSupport<?> awl;
    private View awm;
    private int padding;
    private TextView Sm = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View KB = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.awl = null;
        this.awl = tbPageContextSupport;
        this.padding = this.awl.getPageContext().getResources().getDimensionPixelSize(t.e.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View jn() {
        this.KB = LayoutInflater.from(this.awl.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.KB.setPadding(0, this.padding, 0, this.padding);
        this.Sm = (TextView) this.KB.findViewById(t.g.pb_more_text);
        this.awm = this.KB.findViewById(t.g.pb_more_view);
        this.awm.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.KB.findViewById(t.g.progress);
        a(this.awl.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        this.awm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.KB;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.awl.getPageContext().getLayoutMode().x(this.awm);
        return true;
    }

    public void hide() {
        this.awm.setVisibility(8);
        this.KB.setPadding(0, 0, 0, 0);
    }

    public void kC() {
        this.awm.setVisibility(0);
        this.KB.setPadding(0, this.padding, 0, this.padding);
    }

    public void eE(int i) {
        this.mProgressBar.setVisibility(0);
        this.Sm.setText(i);
        this.awm.setVisibility(0);
    }

    public void eF(int i) {
        this.mProgressBar.setVisibility(8);
        this.Sm.setText(i);
    }

    public void eG(int i) {
        this.mProgressBar.setVisibility(8);
        this.Sm.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.KB);
        }
    }
}
