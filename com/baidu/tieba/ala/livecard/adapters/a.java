package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.h;
/* loaded from: classes6.dex */
public class a extends h<com.baidu.tieba.tbadkCore.f, com.baidu.tieba.ala.livecard.a.b> implements z {
    private com.baidu.tieba.ala.livecard.b.a dSf;
    private String mForumName;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.mForumName = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.ala.livecard.a.b b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.dSf = new com.baidu.tieba.ala.livecard.b.a(this.mPageContext);
        this.dSf.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.b(this.dSf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.f fVar, com.baidu.tieba.ala.livecard.a.b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) fVar, (com.baidu.tieba.tbadkCore.f) bVar);
        if (fVar != null) {
            int topThreadSize = this.fua != null ? this.fua.getTopThreadSize() : 0;
            if (fVar.jfo != null && fVar.jfo.get(0) != null) {
                fVar.jfo.get(0).cdI = (i + 1) - topThreadSize;
            }
            bVar.dSw.setForumName(this.mForumName);
            bVar.dSw.a(fVar);
        }
        return view;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
    }
}
