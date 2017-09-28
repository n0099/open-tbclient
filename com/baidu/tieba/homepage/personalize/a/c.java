package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId aPx;
    private c.a aVH;
    x<com.baidu.tieba.card.data.k> cVT;
    private com.baidu.tieba.card.i cZr;
    private TbPageContext<?> mG;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVH = null;
        this.cVT = new x<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.cZr.bKr == view) {
                    int i = 0;
                    String str = "";
                    if (kVar != null && kVar.Nj() != null) {
                        i = kVar.Nj().rN().live_type;
                        str = kVar.Nj().getTid();
                    }
                    ak akVar = new ak("c11824");
                    akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    akVar.r("obj_type", i);
                    akVar.ad("tid", str);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cZr = new com.baidu.tieba.card.i(this.mG);
        if (this.aPx != null) {
            this.cZr.k(this.aPx);
        }
        return new a(this.cZr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.hR(i + 1);
        }
        aVar.cZt.a(kVar);
        aVar.cZt.b(this.cVT);
        aVar.cZt.a(this.aVH);
        int i2 = 0;
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.Nj() != null) {
            i2 = kVar.Nj().rN().live_type;
            str = kVar.Nj().getTid();
            if (!StringUtils.isNull(kVar.Nj().rN().appId)) {
                str2 = kVar.Nj().rN().appId;
            }
        }
        TiebaStatic.log(new ak("c11823").r("obj_type", i2).ad("tid", str).ad("obj_param3", str2));
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.aVH = aVar;
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.card.i cZt;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.cZt = iVar;
        }
    }
}
