package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends e<com.baidu.tbadk.data.d, com.baidu.tbadk.i.b> {
    private View.OnClickListener aPe;
    private com.baidu.tbadk.i.b bav;
    private TbPageContext mG;
    private BdUniqueId mId;

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public com.baidu.tbadk.i.b onCreateViewHolder(ViewGroup viewGroup) {
        this.bav = new com.baidu.tbadk.i.b(LayoutInflater.from(this.mContext).inflate(d.j.entrance_story_pics_layout, viewGroup, false), this.mG);
        if (this.mId != null && this.bav.aEN != null) {
            this.bav.aEN.i(this.mId);
            this.bav.aEN.setItemOnclickListener(this.aPe);
        }
        return this.bav;
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
            bVar.DW();
            bVar.a(dVar);
        }
        return view;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.aPe = onClickListener;
    }
}
