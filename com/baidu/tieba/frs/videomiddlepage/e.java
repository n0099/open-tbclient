package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> TA;
    private com.baidu.tieba.lego.card.view.f TB;
    private String byD;
    private boolean fes;
    private com.baidu.tieba.frs.aggregation.a fet;
    private boolean feu;
    private ab<com.baidu.tieba.frs.aggregation.g> fev;
    private c fwM;
    private com.baidu.tieba.frs.videomiddlepage.a.a fwN;
    private b fwQ;
    private a fxl;
    private boolean fxm;
    private boolean fxn;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.feA);
        this.TA = new ArrayList();
        this.mHandler = new Handler();
        this.fxm = true;
        this.fev = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar) {
                if (view != null && gVar != null) {
                    String str3 = gVar.threadId != null ? gVar.threadId : null;
                    bg bgVar = new bg();
                    bgVar.setId(str3);
                    bgVar.setTid(str3);
                    bgVar.setFid(com.baidu.adp.lib.g.b.d(gVar.forumId, 0L));
                    bgVar.setThreadType(40);
                    if ((view.getId() == d.g.video_container || view.getId() == d.g.video_agg_container || view.getId() == d.g.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.fxl != null && e.this.fxl != aVar2 && (view.getId() == d.g.video_container || view.getId() == d.g.mobile_network_play)) {
                            e.this.fxl.beK();
                        }
                        if (e.this.fxl != aVar2) {
                            e.this.fxl = aVar2;
                        }
                        if (e.this.fxl != null) {
                            e.this.fxl.jS(e.this.fxm);
                        }
                    }
                    if (view.getId() == d.g.title) {
                        am amVar = new am("c12411");
                        amVar.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                        if (e.this.fxl != null && !e.this.fxl.bjL()) {
                            com.baidu.tieba.q.c.cdp().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 1, gVar.ekF, false, null, null));
                        }
                    } else if (view.getId() == d.g.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == d.g.thread_info_commont_container || view.getId() == d.g.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                        com.baidu.tieba.q.c.cdp().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 5, gVar.ekF, false, null, null));
                    } else if (view.getId() == d.g.user_icon || view.getId() == d.g.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                        com.baidu.tieba.q.c.cdp().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 2, gVar.ekF, false, null, null));
                    } else if (view.getId() == d.g.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == d.g.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.bJ(ImageViewerConfig.FORUM_ID, gVar.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.bJ("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.fet = aVar;
        this.feu = z;
        this.fwM = cVar;
        this.mFrom = str;
        this.fwN = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.byD = str2;
        this.TB = fVar;
        this.fwQ = bVar;
    }

    public void jW(boolean z) {
        this.fxn = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fxl != null) {
            this.fes = true;
            this.fxl.onConfigurationChanged(configuration);
            if (configuration.orientation == 1) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.fes) {
                            e.this.fes = false;
                        }
                    }
                }, 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.feu, this.mFrom, this.byD, this.fwQ);
        aVar.d(this.fev);
        this.TA.add(aVar);
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
        if (!this.fxn) {
            if (!this.fes) {
                aVar.aRg().a(gVar, i, this.fet);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pU();
                }
                aVar.aRg().mPosition = i;
                aVar.aRg().setOnVideoContainerForegroundClickListener(this.fwM);
            } else {
                aVar.aRg().c(gVar, i, this.fet);
            }
        }
        if (aVar.aRg() instanceof com.baidu.tieba.lego.card.view.g) {
            aVar.aRg().setCurrentPlayCallBack(this.TB);
        }
        gVar.ekF = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bg bgVar = new bg();
        bgVar.setId(str);
        bgVar.setTid(str);
        bgVar.setFid(com.baidu.adp.lib.g.b.d(gVar.forumId, 0L));
        bgVar.setThreadType(40);
        com.baidu.tieba.q.c.cdp().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bgVar, "a023", "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pY() {
        if (this.fxl != null) {
            return this.fxl.isPlaying();
        }
        return false;
    }

    public boolean bjD() {
        if (this.fxl != null) {
            return this.fxl.bjD();
        }
        return false;
    }

    public void pW() {
        if (this.fxl != null) {
            this.fxl.beJ();
        }
    }

    public void pX() {
        if (this.fxl != null) {
            this.fxl.beK();
        }
    }

    public void bjQ() {
        if (this.fxl != null) {
            this.fxl.bjE();
        }
    }

    public void onDestroy() {
        if (this.fwN != null) {
            this.fwN.bjV();
        }
        for (a aVar : this.TA) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean qs(int i) {
        if (this.fxl == null) {
            return false;
        }
        return this.fxl.qs(i);
    }

    public void bjR() {
        if (this.fxl != null) {
            this.fxl.bjK();
        }
    }
}
