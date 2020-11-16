package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class a extends k<com.baidu.tieba.tbadkCore.g, com.baidu.tieba.ala.livecard.a.b> implements z {
    private com.baidu.tieba.ala.livecard.b.a gSb;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumName = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public com.baidu.tieba.ala.livecard.a.b c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.gSb = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.gSb.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.gSb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.g gVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (com.baidu.tieba.tbadkCore.g) bVar);
        if (gVar != null) {
            int topThreadSize = this.iHB != null ? this.iHB.getTopThreadSize() : 0;
            if (gVar.mVz != null && gVar.mVz.get(0) != null) {
                gVar.mVz.get(0).eAb = (i + 1) - topThreadSize;
            }
            bVar.gSu.setForumName(this.mForumName);
            bVar.gSu.a(gVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
    }
}
