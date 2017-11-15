package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends g<com.baidu.tbadk.data.f, com.baidu.tbadk.j.d> {
    private com.baidu.tbadk.j.d baX;
    private View.OnClickListener mClickListener;
    private BdUniqueId mId;
    private TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tbadk.j.d onCreateViewHolder(ViewGroup viewGroup) {
        this.baX = new com.baidu.tbadk.j.d(LayoutInflater.from(this.mContext).inflate(d.h.entrance_story_pics_layout, viewGroup, false), this.mPageContext);
        if (this.mId != null && this.baX.aFs != null) {
            this.baX.aFs.i(this.mId);
            this.baX.aFs.setItemOnclickListener(this.mClickListener);
        }
        return this.baX;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.f fVar, com.baidu.tbadk.j.d dVar) {
        if (fVar != null && dVar != null) {
            dVar.Eq();
            dVar.a(fVar);
        }
        return view;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
