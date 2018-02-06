package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<m, a> {
    public BdUniqueId bII;
    public int cardShowType;
    private v egi;
    private com.baidu.tieba.homepage.concern.view.c egz;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cardShowType = 0;
        this.egi = new v<m>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                if (view != null && h.this.egz != null && h.this.egz.getView() != null && mVar != null && mVar.WE() != null && !StringUtils.isNull(mVar.WE().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((h.this.egz.getHeaderImg() != null && view.getId() == h.this.egz.getHeaderImg().getId()) || (h.this.egz.akS() != null && view.getId() == h.this.egz.akS().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.s("obj_type", 2);
                    akVar.ab("tid", mVar.bZr.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, mVar.bZr.getFid());
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
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
        this.egz = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.bII != null) {
            this.egz.j(this.bII);
        }
        return new a(this.egz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, a aVar) {
        if (mVar == null || aVar == null || aVar.egB == null) {
            return null;
        }
        mVar.lD(i + 1);
        r.alt().a(mVar.kz("c12351"));
        if (mVar.bZr != null) {
            mVar.bZr.aQz = this.cardShowType;
        }
        aVar.egB.a(mVar);
        aVar.egB.b(this.egi);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        public com.baidu.tieba.homepage.concern.view.c egB;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.egB = cVar;
        }
    }
}
