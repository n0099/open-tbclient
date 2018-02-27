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
    private View aHS;
    private TbPageContextSupport<?> bzh;
    private View bzi;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private int padding;
    private TextView ry;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bzh = null;
        this.ry = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.aHS = null;
        this.bzh = tbPageContextSupport;
        this.padding = this.bzh.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View st() {
        if (this.mParentView == null) {
            this.aHS = LayoutInflater.from(this.bzh.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.aHS = LayoutInflater.from(this.bzh.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, this.mParentView, false);
        }
        this.aHS.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.aHS.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.aHS.setLayoutParams(layoutParams);
        }
        this.ry = (TextView) this.aHS.findViewById(d.g.pb_more_text);
        this.bzi = this.aHS.findViewById(d.g.pb_more_view);
        this.bzi.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aHS.findViewById(d.g.progress);
        b(this.bzh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bzi.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aHS;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bzh.getPageContext().getLayoutMode().aM(this.bzi);
        return true;
    }

    public void hide() {
        this.bzi.setVisibility(8);
        this.aHS.setPadding(0, 0, 0, 0);
    }

    public void th() {
        this.bzi.setVisibility(0);
        this.aHS.setPadding(0, this.padding, 0, this.padding);
    }

    public void id(int i) {
        this.mProgressBar.setVisibility(0);
        this.ry.setText(i);
        this.bzi.setVisibility(0);
    }

    public void ie(int i) {
        this.mProgressBar.setVisibility(8);
        this.ry.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aHS);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
