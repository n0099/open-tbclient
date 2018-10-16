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
    public BdUniqueId aZt;
    private String bVS;
    private NEGFeedBackView.a bsM;
    ad<com.baidu.tieba.card.data.j> eio;
    private m enq;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsM = null;
        this.eio = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.enq.bXd != view) {
                    if (view == b.this.enq.bWf.getCommentContainer() || view == b.this.enq.bWS.aFS.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.YA() != null) {
                            str = jVar.YA().getTid();
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
                if (jVar != null && jVar.YA() != null) {
                    i = jVar.YA().yP().live_type;
                    str2 = jVar.YA().getTid();
                    j = jVar.YA().yP().live_id;
                }
                am amVar2 = new am("c11824");
                amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                amVar2.ax("ab_tag", jVar.aoA());
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
    /* renamed from: aO */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        this.enq = new m(this.mPageContext);
        this.enq.currentPageType = 2;
        if (this.enq.bWf != null) {
            this.enq.bWf.ary = 2;
        }
        if (this.enq.bWS != null && this.enq.bWS.aFS != null) {
            this.enq.bWS.aFS.ary = 2;
        }
        if (this.aZt != null) {
            this.enq.j(this.aZt);
        }
        return new a(this.enq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.jT(i + 1);
        }
        if (aVar.ens instanceof com.baidu.tieba.a.e) {
            aVar.ens.setPage(this.bVS);
        }
        aVar.ens.a(jVar);
        aVar.ens.b(this.eio);
        aVar.ens.a(this.bsM);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.YA() != null) {
            int i2 = jVar.YA().yP().live_type;
            String tid = jVar.YA().getTid();
            if (!StringUtils.isNull(jVar.YA().yP().appId)) {
                str = jVar.YA().yP().appId;
                j = jVar.YA().yP().live_id;
            }
            am amVar = new am("c11823");
            amVar.x("obj_type", i2);
            amVar.ax("obj_param3", str);
            amVar.ax("tid", tid);
            amVar.ax("ab_tag", jVar.aoA());
            amVar.h("liveid", j);
            amVar.h(ImageViewerConfig.FORUM_ID, jVar.YA().getFid());
            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.ax("obj_param1", jVar.getExtra());
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            TiebaStatic.log(amVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bsM = aVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public m ens;

        public a(m mVar) {
            super(mVar.getView());
            this.ens = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
