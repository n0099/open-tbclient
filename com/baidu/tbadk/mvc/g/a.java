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
    private View btY;
    private TbPageContextSupport<?> cpE;
    private View cpF;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.cpE = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.btY = null;
        this.cpE = tbPageContextSupport;
        this.padding = this.cpE.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oM() {
        if (this.mParentView == null) {
            this.btY = LayoutInflater.from(this.cpE.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.btY = LayoutInflater.from(this.cpE.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, this.mParentView, false);
        }
        this.btY.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.btY.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.btY.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.btY.findViewById(d.g.pb_more_text);
        this.cpF = this.btY.findViewById(d.g.pb_more_view);
        this.cpF.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.btY.findViewById(d.g.progress);
        b(this.cpE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cpF.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.btY;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.cpE.getPageContext().getLayoutMode().onModeChanged(this.cpF);
        return true;
    }

    public void hide() {
        this.cpF.setVisibility(8);
        this.btY.setPadding(0, 0, 0, 0);
    }

    public void qT() {
        this.cpF.setVisibility(0);
        this.btY.setPadding(0, this.padding, 0, this.padding);
    }

    public void jU(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.cpF.setVisibility(0);
    }

    public void jV(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.btY);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
