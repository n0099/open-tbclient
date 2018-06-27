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
    private TbPageContextSupport<?> aTe;
    private View aTf;
    private View abt;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aTe = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.abt = null;
        this.aTe = tbPageContextSupport;
        this.padding = this.aTe.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View nn() {
        if (this.mParentView == null) {
            this.abt = LayoutInflater.from(this.aTe.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
        } else {
            this.abt = LayoutInflater.from(this.aTe.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, this.mParentView, false);
        }
        this.abt.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.abt.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.abt.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.abt.findViewById(d.g.pb_more_text);
        this.aTf = this.abt.findViewById(d.g.pb_more_view);
        this.aTf.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.abt.findViewById(d.g.progress);
        b(this.aTe.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aTf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.abt;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aTe.getPageContext().getLayoutMode().onModeChanged(this.aTf);
        return true;
    }

    public void hide() {
        this.aTf.setVisibility(8);
        this.abt.setPadding(0, 0, 0, 0);
    }

    public void oD() {
        this.aTf.setVisibility(0);
        this.abt.setPadding(0, this.padding, 0, this.padding);
    }

    public void fi(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aTf.setVisibility(0);
    }

    public void fj(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.abt);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
