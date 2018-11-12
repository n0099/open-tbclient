package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.m;
/* loaded from: classes6.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, a> implements com.baidu.tieba.a.f {
    private String bWE;
    public BdUniqueId bag;
    private NEGFeedBackView.a btz;
    ad<com.baidu.tieba.card.data.j> ejJ;
    private m eoL;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.btz = null;
        this.ejJ = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.eoL.bXP != view) {
                    if (view == b.this.eoL.bWR.getCommentContainer() || view == b.this.eoL.bXE.aGI.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.YL() != null) {
                            str = jVar.YL().getTid();
                        }
                        am amVar = new am("c12942");
                        amVar.x("obj_locate", 1);
                        amVar.x("obj_type", 5);
                        amVar.ax("tid", str);
                        amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                        TiebaStatic.log(amVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.YL() != null) {
                    i = jVar.YL().yW().live_type;
                    str2 = jVar.YL().getTid();
                    j = jVar.YL().yW().live_id;
                }
                am amVar2 = new am("c11824");
                amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                amVar2.ax("ab_tag", jVar.aoc());
                amVar2.h("liveid", j);
                amVar2.x("obj_type", i);
                amVar2.ax("tid", str2);
                amVar2.ax("obj_param1", jVar.getExtra());
                amVar2.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
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
        this.eoL = new m(this.mPageContext);
        this.eoL.currentPageType = 2;
        if (this.eoL.bWR != null) {
            this.eoL.bWR.asl = 2;
        }
        if (this.eoL.bXE != null && this.eoL.bXE.aGI != null) {
            this.eoL.bXE.aGI.asl = 2;
        }
        if (this.bag != null) {
            this.eoL.j(this.bag);
        }
        return new a(this.eoL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.km(i + 1);
        }
        if (aVar.eoN instanceof com.baidu.tieba.a.e) {
            aVar.eoN.setPage(this.bWE);
        }
        aVar.eoN.a(jVar);
        aVar.eoN.b(this.ejJ);
        aVar.eoN.a(this.btz);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.YL() != null) {
            int i2 = jVar.YL().yW().live_type;
            String tid = jVar.YL().getTid();
            if (!StringUtils.isNull(jVar.YL().yW().appId)) {
                str = jVar.YL().yW().appId;
                j = jVar.YL().yW().live_id;
            }
            am amVar = new am("c11823");
            amVar.x("obj_type", i2);
            amVar.ax("obj_param3", str);
            amVar.ax("tid", tid);
            amVar.ax("ab_tag", jVar.aoc());
            amVar.h("liveid", j);
            amVar.h(ImageViewerConfig.FORUM_ID, jVar.YL().getFid());
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.ax("obj_param1", jVar.getExtra());
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            TiebaStatic.log(amVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.btz = aVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public m eoN;

        public a(m mVar) {
            super(mVar.getView());
            this.eoN = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
