package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private com.baidu.tieba.card.e fBT;
    private String mForumId;
    private TbPageContext<?> mPageContext;
    private ab sE;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.b.eNe);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.fBT = new com.baidu.tieba.card.e(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.fBT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> aVar) {
        if (aVar.aYs() == null) {
            return null;
        }
        aVar.aYs().a(bVar);
        aVar.aYs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.aYs().d(new ab<com.baidu.tieba.e.b>() { // from class: com.baidu.tieba.frs.gamerecommend.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.b bVar2) {
                TiebaStatic.log(new am("c13047").P("obj_locate", 3).bT("fid", c.this.mForumId));
                c.this.a(view2, bVar2);
            }
        });
        return aVar.aYs().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bVar.abv(), null, n.adi(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.abv().getFid()));
        createFromThreadCfg.setForumName(bVar.abv().adA());
        createFromThreadCfg.setStartFrom(0);
        n.uR(bVar.abv().getTid());
        this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        if (this.sE != null) {
            this.sE.a(view, bVar);
        }
    }

    public void e(ab abVar) {
        this.sE = abVar;
    }
}
