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
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes.dex */
public class a extends b implements l {
    private TbPageContextSupport<?> aHU;
    private View aHV;
    private int padding;
    private TextView abv = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rt = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aHU = null;
        this.aHU = tbPageContextSupport;
        this.padding = this.aHU.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View ld() {
        this.Rt = LayoutInflater.from(this.aHU.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.Rt.setPadding(0, this.padding, 0, this.padding);
        this.abv = (TextView) this.Rt.findViewById(d.h.pb_more_text);
        this.aHV = this.Rt.findViewById(d.h.pb_more_view);
        this.aHV.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Rt.findViewById(d.h.progress);
        b(this.aHU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aHV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Rt;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aHU.getPageContext().getLayoutMode().t(this.aHV);
        return true;
    }

    public void hide() {
        this.aHV.setVisibility(8);
        this.Rt.setPadding(0, 0, 0, 0);
    }

    public void lM() {
        this.aHV.setVisibility(0);
        this.Rt.setPadding(0, this.padding, 0, this.padding);
    }

    public void fn(int i) {
        this.mProgressBar.setVisibility(0);
        this.abv.setText(i);
        this.aHV.setVisibility(0);
    }

    public void fo(int i) {
        this.mProgressBar.setVisibility(8);
        this.abv.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rt);
        }
    }
}
