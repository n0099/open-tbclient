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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.q;
/* loaded from: classes.dex */
public class a extends c implements q {
    private TbPageContextSupport<?> azD;
    private View azE;
    private int padding;
    private TextView Vt = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View LW = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.azD = null;
        this.azD = tbPageContextSupport;
        this.padding = this.azD.getPageContext().getResources().getDimensionPixelSize(r.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kg() {
        this.LW = LayoutInflater.from(this.azD.getPageContext().getPageActivity()).inflate(r.j.new_pb_list_more, (ViewGroup) null);
        this.LW.setPadding(0, this.padding, 0, this.padding);
        this.Vt = (TextView) this.LW.findViewById(r.h.pb_more_text);
        this.azE = this.LW.findViewById(r.h.pb_more_view);
        this.azE.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.LW.findViewById(r.h.progress);
        a(this.azD.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.azE.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.LW;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.azD.getPageContext().getLayoutMode().v(this.azE);
        return true;
    }

    public void hide() {
        this.azE.setVisibility(8);
        this.LW.setPadding(0, 0, 0, 0);
    }

    public void lr() {
        this.azE.setVisibility(0);
        this.LW.setPadding(0, this.padding, 0, this.padding);
    }

    public void fa(int i) {
        this.mProgressBar.setVisibility(0);
        this.Vt.setText(i);
        this.azE.setVisibility(0);
    }

    public void fb(int i) {
        this.mProgressBar.setVisibility(8);
        this.Vt.setText(i);
    }

    public void fc(int i) {
        this.mProgressBar.setVisibility(8);
        this.Vt.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.LW);
        }
    }
}
