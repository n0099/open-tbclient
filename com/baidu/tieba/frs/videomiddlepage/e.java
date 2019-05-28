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
    private List<a> Rm;
    private com.baidu.tieba.lego.card.view.f Rn;
    private String bFP;
    private c fNE;
    private com.baidu.tieba.frs.videomiddlepage.a.a fNF;
    private b fNI;
    private com.baidu.tieba.lego.card.view.g fNK;
    private a fOe;
    private boolean fOf;
    private boolean fOg;
    private int fOh;
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
        this.Rm = new ArrayList();
        this.mHandler = new Handler();
        this.fOf = true;
        this.fOh = 1;
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
                        if (e.this.fOe != null && e.this.fOe != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fOe.bmf();
                        }
                        if (e.this.fOe != aVar2) {
                            e.this.fOe = aVar2;
                        }
                        if (e.this.fOe != null) {
                            e.this.fOe.kH(e.this.fOf);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        am amVar = new am("c12411");
                        amVar.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar);
                        if (e.this.fOe != null && !e.this.fOe.brg()) {
                            com.baidu.tieba.q.c.clv().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 1, gVar2.eAv, false, (String) null, (String) null));
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
                        com.baidu.tieba.q.c.clv().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 5, gVar2.eAv, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        am amVar4 = new am("c12412");
                        amVar4.bT("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            amVar4.bT("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(amVar4);
                        com.baidu.tieba.q.c.clv().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bgVar, "a023", "common_click", 2, gVar2.eAv, false, (String) null, (String) null));
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
        this.fNE = cVar;
        this.mFrom = str;
        this.fNF = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.bFP = str2;
        this.Rn = fVar;
        this.fNI = bVar;
        this.fNK = gVar;
    }

    public void kL(boolean z) {
        this.fOg = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.fOh) {
            this.fOh = i;
            if (this.fOe != null) {
                this.fuH = true;
                this.fOe.onConfigurationChanged(configuration);
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
        a aVar = new a(this.mPageContext, this.fuJ, this.mFrom, this.bFP, this.fNI);
        aVar.d(this.fuK);
        aVar.a(this.fNK);
        this.Rm.add(aVar);
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
        if (!this.fOg) {
            if (!this.fuH) {
                aVar.aYs().a(gVar, i, this.fuI);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.oP();
                }
                aVar.aYs().mPosition = i;
                aVar.aYs().setOnVideoContainerForegroundClickListener(this.fNE);
            } else {
                aVar.aYs().c(gVar, i, this.fuI);
            }
        }
        if (aVar.aYs() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.aYs().setCurrentPlayCallBack(this.Rn);
        }
        gVar.eAv = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bg bgVar = new bg();
        bgVar.setId(str);
        bgVar.setTid(str);
        bgVar.setFid(com.baidu.adp.lib.g.b.c(gVar.forumId, 0L));
        bgVar.setThreadType(40);
        com.baidu.tieba.q.c.clv().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bgVar, "a023", "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean oT() {
        if (this.fOe != null) {
            return this.fOe.isPlaying();
        }
        return false;
    }

    public boolean bqY() {
        if (this.fOe != null) {
            return this.fOe.bqY();
        }
        return false;
    }

    public void oR() {
        if (this.fOe != null) {
            this.fOe.bme();
        }
    }

    public void oS() {
        if (this.fOe != null) {
            this.fOe.bmf();
        }
    }

    public void brl() {
        if (this.fOe != null) {
            this.fOe.bqZ();
        }
    }

    public void onDestroy() {
        if (this.fNF != null) {
            this.fNF.brq();
        }
        for (a aVar : this.Rm) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean rz(int i) {
        if (this.fOe == null) {
            return false;
        }
        return this.fOe.rz(i);
    }

    public void brm() {
        if (this.fOe != null) {
            this.fOe.brf();
        }
    }
}
