package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.j;
/* loaded from: classes4.dex */
public class e extends j<com.baidu.tieba.tbadkCore.h, com.baidu.tieba.ala.livecard.a.c> implements y {
    private com.baidu.tieba.ala.livecard.b.d fWQ;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.ala.livecard.a.c b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fWQ = new com.baidu.tieba.ala.livecard.b.d(this.mPageContext);
        this.fWQ.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.c(this.fWQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, com.baidu.tieba.ala.livecard.a.c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.h) cVar);
        if (hVar != null) {
            int i2 = 0;
            if (this.hEX != null) {
                i2 = this.hEX.getTopThreadSize();
            }
            cVar.fWY.dPI = (i + 1) - i2;
            cVar.fWY.setForumName(this.mForumName);
            cVar.fWY.a(hVar);
        }
        return view;
    }
}
