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
    public BdUniqueId bGE;
    private c.a bMW;
    private int cardShowType;
    v<com.baidu.tieba.card.data.k> ebW;
    private com.baidu.tieba.card.i efB;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMW = null;
        this.cardShowType = 0;
        this.ebW = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.efB.cTE == view) {
                    int i = 0;
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.VM() != null) {
                        i = kVar.VM().zm().live_type;
                        str = kVar.VM().getTid();
                        j = kVar.VM().zm().live_id;
                    }
                    ak akVar = new ak("c11824");
                    akVar.aa("uid", TbadkCoreApplication.getCurrentAccount());
                    akVar.aa("ab_tag", kVar.akU());
                    akVar.f("liveid", j);
                    akVar.s("obj_type", i);
                    akVar.aa("tid", str);
                    akVar.aa("obj_param1", kVar.getExtra());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.efB = new com.baidu.tieba.card.i(this.mPageContext);
        this.efB.currentPageType = 2;
        if (this.efB.ciT != null) {
            this.efB.ciT.bbX = 2;
        }
        if (this.efB.cSM != null && this.efB.cSM.bcI != null) {
            this.efB.cSM.bcI.bbX = 2;
        }
        if (this.bGE != null) {
            this.efB.j(this.bGE);
        }
        return new a(this.efB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.lH(i + 1);
        }
        if (kVar != null && kVar.threadData != null) {
            kVar.threadData.aPd = this.cardShowType;
        }
        aVar.efD.a(kVar);
        aVar.efD.b(this.ebW);
        aVar.efD.a(this.bMW);
        long j = 0;
        String str = "";
        if (kVar != null && kVar.VM() != null) {
            int i2 = kVar.VM().zm().live_type;
            String tid = kVar.VM().getTid();
            if (!StringUtils.isNull(kVar.VM().zm().appId)) {
                str = kVar.VM().zm().appId;
                j = kVar.VM().zm().live_id;
            }
            ak akVar = new ak("c11823");
            akVar.s("obj_type", i2);
            akVar.aa("obj_param3", str);
            akVar.aa("tid", tid);
            akVar.aa("ab_tag", kVar.akU());
            akVar.f("liveid", j);
            akVar.f(ImageViewerConfig.FORUM_ID, kVar.VM().getFid());
            akVar.aa("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.aa("obj_param1", kVar.getExtra());
            TiebaStatic.log(akVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.bMW = aVar;
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        public com.baidu.tieba.card.i efD;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.efD = iVar;
        }
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
