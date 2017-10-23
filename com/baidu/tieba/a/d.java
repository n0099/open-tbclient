package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends e<com.baidu.tbadk.data.d, com.baidu.tbadk.i.b> {
    private View.OnClickListener aOR;
    private com.baidu.tbadk.i.b bah;
    private TbPageContext mH;
    private BdUniqueId mId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public com.baidu.tbadk.i.b onCreateViewHolder(ViewGroup viewGroup) {
        this.bah = new com.baidu.tbadk.i.b(LayoutInflater.from(this.mContext).inflate(d.j.entrance_story_pics_layout, viewGroup, false), this.mH);
        if (this.mId != null && this.bah.aEA != null) {
            this.bah.aEA.i(this.mId);
            this.bah.aEA.setItemOnclickListener(this.aOR);
        }
        return this.bah;
    }

    public void j(BdUniqueId bdUniqueId) {
        this.mId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.d dVar, com.baidu.tbadk.i.b bVar) {
        if (dVar != null && bVar != null) {
            bVar.DQ();
            bVar.a(dVar);
        }
        return view;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.aOR = onClickListener;
    }
}
