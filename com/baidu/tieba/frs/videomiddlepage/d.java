package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.afd.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Sj;
    private com.baidu.tieba.lego.card.view.f Sk;
    private String arh;
    private boolean dQa;
    private com.baidu.tieba.frs.aggregation.a dQb;
    private boolean dQc;
    private ad<com.baidu.tieba.frs.aggregation.g> dQd;
    private a ehD;
    private boolean ehE;
    private boolean ehF;
    private b ehl;
    private com.baidu.tieba.frs.videomiddlepage.controller.a ehm;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dQi);
        this.Sj = new ArrayList();
        this.mHandler = new Handler();
        this.ehE = true;
        this.dQd = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.ehD != null && d.this.ehD != aVar2 && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            d.this.ehD.aDG();
                        }
                        if (d.this.ehD != aVar2) {
                            d.this.ehD = aVar2;
                        }
                        if (d.this.ehD != null) {
                            d.this.ehD.ht(d.this.ehE);
                        }
                    }
                    if (view.getId() == e.g.title) {
                        am amVar = new am("c12411");
                        amVar.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == e.g.thread_info_commont_container || view.getId() == e.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                    } else if (view.getId() == e.g.user_icon || view.getId() == e.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                    } else if (view.getId() == e.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == e.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.aA(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.aA("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dQb = aVar;
        this.dQc = z;
        this.ehl = bVar;
        this.mFrom = str;
        this.ehm = new com.baidu.tieba.frs.videomiddlepage.controller.a();
        this.arh = str2;
        this.Sk = fVar;
    }

    public void hx(boolean z) {
        this.ehF = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.ehD != null) {
            this.dQa = true;
            this.ehD.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dQa) {
                            d.this.dQa = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dQc, this.mFrom, this.arh);
        if (this.ehm.hy(false)) {
            aVar.ehm = this.ehm;
        }
        aVar.b(this.dQd);
        this.Sj.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.ehF) {
            if (!this.dQa) {
                aVar.aqT().a(gVar, i, this.dQb);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.px();
                }
                aVar.aqT().mPosition = i;
                aVar.aqT().setOnVideoContainerForegroundClickListener(this.ehl);
            } else {
                aVar.aqT().c(gVar, i, this.dQb);
            }
        }
        if (aVar.aqT() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.aqT().setCurrentPlayCallBack(this.Sk);
        }
        return aVar.getView();
    }

    public boolean pB() {
        if (this.ehD != null) {
            return this.ehD.isPlaying();
        }
        return false;
    }

    public void pz() {
        if (this.ehD != null) {
            this.ehD.aDF();
        }
    }

    public void pA() {
        if (this.ehD != null) {
            this.ehD.aDG();
        }
    }

    public void onDestroy() {
        if (this.ehm != null) {
            this.ehm.aIC();
        }
        for (a aVar : this.Sj) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean mH(int i) {
        if (this.ehD == null) {
            return false;
        }
        return this.ehD.mH(i);
    }
}
