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
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> {
    public BdUniqueId bII;
    private c.a bPd;
    private int cardShowType;
    v<com.baidu.tieba.card.data.j> egi;
    private com.baidu.tieba.card.h ejN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bPd = null;
        this.cardShowType = 0;
        this.egi = new v<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (c.this.ejN.cWn != view) {
                    if (view == c.this.ejN.cmk.getCommentContainer() || view == c.this.ejN.cmX.bez.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.WE() != null) {
                            str = jVar.WE().getTid();
                        }
                        ak akVar = new ak("c12942");
                        akVar.s("obj_locate", 1);
                        akVar.s("obj_type", 5);
                        akVar.ab("tid", str);
                        TiebaStatic.log(akVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.WE() != null) {
                    i = jVar.WE().zG().live_type;
                    str2 = jVar.WE().getTid();
                    j = jVar.WE().zG().live_id;
                }
                ak akVar2 = new ak("c11824");
                akVar2.ab("uid", TbadkCoreApplication.getCurrentAccount());
                akVar2.ab("ab_tag", jVar.alD());
                akVar2.f("liveid", j);
                akVar2.s("obj_type", i);
                akVar2.ab("tid", str2);
                akVar2.ab("obj_param1", jVar.getExtra());
                TiebaStatic.log(akVar2);
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.ejN = new com.baidu.tieba.card.h(this.mPageContext);
        this.ejN.currentPageType = 2;
        if (this.ejN.cmk != null) {
            this.ejN.cmk.aQE = 2;
        }
        if (this.ejN.cmX != null && this.ejN.cmX.bez != null) {
            this.ejN.cmX.bez.aQE = 2;
        }
        if (this.bII != null) {
            this.ejN.j(this.bII);
        }
        return new a(this.ejN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.lD(i + 1);
        }
        if (jVar != null && jVar.threadData != null) {
            jVar.threadData.aQz = this.cardShowType;
        }
        aVar.ejP.a(jVar);
        aVar.ejP.b(this.egi);
        aVar.ejP.a(this.bPd);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.WE() != null) {
            int i2 = jVar.WE().zG().live_type;
            String tid = jVar.WE().getTid();
            if (!StringUtils.isNull(jVar.WE().zG().appId)) {
                str = jVar.WE().zG().appId;
                j = jVar.WE().zG().live_id;
            }
            ak akVar = new ak("c11823");
            akVar.s("obj_type", i2);
            akVar.ab("obj_param3", str);
            akVar.ab("tid", tid);
            akVar.ab("ab_tag", jVar.alD());
            akVar.f("liveid", j);
            akVar.f(ImageViewerConfig.FORUM_ID, jVar.WE().getFid());
            akVar.ab("uid", TbadkCoreApplication.getCurrentAccount());
            akVar.ab("obj_param1", jVar.getExtra());
            TiebaStatic.log(akVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(c.a aVar) {
        this.bPd = aVar;
    }

    /* loaded from: classes2.dex */
    public class a extends r.a {
        public com.baidu.tieba.card.h ejP;

        public a(com.baidu.tieba.card.h hVar) {
            super(hVar.getView());
            this.ejP = hVar;
        }
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
