package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private ab dNe;
    private com.baidu.tieba.homepage.concern.view.c dNt;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dNe = new ab<l>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                if (view != null && h.this.dNt != null && h.this.dNt.getView() != null && lVar != null && lVar.Sz() != null && !StringUtils.isNull(lVar.Sz().getTid())) {
                    am amVar = new am("c12352");
                    if ((h.this.dNt.getHeaderImg() != null && view.getId() == h.this.dNt.getHeaderImg().getId()) || (h.this.dNt.aiL() != null && view.getId() == h.this.dNt.aiL().getId())) {
                        amVar.r("obj_locate", 1);
                    } else {
                        amVar.r("obj_locate", 2);
                    }
                    amVar.r("obj_type", 2);
                    amVar.ah("tid", lVar.brC.getTid());
                    amVar.f(ImageViewerConfig.FORUM_ID, lVar.brC.getFid());
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    amVar.r("obj_param1", lVar.ajv() ? 2 : 1);
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dNt = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.aQJ != null) {
            this.dNt.j(this.aQJ);
        }
        return new a(this.dNt);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, a aVar) {
        if (lVar == null || aVar == null || aVar.dNv == null) {
            return null;
        }
        lVar.iN(i + 1);
        v.ajh().a(lVar.li("c12351"));
        if (aVar.dNv instanceof com.baidu.tieba.a.e) {
            aVar.dNv.setPage(this.bER);
        }
        aVar.dNv.a(lVar);
        aVar.dNv.b(this.dNe);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public com.baidu.tieba.homepage.concern.view.c dNv;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.dNv = cVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
