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
    private View amM;
    private TbPageContextSupport<?> bfj;
    private View bfk;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bfj = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.amM = null;
        this.bfj = tbPageContextSupport;
        this.padding = this.bfj.getPageContext().getResources().getDimensionPixelSize(e.C0210e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oD() {
        if (this.mParentView == null) {
            this.amM = LayoutInflater.from(this.bfj.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.amM = LayoutInflater.from(this.bfj.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, this.mParentView, false);
        }
        this.amM.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.amM.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.amM.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.amM.findViewById(e.g.pb_more_text);
        this.bfk = this.amM.findViewById(e.g.pb_more_view);
        this.bfk.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.amM.findViewById(e.g.progress);
        b(this.bfj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bfk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.amM;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bfj.getPageContext().getLayoutMode().onModeChanged(this.bfk);
        return true;
    }

    public void hide() {
        this.bfk.setVisibility(8);
        this.amM.setPadding(0, 0, 0, 0);
    }

    public void pN() {
        this.bfk.setVisibility(0);
        this.amM.setPadding(0, this.padding, 0, this.padding);
    }

    public void gg(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.bfk.setVisibility(0);
    }

    public void gh(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.amM);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
