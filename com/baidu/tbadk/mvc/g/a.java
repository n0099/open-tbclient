package com.baidu.tbadk.mvc.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes.dex */
public class a extends b implements m {
    private TbPageContextSupport<?> aIr;
    private View aIs;
    private int padding;
    private TextView abE = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Ry = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aIr = null;
        this.aIr = tbPageContextSupport;
        this.padding = this.aIr.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View kX() {
        this.Ry = LayoutInflater.from(this.aIr.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.Ry.setPadding(0, this.padding, 0, this.padding);
        this.abE = (TextView) this.Ry.findViewById(d.g.pb_more_text);
        this.aIs = this.Ry.findViewById(d.g.pb_more_view);
        this.aIs.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Ry.findViewById(d.g.progress);
        b(this.aIr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIs.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Ry;
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aIr.getPageContext().getLayoutMode().t(this.aIs);
        return true;
    }

    public void hide() {
        this.aIs.setVisibility(8);
        this.Ry.setPadding(0, 0, 0, 0);
    }

    public void lG() {
        this.aIs.setVisibility(0);
        this.Ry.setPadding(0, this.padding, 0, this.padding);
    }

    public void fn(int i) {
        this.mProgressBar.setVisibility(0);
        this.abE.setText(i);
        this.aIs.setVisibility(0);
    }

    public void fo(int i) {
        this.mProgressBar.setVisibility(8);
        this.abE.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Ry);
        }
    }
}
