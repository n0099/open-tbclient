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
    public BdUniqueId aPq;
    private c.a aVE;
    x<com.baidu.tieba.card.data.k> ddZ;
    private com.baidu.tieba.card.i dhu;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVE = null;
        this.ddZ = new x<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.dhu.bRL == view) {
                    int i = 0;
                    String str = "";
                    if (kVar != null && kVar.Np() != null) {
                        i = kVar.Np().rM().live_type;
                        str = kVar.Np().getTid();
                    }
                    ak akVar = new ak("c11824");
                    akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    akVar.r("obj_type", i);
                    akVar.ac("tid", str);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dhu = new com.baidu.tieba.card.i(this.mPageContext);
        if (this.aPq != null) {
            this.dhu.k(this.aPq);
        }
        return new a(this.dhu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.ij(i + 1);
        }
        aVar.dhw.a(kVar);
        aVar.dhw.b(this.ddZ);
        aVar.dhw.a(this.aVE);
        int i2 = 0;
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.Np() != null) {
            i2 = kVar.Np().rM().live_type;
            str = kVar.Np().getTid();
            if (!StringUtils.isNull(kVar.Np().rM().appId)) {
                str2 = kVar.Np().rM().appId;
            }
        }
        TiebaStatic.log(new ak("c11823").r("obj_type", i2).ac("tid", str).ac("obj_param3", str2));
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.aVE = aVar;
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.card.i dhw;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.dhw = iVar;
        }
    }
}
