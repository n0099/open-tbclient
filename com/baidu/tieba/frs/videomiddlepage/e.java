package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
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
    private String bGS;
    private boolean fAr;
    private com.baidu.tieba.frs.aggregation.a fAs;
    private boolean fAt;
    private ab<com.baidu.tieba.frs.aggregation.g> fAu;
    private a fTT;
    private boolean fTU;
    private boolean fTV;
    private int fTW;
    private c fTt;
    private com.baidu.tieba.frs.videomiddlepage.a.a fTu;
    private b fTx;
    private com.baidu.tieba.lego.card.view.g fTz;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.fAz);
        this.RD = new ArrayList();
        this.mHandler = new Handler();
        this.fTU = true;
        this.fTW = 1;
        this.fAu = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bh bhVar = new bh();
                    bhVar.setId(str3);
                    bhVar.setTid(str3);
                    bhVar.setFid(com.baidu.adp.lib.g.b.c(gVar2.forumId, 0L));
                    bhVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.fTT != null && e.this.fTT != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fTT.bot();
                        }
                        if (e.this.fTT != aVar2) {
                            e.this.fTT = aVar2;
                        }
                        if (e.this.fTT != null) {
                            e.this.fTT.kS(e.this.fTU);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.fTT != null && !e.this.fTT.btw()) {
                            com.baidu.tieba.q.c.coG().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, "a023", "common_click", 1, gVar2.eFy, false, (String) null, (String) null));
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
                        com.baidu.tieba.q.c.coG().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, "a023", "common_click", 5, gVar2.eFy, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.q.c.coG().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, "a023", "common_click", 2, gVar2.eFy, false, (String) null, (String) null));
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
        this.fAs = aVar;
        this.fAt = z;
        this.fTt = cVar;
        this.mFrom = str;
        this.fTu = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.bGS = str2;
        this.RE = fVar;
        this.fTx = bVar;
        this.fTz = gVar;
    }

    public void kW(boolean z) {
        this.fTV = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.fTW) {
            this.fTW = i;
            if (this.fTT != null) {
                this.fAr = true;
                this.fTT.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.fAr) {
                                e.this.fAr = false;
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
        a aVar = new a(this.mPageContext, this.fAt, this.mFrom, this.bGS, this.fTx);
        aVar.d(this.fAu);
        aVar.a(this.fTz);
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
        if (!this.fTV) {
            if (!this.fAr) {
                aVar.bat().a(gVar, i, this.fAs);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pk();
                }
                aVar.bat().mPosition = i;
                aVar.bat().setOnVideoContainerForegroundClickListener(this.fTt);
            } else {
                aVar.bat().c(gVar, i, this.fAs);
            }
        }
        if (aVar.bat() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bat().setCurrentPlayCallBack(this.RE);
        }
        gVar.eFy = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bh bhVar = new bh();
        bhVar.setId(str);
        bhVar.setTid(str);
        bhVar.setFid(com.baidu.adp.lib.g.b.c(gVar.forumId, 0L));
        bhVar.setThreadType(40);
        com.baidu.tieba.q.c.coG().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bhVar, "a023", "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean po() {
        if (this.fTT != null) {
            return this.fTT.isPlaying();
        }
        return false;
    }

    public boolean bto() {
        if (this.fTT != null) {
            return this.fTT.bto();
        }
        return false;
    }

    public void pm() {
        if (this.fTT != null) {
            this.fTT.bos();
        }
    }

    public void pn() {
        if (this.fTT != null) {
            this.fTT.bot();
        }
    }

    public void btB() {
        if (this.fTT != null) {
            this.fTT.btp();
        }
    }

    public void onDestroy() {
        if (this.fTu != null) {
            this.fTu.btG();
        }
        for (a aVar : this.RD) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean rT(int i) {
        if (this.fTT == null) {
            return false;
        }
        return this.fTT.rT(i);
    }

    public void btC() {
        if (this.fTT != null) {
            this.fTT.btv();
        }
    }
}
