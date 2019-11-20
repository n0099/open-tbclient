package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.h;
/* loaded from: classes6.dex */
public class c extends h<bh, com.baidu.tieba.ala.livecard.a.a> implements z {
    private com.baidu.tieba.ala.livecard.b.b dSk;
    private ab<bh> dSl;
    private String mForumName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.dSl = new ab<bh>() { // from class: com.baidu.tieba.ala.livecard.adapters.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_LIVE_START, Integer.valueOf(bhVar.getThreadType())));
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
    /* renamed from: V */
    public com.baidu.tieba.ala.livecard.a.a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.dSk = new com.baidu.tieba.ala.livecard.b.b(this.mPageContext);
        this.dSk.l(this.mPageId);
        this.dSk.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.a(this.dSk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.tieba.ala.livecard.a.a aVar) {
        aVar.dSv.a(bhVar);
        aVar.dSv.setForumName(this.mForumName);
        aVar.dSv.d(this.dSl);
        if (bhVar != null) {
            bhVar.ajI();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
    }
}
