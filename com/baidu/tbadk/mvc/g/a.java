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
import com.baidu.tieba.tbadkCore.p;
/* loaded from: classes.dex */
public class a extends b implements p {
    private View aHT;
    private TbPageContextSupport<?> bzk;
    private View bzl;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private int padding;
    private TextView ry;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bzk = null;
        this.ry = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.aHT = null;
        this.bzk = tbPageContextSupport;
        this.padding = this.bzk.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View st() {
        if (this.mParentView == null) {
            this.aHT = LayoutInflater.from(this.bzk.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.aHT = LayoutInflater.from(this.bzk.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, this.mParentView, false);
        }
        this.aHT.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.aHT.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.aHT.setLayoutParams(layoutParams);
        }
        this.ry = (TextView) this.aHT.findViewById(d.g.pb_more_text);
        this.bzl = this.aHT.findViewById(d.g.pb_more_view);
        this.bzl.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aHT.findViewById(d.g.progress);
        b(this.bzk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bzl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aHT;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bzk.getPageContext().getLayoutMode().aM(this.bzl);
        return true;
    }

    public void hide() {
        this.bzl.setVisibility(8);
        this.aHT.setPadding(0, 0, 0, 0);
    }

    public void th() {
        this.bzl.setVisibility(0);
        this.aHT.setPadding(0, this.padding, 0, this.padding);
    }

    public void id(int i) {
        this.mProgressBar.setVisibility(0);
        this.ry.setText(i);
        this.bzl.setVisibility(0);
    }

    public void ie(int i) {
        this.mProgressBar.setVisibility(8);
        this.ry.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aHT);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
