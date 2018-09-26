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
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private ad eav;
    private com.baidu.tieba.homepage.concern.view.a eaz;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eav = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.eaz != null && c.this.eaz.getView() != null && jVar != null && jVar.UT() != null && !StringUtils.isNull(jVar.UT().getTid())) {
                    boolean z = view == c.this.eaz.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.w("obj_locate", z ? 1 : 2);
                    amVar.al("obj_type", jVar.akZ());
                    amVar.al("tid", jVar.threadData.getTid());
                    amVar.g(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.eaz.bND.getCommentContainer() || view == c.this.eaz.bOr.aBl.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.w("obj_locate", 7);
                        amVar2.w("obj_type", 5);
                        amVar2.al("tid", jVar.UT().getTid());
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
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.eaz = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aUU != null) {
            this.eaz.j(this.aUU);
        }
        return new com.baidu.tieba.card.a.a<>(this.eaz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aln() == null) {
            return null;
        }
        jVar.jv(i + 1);
        v.akM().a(jVar.lH("c12351"));
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(jVar);
        aVar.aln().b(this.eav);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
