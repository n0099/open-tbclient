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
    private String anG;
    private boolean dGN;
    private com.baidu.tieba.frs.aggregation.a dGO;
    private boolean dGP;
    private ad<com.baidu.tieba.frs.aggregation.g> dGQ;
    private b dXR;
    private com.baidu.tieba.frs.videomiddlepage.controller.a dXS;
    private a dYj;
    private boolean dYk;
    private boolean dYl;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dGV);
        this.Sj = new ArrayList();
        this.mHandler = new Handler();
        this.dYk = true;
        this.dGQ = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.dYj != null && d.this.dYj != aVar2 && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            d.this.dYj.aBh();
                        }
                        if (d.this.dYj != aVar2) {
                            d.this.dYj = aVar2;
                        }
                        if (d.this.dYj != null) {
                            d.this.dYj.ho(d.this.dYk);
                        }
                    }
                    if (view.getId() == e.g.title) {
                        am amVar = new am("c12411");
                        amVar.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == e.g.thread_info_commont_container || view.getId() == e.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                    } else if (view.getId() == e.g.user_icon || view.getId() == e.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                    } else if (view.getId() == e.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == e.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.ax(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.ax("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dGO = aVar;
        this.dGP = z;
        this.dXR = bVar;
        this.mFrom = str;
        this.dXS = new com.baidu.tieba.frs.videomiddlepage.controller.a();
        this.anG = str2;
        this.Sk = fVar;
    }

    public void hs(boolean z) {
        this.dYl = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dYj != null) {
            this.dGN = true;
            this.dYj.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dGN) {
                            d.this.dGN = false;
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
        a aVar = new a(this.mPageContext, this.dGP, this.mFrom, this.anG);
        if (this.dXS.ht(false)) {
            aVar.dXS = this.dXS;
        }
        aVar.b(this.dGQ);
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
        if (!this.dYl) {
            if (!this.dGN) {
                aVar.aor().a(gVar, i, this.dGO);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.py();
                }
                aVar.aor().mPosition = i;
                aVar.aor().setOnVideoContainerForegroundClickListener(this.dXR);
            } else {
                aVar.aor().c(gVar, i, this.dGO);
            }
        }
        if (aVar.aor() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.aor().setCurrentPlayCallBack(this.Sk);
        }
        return aVar.getView();
    }

    public boolean pC() {
        if (this.dYj != null) {
            return this.dYj.isPlaying();
        }
        return false;
    }

    public void pA() {
        if (this.dYj != null) {
            this.dYj.aBg();
        }
    }

    public void pB() {
        if (this.dYj != null) {
            this.dYj.aBh();
        }
    }

    public void onDestroy() {
        if (this.dXS != null) {
            this.dXS.aGb();
        }
        for (a aVar : this.Sj) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean me(int i) {
        if (this.dYj == null) {
            return false;
        }
        return this.dYj.me(i);
    }
}
