package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.j;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId aOO;
    private h.a amd;
    x<com.baidu.tieba.card.data.k> cSl;
    private com.baidu.tieba.card.i cVF;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amd = null;
        this.cSl = new x<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.cVF.bHs == view) {
                    int i = 0;
                    String str = "";
                    if (kVar != null && kVar.MF() != null) {
                        i = kVar.MF().rY().live_type;
                        str = kVar.MF().getTid();
                    }
                    aj ajVar = new aj("c11824");
                    ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    ajVar.r("obj_type", i);
                    ajVar.aa("tid", str);
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.oW = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cVF = new com.baidu.tieba.card.i(this.oW);
        this.cVF.j(this.oW.getUniqueId());
        return new a(this.cVF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.hw(i + 1);
        }
        aVar.cVH.a(kVar);
        aVar.cVH.b(this.cSl);
        aVar.cVH.a(this.amd);
        int i2 = 0;
        String str = "";
        if (kVar != null && kVar.MF() != null) {
            i2 = kVar.MF().rY().live_type;
            str = kVar.MF().getTid();
        }
        TiebaStatic.log(new aj("c11823").r("obj_type", i2).aa("tid", str));
        return aVar.getView();
    }

    public void setEventCallback(h.a aVar) {
        this.amd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.card.i cVH;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.cVH = iVar;
        }
    }
}
