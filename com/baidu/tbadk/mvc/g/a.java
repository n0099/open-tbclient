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
    private TbPageContextSupport<?> bxn;
    private View bxo;
    private int padding;
    private TextView rz = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View aGK = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bxn = null;
        this.bxn = tbPageContextSupport;
        this.padding = this.bxn.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View sv() {
        this.aGK = LayoutInflater.from(this.bxn.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.aGK.setPadding(0, this.padding, 0, this.padding);
        this.rz = (TextView) this.aGK.findViewById(d.g.pb_more_text);
        this.bxo = this.aGK.findViewById(d.g.pb_more_view);
        this.bxo.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aGK.findViewById(d.g.progress);
        b(this.bxn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bxo.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aGK;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bxn.getPageContext().getLayoutMode().aM(this.bxo);
        return true;
    }

    public void hide() {
        this.bxo.setVisibility(8);
        this.aGK.setPadding(0, 0, 0, 0);
    }

    public void ti() {
        this.bxo.setVisibility(0);
        this.aGK.setPadding(0, this.padding, 0, this.padding);
    }

    public void ig(int i) {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(i);
        this.bxo.setVisibility(0);
    }

    public void ih(int i) {
        this.mProgressBar.setVisibility(8);
        this.rz.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aGK);
        }
    }
}
