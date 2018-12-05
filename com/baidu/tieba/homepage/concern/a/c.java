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
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    public BdUniqueId bdE;
    private String caw;
    private ad eqD;
    private com.baidu.tieba.homepage.concern.view.a eqH;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eqD = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.eqH != null && c.this.eqH.getView() != null && jVar != null && jVar.ZR() != null && !StringUtils.isNull(jVar.ZR().getTid())) {
                    boolean z = view == c.this.eqH.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.x("obj_locate", z ? 1 : 2);
                    amVar.aA("obj_type", jVar.apQ());
                    amVar.aA("tid", jVar.threadData.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.eqH.caJ.getCommentContainer() || view == c.this.eqH.cbw.aKi.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.x("obj_locate", 7);
                        amVar2.x("obj_type", 5);
                        amVar2.aA("tid", jVar.ZR().getTid());
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
        this.eqH = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.bdE != null) {
            this.eqH.j(this.bdE);
        }
        return new com.baidu.tieba.card.a.a<>(this.eqH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aqe() == null) {
            return null;
        }
        jVar.kC(i + 1);
        v.apD().a(jVar.mJ("c12351"));
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        aVar.aqe().a(jVar);
        aVar.aqe().b(this.eqD);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
