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
import com.baidu.tieba.tbadkCore.n;
/* loaded from: classes.dex */
public class a extends b implements n {
    private TbPageContextSupport<?> aJe;
    private View aJf;
    private int padding;
    private TextView abT = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Se = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aJe = null;
        this.aJe = tbPageContextSupport;
        this.padding = this.aJe.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View kX() {
        this.Se = LayoutInflater.from(this.aJe.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.Se.setPadding(0, this.padding, 0, this.padding);
        this.abT = (TextView) this.Se.findViewById(d.g.pb_more_text);
        this.aJf = this.Se.findViewById(d.g.pb_more_view);
        this.aJf.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Se.findViewById(d.g.progress);
        b(this.aJe.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aJf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Se;
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aJe.getPageContext().getLayoutMode().t(this.aJf);
        return true;
    }

    public void hide() {
        this.aJf.setVisibility(8);
        this.Se.setPadding(0, 0, 0, 0);
    }

    public void lE() {
        this.aJf.setVisibility(0);
        this.Se.setPadding(0, this.padding, 0, this.padding);
    }

    public void fl(int i) {
        this.mProgressBar.setVisibility(0);
        this.abT.setText(i);
        this.aJf.setVisibility(0);
    }

    public void fm(int i) {
        this.mProgressBar.setVisibility(8);
        this.abT.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Se);
        }
    }
}
