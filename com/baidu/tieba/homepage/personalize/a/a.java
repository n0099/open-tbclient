package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.sina.weibo.sdk.api.CmdObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.card.j>> {
    private BdUniqueId aQJ;
    private com.baidu.tieba.card.j dQM;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.personalize.data.d.dRz);
        this.mPageContext = tbPageContext;
        this.dQM = new com.baidu.tieba.card.j(this.mPageContext);
        this.dQM.k("c10714", "c10739", "c10712", "c10738");
        this.dQM.setFrom(CmdObject.CMD_HOME);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.aQJ = bdUniqueId;
        if (this.dQM != null) {
            this.dQM.h(this.aQJ);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.b bVar, com.baidu.tieba.card.a.a aVar) {
        if (aVar.ajG() == null) {
            return null;
        }
        aVar.ajG().a(bVar);
        v.ajh().a(new am("c10714").ah("obj_param3", o.aiY()));
        return aVar.getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        if (this.dQM == null) {
            this.dQM = new com.baidu.tieba.card.j(this.mPageContext);
            this.dQM.h(this.aQJ);
            this.dQM.k("c10714", "c10739", "c10712", "c10738");
        }
        return new com.baidu.tieba.card.a.a(this.dQM);
    }

    public void onChangeSkinType(int i) {
        if (this.dQM != null) {
            this.dQM.d(this.mPageContext, i);
        }
    }
}
