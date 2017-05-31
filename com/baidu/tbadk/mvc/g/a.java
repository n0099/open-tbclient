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
    private TbPageContextSupport<?> aFf;
    private View aFg;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Qx = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aFf = null;
        this.aFf = tbPageContextSupport;
        this.padding = this.aFf.getPageContext().getResources().getDimensionPixelSize(w.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View le() {
        this.Qx = LayoutInflater.from(this.aFf.getPageContext().getPageActivity()).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.Qx.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.Qx.findViewById(w.h.pb_more_text);
        this.aFg = this.Qx.findViewById(w.h.pb_more_view);
        this.aFg.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Qx.findViewById(w.h.progress);
        b(this.aFf.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aFg.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Qx;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aFf.getPageContext().getLayoutMode().t(this.aFg);
        return true;
    }

    public void hide() {
        this.aFg.setVisibility(8);
        this.Qx.setPadding(0, 0, 0, 0);
    }

    public void lO() {
        this.aFg.setVisibility(0);
        this.Qx.setPadding(0, this.padding, 0, this.padding);
    }

    public void eV(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aFg.setVisibility(0);
    }

    public void eW(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Qx);
        }
    }
}
