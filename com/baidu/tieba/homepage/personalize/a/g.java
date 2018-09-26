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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId aUU;
    private ad<com.baidu.tieba.card.data.h> dxA;
    private com.baidu.tieba.card.k efH;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.dxA = new ad<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && g.this.efH != null && g.this.efH.cEa != null && g.this.efH.cEa.cEf != null && g.this.efH.cEa.cEd != null && g.this.efH.cEa.getView() != null) {
                    if (view.getId() != g.this.efH.cEa.cEf.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == g.this.efH.cEa.getView().getId() || view.getId() == g.this.efH.cEa.cEd.getId()) && (view.getTag(e.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new am("c11005").al(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(e.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new am("c10803").w("obj_locate", 6));
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
        this.efH = new com.baidu.tieba.card.k(this.mPageContext, this.aUU);
        return new com.baidu.tieba.card.a.a(this.efH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        this.efH = aVar.aln();
        aVar.aln().a(hVar);
        aVar.aln().b(this.dxA);
        aVar.aln().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.akM().a(new am("c11006"));
        return aVar.getView();
    }

    public void nx(int i) {
        if (this.efH != null) {
            this.efH.d(this.mPageContext, i);
        }
    }
}
