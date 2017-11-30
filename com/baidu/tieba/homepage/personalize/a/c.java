package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, a> {
    public BdUniqueId aSv;
    private c.a aYN;
    v<com.baidu.tieba.card.data.k> dmZ;
    private com.baidu.tieba.card.i dqD;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYN = null;
        this.dmZ = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (c.this.dqD.bZV == view) {
                    int i = 0;
                    String str = "";
                    long j = 0;
                    if (kVar != null && kVar.Ox() != null) {
                        i = kVar.Ox().rQ().live_type;
                        str = kVar.Ox().getTid();
                        j = kVar.Ox().rQ().live_id;
                    }
                    ak akVar = new ak("c11824");
                    akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    akVar.ac("ab_tag", kVar.abX());
                    akVar.f("liveid", j);
                    akVar.r("obj_type", i);
                    akVar.ac("tid", str);
                    akVar.ac("obj_param1", kVar.getExtra());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dqD = new com.baidu.tieba.card.i(this.mPageContext);
        this.dqD.currentPageType = 2;
        if (this.dqD.bvH != null) {
            this.dqD.bvH.anM = 2;
        }
        if (this.aSv != null) {
            this.dqD.k(this.aSv);
        }
        return new a(this.dqD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, a aVar) {
        if (kVar != null) {
            kVar.iE(i + 1);
        }
        aVar.dqF.a(kVar);
        aVar.dqF.b(this.dmZ);
        aVar.dqF.a(this.aYN);
        long j = 0;
        String str = "";
        if (kVar != null && kVar.Ox() != null) {
            int i2 = kVar.Ox().rQ().live_type;
            String tid = kVar.Ox().getTid();
            if (!StringUtils.isNull(kVar.Ox().rQ().appId)) {
                str = kVar.Ox().rQ().appId;
                j = kVar.Ox().rQ().live_id;
            }
            ak akVar = new ak("c11823");
            akVar.r("obj_type", i2);
            akVar.ac("obj_param3", str);
            akVar.ac("tid", tid);
            akVar.ac("ab_tag", kVar.abX());
            akVar.f("liveid", j);
            akVar.f(ImageViewerConfig.FORUM_ID, kVar.Ox().getFid());
            akVar.ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            akVar.ac("obj_param1", kVar.getExtra());
            TiebaStatic.log(akVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.aYN = aVar;
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        public com.baidu.tieba.card.i dqF;

        public a(com.baidu.tieba.card.i iVar) {
            super(iVar.getView());
            this.dqF = iVar;
        }
    }
}
