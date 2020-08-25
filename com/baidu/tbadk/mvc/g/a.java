package com.baidu.tbadk.mvc.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.c;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class a extends c implements s {
    private TbPageContextSupport eQY;
    private View eQZ;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private View mRoot;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport tbPageContextSupport) {
        this.eQY = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.mRoot = null;
        this.eQY = tbPageContextSupport;
        this.padding = this.eQY.getPageContext().getResources().getDimensionPixelSize(R.dimen.ds16);
    }

    public a(TbPageContextSupport tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View createView() {
        if (this.mParentView == null) {
            this.mRoot = LayoutInflater.from(this.eQY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        } else {
            this.mRoot = LayoutInflater.from(this.eQY.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, this.mParentView, false);
        }
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.mRoot.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.mRoot.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
        this.eQZ = this.mRoot.findViewById(R.id.pb_more_view);
        this.eQZ.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        b(this.eQY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.eQZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.eQY.getPageContext().getLayoutMode().onModeChanged(this.eQZ);
        return true;
    }

    public void hide() {
        this.eQZ.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void display() {
        this.eQZ.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void qx(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.eQZ.setVisibility(0);
    }

    public void qy(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
