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
    private boolean dNm;
    private com.baidu.tieba.frs.aggregation.a dNn;
    private boolean dNo;
    private ad<com.baidu.tieba.frs.aggregation.g> dNp;
    private a eeM;
    private boolean eeN;
    private boolean eeO;
    private b eeu;
    private com.baidu.tieba.frs.videomiddlepage.controller.a eev;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dNu);
        this.Sj = new ArrayList();
        this.mHandler = new Handler();
        this.eeN = true;
        this.dNp = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.eeM != null && d.this.eeM != aVar2 && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            d.this.eeM.aCR();
                        }
                        if (d.this.eeM != aVar2) {
                            d.this.eeM = aVar2;
                        }
                        if (d.this.eeM != null) {
                            d.this.eeM.hq(d.this.eeN);
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
        this.dNn = aVar;
        this.dNo = z;
        this.eeu = bVar;
        this.mFrom = str;
        this.eev = new com.baidu.tieba.frs.videomiddlepage.controller.a();
        this.arh = str2;
        this.Sk = fVar;
    }

    public void hu(boolean z) {
        this.eeO = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.eeM != null) {
            this.dNm = true;
            this.eeM.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dNm) {
                            d.this.dNm = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dNo, this.mFrom, this.arh);
        if (this.eev.hv(false)) {
            aVar.eev = this.eev;
        }
        aVar.b(this.dNp);
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
        if (!this.eeO) {
            if (!this.dNm) {
                aVar.aqe().a(gVar, i, this.dNn);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.px();
                }
                aVar.aqe().mPosition = i;
                aVar.aqe().setOnVideoContainerForegroundClickListener(this.eeu);
            } else {
                aVar.aqe().c(gVar, i, this.dNn);
            }
        }
        if (aVar.aqe() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.aqe().setCurrentPlayCallBack(this.Sk);
        }
        return aVar.getView();
    }

    public boolean pB() {
        if (this.eeM != null) {
            return this.eeM.isPlaying();
        }
        return false;
    }

    public void pz() {
        if (this.eeM != null) {
            this.eeM.aCQ();
        }
    }

    public void pA() {
        if (this.eeM != null) {
            this.eeM.aCR();
        }
    }

    public void onDestroy() {
        if (this.eev != null) {
            this.eev.aHN();
        }
        for (a aVar : this.Sj) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean mu(int i) {
        if (this.eeM == null) {
            return false;
        }
        return this.eeM.mu(i);
    }
}
