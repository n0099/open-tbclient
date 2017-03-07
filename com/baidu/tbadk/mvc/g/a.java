package com.baidu.tbadk.mvc.g;

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
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends c implements q {
    private TbPageContextSupport<?> aEW;
    private View aEX;
    private int padding;
    private TextView aaE = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View QZ = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aEW = null;
        this.aEW = tbPageContextSupport;
        this.padding = this.aEW.getPageContext().getResources().getDimensionPixelSize(w.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View la() {
        this.QZ = LayoutInflater.from(this.aEW.getPageContext().getPageActivity()).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.QZ.setPadding(0, this.padding, 0, this.padding);
        this.aaE = (TextView) this.QZ.findViewById(w.h.pb_more_text);
        this.aEX = this.QZ.findViewById(w.h.pb_more_view);
        this.aEX.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.QZ.findViewById(w.h.progress);
        b(this.aEW.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aEX.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.QZ;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aEW.getPageContext().getLayoutMode().t(this.aEX);
        return true;
    }

    public void hide() {
        this.aEX.setVisibility(8);
        this.QZ.setPadding(0, 0, 0, 0);
    }

    public void ml() {
        this.aEX.setVisibility(0);
        this.QZ.setPadding(0, this.padding, 0, this.padding);
    }

    public void eV(int i) {
        this.mProgressBar.setVisibility(0);
        this.aaE.setText(i);
        this.aEX.setVisibility(0);
    }

    public void eW(int i) {
        this.mProgressBar.setVisibility(8);
        this.aaE.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.QZ);
        }
    }
}
