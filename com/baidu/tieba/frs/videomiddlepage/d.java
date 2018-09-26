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
    private List<a> RR;
    private com.baidu.tieba.lego.card.view.f RT;
    private String ahY;
    private b dOI;
    private com.baidu.tieba.frs.videomiddlepage.controller.a dOJ;
    private a dPa;
    private boolean dPb;
    private boolean dPc;
    private ad<com.baidu.tieba.frs.aggregation.g> dxA;
    private boolean dxx;
    private com.baidu.tieba.frs.aggregation.a dxy;
    private boolean dxz;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dxF);
        this.RR = new ArrayList();
        this.mHandler = new Handler();
        this.dPb = true;
        this.dxA = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.dPa != null && d.this.dPa != aVar2 && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            d.this.dPa.ayo();
                        }
                        if (d.this.dPa != aVar2) {
                            d.this.dPa = aVar2;
                        }
                        if (d.this.dPa != null) {
                            d.this.dPa.gM(d.this.dPb);
                        }
                    }
                    if (view.getId() == e.g.title) {
                        am amVar = new am("c12411");
                        amVar.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                    } else if (view.getId() == e.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.al("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == e.g.thread_info_commont_container || view.getId() == e.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.al("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                    } else if (view.getId() == e.g.user_icon || view.getId() == e.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.al("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                    } else if (view.getId() == e.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.al("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == e.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.al(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.al("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.dxy = aVar;
        this.dxz = z;
        this.dOI = bVar;
        this.mFrom = str;
        this.dOJ = new com.baidu.tieba.frs.videomiddlepage.controller.a();
        this.ahY = str2;
        this.RT = fVar;
    }

    public void gQ(boolean z) {
        this.dPc = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dPa != null) {
            this.dxx = true;
            this.dPa.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dxx) {
                            d.this.dxx = false;
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
        a aVar = new a(this.mPageContext, this.dxz, this.mFrom, this.ahY);
        if (this.dOJ.gR(false)) {
            aVar.dOJ = this.dOJ;
        }
        aVar.b(this.dxA);
        this.RR.add(aVar);
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
        if (!this.dPc) {
            if (!this.dxx) {
                aVar.aln().a(gVar, i, this.dxy);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.ps();
                }
                aVar.aln().mPosition = i;
                aVar.aln().setOnVideoContainerForegroundClickListener(this.dOI);
            } else {
                aVar.aln().c(gVar, i, this.dxy);
            }
        }
        if (aVar.aln() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.aln().setCurrentPlayCallBack(this.RT);
        }
        return aVar.getView();
    }

    public boolean pw() {
        if (this.dPa != null) {
            return this.dPa.isPlaying();
        }
        return false;
    }

    public void pu() {
        if (this.dPa != null) {
            this.dPa.ayn();
        }
    }

    public void pv() {
        if (this.dPa != null) {
            this.dPa.ayo();
        }
    }

    public void onDestroy() {
        if (this.dOJ != null) {
            this.dOJ.aDl();
        }
        for (a aVar : this.RR) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean lo(int i) {
        if (this.dPa == null) {
            return false;
        }
        return this.dPa.lo(i);
    }
}
