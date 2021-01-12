package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.b, CardViewHolder<com.baidu.tieba.card.e>> {
    private com.baidu.tieba.card.e jtA;
    private aa jty;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.b.iyj);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.e> e(ViewGroup viewGroup) {
        this.jtA = new com.baidu.tieba.card.e(this.mPageContext);
        return new CardViewHolder<>(this.jtA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.b bVar, CardViewHolder<com.baidu.tieba.card.e> cardViewHolder) {
        if (cardViewHolder.crP() == null) {
            return null;
        }
        cardViewHolder.crP().a(bVar);
        cardViewHolder.crP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.crP().c(new aa<com.baidu.tieba.e.b>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.b bVar2) {
                TiebaStatic.log(new aq("c13047").an("obj_locate", 3).dW("fid", c.this.mForumId));
                c.this.a(view2, bVar2);
            }
        });
        return cardViewHolder.crP().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bVar.bkV(), null, m.bnj(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.bkV().getFid()));
        createFromThreadCfg.setForumName(bVar.bkV().bnB());
        createFromThreadCfg.setStartFrom(0);
        m.Ic(bVar.bkV().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.jty != null) {
            this.jty.a(view, bVar);
        }
    }

    public void d(aa aaVar) {
        this.jty = aaVar;
    }
}
