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
    public BdUniqueId bdE;
    private NEGFeedBackView.a bwX;
    private String caw;
    ad<com.baidu.tieba.card.data.j> eqD;
    private m evF;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bwX = null;
        this.eqD = new ad<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (b.this.evF.cbH != view) {
                    if (view == b.this.evF.caJ.getCommentContainer() || view == b.this.evF.cbw.aKi.getCommentContainer()) {
                        String str = "";
                        if (jVar != null && jVar.ZR() != null) {
                            str = jVar.ZR().getTid();
                        }
                        am amVar = new am("c12942");
                        amVar.x("obj_locate", 1);
                        amVar.x("obj_type", 5);
                        amVar.aA("tid", str);
                        amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
                        TiebaStatic.log(amVar);
                        return;
                    }
                    return;
                }
                int i = 0;
                String str2 = "";
                long j = 0;
                if (jVar != null && jVar.ZR() != null) {
                    i = jVar.ZR().Aa().live_type;
                    str2 = jVar.ZR().getTid();
                    j = jVar.ZR().Aa().live_id;
                }
                am amVar2 = new am("c11824");
                amVar2.aA("uid", TbadkCoreApplication.getCurrentAccount());
                amVar2.aA("ab_tag", jVar.apP());
                amVar2.i("liveid", j);
                amVar2.x("obj_type", i);
                amVar2.aA("tid", str2);
                amVar2.aA("obj_param1", jVar.getExtra());
                amVar2.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
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
        this.evF = new m(this.mPageContext);
        this.evF.currentPageType = 2;
        if (this.evF.caJ != null) {
            this.evF.caJ.avL = 2;
        }
        if (this.evF.cbw != null && this.evF.cbw.aKi != null) {
            this.evF.cbw.aKi.avL = 2;
        }
        if (this.bdE != null) {
            this.evF.j(this.bdE);
        }
        return new a(this.evF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, a aVar) {
        if (jVar != null) {
            jVar.kC(i + 1);
        }
        if (aVar.evH instanceof com.baidu.tieba.a.e) {
            aVar.evH.setPage(this.caw);
        }
        aVar.evH.a(jVar);
        aVar.evH.b(this.eqD);
        aVar.evH.a(this.bwX);
        long j = 0;
        String str = "";
        if (jVar != null && jVar.ZR() != null) {
            int i2 = jVar.ZR().Aa().live_type;
            String tid = jVar.ZR().getTid();
            if (!StringUtils.isNull(jVar.ZR().Aa().appId)) {
                str = jVar.ZR().Aa().appId;
                j = jVar.ZR().Aa().live_id;
            }
            am amVar = new am("c11823");
            amVar.x("obj_type", i2);
            amVar.aA("obj_param3", str);
            amVar.aA("tid", tid);
            amVar.aA("ab_tag", jVar.apP());
            amVar.i("liveid", j);
            amVar.i(ImageViewerConfig.FORUM_ID, jVar.ZR().getFid());
            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
            amVar.aA("obj_param1", jVar.getExtra());
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, jVar.getSource());
            TiebaStatic.log(amVar);
        }
        return aVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bwX = aVar;
    }

    /* loaded from: classes6.dex */
    public static class a extends q.a {
        public m evH;

        public a(m mVar) {
            super(mVar.getView());
            this.evH = mVar;
        }
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
