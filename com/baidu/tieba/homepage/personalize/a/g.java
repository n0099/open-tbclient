package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId aRC;
    private com.baidu.tieba.card.k dYm;
    private ad<com.baidu.tieba.card.data.h> drm;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.drm = new ad<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && g.this.dYm != null && g.this.dYm.cyk != null && g.this.dYm.cyk.cyp != null && g.this.dYm.cyk.cyn != null && g.this.dYm.cyk.getView() != null) {
                    if (view.getId() != g.this.dYm.cyk.cyp.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == g.this.dYm.cyk.getView().getId() || view.getId() == g.this.dYm.cyk.cyn.getId()) && (view.getTag(f.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new an("c11005").ae(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(f.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new an("c10803").r("obj_locate", 6));
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
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dYm = new com.baidu.tieba.card.k(this.mPageContext, this.aRC);
        return new com.baidu.tieba.card.a.a(this.dYm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        this.dYm = aVar.ajC();
        aVar.ajC().a(hVar);
        aVar.ajC().b(this.drm);
        aVar.ajC().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.ajb().a(new an("c11006"));
        return aVar.getView();
    }

    public void mT(int i) {
        if (this.dYm != null) {
            this.dYm.d(this.mPageContext, i);
        }
    }
}
