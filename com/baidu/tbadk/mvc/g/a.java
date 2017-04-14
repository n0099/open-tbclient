package com.baidu.tbadk.mvc.g;

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
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends c implements q {
    private TbPageContextSupport<?> aFm;
    private View aFn;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rr = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aFm = null;
        this.aFm = tbPageContextSupport;
        this.padding = this.aFm.getPageContext().getResources().getDimensionPixelSize(w.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View le() {
        this.Rr = LayoutInflater.from(this.aFm.getPageContext().getPageActivity()).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.Rr.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.Rr.findViewById(w.h.pb_more_text);
        this.aFn = this.Rr.findViewById(w.h.pb_more_view);
        this.aFn.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Rr.findViewById(w.h.progress);
        b(this.aFm.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aFn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Rr;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aFm.getPageContext().getLayoutMode().t(this.aFn);
        return true;
    }

    public void hide() {
        this.aFn.setVisibility(8);
        this.Rr.setPadding(0, 0, 0, 0);
    }

    public void mp() {
        this.aFn.setVisibility(0);
        this.Rr.setPadding(0, this.padding, 0, this.padding);
    }

    public void eY(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aFn.setVisibility(0);
    }

    public void eZ(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rr);
        }
    }
}
