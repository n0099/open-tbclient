package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private ab dNe;
    private com.baidu.tieba.homepage.concern.view.a dNi;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dNe = new ab<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, j jVar) {
                if (view != null && c.this.dNi != null && c.this.dNi.getView() != null && jVar != null && jVar.Sz() != null && !StringUtils.isNull(jVar.Sz().getTid())) {
                    boolean z = view == c.this.dNi.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.r("obj_locate", z ? 1 : 2);
                    amVar.ah("obj_type", jVar.ajs());
                    amVar.ah("tid", jVar.threadData.getTid());
                    amVar.f(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.dNi.bFe.getCommentContainer() || view == c.this.dNi.bFT.axN.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.r("obj_locate", 7);
                        amVar2.r("obj_type", 5);
                        amVar2.ah("tid", jVar.Sz().getTid());
                        TiebaStatic.log(amVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.dNi = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aQJ != null) {
            this.dNi.j(this.aQJ);
        }
        return new com.baidu.tieba.card.a.a<>(this.dNi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.ajG() == null) {
            return null;
        }
        jVar.iN(i + 1);
        v.ajh().a(jVar.lh("c12351"));
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        aVar.ajG().a(jVar);
        aVar.ajG().b(this.dNe);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
