package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends g<com.baidu.tbadk.data.f, com.baidu.tbadk.i.d> {
    private com.baidu.tbadk.i.d beh;
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
    public com.baidu.tbadk.i.d onCreateViewHolder(ViewGroup viewGroup) {
        this.beh = new com.baidu.tbadk.i.d(LayoutInflater.from(this.mContext).inflate(d.h.entrance_story_pics_layout, viewGroup, false), this.mPageContext);
        if (this.mId != null && this.beh.aFT != null) {
            this.beh.aFT.i(this.mId);
            this.beh.aFT.setItemOnclickListener(this.mClickListener);
        }
        return this.beh;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.f fVar, com.baidu.tbadk.i.d dVar) {
        if (fVar != null && dVar != null) {
            dVar.Ex();
            dVar.a(fVar);
        }
        return view;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
