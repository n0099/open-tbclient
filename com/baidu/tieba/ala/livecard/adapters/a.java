package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes6.dex */
public class a extends k<com.baidu.tieba.tbadkCore.g, com.baidu.tieba.ala.livecard.a.b> implements z {
    private com.baidu.tieba.ala.livecard.b.a hbo;
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
        this.hbo = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.hbo.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.hbo);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.g gVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (com.baidu.tieba.tbadkCore.g) bVar);
        if (gVar != null) {
            int topThreadSize = this.iSt != null ? this.iSt.getTopThreadSize() : 0;
            if (gVar.njx != null && gVar.njx.get(0) != null) {
                gVar.njx.get(0).eHa = (i + 1) - topThreadSize;
            }
            bVar.hbH.setForumName(this.mForumName);
            bVar.hbH.a(gVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
    }
}
