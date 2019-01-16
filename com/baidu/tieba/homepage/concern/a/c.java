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
    public BdUniqueId bes;
    private String cbk;
    private ad eub;
    private com.baidu.tieba.homepage.concern.view.a euf;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eub = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.euf != null && c.this.euf.getView() != null && jVar != null && jVar.aaq() != null && !StringUtils.isNull(jVar.aaq().getTid())) {
                    boolean z = view == c.this.euf.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.y("obj_locate", z ? 1 : 2);
                    amVar.aB("obj_type", jVar.arc());
                    amVar.aB("tid", jVar.threadData.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.euf.cbx.getCommentContainer() || view == c.this.euf.cck.aKM.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.y("obj_locate", 7);
                        amVar2.y("obj_type", 5);
                        amVar2.aB("tid", jVar.aaq().getTid());
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
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.euf = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.bes != null) {
            this.euf.j(this.bes);
        }
        return new com.baidu.tieba.card.a.a<>(this.euf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        jVar.kP(i + 1);
        v.aqP().a(jVar.nc("c12351"));
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        aVar.arr().a(jVar);
        aVar.arr().b(this.eub);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }
}
