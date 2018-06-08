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
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.e.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    private com.baidu.tieba.card.f dsD;
    private String mForumId;
    private TbPageContext<?> mPageContext;
    private ab rY;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.e.b.cNU);
        this.mPageContext = tbPageContext;
        this.mForumId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> onCreateViewHolder(ViewGroup viewGroup) {
        this.dsD = new com.baidu.tieba.card.f(this.mPageContext);
        return new com.baidu.tieba.card.a.a<>(this.dsD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.e.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        if (aVar.ajG() == null) {
            return null;
        }
        aVar.ajG().a(bVar);
        aVar.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.ajG().b(new ab<com.baidu.tieba.e.b>() { // from class: com.baidu.tieba.frs.gamerecommend.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view2, com.baidu.tieba.e.b bVar2) {
                TiebaStatic.log(new am("c13047").r("obj_locate", 3).ah(ImageViewerConfig.FORUM_ID, c.this.mForumId));
                c.this.a(view2, bVar2);
            }
        });
        return aVar.ajG().getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.e.b bVar) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createFromThreadCfg(bVar.Sz(), null, o.vb(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(bVar.Sz().getFid()));
        createFromThreadCfg.setForumName(bVar.Sz().vr());
        createFromThreadCfg.setStartFrom(0);
        o.lb(bVar.Sz().getTid());
        this.mPageContext.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        if (this.rY != null) {
            this.rY.a(view, bVar);
        }
    }

    public void d(ab abVar) {
        this.rY = abVar;
    }
}
