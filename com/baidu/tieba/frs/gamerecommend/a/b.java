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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.a, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private com.baidu.tieba.card.e iXr;
    private ab iXs;
    private String mForumId;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.a.ieK);
        this.mForumId = str;
        this.mForumName = str2;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> c(ViewGroup viewGroup) {
        this.iXr = new com.baidu.tieba.card.e(this.mPageContext, this.mForumId, this.mForumName);
        return new com.baidu.tieba.card.a.a<>(this.iXr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> aVar2) {
        if (aVar2.coY() == null) {
            return null;
        }
        aVar2.coY().a(aVar);
        aVar2.coY().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar2.coY().c(new ab<com.baidu.tieba.e.a>() { // from class: com.baidu.tieba.frs.gamerecommend.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.a aVar3) {
                TiebaStatic.log(new aq("c13047").al("obj_locate", 2).dR("fid", b.this.mForumId));
                b.this.a(view2, aVar3);
            }
        });
        return aVar2.coY().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(aVar.bjZ(), null, n.bmm(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.bjZ().getFid()));
        createFromThreadCfg.setForumName(aVar.bjZ().bmE());
        createFromThreadCfg.setStartFrom(0);
        n.IZ(aVar.bjZ().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.iXs != null) {
            this.iXs.a(view, aVar);
        }
    }

    public void d(ab abVar) {
        this.iXs = abVar;
    }
}
