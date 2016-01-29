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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes.dex */
public class a extends c implements s {
    private TbPageContextSupport<?> azB;
    private View azC;
    private int padding;
    private TextView YG = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sn = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.azB = null;
        this.azB = tbPageContextSupport;
        this.padding = this.azB.getPageContext().getResources().getDimensionPixelSize(t.e.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View ni() {
        this.Sn = LayoutInflater.from(this.azB.getPageContext().getPageActivity()).inflate(t.h.new_pb_list_more, (ViewGroup) null);
        this.Sn.setPadding(0, this.padding, 0, this.padding);
        this.YG = (TextView) this.Sn.findViewById(t.g.pb_more_text);
        this.azC = this.Sn.findViewById(t.g.pb_more_view);
        this.azC.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Sn.findViewById(t.g.progress);
        a(this.azB.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.azC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Sn;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.azB.getPageContext().getLayoutMode().x(this.azC);
        return true;
    }

    public void hide() {
        this.azC.setVisibility(8);
        this.Sn.setPadding(0, 0, 0, 0);
    }

    public void ow() {
        this.azC.setVisibility(0);
        this.Sn.setPadding(0, this.padding, 0, this.padding);
    }

    public void eT(int i) {
        this.mProgressBar.setVisibility(0);
        this.YG.setText(i);
        this.azC.setVisibility(0);
    }

    public void eU(int i) {
        this.mProgressBar.setVisibility(8);
        this.YG.setText(i);
    }

    public void eV(int i) {
        this.mProgressBar.setVisibility(8);
        this.YG.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Sn);
        }
    }
}
