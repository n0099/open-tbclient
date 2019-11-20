package com.baidu.tieba.ala.person.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.adp.widget.listview.BdIListPage;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class d extends BdIListPage {
    private View cKJ;
    private TbPageContext<?> mContext;
    private int padding;
    private TextView mTextView = null;
    private ProgressBar mProgressBar = null;
    private View.OnClickListener mOnClickListener = null;
    private View mRoot = null;

    public d(TbPageContext<?> tbPageContext) {
        this.mContext = null;
        this.mContext = tbPageContext;
        this.padding = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPage
    public View createView() {
        this.mRoot = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_person_loadmore_layout, (ViewGroup) null);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
        this.mTextView = (TextView) this.mRoot.findViewById(a.g.th_more_text);
        this.cKJ = this.mRoot.findViewById(a.g.th_more_view);
        this.cKJ.setVisibility(8);
        this.mProgressBar = (ProgressBar) this.mRoot.findViewById(a.g.progress);
        a(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.cKJ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return this.mRoot;
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        this.mContext.getLayoutMode().onModeChanged(this.cKJ);
        return true;
    }

    public void hide() {
        this.cKJ.setVisibility(8);
        this.mRoot.setPadding(0, 0, 0, 0);
    }

    public void le() {
        this.cKJ.setVisibility(0);
        this.mRoot.setPadding(0, this.padding, 0, this.padding);
    }

    public void kd(int i) {
        this.mProgressBar.setVisibility(0);
        this.mTextView.setText(i);
        this.cKJ.setVisibility(0);
    }

    public void oh(int i) {
        this.mProgressBar.setVisibility(8);
        this.mTextView.setText(i);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPage
    public void onClick() {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(this.mRoot);
        }
    }
}
