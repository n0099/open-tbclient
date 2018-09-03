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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class a extends b implements o {
    private TbPageContextSupport<?> aTe;
    private View aTf;
    private View aaW;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aTe = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.aaW = null;
        this.aTe = tbPageContextSupport;
        this.padding = this.aTe.getPageContext().getResources().getDimensionPixelSize(f.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View np() {
        if (this.mParentView == null) {
            this.aaW = LayoutInflater.from(this.aTe.getPageContext().getPageActivity()).inflate(f.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.aaW = LayoutInflater.from(this.aTe.getPageContext().getPageActivity()).inflate(f.h.new_pb_list_more, this.mParentView, false);
        }
        this.aaW.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.aaW.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.aaW.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.aaW.findViewById(f.g.pb_more_text);
        this.aTf = this.aaW.findViewById(f.g.pb_more_view);
        this.aTf.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aaW.findViewById(f.g.progress);
        b(this.aTe.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aTf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aaW;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aTe.getPageContext().getLayoutMode().onModeChanged(this.aTf);
        return true;
    }

    public void hide() {
        this.aTf.setVisibility(8);
        this.aaW.setPadding(0, 0, 0, 0);
    }

    public void oC() {
        this.aTf.setVisibility(0);
        this.aaW.setPadding(0, this.padding, 0, this.padding);
    }

    public void fi(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aTf.setVisibility(0);
    }

    public void fj(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aaW);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
