package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class i extends com.baidu.adp.widget.ListView.a<z, aa> {
    private int mSkinType;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), z.Xs);
        this.mSkinType = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public aa c(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new aa(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, z zVar, aa aaVar) {
        aaVar.mTextView.setText(zVar.showText);
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setImageResource(aaVar.mImageView, zVar.resId);
            ap.setViewTextColor(aaVar.mTextView, R.color.cp_cont_d);
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
