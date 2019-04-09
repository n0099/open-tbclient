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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    public BdUniqueId coa;
    private com.baidu.tieba.card.j fLM;
    private ab<com.baidu.tieba.card.data.h> fev;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.fev = new ab<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && l.this.fLM != null && l.this.fLM.ehf != null && l.this.fLM.ehf.ehj != null && l.this.fLM.ehf.ehh != null && l.this.fLM.ehf.getView() != null) {
                    if (view.getId() != l.this.fLM.ehf.ehj.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == l.this.fLM.ehf.getView().getId() || view.getId() == l.this.fLM.ehf.ehh.getId()) && (view.getTag(d.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new am("c11005").bJ(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(d.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new am("c10803").T("obj_locate", 6));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.fLM = new com.baidu.tieba.card.j(this.mPageContext, this.coa);
        return new com.baidu.tieba.card.a.a(this.fLM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        this.fLM = aVar.aRg();
        aVar.aRg().a(hVar);
        aVar.aRg().d(this.fev);
        aVar.aRg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.aQD().b(new am("c11006"));
        return aVar.getView();
    }

    public void sA(int i) {
        if (this.fLM != null) {
            this.fLM.onChangeSkinType(this.mPageContext, i);
        }
    }
}
