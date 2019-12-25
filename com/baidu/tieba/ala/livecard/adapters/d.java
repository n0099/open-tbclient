package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.tbadkCore.g;
/* loaded from: classes2.dex */
public class d extends h<g, com.baidu.tieba.ala.livecard.a.c> implements x {
    private com.baidu.tieba.ala.livecard.b.d eHU;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pm(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public com.baidu.tieba.ala.livecard.a.c b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.eHU = new com.baidu.tieba.ala.livecard.b.d(this.mPageContext);
        this.eHU.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.c(this.eHU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, g gVar, com.baidu.tieba.ala.livecard.a.c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) gVar, (g) cVar);
        if (gVar != null) {
            int i2 = 0;
            if (this.giA != null) {
                i2 = this.giA.getTopThreadSize();
            }
            cVar.eIe.cLr = (i + 1) - i2;
            cVar.eIe.setForumName(this.mForumName);
            cVar.eIe.a(gVar);
        }
        return view;
    }
}
