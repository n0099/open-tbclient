package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.g, com.baidu.tieba.ala.livecard.a.b> implements y {
    private com.baidu.tieba.ala.livecard.b.a fGc;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumName = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public com.baidu.tieba.ala.livecard.a.b b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fGc = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.fGc.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.fGc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.g gVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (com.baidu.tieba.tbadkCore.g) bVar);
        if (gVar != null) {
            int topThreadSize = this.hmR != null ? this.hmR.getTopThreadSize() : 0;
            if (gVar.ljH != null && gVar.ljH.get(0) != null) {
                gVar.ljH.get(0).dDb = (i + 1) - topThreadSize;
            }
            bVar.fGv.setForumName(this.mForumName);
            bVar.fGv.a(gVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
    }
}
