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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public class a extends c implements s {
    private View aAA;
    private TbPageContextSupport<?> aAz;
    private int padding;
    private TextView Wl = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MM = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aAz = null;
        this.aAz = tbPageContextSupport;
        this.padding = this.aAz.getPageContext().getResources().getDimensionPixelSize(r.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.MM = LayoutInflater.from(this.aAz.getPageContext().getPageActivity()).inflate(r.h.new_pb_list_more, (ViewGroup) null);
        this.MM.setPadding(0, this.padding, 0, this.padding);
        this.Wl = (TextView) this.MM.findViewById(r.g.pb_more_text);
        this.aAA = this.MM.findViewById(r.g.pb_more_view);
        this.aAA.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.MM.findViewById(r.g.progress);
        a(this.aAz.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aAA.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.MM;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aAz.getPageContext().getLayoutMode().x(this.aAA);
        return true;
    }

    public void hide() {
        this.aAA.setVisibility(8);
        this.MM.setPadding(0, 0, 0, 0);
    }

    public void lw() {
        this.aAA.setVisibility(0);
        this.MM.setPadding(0, this.padding, 0, this.padding);
    }

    public void eW(int i) {
        this.mProgressBar.setVisibility(0);
        this.Wl.setText(i);
        this.aAA.setVisibility(0);
    }

    public void eX(int i) {
        this.mProgressBar.setVisibility(8);
        this.Wl.setText(i);
    }

    public void eY(int i) {
        this.mProgressBar.setVisibility(8);
        this.Wl.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.MM);
        }
    }
}
