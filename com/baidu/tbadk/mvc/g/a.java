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
    private View ano;
    private TbPageContextSupport<?> bfT;
    private View bfU;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bfT = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.ano = null;
        this.bfT = tbPageContextSupport;
        this.padding = this.bfT.getPageContext().getResources().getDimensionPixelSize(e.C0210e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oH() {
        if (this.mParentView == null) {
            this.ano = LayoutInflater.from(this.bfT.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.ano = LayoutInflater.from(this.bfT.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, this.mParentView, false);
        }
        this.ano.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.ano.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.ano.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.ano.findViewById(e.g.pb_more_text);
        this.bfU = this.ano.findViewById(e.g.pb_more_view);
        this.bfU.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.ano.findViewById(e.g.progress);
        b(this.bfT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bfU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.ano;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bfT.getPageContext().getLayoutMode().onModeChanged(this.bfU);
        return true;
    }

    public void hide() {
        this.bfU.setVisibility(8);
        this.ano.setPadding(0, 0, 0, 0);
    }

    public void pR() {
        this.bfU.setVisibility(0);
        this.ano.setPadding(0, this.padding, 0, this.padding);
    }

    public void gg(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.bfU.setVisibility(0);
    }

    public void gh(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.ano);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
