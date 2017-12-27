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
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class a extends b implements o {
    private TbPageContextSupport<?> bwV;
    private View bwW;
    private int padding;
    private TextView rz = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aGJ = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bwV = null;
        this.bwV = tbPageContextSupport;
        this.padding = this.bwV.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View su() {
        this.aGJ = LayoutInflater.from(this.bwV.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.aGJ.setPadding(0, this.padding, 0, this.padding);
        this.rz = (TextView) this.aGJ.findViewById(d.g.pb_more_text);
        this.bwW = this.aGJ.findViewById(d.g.pb_more_view);
        this.bwW.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aGJ.findViewById(d.g.progress);
        b(this.bwV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bwW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aGJ;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bwV.getPageContext().getLayoutMode().aM(this.bwW);
        return true;
    }

    public void hide() {
        this.bwW.setVisibility(8);
        this.aGJ.setPadding(0, 0, 0, 0);
    }

    public void th() {
        this.bwW.setVisibility(0);
        this.aGJ.setPadding(0, this.padding, 0, this.padding);
    }

    public void ik(int i) {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(i);
        this.bwW.setVisibility(0);
    }

    public void il(int i) {
        this.mProgressBar.setVisibility(8);
        this.rz.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aGJ);
        }
    }
}
