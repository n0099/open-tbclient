package com.baidu.tbadk.mvc.k;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends e implements ab {
    private com.baidu.tbadk.mvc.core.e<?, ?, ?> aoc;
    private View aod;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public b(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        this.aoc = null;
        this.aoc = eVar;
        this.padding = this.aoc.getResources().getDimensionPixelSize(t.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View mN() {
        this.mRoot = com.baidu.adp.lib.g.b.hH().inflate(this.aoc.getPageContext().getPageActivity(), w.new_pb_list_more, null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(v.pb_more_text);
        this.aod = this.mRoot.findViewById(v.pb_more_view);
        this.aod.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(v.progress);
        a(this.aoc.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.aod.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.aoc.getLayoutMode().h(this.aod);
        return true;
    }

    public void hide() {
        this.aod.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void Cf() {
        this.aod.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void dW(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.aod.setVisibility(0);
    }

    public void dX(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void dV(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
