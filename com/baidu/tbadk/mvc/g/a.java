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
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class a extends b implements o {
    private View bBg;
    private TbPageContextSupport<?> cxO;
    private View cxP;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.cxO = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.bBg = null;
        this.cxO = tbPageContextSupport;
        this.padding = this.cxO.getPageContext().getResources().getDimensionPixelSize(R.dimen.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View nG() {
        if (this.mParentView == null) {
            this.bBg = LayoutInflater.from(this.cxO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        } else {
            this.bBg = LayoutInflater.from(this.cxO.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, this.mParentView, false);
        }
        this.bBg.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.bBg.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.bBg.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.bBg.findViewById(R.id.pb_more_text);
        this.cxP = this.bBg.findViewById(R.id.pb_more_view);
        this.cxP.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.bBg.findViewById(R.id.progress);
        b(this.cxO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cxP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.bBg;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.cxO.getPageContext().getLayoutMode().onModeChanged(this.cxP);
        return true;
    }

    public void hide() {
        this.cxP.setVisibility(8);
        this.bBg.setPadding(0, 0, 0, 0);
    }

    public void pO() {
        this.cxP.setVisibility(0);
        this.bBg.setPadding(0, this.padding, 0, this.padding);
    }

    public void kH(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.cxP.setVisibility(0);
    }

    public void kI(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.bBg);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
