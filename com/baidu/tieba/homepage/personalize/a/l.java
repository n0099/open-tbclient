package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    public BdUniqueId cKf;
    private ab<com.baidu.tieba.card.data.h> fBy;
    private com.baidu.tieba.card.j glp;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.fBy = new ab<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && l.this.glp != null && l.this.glp.eMp != null && l.this.glp.eMp.eMt != null && l.this.glp.eMp.eMr != null && l.this.glp.eMp.getView() != null) {
                    if (view.getId() != l.this.glp.eMp.eMt.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == l.this.glp.eMp.getView().getId() || view.getId() == l.this.glp.eMp.eMr.getId()) && (view.getTag(R.id.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new an("c11005").bS("obj_id", (String) view.getTag(R.id.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new an("c10803").O("obj_locate", 6));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public com.baidu.tieba.card.a.a b(ViewGroup viewGroup) {
        this.glp = new com.baidu.tieba.card.j(this.mPageContext, this.cKf);
        return new com.baidu.tieba.card.a.a(this.glp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        this.glp = aVar.baZ();
        aVar.baZ().a(hVar);
        aVar.baZ().d(this.fBy);
        aVar.baZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.baw().c(new an("c11006"));
        return aVar.getView();
    }

    public void tg(int i) {
        if (this.glp != null) {
            this.glp.onChangeSkinType(this.mPageContext, i);
        }
    }
}
