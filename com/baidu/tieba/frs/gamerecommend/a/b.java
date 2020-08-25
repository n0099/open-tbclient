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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.m;
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.a, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private com.baidu.tieba.card.e iiX;
    private aa iiY;
    private String mForumId;
    private String mForumName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.a.hqg);
        this.mForumId = str;
        this.mForumName = str2;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> b(ViewGroup viewGroup) {
        this.iiX = new com.baidu.tieba.card.e(this.mPageContext, this.mForumId, this.mForumName);
        return new com.baidu.tieba.card.a.a<>(this.iiX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> aVar2) {
        if (aVar2.ccE() == null) {
            return null;
        }
        aVar2.ccE().a(aVar);
        aVar2.ccE().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar2.ccE().c(new aa<com.baidu.tieba.e.a>() { // from class: com.baidu.tieba.frs.gamerecommend.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.a aVar3) {
                TiebaStatic.log(new aq("c13047").ai("obj_locate", 2).dD("fid", b.this.mForumId));
                b.this.a(view2, aVar3);
            }
        });
        return aVar2.ccE().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(aVar.bce(), null, m.beq(), RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.bce().getFid()));
        createFromThreadCfg.setForumName(aVar.bce().beI());
        createFromThreadCfg.setStartFrom(0);
        m.GY(aVar.bce().getTid());
        this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        if (this.iiY != null) {
            this.iiY.a(view, aVar);
        }
    }

    public void d(aa aaVar) {
        this.iiY = aaVar;
    }
}
