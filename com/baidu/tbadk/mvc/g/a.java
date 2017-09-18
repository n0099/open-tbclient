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
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes.dex */
public class a extends b implements l {
    private TbPageContextSupport<?> aIt;
    private View aIu;
    private int padding;
    private TextView abu = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rh = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aIt = null;
        this.aIt = tbPageContextSupport;
        this.padding = this.aIt.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View lb() {
        this.Rh = LayoutInflater.from(this.aIt.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.Rh.setPadding(0, this.padding, 0, this.padding);
        this.abu = (TextView) this.Rh.findViewById(d.h.pb_more_text);
        this.aIu = this.Rh.findViewById(d.h.pb_more_view);
        this.aIu.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Rh.findViewById(d.h.progress);
        b(this.aIt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Rh;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aIt.getPageContext().getLayoutMode().t(this.aIu);
        return true;
    }

    public void hide() {
        this.aIu.setVisibility(8);
        this.Rh.setPadding(0, 0, 0, 0);
    }

    public void lK() {
        this.aIu.setVisibility(0);
        this.Rh.setPadding(0, this.padding, 0, this.padding);
    }

    public void fc(int i) {
        this.mProgressBar.setVisibility(0);
        this.abu.setText(i);
        this.aIu.setVisibility(0);
    }

    public void fd(int i) {
        this.mProgressBar.setVisibility(8);
        this.abu.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rh);
        }
    }
}
