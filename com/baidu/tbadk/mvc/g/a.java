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
    private TbPageContextSupport<?> aFo;
    private View aFp;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rt = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aFo = null;
        this.aFo = tbPageContextSupport;
        this.padding = this.aFo.getPageContext().getResources().getDimensionPixelSize(w.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lf() {
        this.Rt = LayoutInflater.from(this.aFo.getPageContext().getPageActivity()).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.Rt.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.Rt.findViewById(w.h.pb_more_text);
        this.aFp = this.Rt.findViewById(w.h.pb_more_view);
        this.aFp.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Rt.findViewById(w.h.progress);
        b(this.aFo.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aFp.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Rt;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aFo.getPageContext().getLayoutMode().t(this.aFp);
        return true;
    }

    public void hide() {
        this.aFp.setVisibility(8);
        this.Rt.setPadding(0, 0, 0, 0);
    }

    public void mp() {
        this.aFp.setVisibility(0);
        this.Rt.setPadding(0, this.padding, 0, this.padding);
    }

    public void eY(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aFp.setVisibility(0);
    }

    public void eZ(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rt);
        }
    }
}
