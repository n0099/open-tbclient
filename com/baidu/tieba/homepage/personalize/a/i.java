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
    public BdUniqueId aPk;
    private com.baidu.tieba.card.f cZr;
    private x<com.baidu.tieba.card.data.h> cuq;
    private TbPageContext<?> mH;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.data.h.TYPE);
        this.cuq = new x<com.baidu.tieba.card.data.h>() { // from class: com.baidu.tieba.homepage.personalize.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.h hVar) {
                if (view != null && i.this.cZr != null && i.this.cZr.bJJ != null && i.this.cZr.bJJ.bJO != null && i.this.cZr.bJJ.bJM != null && i.this.cZr.bJJ.getView() != null) {
                    if (view.getId() != i.this.cZr.bJJ.bJO.getId() || !(view.getTag() instanceof MetaData)) {
                        if ((view.getId() == i.this.cZr.bJJ.getView().getId() || view.getId() == i.this.cZr.bJJ.bJM.getId()) && (view.getTag(d.h.rec_god_item_root) instanceof String)) {
                            TiebaStatic.log(new ak("c11005").ac("obj_id", (String) view.getTag(d.h.rec_god_item_root)));
                        }
                    } else if (!StringUtils.isNull(((MetaData) view.getTag()).getUserId())) {
                        TiebaStatic.log(new ak("c10803").r("obj_locate", 6));
                    }
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cZr = new com.baidu.tieba.card.f(this.mH, this.aPk);
        return new com.baidu.tieba.card.a.a(this.cZr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.h hVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.f> aVar) {
        this.cZr = aVar.Yn();
        aVar.Yn().a(hVar);
        aVar.Yn().b(this.cuq);
        aVar.Yn().d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        u.XN().a(new ak("c11006"));
        return aVar.getView();
    }

    public void lf(int i) {
        if (this.cZr != null) {
            this.cZr.d(this.mH, i);
        }
    }
}
