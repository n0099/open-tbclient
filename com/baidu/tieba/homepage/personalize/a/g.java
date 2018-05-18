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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k>> {
    public BdUniqueId aTs;
    private com.baidu.tieba.card.k dFH;
    private ab<com.baidu.tieba.card.data.h> dcv;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.dcv = new ab<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.h hVar) {
                if (view2 != null && g.this.dFH != null && g.this.dFH.cpa != null && g.this.dFH.cpa.cpf != null && g.this.dFH.cpa.cpd != null && g.this.dFH.cpa.getView() != null) {
                    if (view2.getId() != g.this.dFH.cpa.cpf.getId() || !(view2.getTag() instanceof MetaData)) {
                        if ((view2.getId() == g.this.dFH.cpa.getView().getId() || view2.getId() == g.this.dFH.cpa.cpd.getId()) && (view2.getTag(d.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new al("c11005").ac(VideoPlayActivityConfig.OBJ_ID, (String) view2.getTag(d.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view2.getTag()).getUserId())) {
                        TiebaStatic.log(new al("c10803").r("obj_locate", 6));
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
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dFH = new com.baidu.tieba.card.k(this.mPageContext, this.aTs);
        return new com.baidu.tieba.card.a.a(this.dFH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.k> aVar) {
        this.dFH = aVar.afY();
        aVar.afY().a(hVar);
        aVar.afY().b(this.dcv);
        aVar.afY().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.afy().a(new al("c11006"));
        return aVar.getView();
    }

    public void mm(int i) {
        if (this.dFH != null) {
            this.dFH.d(this.mPageContext, i);
        }
    }
}
