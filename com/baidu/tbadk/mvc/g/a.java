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
    private TbPageContextSupport<?> aIR;
    private View aIS;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sf = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aIR = null;
        this.aIR = tbPageContextSupport;
        this.padding = this.aIR.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lk() {
        this.Sf = LayoutInflater.from(this.aIR.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.Sf.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.Sf.findViewById(d.h.pb_more_text);
        this.aIS = this.Sf.findViewById(d.h.pb_more_view);
        this.aIS.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Sf.findViewById(d.h.progress);
        b(this.aIR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIS.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Sf;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aIR.getPageContext().getLayoutMode().t(this.aIS);
        return true;
    }

    public void hide() {
        this.aIS.setVisibility(8);
        this.Sf.setPadding(0, 0, 0, 0);
    }

    public void lT() {
        this.aIS.setVisibility(0);
        this.Sf.setPadding(0, this.padding, 0, this.padding);
    }

    public void fc(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aIS.setVisibility(0);
    }

    public void fd(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Sf);
        }
    }
}
