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
    private View Tl;
    private TbPageContextSupport<?> aJG;
    private View aJH;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aJG = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.Tl = null;
        this.aJG = tbPageContextSupport;
        this.padding = this.aJG.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View kA() {
        if (this.mParentView == null) {
            this.Tl = LayoutInflater.from(this.aJG.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
        } else {
            this.Tl = LayoutInflater.from(this.aJG.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, this.mParentView, false);
        }
        this.Tl.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.Tl.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.Tl.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.Tl.findViewById(d.g.pb_more_text);
        this.aJH = this.Tl.findViewById(d.g.pb_more_view);
        this.aJH.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Tl.findViewById(d.g.progress);
        b(this.aJG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aJH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Tl;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aJG.getPageContext().getLayoutMode().u(this.aJH);
        return true;
    }

    public void hide() {
        this.aJH.setVisibility(8);
        this.Tl.setPadding(0, 0, 0, 0);
    }

    public void lN() {
        this.aJH.setVisibility(0);
        this.Tl.setPadding(0, this.padding, 0, this.padding);
    }

    public void fd(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aJH.setVisibility(0);
    }

    public void fe(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Tl);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
