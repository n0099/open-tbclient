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
    private TbPageContextSupport<?> aIS;
    private View aIT;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Sg = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aIS = null;
        this.aIS = tbPageContextSupport;
        this.padding = this.aIS.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lj() {
        this.Sg = LayoutInflater.from(this.aIS.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.Sg.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.Sg.findViewById(d.h.pb_more_text);
        this.aIT = this.Sg.findViewById(d.h.pb_more_view);
        this.aIT.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Sg.findViewById(d.h.progress);
        b(this.aIS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Sg;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aIS.getPageContext().getLayoutMode().t(this.aIT);
        return true;
    }

    public void hide() {
        this.aIT.setVisibility(8);
        this.Sg.setPadding(0, 0, 0, 0);
    }

    public void lS() {
        this.aIT.setVisibility(0);
        this.Sg.setPadding(0, this.padding, 0, this.padding);
    }

    public void fc(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aIT.setVisibility(0);
    }

    public void fd(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Sg);
        }
    }
}
