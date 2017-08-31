package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId aOx;
    private com.baidu.tieba.card.e dcf;
    private TbPageContext<?> mF;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.ddj);
        this.mF = tbPageContext;
        this.dcf = new com.baidu.tieba.card.e(this.mF);
        this.dcf.i("c10714", "c10739", "c10712", "c10738");
        this.dcf.setFrom("home");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aOx = bdUniqueId;
        if (this.dcf != null) {
            this.dcf.i(this.aOx);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.Yy() == null) {
            return null;
        }
        aVar.Yy().a((com.baidu.tieba.card.a) bVar);
        u.XY().a(new ak("c10714").ad("obj_param3", com.baidu.tieba.card.m.XP()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dcf == null) {
            this.dcf = new com.baidu.tieba.card.e(this.mF);
            this.dcf.i(this.aOx);
            this.dcf.i("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dcf);
    }

    public void onChangeSkinType(int i) {
        if (this.dcf != null) {
            this.dcf.d(this.mF, i);
        }
    }
}
