package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.h<bk, com.baidu.tieba.ala.livecard.a.a> implements y {
    private com.baidu.tieba.ala.livecard.b.b fFW;
    private aa<bk> fFX;
    private String mForumName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fFX = new aa<bk>() { // from class: com.baidu.tieba.ala.livecard.adapters.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_LIVE_START, Integer.valueOf(bkVar.getThreadType())));
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
    /* renamed from: aj */
    public com.baidu.tieba.ala.livecard.a.a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fFW = new com.baidu.tieba.ala.livecard.b.b(this.mPageContext);
        this.fFW.o(this.mPageId);
        this.fFW.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.a(this.fFW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.tieba.ala.livecard.a.a aVar) {
        aVar.fGj.a(bkVar);
        aVar.fGj.setForumName(this.mForumName);
        aVar.fGj.c(this.fFX);
        if (bkVar != null) {
            bkVar.aRK();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qw(int i) {
    }
}
