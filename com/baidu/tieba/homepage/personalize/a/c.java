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
    public BdUniqueId aPk;
    private c.a aVu;
    x<com.baidu.tieba.card.data.k> cVH;
    private com.baidu.tieba.card.i cZe;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVu = null;
        this.cVH = new x<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.cZe.bKf == view) {
                    int i = 0;
                    String str = "";
                    if (kVar != null && kVar.Nd() != null) {
                        i = kVar.Nd().rG().live_type;
                        str = kVar.Nd().getTid();
                    }
                    ak akVar = new ak("c11824");
                    akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    akVar.r("obj_type", i);
                    akVar.ac("tid", str);
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.cZe = new com.baidu.tieba.card.i(this.mH);
        if (this.aPk != null) {
            this.cZe.k(this.aPk);
        }
        return new a(this.cZe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.hQ(i + 1);
        }
        aVar.cZg.a(kVar);
        aVar.cZg.b(this.cVH);
        aVar.cZg.a(this.aVu);
        int i2 = 0;
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.Nd() != null) {
            i2 = kVar.Nd().rG().live_type;
            str = kVar.Nd().getTid();
            if (!StringUtils.isNull(kVar.Nd().rG().appId)) {
                str2 = kVar.Nd().rG().appId;
            }
        }
        TiebaStatic.log(new ak("c11823").r("obj_type", i2).ac("tid", str).ac("obj_param3", str2));
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.aVu = aVar;
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.card.i cZg;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.cZg = iVar;
        }
    }
}
