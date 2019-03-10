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
    public BdUniqueId cnX;
    private com.baidu.tieba.card.j fLZ;
    private ab<com.baidu.tieba.card.data.h> feJ;
    private TbPageContext<?> mPageContext;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.feJ = new ab<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && l.this.fLZ != null && l.this.fLZ.ehw != null && l.this.fLZ.ehw.ehA != null && l.this.fLZ.ehw.ehy != null && l.this.fLZ.ehw.getView() != null) {
                    if (view.getId() != l.this.fLZ.ehw.ehA.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == l.this.fLZ.ehw.getView().getId() || view.getId() == l.this.fLZ.ehw.ehy.getId()) && (view.getTag(d.g.rec_god_item_root) instanceof String)) {
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
        this.fLZ = new com.baidu.tieba.card.j(this.mPageContext, this.cnX);
        return new com.baidu.tieba.card.a.a(this.fLZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j> aVar) {
        this.fLZ = aVar.aRj();
        aVar.aRj().a(hVar);
        aVar.aRj().d(this.feJ);
        aVar.aRj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        com.baidu.tieba.card.t.aQG().b(new am("c11006"));
        return aVar.getView();
    }

    public void sE(int i) {
        if (this.fLZ != null) {
            this.fLZ.onChangeSkinType(this.mPageContext, i);
        }
    }
}
