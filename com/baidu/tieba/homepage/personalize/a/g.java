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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId aRF;
    private com.baidu.tieba.card.k dUx;
    private ad<com.baidu.tieba.card.data.h> dow;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.dow = new ad<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && g.this.dUx != null && g.this.dUx.cvL != null && g.this.dUx.cvL.cvQ != null && g.this.dUx.cvL.cvO != null && g.this.dUx.cvL.getView() != null) {
                    if (view.getId() != g.this.dUx.cvL.cvQ.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == g.this.dUx.cvL.getView().getId() || view.getId() == g.this.dUx.cvL.cvO.getId()) && (view.getTag(d.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new an("c11005").ah(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.rec_god_item_root)));
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
    /* renamed from: X */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dUx = new com.baidu.tieba.card.k(this.mPageContext, this.aRF);
        return new com.baidu.tieba.card.a.a(this.dUx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        this.dUx = aVar.aja();
        aVar.aja().a(hVar);
        aVar.aja().b(this.dow);
        aVar.aja().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aiz().a(new an("c11006"));
        return aVar.getView();
    }

    public void mF(int i) {
        if (this.dUx != null) {
            this.dUx.d(this.mPageContext, i);
        }
    }
}
