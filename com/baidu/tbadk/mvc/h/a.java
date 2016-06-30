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
    private TbPageContextSupport<?> axb;
    private View axc;
    private int padding;
    private TextView SD = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View KB = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.axb = null;
        this.axb = tbPageContextSupport;
        this.padding = this.axb.getPageContext().getResources().getDimensionPixelSize(u.e.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View jq() {
        this.KB = LayoutInflater.from(this.axb.getPageContext().getPageActivity()).inflate(u.h.new_pb_list_more, (ViewGroup) null);
        this.KB.setPadding(0, this.padding, 0, this.padding);
        this.SD = (TextView) this.KB.findViewById(u.g.pb_more_text);
        this.axc = this.KB.findViewById(u.g.pb_more_view);
        this.axc.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.KB.findViewById(u.g.progress);
        a(this.axb.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.axc.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.KB;
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.axb.getPageContext().getLayoutMode().w(this.axc);
        return true;
    }

    public void hide() {
        this.axc.setVisibility(8);
        this.KB.setPadding(0, 0, 0, 0);
    }

    public void kF() {
        this.axc.setVisibility(0);
        this.KB.setPadding(0, this.padding, 0, this.padding);
    }

    public void eJ(int i) {
        this.mProgressBar.setVisibility(0);
        this.SD.setText(i);
        this.axc.setVisibility(0);
    }

    public void eK(int i) {
        this.mProgressBar.setVisibility(8);
        this.SD.setText(i);
    }

    public void eL(int i) {
        this.mProgressBar.setVisibility(8);
        this.SD.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.KB);
        }
    }
}
