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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class a extends b implements o {
    private View anp;
    private TbPageContextSupport<?> bfU;
    private View bfV;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bfU = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.anp = null;
        this.bfU = tbPageContextSupport;
        this.padding = this.bfU.getPageContext().getResources().getDimensionPixelSize(e.C0210e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oH() {
        if (this.mParentView == null) {
            this.anp = LayoutInflater.from(this.bfU.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.anp = LayoutInflater.from(this.bfU.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, this.mParentView, false);
        }
        this.anp.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.anp.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.anp.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.anp.findViewById(e.g.pb_more_text);
        this.bfV = this.anp.findViewById(e.g.pb_more_view);
        this.bfV.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.anp.findViewById(e.g.progress);
        b(this.bfU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bfV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.anp;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bfU.getPageContext().getLayoutMode().onModeChanged(this.bfV);
        return true;
    }

    public void hide() {
        this.bfV.setVisibility(8);
        this.anp.setPadding(0, 0, 0, 0);
    }

    public void pR() {
        this.bfV.setVisibility(0);
        this.anp.setPadding(0, this.padding, 0, this.padding);
    }

    public void gg(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.bfV.setVisibility(0);
    }

    public void gh(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.anp);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
