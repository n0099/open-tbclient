package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.h;
/* loaded from: classes2.dex */
public class a extends h<com.baidu.tieba.tbadkCore.f, com.baidu.tieba.ala.livecard.a.b> implements x {
    private com.baidu.tieba.ala.livecard.b.a eIW;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumName = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.ala.livecard.a.b b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.eIW = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.eIW.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.eIW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.f fVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) fVar, (com.baidu.tieba.tbadkCore.f) bVar);
        if (fVar != null) {
            int topThreadSize = this.glJ != null ? this.glJ.getTopThreadSize() : 0;
            if (fVar.kdj != null && fVar.kdj.get(0) != null) {
                fVar.kdj.get(0).cLB = (i + 1) - topThreadSize;
            }
            bVar.eJn.setForumName(this.mForumName);
            bVar.eJn.a(fVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
    }
}
