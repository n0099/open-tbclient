package com.baidu.tieba.homepage.personalize.b;

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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId aOu;
    private h.a alv;
    x<com.baidu.tieba.card.data.k> cZy;
    private com.baidu.tieba.card.i ddd;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alv = null;
        this.cZy = new x<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.ddd.bLc == view) {
                    int i = 0;
                    String str = "";
                    if (kVar != null && kVar.MR() != null) {
                        i = kVar.MR().rT().live_type;
                        str = kVar.MR().getTid();
                    }
                    ak akVar = new ak("c11824");
                    akVar.ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    akVar.r("obj_type", i);
                    akVar.ad("tid", str);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ddd = new com.baidu.tieba.card.i(this.mF);
        if (this.aOu != null) {
            this.ddd.l(this.aOu);
        }
        return new a(this.ddd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.hJ(i + 1);
        }
        aVar.ddf.a(kVar);
        aVar.ddf.b(this.cZy);
        aVar.ddf.a(this.alv);
        int i2 = 0;
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.MR() != null) {
            i2 = kVar.MR().rT().live_type;
            str = kVar.MR().getTid();
            if (!StringUtils.isNull(kVar.MR().rT().appId)) {
                str2 = kVar.MR().rT().appId;
            }
        }
        TiebaStatic.log(new ak("c11823").r("obj_type", i2).ad("tid", str).ad("obj_param3", str2));
        return aVar.getView();
    }

    public void setEventCallback(h.a aVar) {
        this.alv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.card.i ddf;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.ddf = iVar;
        }
    }
}
