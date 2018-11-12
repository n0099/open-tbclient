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
    private View ajk;
    private TbPageContextSupport<?> bbG;
    private View bbH;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bbG = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.ajk = null;
        this.bbG = tbPageContextSupport;
        this.padding = this.bbG.getPageContext().getResources().getDimensionPixelSize(e.C0200e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oE() {
        if (this.mParentView == null) {
            this.ajk = LayoutInflater.from(this.bbG.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.ajk = LayoutInflater.from(this.bbG.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, this.mParentView, false);
        }
        this.ajk.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.ajk.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.ajk.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.ajk.findViewById(e.g.pb_more_text);
        this.bbH = this.ajk.findViewById(e.g.pb_more_view);
        this.bbH.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.ajk.findViewById(e.g.progress);
        b(this.bbG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bbH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.ajk;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bbG.getPageContext().getLayoutMode().onModeChanged(this.bbH);
        return true;
    }

    public void hide() {
        this.bbH.setVisibility(8);
        this.ajk.setPadding(0, 0, 0, 0);
    }

    public void pO() {
        this.bbH.setVisibility(0);
        this.ajk.setPadding(0, this.padding, 0, this.padding);
    }

    public void fR(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.bbH.setVisibility(0);
    }

    public void fS(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.ajk);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
