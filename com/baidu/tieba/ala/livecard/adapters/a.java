package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.g, com.baidu.tieba.ala.livecard.a.b> implements y {
    private com.baidu.tieba.ala.livecard.b.a fFR;
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
        this.fFR = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.fFR.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.fFR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.g gVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (com.baidu.tieba.tbadkCore.g) bVar);
        if (gVar != null) {
            int topThreadSize = this.hmG != null ? this.hmG.getTopThreadSize() : 0;
            if (gVar.liy != null && gVar.liy.get(0) != null) {
                gVar.liy.get(0).dDb = (i + 1) - topThreadSize;
            }
            bVar.fGk.setForumName(this.mForumName);
            bVar.fGk.a(gVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }
}
