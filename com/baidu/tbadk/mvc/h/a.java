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
    private TbPageContextSupport<?> aBr;
    private View aBs;
    private int padding;
    private TextView WJ = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MM = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aBr = null;
        this.aBr = tbPageContextSupport;
        this.padding = this.aBr.getPageContext().getResources().getDimensionPixelSize(r.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.MM = LayoutInflater.from(this.aBr.getPageContext().getPageActivity()).inflate(r.h.new_pb_list_more, (ViewGroup) null);
        this.MM.setPadding(0, this.padding, 0, this.padding);
        this.WJ = (TextView) this.MM.findViewById(r.g.pb_more_text);
        this.aBs = this.MM.findViewById(r.g.pb_more_view);
        this.aBs.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.MM.findViewById(r.g.progress);
        a(this.aBr.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aBs.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.MM;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aBr.getPageContext().getLayoutMode().x(this.aBs);
        return true;
    }

    public void hide() {
        this.aBs.setVisibility(8);
        this.MM.setPadding(0, 0, 0, 0);
    }

    public void lz() {
        this.aBs.setVisibility(0);
        this.MM.setPadding(0, this.padding, 0, this.padding);
    }

    public void eZ(int i) {
        this.mProgressBar.setVisibility(0);
        this.WJ.setText(i);
        this.aBs.setVisibility(0);
    }

    public void fa(int i) {
        this.mProgressBar.setVisibility(8);
        this.WJ.setText(i);
    }

    public void fb(int i) {
        this.mProgressBar.setVisibility(8);
        this.WJ.setText(i);
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
