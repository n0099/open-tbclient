package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private NEGFeedBackView.a aYO;
    private String bvX;
    ab<com.baidu.tieba.card.data.j> dAS;
    private m dEv;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYO = null;
        this.dAS = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.j jVar) {
                if (b.this.dEv.coe != view2) {
                    if (view2 == b.this.dEv.bwk.getCommentContainer() || view2 == b.this.dEv.bwZ.apG.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.Pe() != null) {
                            str = jVar.Pe().getTid();
                        }
                        al alVar = new al("c12942");
                        alVar.r("obj_locate", 1);
                        alVar.r("obj_type", 5);
                        alVar.ac("tid", str);
                        TiebaStatic.log(alVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.Pe() != null) {
                    i = jVar.Pe().si().live_type;
                    str2 = jVar.Pe().getTid();
                    j = jVar.Pe().si().live_id;
                }
                al alVar2 = new al("c11824");
                alVar2.ac("uid", TbadkCoreApplication.getCurrentAccount());
                alVar2.ac("ab_tag", jVar.afK());
                alVar2.f("liveid", j);
                alVar2.r("obj_type", i);
                alVar2.ac("tid", str2);
                alVar2.ac("obj_param1", jVar.getExtra());
                TiebaStatic.log(alVar2);
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dEv = new m(this.mPageContext);
        this.dEv.currentPageType = 2;
        if (this.dEv.bwk != null) {
            this.dEv.bwk.abV = 2;
        }
        if (this.dEv.bwZ != null && this.dEv.bwZ.apG != null) {
            this.dEv.bwZ.apG.abV = 2;
        }
        if (this.aTr != null) {
            this.dEv.j(this.aTr);
        }
        return new a(this.dEv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.iN(i + 1);
        }
        if (aVar.dEx instanceof com.baidu.tieba.a.e) {
            aVar.dEx.setPage(this.bvX);
        }
        aVar.dEx.a(jVar);
        aVar.dEx.b(this.dAS);
        aVar.dEx.a(this.aYO);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.Pe() != null) {
            int i2 = jVar.Pe().si().live_type;
            String tid = jVar.Pe().getTid();
            if (!StringUtils.isNull(jVar.Pe().si().appId)) {
                str = jVar.Pe().si().appId;
                j = jVar.Pe().si().live_id;
            }
            al alVar = new al("c11823");
            alVar.r("obj_type", i2);
            alVar.ac("obj_param3", str);
            alVar.ac("tid", tid);
            alVar.ac("ab_tag", jVar.afK());
            alVar.f("liveid", j);
            alVar.f(ImageViewerConfig.FORUM_ID, jVar.Pe().getFid());
            alVar.ac("uid", TbadkCoreApplication.getCurrentAccount());
            alVar.ac("obj_param1", jVar.getExtra());
            TiebaStatic.log(alVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYO = aVar;
    }

    /* loaded from: classes2.dex */
    public class a extends q.a {
        public m dEx;

        public a(m mVar) {
            super(mVar.getView());
            this.dEx = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
