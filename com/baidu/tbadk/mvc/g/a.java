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
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class a extends b implements o {
    private TbPageContextSupport<?> aSi;
    private View aSj;
    private View abp;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aSi = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.abp = null;
        this.aSi = tbPageContextSupport;
        this.padding = this.aSi.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View nn() {
        if (this.mParentView == null) {
            this.abp = LayoutInflater.from(this.aSi.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
        } else {
            this.abp = LayoutInflater.from(this.aSi.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, this.mParentView, false);
        }
        this.abp.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.abp.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.abp.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.abp.findViewById(d.g.pb_more_text);
        this.aSj = this.abp.findViewById(d.g.pb_more_view);
        this.aSj.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.abp.findViewById(d.g.progress);
        b(this.aSi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aSj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.abp;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aSi.getPageContext().getLayoutMode().onModeChanged(this.aSj);
        return true;
    }

    public void hide() {
        this.aSj.setVisibility(8);
        this.abp.setPadding(0, 0, 0, 0);
    }

    public void oD() {
        this.aSj.setVisibility(0);
        this.abp.setPadding(0, this.padding, 0, this.padding);
    }

    public void fh(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aSj.setVisibility(0);
    }

    public void fi(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.abp);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
