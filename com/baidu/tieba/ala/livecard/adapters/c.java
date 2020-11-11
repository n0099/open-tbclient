package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.k;
/* loaded from: classes4.dex */
public class c extends k<bw, com.baidu.tieba.ala.livecard.a.a> implements z {
    private ab<bw> gSA;
    private com.baidu.tieba.ala.livecard.b.b gSz;
    private String mForumName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gSA = new ab<bw>() { // from class: com.baidu.tieba.ala.livecard.adapters.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_LIVE_START, Integer.valueOf(bwVar.getThreadType())));
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.k
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.a(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.ala.livecard.a.a c(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.gSz = new com.baidu.tieba.ala.livecard.b.b(this.mPageContext);
        this.gSz.o(this.mPageId);
        this.gSz.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.a(this.gSz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.tieba.ala.livecard.a.a aVar) {
        aVar.gSM.a(bwVar);
        aVar.gSM.setForumName(this.mForumName);
        aVar.gSM.c(this.gSA);
        if (bwVar != null) {
            bwVar.bnM();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void vd(int i) {
    }
}
