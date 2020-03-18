package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.x;
import com.baidu.tieba.card.z;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.h<bj, com.baidu.tieba.ala.livecard.a.a> implements x {
    private com.baidu.tieba.ala.livecard.b.b eNF;
    private z<bj> eNG;
    private String mForumName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.eNG = new z<bj>() { // from class: com.baidu.tieba.ala.livecard.adapters.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_LIVE_START, Integer.valueOf(bjVar.getThreadType())));
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.h
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.a(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
    public com.baidu.tieba.ala.livecard.a.a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.eNF = new com.baidu.tieba.ala.livecard.b.b(this.mPageContext);
        this.eNF.m(this.mPageId);
        this.eNF.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.a(this.eNF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.tieba.ala.livecard.a.a aVar) {
        aVar.eNS.a(bjVar);
        aVar.eNS.setForumName(this.mForumName);
        aVar.eNS.c(this.eNG);
        if (bjVar != null) {
            bjVar.aDA();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
    }
}
