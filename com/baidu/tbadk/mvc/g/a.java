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
    private View Th;
    private TbPageContextSupport<?> aJH;
    private View aJI;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private int padding;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aJH = null;
        this.mTextView = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.Th = null;
        this.aJH = tbPageContextSupport;
        this.padding = this.aJH.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View kz() {
        if (this.mParentView == null) {
            this.Th = LayoutInflater.from(this.aJH.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, (ViewGroup) null);
        } else {
            this.Th = LayoutInflater.from(this.aJH.getPageContext().getPageActivity()).inflate(d.i.new_pb_list_more, this.mParentView, false);
        }
        this.Th.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.Th.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.Th.setLayoutParams(layoutParams);
        }
        this.mTextView = (TextView) this.Th.findViewById(d.g.pb_more_text);
        this.aJI = this.Th.findViewById(d.g.pb_more_view);
        this.aJI.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Th.findViewById(d.g.progress);
        b(this.aJH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aJI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Th;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aJH.getPageContext().getLayoutMode().u(this.aJI);
        return true;
    }

    public void hide() {
        this.aJI.setVisibility(8);
        this.Th.setPadding(0, 0, 0, 0);
    }

    public void lM() {
        this.aJI.setVisibility(0);
        this.Th.setPadding(0, this.padding, 0, this.padding);
    }

    public void fd(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aJI.setVisibility(0);
    }

    public void fe(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Th);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
