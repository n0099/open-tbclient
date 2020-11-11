package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class a extends k<com.baidu.tieba.tbadkCore.g, com.baidu.tieba.ala.livecard.a.b> implements z {
    private com.baidu.tieba.ala.livecard.b.a gSu;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumName = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public com.baidu.tieba.ala.livecard.a.b c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.gSu = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.gSu.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.gSu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.g gVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (com.baidu.tieba.tbadkCore.g) bVar);
        if (gVar != null) {
            int topThreadSize = this.iGN != null ? this.iGN.getTopThreadSize() : 0;
            if (gVar.mUG != null && gVar.mUG.get(0) != null) {
                gVar.mUG.get(0).eBK = (i + 1) - topThreadSize;
            }
            bVar.gSN.setForumName(this.mForumName);
            bVar.gSN.a(gVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
    }
}
