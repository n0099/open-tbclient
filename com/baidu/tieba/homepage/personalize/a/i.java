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
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.h, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f>> {
    public BdUniqueId aPy;
    private x<com.baidu.tieba.card.data.h> cCl;
    private com.baidu.tieba.card.f dib;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.cCl = new x<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && i.this.dib != null && i.this.dib.bRC != null && i.this.dib.bRC.bRH != null && i.this.dib.bRC.bRF != null && i.this.dib.bRC.getView() != null) {
                    if (view.getId() != i.this.dib.bRC.bRH.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == i.this.dib.bRC.getView().getId() || view.getId() == i.this.dib.bRC.bRF.getId()) && (view.getTag(d.g.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new ak("c11005").ac("obj_id", (String) view.getTag(d.g.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new ak("c10803").r("obj_locate", 6));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dib = new com.baidu.tieba.card.f(this.mPageContext, this.aPy);
        return new com.baidu.tieba.card.a.a(this.dib);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        this.dib = aVar.aaJ();
        aVar.aaJ().a(hVar);
        aVar.aaJ().b(this.cCl);
        aVar.aaJ().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        u.aaj().a(new ak("c11006"));
        return aVar.getView();
    }

    public void lx(int i) {
        if (this.dib != null) {
            this.dib.d(this.mPageContext, i);
        }
    }
}
