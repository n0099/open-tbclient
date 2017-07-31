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
    private TbPageContextSupport<?> aIQ;
    private View aIR;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sd = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aIQ = null;
        this.aIQ = tbPageContextSupport;
        this.padding = this.aIQ.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lk() {
        this.Sd = LayoutInflater.from(this.aIQ.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.Sd.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.Sd.findViewById(d.h.pb_more_text);
        this.aIR = this.Sd.findViewById(d.h.pb_more_view);
        this.aIR.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Sd.findViewById(d.h.progress);
        b(this.aIQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIR.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Sd;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aIQ.getPageContext().getLayoutMode().t(this.aIR);
        return true;
    }

    public void hide() {
        this.aIR.setVisibility(8);
        this.Sd.setPadding(0, 0, 0, 0);
    }

    public void lT() {
        this.aIR.setVisibility(0);
        this.Sd.setPadding(0, this.padding, 0, this.padding);
    }

    public void fc(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aIR.setVisibility(0);
    }

    public void fd(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Sd);
        }
    }
}
