package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.y;
import com.baidu.tieba.frs.j;
/* loaded from: classes4.dex */
public class c extends j<bv, com.baidu.tieba.ala.livecard.a.a> implements y {
    private com.baidu.tieba.ala.livecard.b.b fWJ;
    private aa<bv> fWK;
    private String mForumName;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.fWK = new aa<bv>() { // from class: com.baidu.tieba.ala.livecard.adapters.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_LIVE_START, Integer.valueOf(bvVar.getThreadType())));
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.j
    public void a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super.a(tbPageContext, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public com.baidu.tieba.ala.livecard.a.a b(ViewGroup viewGroup) {
        if (this.mPageContext == null) {
            return null;
        }
        this.fWJ = new com.baidu.tieba.ala.livecard.b.b(this.mPageContext);
        this.fWJ.p(this.mPageId);
        this.fWJ.setForumName(this.mForumName);
        return new com.baidu.tieba.ala.livecard.a.a(this.fWJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.tieba.ala.livecard.a.a aVar) {
        aVar.fWW.a(bvVar);
        aVar.fWW.setForumName(this.mForumName);
        aVar.fWW.c(this.fWK);
        if (bvVar != null) {
            bvVar.aXx();
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
    }
}
