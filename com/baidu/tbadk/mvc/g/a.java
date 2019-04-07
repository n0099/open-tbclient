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
    private View bub;
    private TbPageContextSupport<?> cpG;
    private View cpH;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.cpG = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.bub = null;
        this.cpG = tbPageContextSupport;
        this.padding = this.cpG.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oM() {
        if (this.mParentView == null) {
            this.bub = LayoutInflater.from(this.cpG.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.bub = LayoutInflater.from(this.cpG.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, this.mParentView, false);
        }
        this.bub.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.bub.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.bub.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.bub.findViewById(d.g.pb_more_text);
        this.cpH = this.bub.findViewById(d.g.pb_more_view);
        this.cpH.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.bub.findViewById(d.g.progress);
        b(this.cpG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cpH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.bub;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.cpG.getPageContext().getLayoutMode().onModeChanged(this.cpH);
        return true;
    }

    public void hide() {
        this.cpH.setVisibility(8);
        this.bub.setPadding(0, 0, 0, 0);
    }

    public void qT() {
        this.cpH.setVisibility(0);
        this.bub.setPadding(0, this.padding, 0, this.padding);
    }

    public void jT(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.cpH.setVisibility(0);
    }

    public void jU(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.bub);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
