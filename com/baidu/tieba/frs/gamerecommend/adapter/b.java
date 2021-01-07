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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.a, CardViewHolder<com.baidu.tieba.card.d>> {
    private com.baidu.tieba.card.d jyd;
    private aa jye;
    private String mForumId;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.a.iCP);
        this.mForumId = str;
        this.mForumName = str2;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.d> e(ViewGroup viewGroup) {
        this.jyd = new com.baidu.tieba.card.d(this.mPageContext, this.mForumId, this.mForumName);
        return new CardViewHolder<>(this.jyd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.a aVar, CardViewHolder<com.baidu.tieba.card.d> cardViewHolder) {
        if (cardViewHolder.cvH() == null) {
            return null;
        }
        cardViewHolder.cvH().a(aVar);
        cardViewHolder.cvH().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.cvH().c(new aa<com.baidu.tieba.e.a>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.a aVar2) {
                TiebaStatic.log(new aq("c13047").an("obj_locate", 2).dX("fid", b.this.mForumId));
                b.this.a(view2, aVar2);
            }
        });
        return cardViewHolder.cvH().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(aVar.boP(), null, m.brd(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.boP().getFid()));
        createFromThreadCfg.setForumName(aVar.boP().brv());
        createFromThreadCfg.setStartFrom(0);
        m.Jn(aVar.boP().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.jye != null) {
            this.jye.a(view, aVar);
        }
    }

    public void d(aa aaVar) {
        this.jye = aaVar;
    }
}
