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
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes.dex */
public class a extends c implements r {
    private TbPageContextSupport<?> aAL;
    private View aAM;
    private int padding;
    private TextView Wd = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View MJ = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aAL = null;
        this.aAL = tbPageContextSupport;
        this.padding = this.aAL.getPageContext().getResources().getDimensionPixelSize(r.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View kk() {
        this.MJ = LayoutInflater.from(this.aAL.getPageContext().getPageActivity()).inflate(r.h.new_pb_list_more, (ViewGroup) null);
        this.MJ.setPadding(0, this.padding, 0, this.padding);
        this.Wd = (TextView) this.MJ.findViewById(r.g.pb_more_text);
        this.aAM = this.MJ.findViewById(r.g.pb_more_view);
        this.aAM.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.MJ.findViewById(r.g.progress);
        a(this.aAL.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aAM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.MJ;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aAL.getPageContext().getLayoutMode().x(this.aAM);
        return true;
    }

    public void hide() {
        this.aAM.setVisibility(8);
        this.MJ.setPadding(0, 0, 0, 0);
    }

    public void lz() {
        this.aAM.setVisibility(0);
        this.MJ.setPadding(0, this.padding, 0, this.padding);
    }

    public void eZ(int i) {
        this.mProgressBar.setVisibility(0);
        this.Wd.setText(i);
        this.aAM.setVisibility(0);
    }

    public void fa(int i) {
        this.mProgressBar.setVisibility(8);
        this.Wd.setText(i);
    }

    public void fb(int i) {
        this.mProgressBar.setVisibility(8);
        this.Wd.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.MJ);
        }
    }
}
