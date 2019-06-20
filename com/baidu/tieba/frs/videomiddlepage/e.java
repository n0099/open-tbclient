package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Rl;
    private com.baidu.tieba.lego.card.view.f Rm;
    private String bFQ;
    private c fNG;
    private com.baidu.tieba.frs.videomiddlepage.a.a fNH;
    private b fNK;
    private com.baidu.tieba.lego.card.view.g fNM;
    private a fOg;
    private boolean fOh;
    private boolean fOi;
    private int fOj;
    private boolean fuH;
    private com.baidu.tieba.frs.aggregation.a fuI;
    private boolean fuJ;
    private ab<com.baidu.tieba.frs.aggregation.g> fuK;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.fuP);
        this.Rl = new ArrayList();
        this.mHandler = new Handler();
        this.fOh = true;
        this.fOj = 1;
        this.fuK = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bg bgVar = new bg();
                    bgVar.setId(str3);
                    bgVar.setTid(str3);
                    bgVar.setFid(com.baidu.adp.lib.g.b.c(gVar2.forumId, 0L));
                    bgVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.fOg != null && e.this.fOg != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fOg.bmf();
                        }
                        if (e.this.fOg != aVar2) {
                            e.this.fOg = aVar2;
                        }
                        if (e.this.fOg != null) {
                            e.this.fOg.kI(e.this.fOh);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        am amVar = new am("c12411");
                        amVar.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                        if (e.this.fOg != null && !e.this.fOg.bri()) {
                            com.baidu.tieba.q.c.clw().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 1, gVar2.eAv, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        am amVar2 = new am("c12414");
                        amVar2.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        am amVar3 = new am("c12415");
                        amVar3.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar3);
                        com.baidu.tieba.q.c.clw().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 5, gVar2.eAv, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                        com.baidu.tieba.q.c.clw().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 2, gVar2.eAv, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        am amVar5 = new am("c12413");
                        amVar5.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        am amVar6 = new am("c12416");
                        amVar6.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.fuI = aVar;
        this.fuJ = z;
        this.fNG = cVar;
        this.mFrom = str;
        this.fNH = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.bFQ = str2;
        this.Rm = fVar;
        this.fNK = bVar;
        this.fNM = gVar;
    }

    public void kM(boolean z) {
        this.fOi = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.fOj) {
            this.fOj = i;
            if (this.fOg != null) {
                this.fuH = true;
                this.fOg.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.fuH) {
                                e.this.fuH = false;
                            }
                        }
                    }, 500L);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.fuJ, this.mFrom, this.bFQ, this.fNK);
        aVar.d(this.fuK);
        aVar.a(this.fNM);
        this.Rl.add(aVar);
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
        if (!this.fOi) {
            if (!this.fuH) {
                aVar.aYs().a(gVar, i, this.fuI);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.oP();
                }
                aVar.aYs().mPosition = i;
                aVar.aYs().setOnVideoContainerForegroundClickListener(this.fNG);
            } else {
                aVar.aYs().c(gVar, i, this.fuI);
            }
        }
        if (aVar.aYs() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.aYs().setCurrentPlayCallBack(this.Rm);
        }
        gVar.eAv = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bg bgVar = new bg();
        bgVar.setId(str);
        bgVar.setTid(str);
        bgVar.setFid(com.baidu.adp.lib.g.b.c(gVar.forumId, 0L));
        bgVar.setThreadType(40);
        com.baidu.tieba.q.c.clw().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bgVar, "a023", "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean oT() {
        if (this.fOg != null) {
            return this.fOg.isPlaying();
        }
        return false;
    }

    public boolean bra() {
        if (this.fOg != null) {
            return this.fOg.bra();
        }
        return false;
    }

    public void oR() {
        if (this.fOg != null) {
            this.fOg.bme();
        }
    }

    public void oS() {
        if (this.fOg != null) {
            this.fOg.bmf();
        }
    }

    public void brn() {
        if (this.fOg != null) {
            this.fOg.brb();
        }
    }

    public void onDestroy() {
        if (this.fNH != null) {
            this.fNH.brs();
        }
        for (a aVar : this.Rl) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean rz(int i) {
        if (this.fOg == null) {
            return false;
        }
        return this.fOg.rz(i);
    }

    public void bro() {
        if (this.fOg != null) {
            this.fOg.brh();
        }
    }
}
