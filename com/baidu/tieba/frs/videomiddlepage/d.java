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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Pr;
    private com.baidu.tieba.lego.card.view.f Ps;
    private String agd;
    private b dEQ;
    private com.baidu.tieba.frs.videomiddlepage.a.a dER;
    private a dFl;
    private boolean dFm;
    private boolean dFn;
    private boolean dot;
    private com.baidu.tieba.frs.aggregation.a dou;
    private boolean dov;
    private ad<com.baidu.tieba.frs.aggregation.g> dow;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.doB);
        this.Pr = new ArrayList();
        this.mHandler = new Handler();
        this.dFm = true;
        this.dow = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.dFl != null && d.this.dFl != aVar2 && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            d.this.dFl.avA();
                        }
                        if (d.this.dFl != aVar2) {
                            d.this.dFl = aVar2;
                        }
                        if (d.this.dFl != null) {
                            d.this.dFl.go(d.this.dFm);
                        }
                    }
                    if (view.getId() == d.g.title) {
                        an anVar = new an("c12411");
                        anVar.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == d.g.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == d.g.thread_info_commont_container || view.getId() == d.g.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == d.g.user_icon || view.getId() == d.g.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == d.g.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == d.g.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.ah(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.ah("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dou = aVar;
        this.dov = z;
        this.dEQ = bVar;
        this.mFrom = str;
        this.dER = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.agd = str2;
        this.Ps = fVar;
    }

    public void gq(boolean z) {
        this.dFn = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dFl != null) {
            this.dot = true;
            this.dFl.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dot) {
                            d.this.dot = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dov, this.mFrom, this.agd);
        if (this.dER.gr(false)) {
            aVar.dER = this.dER;
        }
        aVar.b(this.dow);
        this.Pr.add(aVar);
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
        if (!this.dFn) {
            if (!this.dot) {
                aVar.aja().a(gVar, i, this.dou);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.on();
                }
                aVar.aja().mPosition = i;
                aVar.aja().setOnVideoContainerForegroundClickListener(this.dEQ);
            } else {
                aVar.aja().c(gVar, i, this.dou);
            }
        }
        if (aVar.aja() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.aja().setCurrentPlayCallBack(this.Ps);
        }
        return aVar.getView();
    }

    public boolean or() {
        if (this.dFl != null) {
            return this.dFl.isPlaying();
        }
        return false;
    }

    public void go(boolean z) {
        this.dFm = z;
        if (this.dFl != null) {
            this.dFl.go(z);
        }
    }

    public void op() {
        if (this.dFl != null) {
            this.dFl.avz();
        }
    }

    public void oq() {
        if (this.dFl != null) {
            this.dFl.avA();
        }
    }

    public void onDestroy() {
        if (this.dER != null) {
            this.dER.aAx();
        }
        for (a aVar : this.Pr) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean kB(int i) {
        if (this.dFl == null) {
            return false;
        }
        return this.dFl.kB(i);
    }
}
