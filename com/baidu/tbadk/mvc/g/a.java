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
    private TbPageContextSupport<?> aGt;
    private View aGu;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Qr = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aGt = null;
        this.aGt = tbPageContextSupport;
        this.padding = this.aGt.getPageContext().getResources().getDimensionPixelSize(w.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View lc() {
        this.Qr = LayoutInflater.from(this.aGt.getPageContext().getPageActivity()).inflate(w.j.new_pb_list_more, (ViewGroup) null);
        this.Qr.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.Qr.findViewById(w.h.pb_more_text);
        this.aGu = this.Qr.findViewById(w.h.pb_more_view);
        this.aGu.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Qr.findViewById(w.h.progress);
        b(this.aGt.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aGu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Qr;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aGt.getPageContext().getLayoutMode().t(this.aGu);
        return true;
    }

    public void hide() {
        this.aGu.setVisibility(8);
        this.Qr.setPadding(0, 0, 0, 0);
    }

    public void lM() {
        this.aGu.setVisibility(0);
        this.Qr.setPadding(0, this.padding, 0, this.padding);
    }

    public void eX(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aGu.setVisibility(0);
    }

    public void eY(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Qr);
        }
    }
}
