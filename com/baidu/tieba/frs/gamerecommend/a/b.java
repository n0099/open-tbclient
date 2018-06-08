package com.baidu.tieba.frs.gamerecommend.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.o;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.a, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private com.baidu.tieba.card.e dsB;
    private String mForumId;
    private String mForumName;
    private TbPageContext<?> mPageContext;
    private ab rY;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.a.cNT);
        this.mForumId = str;
        this.mForumName = str2;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.dsB = new com.baidu.tieba.card.e(this.mPageContext, this.mForumId, this.mForumName);
        return new com.baidu.tieba.card.a.a<>(this.dsB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.a aVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e> aVar2) {
        if (aVar2.ajG() == null) {
            return null;
        }
        aVar2.ajG().a(aVar);
        aVar2.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar2.ajG().b(new ab<com.baidu.tieba.e.a>() { // from class: com.baidu.tieba.frs.gamerecommend.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.a aVar3) {
                TiebaStatic.log(new am("c13047").r("obj_locate", 2).ah(ImageViewerConfig.FORUM_ID, b.this.mForumId));
                b.this.a(view2, aVar3);
            }
        });
        return aVar2.ajG().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.a aVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(aVar.Sz(), null, o.vb(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(aVar.Sz().getFid()));
        createFromThreadCfg.setForumName(aVar.Sz().vr());
        createFromThreadCfg.setStartFrom(0);
        o.lb(aVar.Sz().getTid());
        this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        if (this.rY != null) {
            this.rY.a(view, aVar);
        }
    }

    public void d(ab abVar) {
        this.rY = abVar;
    }
}
