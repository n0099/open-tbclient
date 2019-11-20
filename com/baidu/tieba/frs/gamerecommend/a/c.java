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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.n;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private ab fHU;
    private com.baidu.tieba.card.e fHW;
    private String mForumId;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.b.eVQ);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> b(ViewGroup viewGroup) {
        this.fHW = new com.baidu.tieba.card.e(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.fHW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> aVar) {
        if (aVar.baX() == null) {
            return null;
        }
        aVar.baX().a(bVar);
        aVar.baX().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.baX().d(new ab<com.baidu.tieba.e.b>() { // from class: com.baidu.tieba.frs.gamerecommend.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.b bVar2) {
                TiebaStatic.log(new an("c13047").O("obj_locate", 3).bS("fid", c.this.mForumId));
                c.this.a(view2, bVar2);
            }
        });
        return aVar.baX().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bVar.agG(), null, n.air(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.agG().getFid()));
        createFromThreadCfg.setForumName(bVar.agG().aiJ());
        createFromThreadCfg.setStartFrom(0);
        n.uz(bVar.agG().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.fHU != null) {
            this.fHU.a(view, bVar);
        }
    }

    public void e(ab abVar) {
        this.fHU = abVar;
    }
}
