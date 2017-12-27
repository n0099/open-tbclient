package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId bGo;
    private c.a bMG;
    v<com.baidu.tieba.card.data.k> ear;
    private com.baidu.tieba.card.i edS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMG = null;
        this.ear = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.edS.cOI == view) {
                    int i = 0;
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.VW() != null) {
                        i = kVar.VW().zq().live_type;
                        str = kVar.VW().getTid();
                        j = kVar.VW().zq().live_id;
                    }
                    ak akVar = new ak("c11824");
                    akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
                    akVar.ab("ab_tag", kVar.ajM());
                    akVar.f("liveid", j);
                    akVar.s("obj_type", i);
                    akVar.ab("tid", str);
                    akVar.ab("obj_param1", kVar.getExtra());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.edS = new com.baidu.tieba.card.i(this.mPageContext);
        this.edS.currentPageType = 2;
        if (this.edS.ciE != null) {
            this.edS.ciE.bbP = 2;
        }
        if (this.bGo != null) {
            this.edS.j(this.bGo);
        }
        return new a(this.edS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.lE(i + 1);
        }
        aVar.edU.a(kVar);
        aVar.edU.b(this.ear);
        aVar.edU.a(this.bMG);
        long j = 0;
        String str = "";
        if (kVar != null && kVar.VW() != null) {
            int i2 = kVar.VW().zq().live_type;
            String tid = kVar.VW().getTid();
            if (!StringUtils.isNull(kVar.VW().zq().appId)) {
                str = kVar.VW().zq().appId;
                j = kVar.VW().zq().live_id;
            }
            ak akVar = new ak("c11823");
            akVar.s("obj_type", i2);
            akVar.ab("obj_param3", str);
            akVar.ab("tid", tid);
            akVar.ab("ab_tag", kVar.ajM());
            akVar.f("liveid", j);
            akVar.f(ImageViewerConfig.FORUM_ID, kVar.VW().getFid());
            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ab("obj_param1", kVar.getExtra());
            TiebaStatic.log(akVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.bMG = aVar;
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        public com.baidu.tieba.card.i edU;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.edU = iVar;
        }
    }
}
