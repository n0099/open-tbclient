package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<x, y> {
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), x.Wk);
        this.mSkinType = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public y b(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new y(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, x xVar, y yVar) {
        yVar.mTextView.setText(xVar.showText);
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            an.setImageResource(yVar.mImageView, xVar.resId);
            an.setViewTextColor(yVar.mTextView, (int) R.color.cp_cont_d);
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
