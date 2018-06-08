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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private NEGFeedBackView.a bgZ;
    ab<com.baidu.tieba.card.data.j> dNe;
    private m dQN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bgZ = null;
        this.dNe = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.dQN.cxO != view) {
                    if (view == b.this.dQN.bFe.getCommentContainer() || view == b.this.dQN.bFT.axN.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.Sz() != null) {
                            str = jVar.Sz().getTid();
                        }
                        am amVar = new am("c12942");
                        amVar.r("obj_locate", 1);
                        amVar.r("obj_type", 5);
                        amVar.ah("tid", str);
                        TiebaStatic.log(amVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.Sz() != null) {
                    i = jVar.Sz().vE().live_type;
                    str2 = jVar.Sz().getTid();
                    j = jVar.Sz().vE().live_id;
                }
                am amVar2 = new am("c11824");
                amVar2.ah("uid", TbadkCoreApplication.getCurrentAccount());
                amVar2.ah("ab_tag", jVar.ajr());
                amVar2.f("liveid", j);
                amVar2.r("obj_type", i);
                amVar2.ah("tid", str2);
                amVar2.ah("obj_param1", jVar.getExtra());
                TiebaStatic.log(amVar2);
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.dQN = new m(this.mPageContext);
        this.dQN.currentPageType = 2;
        if (this.dQN.bFe != null) {
            this.dQN.bFe.aka = 2;
        }
        if (this.dQN.bFT != null && this.dQN.bFT.axN != null) {
            this.dQN.bFT.axN.aka = 2;
        }
        if (this.aQJ != null) {
            this.dQN.j(this.aQJ);
        }
        return new a(this.dQN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.iN(i + 1);
        }
        if (aVar.dQP instanceof com.baidu.tieba.a.e) {
            aVar.dQP.setPage(this.bER);
        }
        aVar.dQP.a(jVar);
        aVar.dQP.b(this.dNe);
        aVar.dQP.a(this.bgZ);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.Sz() != null) {
            int i2 = jVar.Sz().vE().live_type;
            String tid = jVar.Sz().getTid();
            if (!StringUtils.isNull(jVar.Sz().vE().appId)) {
                str = jVar.Sz().vE().appId;
                j = jVar.Sz().vE().live_id;
            }
            am amVar = new am("c11823");
            amVar.r("obj_type", i2);
            amVar.ah("obj_param3", str);
            amVar.ah("tid", tid);
            amVar.ah("ab_tag", jVar.ajr());
            amVar.f("liveid", j);
            amVar.f(ImageViewerConfig.FORUM_ID, jVar.Sz().getFid());
            amVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.ah("obj_param1", jVar.getExtra());
            TiebaStatic.log(amVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bgZ = aVar;
    }

    /* loaded from: classes2.dex */
    public static class a extends q.a {
        public m dQP;

        public a(m mVar) {
            super(mVar.getView());
            this.dQP = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
