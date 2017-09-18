package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aOu;
    private com.baidu.tieba.card.e dda;
    private TbPageContext<?> mF;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.def);
        this.mF = tbPageContext;
        this.dda = new com.baidu.tieba.card.e(this.mF);
        this.dda.i("c10714", "c10739", "c10712", "c10738");
        this.dda.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOu = bdUniqueId;
        if (this.dda != null) {
            this.dda.i(this.aOu);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.YJ() == null) {
            return null;
        }
        aVar.YJ().a((com.baidu.tieba.card.a) bVar);
        u.Yj().a(new ak("c10714").ad("obj_param3", com.baidu.tieba.card.m.Ya()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dda == null) {
            this.dda = new com.baidu.tieba.card.e(this.mF);
            this.dda.i(this.aOu);
            this.dda.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dda);
    }

    public void onChangeSkinType(int i) {
        if (this.dda != null) {
            this.dda.d(this.mF, i);
        }
    }
}
