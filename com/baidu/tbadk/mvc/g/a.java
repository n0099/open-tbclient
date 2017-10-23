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
    private TbPageContextSupport<?> aHH;
    private View aHI;
    private int padding;
    private TextView abi = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View Rh = null;

    public a(TbPageContextSupport<?> tbPageContextSupport) {
        this.aHH = null;
        this.aHH = tbPageContextSupport;
        this.padding = this.aHH.getPageContext().getResources().getDimensionPixelSize(d.f.ds16);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public View ld() {
        this.Rh = LayoutInflater.from(this.aHH.getPageContext().getPageActivity()).inflate(d.j.new_pb_list_more, (ViewGroup) null);
        this.Rh.setPadding(0, this.padding, 0, this.padding);
        this.abi = (TextView) this.Rh.findViewById(d.h.pb_more_text);
        this.aHI = this.Rh.findViewById(d.h.pb_more_view);
        this.aHI.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.Rh.findViewById(d.h.progress);
        b(this.aHH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aHI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.Rh;
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        this.aHH.getPageContext().getLayoutMode().t(this.aHI);
        return true;
    }

    public void hide() {
        this.aHI.setVisibility(8);
        this.Rh.setPadding(0, 0, 0, 0);
    }

    public void lM() {
        this.aHI.setVisibility(0);
        this.Rh.setPadding(0, this.padding, 0, this.padding);
    }

    public void fm(int i) {
        this.mProgressBar.setVisibility(0);
        this.abi.setText(i);
        this.aHI.setVisibility(0);
    }

    public void fn(int i) {
        this.mProgressBar.setVisibility(8);
        this.abi.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.Rh);
        }
    }
}
