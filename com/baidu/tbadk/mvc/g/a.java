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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes.dex */
public class a extends b implements r {
    private TbPageContextSupport erk;
    private View erl;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private View mRoot;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport tbPageContextSupport) {
        this.erk = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.mRoot = null;
        this.erk = tbPageContextSupport;
        this.padding = this.erk.getPageContext().getResources().getDimensionPixelSize(R.dimen.ds16);
    }

    public a(TbPageContextSupport tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View createView() {
        if (this.mParentView == null) {
            this.mRoot = LayoutInflater.from(this.erk.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        } else {
            this.mRoot = LayoutInflater.from(this.erk.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, this.mParentView, false);
        }
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.mRoot.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.mRoot.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
        this.erl = this.mRoot.findViewById(R.id.pb_more_view);
        this.erl.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        b(this.erk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.erl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.erk.getPageContext().getLayoutMode().onModeChanged(this.erl);
        return true;
    }

    public void hide() {
        this.erl.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void display() {
        this.erl.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void nx(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.erl.setVisibility(0);
    }

    public void ny(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
