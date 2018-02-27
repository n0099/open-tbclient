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
    public BdUniqueId bIv;
    public int cardShowType;
    private v efW;
    private com.baidu.tieba.homepage.concern.view.c egn;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cardShowType = 0;
        this.efW = new v<m>() { // from class: com.baidu.tieba.homepage.concern.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                if (view != null && h.this.egn != null && h.this.egn.getView() != null && mVar != null && mVar.WD() != null && !StringUtils.isNull(mVar.WD().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((h.this.egn.getHeaderImg() != null && view.getId() == h.this.egn.getHeaderImg().getId()) || (h.this.egn.akR() != null && view.getId() == h.this.egn.akR().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.s("obj_type", 2);
                    akVar.ab("tid", mVar.bZf.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, mVar.bZf.getFid());
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
        this.egn = new com.baidu.tieba.homepage.concern.view.c(this.mPageContext);
        if (this.bIv != null) {
            this.egn.j(this.bIv);
        }
        return new a(this.egn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, a aVar) {
        if (mVar == null || aVar == null || aVar.egp == null) {
            return null;
        }
        mVar.lD(i + 1);
        r.als().a(mVar.kz("c12351"));
        if (mVar.bZf != null) {
            mVar.bZf.aQo = this.cardShowType;
        }
        aVar.egp.a(mVar);
        aVar.egp.b(this.efW);
        return aVar.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        public com.baidu.tieba.homepage.concern.view.c egp;

        public a(com.baidu.tieba.homepage.concern.view.c cVar) {
            super(cVar.getView());
            this.egp = cVar;
        }
    }
}
