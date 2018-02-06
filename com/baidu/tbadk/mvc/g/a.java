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
    private View aId;
    private TbPageContextSupport<?> bzu;
    private View bzv;
    private int mHeight;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mParentView;
    private ProgressBar mProgressBar;
    private int padding;
    private TextView rz;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.bzu = null;
        this.rz = null;
        this.mProgressBar = null;
        this.mOnClickListener = null;
        this.aId = null;
        this.bzu = tbPageContextSupport;
        this.padding = this.bzu.getPageContext().getResources().getDimensionPixelSize(d.e.ds16);
    }

    public a(TbPageContextSupport<?> tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        this.mParentView = viewGroup;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View st() {
        if (this.mParentView == null) {
            this.aId = LayoutInflater.from(this.bzu.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, (ViewGroup) null);
        } else {
            this.aId = LayoutInflater.from(this.bzu.getPageContext().getPageActivity()).inflate(d.h.new_pb_list_more, this.mParentView, false);
        }
        this.aId.setPadding(0, this.padding, 0, this.padding);
        if (this.mHeight != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.aId.getLayoutParams());
            layoutParams.height = this.mHeight;
            this.aId.setLayoutParams(layoutParams);
        }
        this.rz = (TextView) this.aId.findViewById(d.g.pb_more_text);
        this.bzv = this.aId.findViewById(d.g.pb_more_view);
        this.bzv.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.aId.findViewById(d.g.progress);
        b(this.bzu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bzv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.aId;
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.bzu.getPageContext().getLayoutMode().aM(this.bzv);
        return true;
    }

    public void hide() {
        this.bzv.setVisibility(8);
        this.aId.setPadding(0, 0, 0, 0);
    }

    public void th() {
        this.bzv.setVisibility(0);
        this.aId.setPadding(0, this.padding, 0, this.padding);
    }

    public void id(int i) {
        this.mProgressBar.setVisibility(0);
        this.rz.setText(i);
        this.bzv.setVisibility(0);
    }

    public void ie(int i) {
        this.mProgressBar.setVisibility(8);
        this.rz.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.aId);
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }
}
