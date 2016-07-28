package com.baidu.tbadk.mvc.h;

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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends c implements t {
    private TbPageContextSupport<?> axP;
    private View axQ;
    private int padding;
    private TextView Tl = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View KA = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.axP = null;
        this.axP = tbPageContextSupport;
        this.padding = this.axP.getPageContext().getResources().getDimensionPixelSize(u.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View jp() {
        this.KA = LayoutInflater.from(this.axP.getPageContext().getPageActivity()).inflate(u.h.new_pb_list_more, (ViewGroup) null);
        this.KA.setPadding(0, this.padding, 0, this.padding);
        this.Tl = (TextView) this.KA.findViewById(u.g.pb_more_text);
        this.axQ = this.KA.findViewById(u.g.pb_more_view);
        this.axQ.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.KA.findViewById(u.g.progress);
        a(this.axP.getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
        this.axQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.KA;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.axP.getPageContext().getLayoutMode().w(this.axQ);
        return true;
    }

    public void hide() {
        this.axQ.setVisibility(8);
        this.KA.setPadding(0, 0, 0, 0);
    }

    public void kB() {
        this.axQ.setVisibility(0);
        this.KA.setPadding(0, this.padding, 0, this.padding);
    }

    public void eJ(int i) {
        this.mProgressBar.setVisibility(0);
        this.Tl.setText(i);
        this.axQ.setVisibility(0);
    }

    public void eK(int i) {
        this.mProgressBar.setVisibility(8);
        this.Tl.setText(i);
    }

    public void eL(int i) {
        this.mProgressBar.setVisibility(8);
        this.Tl.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.KA);
        }
    }
}
