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
    private TbPageContextSupport<?> bfg;
    private View bfh;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bfg = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.amM = null;
        this.bfg = tbPageContextSupport;
        this.padding = this.bfg.getPageContext().getResources().getDimensionPixelSize(e.C0210e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oD() {
        if (this.mParentView == null) {
            this.amM = LayoutInflater.from(this.bfg.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.amM = LayoutInflater.from(this.bfg.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, this.mParentView, false);
        }
        this.amM.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.amM.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.amM.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.amM.findViewById(e.g.pb_more_text);
        this.bfh = this.amM.findViewById(e.g.pb_more_view);
        this.bfh.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.amM.findViewById(e.g.progress);
        b(this.bfg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bfh.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.amM;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bfg.getPageContext().getLayoutMode().onModeChanged(this.bfh);
        return true;
    }

    public void hide() {
        this.bfh.setVisibility(8);
        this.amM.setPadding(0, 0, 0, 0);
    }

    public void pN() {
        this.bfh.setVisibility(0);
        this.amM.setPadding(0, this.padding, 0, this.padding);
    }

    public void gf(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.bfh.setVisibility(0);
    }

    public void gg(int i) {
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
