package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends e<com.baidu.tbadk.data.e, com.baidu.tbadk.j.b> {
    private View.OnClickListener aYK;
    private com.baidu.tbadk.j.b aYL;
    private TbPageContext mF;
    private BdUniqueId mId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public com.baidu.tbadk.j.b onCreateViewHolder(ViewGroup viewGroup) {
        this.aYL = new com.baidu.tbadk.j.b(LayoutInflater.from(this.mContext).inflate(d.j.entrance_story_pics_layout, viewGroup, false), this.mF);
        if (this.mId != null && this.aYL.aFx != null) {
            this.aYL.aFx.j(this.mId);
            this.aYL.aFx.setItemOnclickListener(this.aYK);
        }
        return this.aYL;
    }

    public void k(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.e eVar, com.baidu.tbadk.j.b bVar) {
        if (eVar != null && bVar != null) {
            bVar.Es();
            bVar.a(eVar);
        }
        return view;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.aYK = onClickListener;
    }
}
