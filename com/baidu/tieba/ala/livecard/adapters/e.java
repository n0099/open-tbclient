package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.h, com.baidu.tieba.ala.livecard.a.c> implements y {
    private com.baidu.tieba.ala.livecard.b.d fGd;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public com.baidu.tieba.ala.livecard.a.c b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fGd = new com.baidu.tieba.ala.livecard.b.d(this.mPageContext);
        this.fGd.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.c(this.fGd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, com.baidu.tieba.ala.livecard.a.c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.h) cVar);
        if (hVar != null) {
            int i2 = 0;
            if (this.hmG != null) {
                i2 = this.hmG.getTopThreadSize();
            }
            cVar.fGl.dDb = (i + 1) - i2;
            cVar.fGl.setForumName(this.mForumName);
            cVar.fGl.a(hVar);
        }
        return view;
    }
}
