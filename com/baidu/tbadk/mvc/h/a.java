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
    private TbPageContextSupport<?> aAi;
    private View aAj;
    private int padding;
    private TextView WY = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View PL = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aAi = null;
        this.aAi = tbPageContextSupport;
        this.padding = this.aAi.getPageContext().getResources().getDimensionPixelSize(t.e.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View mZ() {
        this.PL = LayoutInflater.from(this.aAi.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.PL.setPadding(0, this.padding, 0, this.padding);
        this.WY = (TextView) this.PL.findViewById(t.g.pb_more_text);
        this.aAj = this.PL.findViewById(t.g.pb_more_view);
        this.aAj.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.PL.findViewById(t.g.progress);
        a(this.aAi.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.aAj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.PL;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aAi.getPageContext().getLayoutMode().x(this.aAj);
        return true;
    }

    public void hide() {
        this.aAj.setVisibility(8);
        this.PL.setPadding(0, 0, 0, 0);
    }

    public void op() {
        this.aAj.setVisibility(0);
        this.PL.setPadding(0, this.padding, 0, this.padding);
    }

    public void eZ(int i) {
        this.mProgressBar.setVisibility(0);
        this.WY.setText(i);
        this.aAj.setVisibility(0);
    }

    public void fa(int i) {
        this.mProgressBar.setVisibility(8);
        this.WY.setText(i);
    }

    public void fb(int i) {
        this.mProgressBar.setVisibility(8);
        this.WY.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.PL);
        }
    }
}
