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
    private TbPageContextSupport<?> aAW;
    private View aAX;
    private int padding;
    private TextView Wb = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MN = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aAW = null;
        this.aAW = tbPageContextSupport;
        this.padding = this.aAW.getPageContext().getResources().getDimensionPixelSize(t.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.MN = LayoutInflater.from(this.aAW.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.MN.setPadding(0, this.padding, 0, this.padding);
        this.Wb = (TextView) this.MN.findViewById(t.g.pb_more_text);
        this.aAX = this.MN.findViewById(t.g.pb_more_view);
        this.aAX.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.MN.findViewById(t.g.progress);
        a(this.aAW.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aAX.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.MN;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aAW.getPageContext().getLayoutMode().x(this.aAX);
        return true;
    }

    public void hide() {
        this.aAX.setVisibility(8);
        this.MN.setPadding(0, 0, 0, 0);
    }

    public void lw() {
        this.aAX.setVisibility(0);
        this.MN.setPadding(0, this.padding, 0, this.padding);
    }

    public void eX(int i) {
        this.mProgressBar.setVisibility(0);
        this.Wb.setText(i);
        this.aAX.setVisibility(0);
    }

    public void eY(int i) {
        this.mProgressBar.setVisibility(8);
        this.Wb.setText(i);
    }

    public void eZ(int i) {
        this.mProgressBar.setVisibility(8);
        this.Wb.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.MN);
        }
    }
}
