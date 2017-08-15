package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.d, com.baidu.tbadk.j.a> {
    private View.OnClickListener aYW;
    private TbPageContext oV;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), com.baidu.tbadk.data.d.aAw, bdUniqueId);
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public com.baidu.tbadk.j.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.j.a(LayoutInflater.from(this.oV.getPageActivity()).inflate(d.j.entrance_pic_add_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.d dVar, com.baidu.tbadk.j.a aVar) {
        if (aVar == null || dVar == null) {
            return null;
        }
        aVar.setOnClick(this.aYW);
        aVar.c(dVar);
        return aVar.getView();
    }

    public void setOnClick(View.OnClickListener onClickListener) {
        this.aYW = onClickListener;
    }
}
