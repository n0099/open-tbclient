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
    private View buc;
    private TbPageContextSupport<?> cpH;
    private View cpI;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.cpH = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.buc = null;
        this.cpH = tbPageContextSupport;
        this.padding = this.cpH.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View oM() {
        if (this.mParentView == null) {
            this.buc = LayoutInflater.from(this.cpH.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.buc = LayoutInflater.from(this.cpH.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, this.mParentView, false);
        }
        this.buc.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.buc.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.buc.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.buc.findViewById(d.g.pb_more_text);
        this.cpI = this.buc.findViewById(d.g.pb_more_view);
        this.cpI.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.buc.findViewById(d.g.progress);
        b(this.cpH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cpI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.buc;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.cpH.getPageContext().getLayoutMode().onModeChanged(this.cpI);
        return true;
    }

    public void hide() {
        this.cpI.setVisibility(8);
        this.buc.setPadding(0, 0, 0, 0);
    }

    public void qT() {
        this.cpI.setVisibility(0);
        this.buc.setPadding(0, this.padding, 0, this.padding);
    }

    public void jT(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.cpI.setVisibility(0);
    }

    public void jU(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.buc);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
