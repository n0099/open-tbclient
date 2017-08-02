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
    private TbPageContextSupport<?> aHB;
    private View aHC;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View QE = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aHB = null;
        this.aHB = tbPageContextSupport;
        this.padding = this.aHB.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View la() {
        this.QE = LayoutInflater.from(this.aHB.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.QE.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.QE.findViewById(d.h.pb_more_text);
        this.aHC = this.QE.findViewById(d.h.pb_more_view);
        this.aHC.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.QE.findViewById(d.h.progress);
        b(this.aHB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aHC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.QE;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aHB.getPageContext().getLayoutMode().t(this.aHC);
        return true;
    }

    public void hide() {
        this.aHC.setVisibility(8);
        this.QE.setPadding(0, 0, 0, 0);
    }

    public void lJ() {
        this.aHC.setVisibility(0);
        this.QE.setPadding(0, this.padding, 0, this.padding);
    }

    public void fa(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aHC.setVisibility(0);
    }

    public void fb(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.QE);
        }
    }
}
