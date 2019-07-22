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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> RD;
    private com.baidu.tieba.lego.card.view.f RE;
    private String bGR;
    private c fSD;
    private com.baidu.tieba.frs.videomiddlepage.a.a fSE;
    private b fSH;
    private com.baidu.tieba.lego.card.view.g fSJ;
    private a fTd;
    private boolean fTe;
    private boolean fTf;
    private int fTg;
    private boolean fzD;
    private com.baidu.tieba.frs.aggregation.a fzE;
    private boolean fzF;
    private ab<com.baidu.tieba.frs.aggregation.g> fzG;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.fzL);
        this.RD = new ArrayList();
        this.mHandler = new Handler();
        this.fTe = true;
        this.fTg = 1;
        this.fzG = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.fTd != null && e.this.fTd != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fTd.bog();
                        }
                        if (e.this.fTd != aVar2) {
                            e.this.fTd = aVar2;
                        }
                        if (e.this.fTd != null) {
                            e.this.fTd.kS(e.this.fTe);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.fTd != null && !e.this.fTd.btj()) {
                            com.baidu.tieba.q.c.coo().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 1, gVar2.eFr, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.q.c.coo().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 5, gVar2.eFr, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.q.c.coo().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 2, gVar2.eFr, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.fzE = aVar;
        this.fzF = z;
        this.fSD = cVar;
        this.mFrom = str;
        this.fSE = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.bGR = str2;
        this.RE = fVar;
        this.fSH = bVar;
        this.fSJ = gVar;
    }

    public void kW(boolean z) {
        this.fTf = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.fTg) {
            this.fTg = i;
            if (this.fTd != null) {
                this.fzD = true;
                this.fTd.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.fzD) {
                                e.this.fzD = false;
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
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<a> onCreateViewHolder(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.fzF, this.mFrom, this.bGR, this.fSH);
        aVar.d(this.fzG);
        aVar.a(this.fSJ);
        this.RD.add(aVar);
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
        if (!this.fTf) {
            if (!this.fzD) {
                aVar.bar().a(gVar, i, this.fzE);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pk();
                }
                aVar.bar().mPosition = i;
                aVar.bar().setOnVideoContainerForegroundClickListener(this.fSD);
            } else {
                aVar.bar().c(gVar, i, this.fzE);
            }
        }
        if (aVar.bar() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bar().setCurrentPlayCallBack(this.RE);
        }
        gVar.eFr = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bg bgVar = new bg();
        bgVar.setId(str);
        bgVar.setTid(str);
        bgVar.setFid(com.baidu.adp.lib.g.b.c(gVar.forumId, 0L));
        bgVar.setThreadType(40);
        com.baidu.tieba.q.c.coo().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bgVar, "a023", "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean po() {
        if (this.fTd != null) {
            return this.fTd.isPlaying();
        }
        return false;
    }

    public boolean btb() {
        if (this.fTd != null) {
            return this.fTd.btb();
        }
        return false;
    }

    public void pm() {
        if (this.fTd != null) {
            this.fTd.bof();
        }
    }

    public void pn() {
        if (this.fTd != null) {
            this.fTd.bog();
        }
    }

    public void bto() {
        if (this.fTd != null) {
            this.fTd.btc();
        }
    }

    public void onDestroy() {
        if (this.fSE != null) {
            this.fSE.btt();
        }
        for (a aVar : this.RD) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean rR(int i) {
        if (this.fTd == null) {
            return false;
        }
        return this.fTd.rR(i);
    }

    public void btp() {
        if (this.fTd != null) {
            this.fTd.bti();
        }
    }
}
