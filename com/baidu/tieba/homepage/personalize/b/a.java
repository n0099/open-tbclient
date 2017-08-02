package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aNy;
    private TbPageContext<?> ako;
    private com.baidu.tieba.card.e cSk;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.cTn);
        this.ako = tbPageContext;
        this.cSk = new com.baidu.tieba.card.e(this.ako);
        this.cSk.k("c10714", "c10739", "c10712", "c10738");
        this.cSk.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aNy = bdUniqueId;
        if (this.cSk != null) {
            this.cSk.i(this.aNy);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.WX() == null) {
            return null;
        }
        aVar.WX().a((com.baidu.tieba.card.a) bVar);
        u.Ww().a(new aj("c10714").aa("obj_param3", com.baidu.tieba.card.m.Wn()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.cSk == null) {
            this.cSk = new com.baidu.tieba.card.e(this.ako);
            this.cSk.i(this.aNy);
            this.cSk.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.cSk);
    }

    public void onChangeSkinType(int i) {
        if (this.cSk != null) {
            this.cSk.d(this.ako, i);
        }
    }
}
