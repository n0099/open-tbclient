package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    public BdUniqueId bIy;
    private v<com.baidu.tieba.card.data.h> dIB;
    private com.baidu.tieba.card.f ejZ;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.dIB = new v<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && g.this.ejZ != null && g.this.ejZ.cVU != null && g.this.ejZ.cVU.cVZ != null && g.this.ejZ.cVU.cVX != null && g.this.ejZ.cVU.getView() != null) {
                    if (view.getId() != g.this.ejZ.cVU.cVZ.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == g.this.ejZ.cVU.getView().getId() || view.getId() == g.this.ejZ.cVU.cVX.getId()) && (view.getTag(d.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new ak("c11005").ab("obj_id", (String) view.getTag(d.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new ak("c10803").s("obj_locate", 6));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.ejZ = new com.baidu.tieba.card.f(this.mPageContext, this.bIy);
        return new com.baidu.tieba.card.a.a(this.ejZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        this.ejZ = aVar.alY();
        aVar.alY().a(hVar);
        aVar.alY().b(this.dIB);
        aVar.alY().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        r.alt().a(new ak("c11006"));
        return aVar.getView();
    }

    public void oP(int i) {
        if (this.ejZ != null) {
            this.ejZ.d(this.mPageContext, i);
        }
    }
}
