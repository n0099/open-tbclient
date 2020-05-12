package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.i;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Xb;
    private com.baidu.tieba.lego.card.view.f Xc;
    private String dop;
    private boolean het;
    private com.baidu.tieba.frs.aggregation.a heu;
    private boolean hev;
    private z<com.baidu.tieba.frs.aggregation.g> hew;
    private c hyY;
    private com.baidu.tieba.frs.videomiddlepage.a.a hyZ;
    private boolean hzA;
    private boolean hzB;
    private int hzC;
    private b hzc;
    private com.baidu.tieba.lego.card.view.g hze;
    private a hzz;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.heB);
        this.Xb = new ArrayList();
        this.mHandler = new Handler();
        this.hzA = true;
        this.hzC = 1;
        this.hew = new z<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bj bjVar = new bj();
                    bjVar.setId(str3);
                    bjVar.setTid(str3);
                    bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bjVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bjVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.hzz != null && e.this.hzz != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.hzz.bQX();
                        }
                        if (e.this.hzz != aVar2) {
                            e.this.hzz = aVar2;
                        }
                        if (e.this.hzz != null) {
                            e.this.hzz.ns(e.this.hzA);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.hzz != null && !e.this.hzz.bWl()) {
                            com.baidu.tieba.s.c.cVp().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.gsb, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.s.c.cVp().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.gsb, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.s.c.cVp().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.gsb, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.heu = aVar;
        this.hev = z;
        this.hyY = cVar;
        this.mFrom = str;
        this.hyZ = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.dop = str2;
        this.Xc = fVar;
        this.hzc = bVar;
        this.hze = gVar;
    }

    public void nx(boolean z) {
        this.hzB = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.hzC) {
            this.hzC = i;
            if (this.hzz != null) {
                this.het = true;
                this.hzz.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.het) {
                                e.this.het = false;
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
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.hev, this.mFrom, this.dop, this.hzc);
        aVar.c(this.hew);
        aVar.a(this.hze);
        this.Xb.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.hzB) {
            if (!this.het) {
                aVar.bFA().a(gVar, i, this.heu);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pr();
                }
                aVar.bFA().mPosition = i;
                aVar.bFA().setOnVideoContainerForegroundClickListener(this.hyY);
            } else {
                aVar.bFA().c(gVar, i, this.heu);
            }
        }
        if (aVar.bFA() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bFA().setCurrentPlayCallBack(this.Xc);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bj bjVar = new bj();
        bjVar.setId(gVar.threadId);
        bjVar.setTid(gVar.threadId);
        bjVar.setBaijiahaoData(gVar.mBaijiahao);
        bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bjVar.setThreadType(40);
        com.baidu.tieba.s.c.cVp().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pv() {
        if (this.hzz != null) {
            return this.hzz.isPlaying();
        }
        return false;
    }

    public boolean bWd() {
        if (this.hzz != null) {
            return this.hzz.bWd();
        }
        return false;
    }

    public void pt() {
        if (this.hzz != null) {
            this.hzz.bQW();
        }
    }

    public void pu() {
        if (this.hzz != null) {
            this.hzz.bQX();
        }
    }

    public void bWq() {
        if (this.hzz != null) {
            this.hzz.bWe();
        }
    }

    public void onDestroy() {
        if (this.hyZ != null) {
            this.hyZ.bWw();
        }
        for (a aVar : this.Xb) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean tF(int i) {
        if (this.hzz == null) {
            return false;
        }
        return this.hzz.tF(i);
    }

    public void bWr() {
        if (this.hzz != null) {
            this.hzz.bWk();
        }
    }
}
