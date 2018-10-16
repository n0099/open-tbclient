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
    private View aix;
    private TbPageContextSupport<?> baT;
    private View baU;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.baT = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.aix = null;
        this.baT = tbPageContextSupport;
        this.padding = this.baT.getPageContext().getResources().getDimensionPixelSize(e.C0175e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oG() {
        if (this.mParentView == null) {
            this.aix = LayoutInflater.from(this.baT.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.aix = LayoutInflater.from(this.baT.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, this.mParentView, false);
        }
        this.aix.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.aix.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.aix.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.aix.findViewById(e.g.pb_more_text);
        this.baU = this.aix.findViewById(e.g.pb_more_view);
        this.baU.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aix.findViewById(e.g.progress);
        b(this.baT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.baU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aix;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.baT.getPageContext().getLayoutMode().onModeChanged(this.baU);
        return true;
    }

    public void hide() {
        this.baU.setVisibility(8);
        this.aix.setPadding(0, 0, 0, 0);
    }

    public void pQ() {
        this.baU.setVisibility(0);
        this.aix.setPadding(0, this.padding, 0, this.padding);
    }

    public void fD(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.baU.setVisibility(0);
    }

    public void fE(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aix);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
