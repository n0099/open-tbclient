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
    private TbPageContextSupport<?> aJa;
    private View aJb;
    private int padding;
    private TextView abZ = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sh = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aJa = null;
        this.aJa = tbPageContextSupport;
        this.padding = this.aJa.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View kX() {
        this.Sh = LayoutInflater.from(this.aJa.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.Sh.setPadding(0, this.padding, 0, this.padding);
        this.abZ = (TextView) this.Sh.findViewById(d.g.pb_more_text);
        this.aJb = this.Sh.findViewById(d.g.pb_more_view);
        this.aJb.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Sh.findViewById(d.g.progress);
        b(this.aJa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aJb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Sh;
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aJa.getPageContext().getLayoutMode().t(this.aJb);
        return true;
    }

    public void hide() {
        this.aJb.setVisibility(8);
        this.Sh.setPadding(0, 0, 0, 0);
    }

    public void lE() {
        this.aJb.setVisibility(0);
        this.Sh.setPadding(0, this.padding, 0, this.padding);
    }

    public void fl(int i) {
        this.mProgressBar.setVisibility(0);
        this.abZ.setText(i);
        this.aJb.setVisibility(0);
    }

    public void fm(int i) {
        this.mProgressBar.setVisibility(8);
        this.abZ.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Sh);
        }
    }
}
