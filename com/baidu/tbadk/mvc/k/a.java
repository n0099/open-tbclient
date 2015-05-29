package com.baidu.tbadk.mvc.k;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.ab;
/* loaded from: classes.dex */
public class a extends e implements ab {
    private com.baidu.tbadk.mvc.core.e<?, ?, ?> apf;
    private View apg;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        this.apf = null;
        this.apf = eVar;
        this.padding = this.apf.getResources().getDimensionPixelSize(o.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View ng() {
        this.mRoot = com.baidu.adp.lib.g.b.hr().inflate(this.apf.getPageContext().getPageActivity(), r.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(q.pb_more_text);
        this.apg = this.mRoot.findViewById(q.pb_more_view);
        this.apg.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(q.progress);
        a(this.apf.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.apg.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.apf.getLayoutMode().j(this.apg);
        return true;
    }

    public void hide() {
        this.apg.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void CQ() {
        this.apg.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void ed(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.apg.setVisibility(0);
    }

    public void ee(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void ef(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
