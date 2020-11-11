package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class e extends k<com.baidu.tieba.tbadkCore.h, com.baidu.tieba.ala.livecard.a.c> implements z {
    private com.baidu.tieba.ala.livecard.b.d gSG;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public com.baidu.tieba.ala.livecard.a.c c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.gSG = new com.baidu.tieba.ala.livecard.b.d(this.mPageContext);
        this.gSG.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.c(this.gSG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, com.baidu.tieba.ala.livecard.a.c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.h) cVar);
        if (hVar != null) {
            int i2 = 0;
            if (this.iGN != null) {
                i2 = this.iGN.getTopThreadSize();
            }
            cVar.gSO.eBK = (i + 1) - i2;
            cVar.gSO.setForumName(this.mForumName);
            cVar.gSO.a(hVar);
        }
        return view;
    }
}
