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
    private TbPageContextSupport<?> aWt;
    private View aWu;
    private View adA;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aWt = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.adA = null;
        this.aWt = tbPageContextSupport;
        this.padding = this.aWt.getPageContext().getResources().getDimensionPixelSize(e.C0141e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View ov() {
        if (this.mParentView == null) {
            this.adA = LayoutInflater.from(this.aWt.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.adA = LayoutInflater.from(this.aWt.getPageContext().getPageActivity()).inflate(e.h.new_pb_list_more, this.mParentView, false);
        }
        this.adA.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.adA.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.adA.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.adA.findViewById(e.g.pb_more_text);
        this.aWu = this.adA.findViewById(e.g.pb_more_view);
        this.aWu.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.adA.findViewById(e.g.progress);
        b(this.aWt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aWu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.adA;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aWt.getPageContext().getLayoutMode().onModeChanged(this.aWu);
        return true;
    }

    public void hide() {
        this.aWu.setVisibility(8);
        this.adA.setPadding(0, 0, 0, 0);
    }

    public void pI() {
        this.aWu.setVisibility(0);
        this.adA.setPadding(0, this.padding, 0, this.padding);
    }

    public void fu(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aWu.setVisibility(0);
    }

    public void fv(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.adA);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
