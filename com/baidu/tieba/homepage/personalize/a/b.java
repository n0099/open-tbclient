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
    ad<com.baidu.tieba.card.data.j> eip;
    private m enr;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bsM = null;
        this.eip = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.enr.bXd != view) {
                    if (view == b.this.enr.bWf.getCommentContainer() || view == b.this.enr.bWS.aFS.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.YB() != null) {
                            str = jVar.YB().getTid();
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
                if (jVar != null && jVar.YB() != null) {
                    i = jVar.YB().yP().live_type;
                    str2 = jVar.YB().getTid();
                    j = jVar.YB().yP().live_id;
                }
                am amVar2 = new am("c11824");
                amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                amVar2.ax("ab_tag", jVar.aoB());
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
        this.enr = new m(this.mPageContext);
        this.enr.currentPageType = 2;
        if (this.enr.bWf != null) {
            this.enr.bWf.ary = 2;
        }
        if (this.enr.bWS != null && this.enr.bWS.aFS != null) {
            this.enr.bWS.aFS.ary = 2;
        }
        if (this.aZt != null) {
            this.enr.j(this.aZt);
        }
        return new a(this.enr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.jT(i + 1);
        }
        if (aVar.ent instanceof com.baidu.tieba.a.e) {
            aVar.ent.setPage(this.bVS);
        }
        aVar.ent.a(jVar);
        aVar.ent.b(this.eip);
        aVar.ent.a(this.bsM);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.YB() != null) {
            int i2 = jVar.YB().yP().live_type;
            String tid = jVar.YB().getTid();
            if (!StringUtils.isNull(jVar.YB().yP().appId)) {
                str = jVar.YB().yP().appId;
                j = jVar.YB().yP().live_id;
            }
            am amVar = new am("c11823");
            amVar.x("obj_type", i2);
            amVar.ax("obj_param3", str);
            amVar.ax("tid", tid);
            amVar.ax("ab_tag", jVar.aoB());
            amVar.h("liveid", j);
            amVar.h(ImageViewerConfig.FORUM_ID, jVar.YB().getFid());
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
        public m ent;

        public a(m mVar) {
            super(mVar.getView());
            this.ent = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
