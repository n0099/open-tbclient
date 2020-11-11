package com.baidu.tieba.frs.gamerecommend.a;

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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    private ab iXs;
    private com.baidu.tieba.card.f iXu;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.b.ieL);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> c(ViewGroup viewGroup) {
        this.iXu = new com.baidu.tieba.card.f(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.iXu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        if (aVar.coY() == null) {
            return null;
        }
        aVar.coY().a(bVar);
        aVar.coY().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.coY().c(new ab<com.baidu.tieba.e.b>() { // from class: com.baidu.tieba.frs.gamerecommend.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.b bVar2) {
                TiebaStatic.log(new aq("c13047").al("obj_locate", 3).dR("fid", c.this.mForumId));
                c.this.a(view2, bVar2);
            }
        });
        return aVar.coY().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bVar.bjZ(), null, n.bmm(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.bjZ().getFid()));
        createFromThreadCfg.setForumName(bVar.bjZ().bmE());
        createFromThreadCfg.setStartFrom(0);
        n.IZ(bVar.bjZ().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.iXs != null) {
            this.iXs.a(view, bVar);
        }
    }

    public void d(ab abVar) {
        this.iXs = abVar;
    }
}
