package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.r;
import com.sina.weibo.sdk.api.CmdObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.e>> {
    private BdUniqueId bIy;
    private com.baidu.tieba.card.e ejO;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.ekB);
        this.mPageContext = tbPageContext;
        this.ejO = new com.baidu.tieba.card.e(this.mPageContext);
        this.ejO.k("c10714", "c10739", "c10712", "c10738");
        this.ejO.setFrom(CmdObject.CMD_HOME);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.bIy = bdUniqueId;
        if (this.ejO != null) {
            this.ejO.h(this.bIy);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.alY() == null) {
            return null;
        }
        aVar.alY().a(bVar);
        r.alt().a(new ak("c10714").ab("obj_param3", com.baidu.tieba.card.j.alg()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.ejO == null) {
            this.ejO = new com.baidu.tieba.card.e(this.mPageContext);
            this.ejO.h(this.bIy);
            this.ejO.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.ejO);
    }

    public void onChangeSkinType(int i) {
        if (this.ejO != null) {
            this.ejO.d(this.mPageContext, i);
        }
    }
}
