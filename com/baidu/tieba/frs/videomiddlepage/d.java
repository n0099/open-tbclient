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
    private List<a> Sh;
    private com.baidu.tieba.lego.card.view.f Si;
    private String amT;
    private boolean dFA;
    private ad<com.baidu.tieba.frs.aggregation.g> dFB;
    private boolean dFy;
    private com.baidu.tieba.frs.aggregation.a dFz;
    private b dWE;
    private com.baidu.tieba.frs.videomiddlepage.controller.a dWF;
    private a dWW;
    private boolean dWX;
    private boolean dWY;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, b bVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.dFG);
        this.Sh = new ArrayList();
        this.mHandler = new Handler();
        this.dWX = true;
        this.dFB = new ad<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    if ((view.getId() == e.g.video_container || view.getId() == e.g.video_agg_container || view.getId() == e.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (d.this.dWW != null && d.this.dWW != aVar2 && (view.getId() == e.g.video_container || view.getId() == e.g.mobile_network_play)) {
                            d.this.dWW.aBK();
                        }
                        if (d.this.dWW != aVar2) {
                            d.this.dWW = aVar2;
                        }
                        if (d.this.dWW != null) {
                            d.this.dWW.he(d.this.dWX);
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
        this.dFz = aVar;
        this.dFA = z;
        this.dWE = bVar;
        this.mFrom = str;
        this.dWF = new com.baidu.tieba.frs.videomiddlepage.controller.a();
        this.amT = str2;
        this.Si = fVar;
    }

    public void hi(boolean z) {
        this.dWY = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.dWW != null) {
            this.dFy = true;
            this.dWW.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (d.this.dFy) {
                            d.this.dFy = false;
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
        a aVar = new a(this.mPageContext, this.dFA, this.mFrom, this.amT);
        if (this.dWF.hj(false)) {
            aVar.dWF = this.dWF;
        }
        aVar.b(this.dFB);
        this.Sh.add(aVar);
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
        if (!this.dWY) {
            if (!this.dFy) {
                aVar.aoQ().a(gVar, i, this.dFz);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pA();
                }
                aVar.aoQ().mPosition = i;
                aVar.aoQ().setOnVideoContainerForegroundClickListener(this.dWE);
            } else {
                aVar.aoQ().c(gVar, i, this.dFz);
            }
        }
        if (aVar.aoQ() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.aoQ().setCurrentPlayCallBack(this.Si);
        }
        return aVar.getView();
    }

    public boolean pE() {
        if (this.dWW != null) {
            return this.dWW.isPlaying();
        }
        return false;
    }

    public void pC() {
        if (this.dWW != null) {
            this.dWW.aBJ();
        }
    }

    public void pD() {
        if (this.dWW != null) {
            this.dWW.aBK();
        }
    }

    public void onDestroy() {
        if (this.dWF != null) {
            this.dWF.aGD();
        }
        for (a aVar : this.Sh) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean lM(int i) {
        if (this.dWW == null) {
            return false;
        }
        return this.dWW.lM(i);
    }
}
