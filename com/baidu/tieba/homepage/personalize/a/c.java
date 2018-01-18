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
    public BdUniqueId bGw;
    private c.a bMO;
    private int cardShowType;
    v<com.baidu.tieba.card.data.k> ebB;
    private com.baidu.tieba.card.i efg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMO = null;
        this.cardShowType = 0;
        this.ebB = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.efg.cTj == view) {
                    int i = 0;
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.VK() != null) {
                        i = kVar.VK().zl().live_type;
                        str = kVar.VK().getTid();
                        j = kVar.VK().zl().live_id;
                    }
                    ak akVar = new ak("c11824");
                    akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
                    akVar.ab("ab_tag", kVar.akP());
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
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.efg = new com.baidu.tieba.card.i(this.mPageContext);
        this.efg.currentPageType = 2;
        if (this.efg.ciL != null) {
            this.efg.ciL.bbP = 2;
        }
        if (this.efg.cSr != null && this.efg.cSr.bcA != null) {
            this.efg.cSr.bcA.bbP = 2;
        }
        if (this.bGw != null) {
            this.efg.j(this.bGw);
        }
        return new a(this.efg);
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
            kVar.threadData.aPa = this.cardShowType;
        }
        aVar.efi.a(kVar);
        aVar.efi.b(this.ebB);
        aVar.efi.a(this.bMO);
        long j = 0;
        String str = "";
        if (kVar != null && kVar.VK() != null) {
            int i2 = kVar.VK().zl().live_type;
            String tid = kVar.VK().getTid();
            if (!StringUtils.isNull(kVar.VK().zl().appId)) {
                str = kVar.VK().zl().appId;
                j = kVar.VK().zl().live_id;
            }
            ak akVar = new ak("c11823");
            akVar.s("obj_type", i2);
            akVar.ab("obj_param3", str);
            akVar.ab("tid", tid);
            akVar.ab("ab_tag", kVar.akP());
            akVar.f("liveid", j);
            akVar.f(ImageViewerConfig.FORUM_ID, kVar.VK().getFid());
            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ab("obj_param1", kVar.getExtra());
            TiebaStatic.log(akVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.bMO = aVar;
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        public com.baidu.tieba.card.i efi;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.efi = iVar;
        }
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
