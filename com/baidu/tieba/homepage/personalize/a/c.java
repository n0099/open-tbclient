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
    public BdUniqueId aPy;
    private c.a aVM;
    x<com.baidu.tieba.card.data.k> deu;
    private com.baidu.tieba.card.i dhO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVM = null;
        this.deu = new x<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.dhO.bRY == view) {
                    int i = 0;
                    String str = "";
                    if (kVar != null && kVar.NA() != null) {
                        i = kVar.NA().rM().live_type;
                        str = kVar.NA().getTid();
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
        this.dhO = new com.baidu.tieba.card.i(this.mPageContext);
        if (this.aPy != null) {
            this.dhO.k(this.aPy);
        }
        return new a(this.dhO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.ih(i + 1);
        }
        aVar.dhQ.a(kVar);
        aVar.dhQ.b(this.deu);
        aVar.dhQ.a(this.aVM);
        int i2 = 0;
        String str = "";
        String str2 = "";
        if (kVar != null && kVar.NA() != null) {
            i2 = kVar.NA().rM().live_type;
            str = kVar.NA().getTid();
            if (!StringUtils.isNull(kVar.NA().rM().appId)) {
                str2 = kVar.NA().rM().appId;
            }
        }
        TiebaStatic.log(new ak("c11823").r("obj_type", i2).ac("tid", str).ac("obj_param3", str2));
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.aVM = aVar;
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.card.i dhQ;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.dhQ = iVar;
        }
    }
}
