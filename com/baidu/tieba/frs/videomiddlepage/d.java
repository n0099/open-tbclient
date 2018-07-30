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
    private List<a> Po;
    private com.baidu.tieba.lego.card.view.f Pp;
    private String afx;
    private b dHD;
    private com.baidu.tieba.frs.videomiddlepage.a.a dHE;
    private a dHZ;
    private boolean dIa;
    private boolean dIb;
    private boolean drm;
    private com.baidu.tieba.frs.aggregation.a drn;
    private boolean dro;
    private ad<com.baidu.tieba.frs.aggregation.g> drp;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dru);
        this.Po = new ArrayList();
        this.mHandler = new Handler();
        this.dIa = true;
        this.drp = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.dHZ != null && d.this.dHZ != aVar2 && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            d.this.dHZ.awf();
                        }
                        if (d.this.dHZ != aVar2) {
                            d.this.dHZ = aVar2;
                        }
                        if (d.this.dHZ != null) {
                            d.this.dHZ.gq(d.this.dIa);
                        }
                    }
                    if (view.getId() == d.g.title) {
                        an anVar = new an("c12411");
                        anVar.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                    } else if (view.getId() == d.g.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == d.g.thread_info_commont_container || view.getId() == d.g.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                    } else if (view.getId() == d.g.user_icon || view.getId() == d.g.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == d.g.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == d.g.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.af(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.af("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.drn = aVar;
        this.dro = z;
        this.dHD = bVar;
        this.mFrom = str;
        this.dHE = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.afx = str2;
        this.Pp = fVar;
    }

    public void gs(boolean z) {
        this.dIb = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dHZ != null) {
            this.drm = true;
            this.dHZ.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.drm) {
                            d.this.drm = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.dro, this.mFrom, this.afx);
        if (this.dHE.gt(false)) {
            aVar.dHE = this.dHE;
        }
        aVar.b(this.drp);
        this.Po.add(aVar);
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
        if (!this.dIb) {
            if (!this.drm) {
                aVar.ajz().a(gVar, i, this.drn);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.op();
                }
                aVar.ajz().mPosition = i;
                aVar.ajz().setOnVideoContainerForegroundClickListener(this.dHD);
            } else {
                aVar.ajz().c(gVar, i, this.drn);
            }
        }
        if (aVar.ajz() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.ajz().setCurrentPlayCallBack(this.Pp);
        }
        return aVar.getView();
    }

    public boolean ot() {
        if (this.dHZ != null) {
            return this.dHZ.isPlaying();
        }
        return false;
    }

    public void gq(boolean z) {
        this.dIa = z;
        if (this.dHZ != null) {
            this.dHZ.gq(z);
        }
    }

    public void or() {
        if (this.dHZ != null) {
            this.dHZ.awe();
        }
    }

    public void os() {
        if (this.dHZ != null) {
            this.dHZ.awf();
        }
    }

    public void onDestroy() {
        if (this.dHE != null) {
            this.dHE.aBg();
        }
        for (a aVar : this.Po) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean kM(int i) {
        if (this.dHZ == null) {
            return false;
        }
        return this.dHZ.kM(i);
    }
}
