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
    private TbPageContextSupport<?> aIw;
    private View aIx;
    private int padding;
    private TextView abu = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rh = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aIw = null;
        this.aIw = tbPageContextSupport;
        this.padding = this.aIw.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lb() {
        this.Rh = LayoutInflater.from(this.aIw.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.Rh.setPadding(0, this.padding, 0, this.padding);
        this.abu = (TextView) this.Rh.findViewById(d.h.pb_more_text);
        this.aIx = this.Rh.findViewById(d.h.pb_more_view);
        this.aIx.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Rh.findViewById(d.h.progress);
        b(this.aIw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIx.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Rh;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aIw.getPageContext().getLayoutMode().t(this.aIx);
        return true;
    }

    public void hide() {
        this.aIx.setVisibility(8);
        this.Rh.setPadding(0, 0, 0, 0);
    }

    public void lK() {
        this.aIx.setVisibility(0);
        this.Rh.setPadding(0, this.padding, 0, this.padding);
    }

    public void fc(int i) {
        this.mProgressBar.setVisibility(0);
        this.abu.setText(i);
        this.aIx.setVisibility(0);
    }

    public void fd(int i) {
        this.mProgressBar.setVisibility(8);
        this.abu.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rh);
        }
    }
}
