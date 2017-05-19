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
    private TbPageContextSupport<?> aFs;
    private View aFt;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View QK = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aFs = null;
        this.aFs = tbPageContextSupport;
        this.padding = this.aFs.getPageContext().getResources().getDimensionPixelSize(w.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View le() {
        this.QK = LayoutInflater.from(this.aFs.getPageContext().getPageActivity()).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.QK.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.QK.findViewById(w.h.pb_more_text);
        this.aFt = this.QK.findViewById(w.h.pb_more_view);
        this.aFt.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.QK.findViewById(w.h.progress);
        b(this.aFs.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aFt.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.QK;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aFs.getPageContext().getLayoutMode().t(this.aFt);
        return true;
    }

    public void hide() {
        this.aFt.setVisibility(8);
        this.QK.setPadding(0, 0, 0, 0);
    }

    public void lW() {
        this.aFt.setVisibility(0);
        this.QK.setPadding(0, this.padding, 0, this.padding);
    }

    public void eU(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aFt.setVisibility(0);
    }

    public void eV(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.QK);
        }
    }
}
