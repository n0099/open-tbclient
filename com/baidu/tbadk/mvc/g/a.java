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
    private TbPageContextSupport<?> bxe;
    private View bxf;
    private int padding;
    private TextView rz = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aGH = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bxe = null;
        this.bxe = tbPageContextSupport;
        this.padding = this.bxe.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View su() {
        this.aGH = LayoutInflater.from(this.bxe.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.aGH.setPadding(0, this.padding, 0, this.padding);
        this.rz = (TextView) this.aGH.findViewById(d.g.pb_more_text);
        this.bxf = this.aGH.findViewById(d.g.pb_more_view);
        this.bxf.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aGH.findViewById(d.g.progress);
        b(this.bxe.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bxf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aGH;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bxe.getPageContext().getLayoutMode().aM(this.bxf);
        return true;
    }

    public void hide() {
        this.bxf.setVisibility(8);
        this.aGH.setPadding(0, 0, 0, 0);
    }

    public void th() {
        this.bxf.setVisibility(0);
        this.aGH.setPadding(0, this.padding, 0, this.padding);
    }

    public void ig(int i) {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(i);
        this.bxf.setVisibility(0);
    }

    public void ih(int i) {
        this.mProgressBar.setVisibility(8);
        this.rz.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aGH);
        }
    }
}
