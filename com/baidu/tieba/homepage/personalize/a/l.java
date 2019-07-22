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
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    public BdUniqueId cxx;
    private ab<com.baidu.tieba.card.data.h> fzG;
    private com.baidu.tieba.card.j gjj;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.fzG = new ab<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && l.this.gjj != null && l.this.gjj.eBS != null && l.this.gjj.eBS.eBW != null && l.this.gjj.eBS.eBU != null && l.this.gjj.eBS.getView() != null) {
                    if (view.getId() != l.this.gjj.eBS.eBW.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == l.this.gjj.eBS.getView().getId() || view.getId() == l.this.gjj.eBS.eBU.getId()) && (view.getTag(R.id.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new an("c11005").bT(VideoPlayActivityConfig.OBJ_ID, (String) view.getTag(R.id.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new an("c10803").P("obj_locate", 6));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.gjj = new com.baidu.tieba.card.j(this.mPageContext, this.cxx);
        return new com.baidu.tieba.card.a.a(this.gjj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        this.gjj = aVar.bar();
        aVar.bar().a(hVar);
        aVar.bar().d(this.fzG);
        aVar.bar().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.aZN().c(new an("c11006"));
        return aVar.getView();
    }

    public void uf(int i) {
        if (this.gjj != null) {
            this.gjj.onChangeSkinType(this.mPageContext, i);
        }
    }
}
