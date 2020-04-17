package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.x;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.h, com.baidu.tieba.ala.livecard.a.c> implements x {
    private com.baidu.tieba.ala.livecard.b.d fsg;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pV(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public com.baidu.tieba.ala.livecard.a.c b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fsg = new com.baidu.tieba.ala.livecard.b.d(this.mPageContext);
        this.fsg.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.c(this.fsg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, com.baidu.tieba.ala.livecard.a.c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.h) cVar);
        if (hVar != null) {
            int i2 = 0;
            if (this.gXO != null) {
                i2 = this.gXO.getTopThreadSize();
            }
            cVar.fso.doZ = (i + 1) - i2;
            cVar.fso.setForumName(this.mForumName);
            cVar.fso.a(hVar);
        }
        return view;
    }
}
