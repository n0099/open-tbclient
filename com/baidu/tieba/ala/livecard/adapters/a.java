package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.x;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.g, com.baidu.tieba.ala.livecard.a.b> implements x {
    private com.baidu.tieba.ala.livecard.b.a eNA;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumName = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.ala.livecard.a.b b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.eNA = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.eNA.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.eNA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.g gVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (com.baidu.tieba.tbadkCore.g) bVar);
        if (gVar != null) {
            int topThreadSize = this.goJ != null ? this.goJ.getTopThreadSize() : 0;
            if (gVar.kfZ != null && gVar.kfZ.get(0) != null) {
                gVar.kfZ.get(0).cPT = (i + 1) - topThreadSize;
            }
            bVar.eNT.setForumName(this.mForumName);
            bVar.eNT.a(gVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
    }
}
