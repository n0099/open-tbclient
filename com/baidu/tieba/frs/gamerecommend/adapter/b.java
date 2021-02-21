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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.a, CardViewHolder<com.baidu.tieba.card.d>> {
    private com.baidu.tieba.card.d jzr;
    private ab jzs;
    private String mForumId;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.a.iEg);
        this.mForumId = str;
        this.mForumName = str2;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<com.baidu.tieba.card.d> e(ViewGroup viewGroup) {
        this.jzr = new com.baidu.tieba.card.d(this.mPageContext, this.mForumId, this.mForumName);
        return new CardViewHolder<>(this.jzr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.a aVar, CardViewHolder<com.baidu.tieba.card.d> cardViewHolder) {
        if (cardViewHolder.cti() == null) {
            return null;
        }
        cardViewHolder.cti().a(aVar);
        cardViewHolder.cti().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.cti().c(new ab<com.baidu.tieba.e.a>() { // from class: com.baidu.tieba.frs.gamerecommend.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.a aVar2) {
                TiebaStatic.log(new ar("c13047").ap("obj_locate", 2).dR("fid", b.this.mForumId));
                b.this.a(view2, aVar2);
            }
        });
        return cardViewHolder.cti().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(aVar.bln(), null, m.bnC(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.bln().getFid()));
        createFromThreadCfg.setForumName(aVar.bln().bnU());
        createFromThreadCfg.setStartFrom(0);
        m.IN(aVar.bln().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.jzs != null) {
            this.jzs.a(view, aVar);
        }
    }

    public void d(ab abVar) {
        this.jzs = abVar;
    }
}
