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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.a, com.baidu.tieba.card.a.a<com.baidu.tieba.card.d>> {
    private com.baidu.tieba.card.d fIK;
    private ab fIL;
    private String mForumId;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.a.eWG);
        this.mForumId = str;
        this.mForumName = str2;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.d> b(ViewGroup viewGroup) {
        this.fIK = new com.baidu.tieba.card.d(this.mPageContext, this.mForumId, this.mForumName);
        return new com.baidu.tieba.card.a.a<>(this.fIK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.d> aVar2) {
        if (aVar2.baZ() == null) {
            return null;
        }
        aVar2.baZ().a(aVar);
        aVar2.baZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar2.baZ().d(new ab<com.baidu.tieba.e.a>() { // from class: com.baidu.tieba.frs.gamerecommend.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.a aVar3) {
                TiebaStatic.log(new an("c13047").O("obj_locate", 2).bS("fid", b.this.mForumId));
                b.this.a(view2, aVar3);
            }
        });
        return aVar2.baZ().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(aVar.agI(), null, n.ait(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.agI().getFid()));
        createFromThreadCfg.setForumName(aVar.agI().aiL());
        createFromThreadCfg.setStartFrom(0);
        n.uz(aVar.agI().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.fIL != null) {
            this.fIL.a(view, aVar);
        }
    }

    public void e(ab abVar) {
        this.fIL = abVar;
    }
}
