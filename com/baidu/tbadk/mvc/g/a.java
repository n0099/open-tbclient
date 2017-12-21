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
    private TbPageContextSupport<?> aJh;
    private View aJi;
    private int padding;
    private TextView abW = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sf = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aJh = null;
        this.aJh = tbPageContextSupport;
        this.padding = this.aJh.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View kX() {
        this.Sf = LayoutInflater.from(this.aJh.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        this.Sf.setPadding(0, this.padding, 0, this.padding);
        this.abW = (TextView) this.Sf.findViewById(d.g.pb_more_text);
        this.aJi = this.Sf.findViewById(d.g.pb_more_view);
        this.aJi.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Sf.findViewById(d.g.progress);
        b(this.aJh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aJi.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Sf;
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aJh.getPageContext().getLayoutMode().t(this.aJi);
        return true;
    }

    public void hide() {
        this.aJi.setVisibility(8);
        this.Sf.setPadding(0, 0, 0, 0);
    }

    public void lE() {
        this.aJi.setVisibility(0);
        this.Sf.setPadding(0, this.padding, 0, this.padding);
    }

    public void fl(int i) {
        this.mProgressBar.setVisibility(0);
        this.abW.setText(i);
        this.aJi.setVisibility(0);
    }

    public void fm(int i) {
        this.mProgressBar.setVisibility(8);
        this.abW.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Sf);
        }
    }
}
