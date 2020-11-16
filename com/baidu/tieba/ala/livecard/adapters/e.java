package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class e extends k<com.baidu.tieba.tbadkCore.h, com.baidu.tieba.ala.livecard.a.c> implements z {
    private com.baidu.tieba.ala.livecard.b.d gSn;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vB(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.ala.livecard.a.c c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.gSn = new com.baidu.tieba.ala.livecard.b.d(this.mPageContext);
        this.gSn.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.c(this.gSn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.h hVar, com.baidu.tieba.ala.livecard.a.c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) hVar, (com.baidu.tieba.tbadkCore.h) cVar);
        if (hVar != null) {
            int i2 = 0;
            if (this.iHB != null) {
                i2 = this.iHB.getTopThreadSize();
            }
            cVar.gSv.eAb = (i + 1) - i2;
            cVar.gSv.setForumName(this.mForumName);
            cVar.gSv.a(hVar);
        }
        return view;
    }
}
