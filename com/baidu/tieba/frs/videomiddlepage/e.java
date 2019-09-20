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
    private List<a> RC;
    private com.baidu.tieba.lego.card.view.f RD;
    private String bHq;
    private boolean fCe;
    private com.baidu.tieba.frs.aggregation.a fCf;
    private boolean fCg;
    private ab<com.baidu.tieba.frs.aggregation.g> fCh;
    private a fVK;
    private boolean fVL;
    private boolean fVM;
    private int fVN;
    private c fVk;
    private com.baidu.tieba.frs.videomiddlepage.a.a fVl;
    private b fVo;
    private com.baidu.tieba.lego.card.view.g fVq;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.fCm);
        this.RC = new ArrayList();
        this.mHandler = new Handler();
        this.fVL = true;
        this.fVN = 1;
        this.fCh = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bh bhVar = new bh();
                    bhVar.setId(str3);
                    bhVar.setTid(str3);
                    bhVar.setFid(com.baidu.adp.lib.g.b.e(gVar2.forumId, 0L));
                    bhVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.fVK != null && e.this.fVK != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fVK.bpe();
                        }
                        if (e.this.fVK != aVar2) {
                            e.this.fVK = aVar2;
                        }
                        if (e.this.fVK != null) {
                            e.this.fVK.kV(e.this.fVL);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.fVK != null && !e.this.fVK.buk()) {
                            com.baidu.tieba.q.c.cpt().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, "a023", "common_click", 1, gVar2.eHh, false, (String) null, (String) null));
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
                        com.baidu.tieba.q.c.cpt().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, "a023", "common_click", 5, gVar2.eHh, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.q.c.cpt().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, "a023", "common_click", 2, gVar2.eHh, false, (String) null, (String) null));
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
        this.fCf = aVar;
        this.fCg = z;
        this.fVk = cVar;
        this.mFrom = str;
        this.fVl = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.bHq = str2;
        this.RD = fVar;
        this.fVo = bVar;
        this.fVq = gVar;
    }

    public void kZ(boolean z) {
        this.fVM = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.fVN) {
            this.fVN = i;
            if (this.fVK != null) {
                this.fCe = true;
                this.fVK.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.fCe) {
                                e.this.fCe = false;
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
        a aVar = new a(this.mPageContext, this.fCg, this.mFrom, this.bHq, this.fVo);
        aVar.d(this.fCh);
        aVar.a(this.fVq);
        this.RC.add(aVar);
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
        if (!this.fVM) {
            if (!this.fCe) {
                aVar.baX().a(gVar, i, this.fCf);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pl();
                }
                aVar.baX().mPosition = i;
                aVar.baX().setOnVideoContainerForegroundClickListener(this.fVk);
            } else {
                aVar.baX().c(gVar, i, this.fCf);
            }
        }
        if (aVar.baX() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.baX().setCurrentPlayCallBack(this.RD);
        }
        gVar.eHh = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bh bhVar = new bh();
        bhVar.setId(str);
        bhVar.setTid(str);
        bhVar.setFid(com.baidu.adp.lib.g.b.e(gVar.forumId, 0L));
        bhVar.setThreadType(40);
        com.baidu.tieba.q.c.cpt().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bhVar, "a023", "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pp() {
        if (this.fVK != null) {
            return this.fVK.isPlaying();
        }
        return false;
    }

    public boolean buc() {
        if (this.fVK != null) {
            return this.fVK.buc();
        }
        return false;
    }

    public void pn() {
        if (this.fVK != null) {
            this.fVK.bpd();
        }
    }

    public void po() {
        if (this.fVK != null) {
            this.fVK.bpe();
        }
    }

    public void bup() {
        if (this.fVK != null) {
            this.fVK.bud();
        }
    }

    public void onDestroy() {
        if (this.fVl != null) {
            this.fVl.buu();
        }
        for (a aVar : this.RC) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean rW(int i) {
        if (this.fVK == null) {
            return false;
        }
        return this.fVK.rW(i);
    }

    public void buq() {
        if (this.fVK != null) {
            this.fVK.buj();
        }
    }
}
