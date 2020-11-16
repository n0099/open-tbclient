package com.baidu.tieba.godSquare.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.h;
/* loaded from: classes23.dex */
public class b extends com.baidu.adp.widget.ListView.a<h, a> {
    private ab gSh;
    private com.baidu.tieba.godSquare.b.a jtH;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.ibT);
        this.gSh = new ab() { // from class: com.baidu.tieba.godSquare.a.b.1
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                if (view != null && b.this.jtH != null && (baseCardInfo instanceof h)) {
                    h hVar = (h) baseCardInfo;
                    if (hVar.eDc != null && !StringUtils.isNull(hVar.eDc.getUserId())) {
                        if (view.getId() != b.this.jtH.jtS.getId()) {
                            if (view.getId() == b.this.jtH.getView().getId() || view.getId() == b.this.jtH.jqc.getId()) {
                                TiebaStatic.log(new ar("c10951").dR("obj_id", hVar.eDc.getUserId()));
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(new ar("c10803").ak("obj_locate", 4).dR("obj_id", hVar.eDc.getUserId()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bx */
    public a c(ViewGroup viewGroup) {
        this.jtH = new com.baidu.tieba.godSquare.b.a(this.mPageContext);
        this.jtH.l(this.mPageContext.getUniqueId());
        this.jtH.c(this.gSh);
        return new a(this.jtH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, h hVar, a aVar) {
        if (aVar == null || aVar.jtJ == null) {
            return null;
        }
        aVar.jtJ.a(hVar);
        return aVar.getView();
    }

    /* loaded from: classes23.dex */
    public class a extends af.a {
        public com.baidu.tieba.godSquare.b.a jtJ;

        public a(com.baidu.tieba.godSquare.b.a aVar) {
            super(aVar.getView());
            this.jtJ = aVar;
        }
    }
}
