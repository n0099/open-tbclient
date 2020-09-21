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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> YM;
    private com.baidu.tieba.lego.card.view.f YN;
    private String eaC;
    private com.baidu.tieba.lego.card.view.g iDB;
    private a iDW;
    private boolean iDX;
    private boolean iDY;
    private int iDZ;
    private c iDv;
    private com.baidu.tieba.frs.videomiddlepage.a.a iDw;
    private b iDz;
    private boolean ihw;
    private com.baidu.tieba.frs.aggregation.a ihx;
    private boolean ihy;
    private aa<com.baidu.tieba.frs.aggregation.g> ihz;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.ihE);
        this.YM = new ArrayList();
        this.mHandler = new Handler();
        this.iDX = true;
        this.iDZ = 1;
        this.ihz = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bw bwVar = new bw();
                    bwVar.setId(str3);
                    bwVar.setTid(str3);
                    bwVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar2.forumId, 0L));
                    bwVar.setBaijiahaoData(gVar2.mBaijiahao);
                    bwVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.iDW != null && e.this.iDW != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.iDW.crX();
                        }
                        if (e.this.iDW != aVar2) {
                            e.this.iDW = aVar2;
                        }
                        if (e.this.iDW != null) {
                            e.this.iDW.pq(e.this.iDX);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dF("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                        if (e.this.iDW != null && !e.this.iDW.cxI()) {
                            com.baidu.tieba.s.c.dzC().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.htF, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dF("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dF("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                        com.baidu.tieba.s.c.dzC().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.htF, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dF("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                        com.baidu.tieba.s.c.dzC().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.htF, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dF("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dF("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.ihx = aVar;
        this.ihy = z;
        this.iDv = cVar;
        this.mFrom = str;
        this.iDw = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.eaC = str2;
        this.YN = fVar;
        this.iDz = bVar;
        this.iDB = gVar;
    }

    public void pv(boolean z) {
        this.iDY = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.iDZ) {
            this.iDZ = i;
            if (this.iDW != null) {
                this.ihw = true;
                this.iDW.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.ihw) {
                                e.this.ihw = false;
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
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.ihy, this.mFrom, this.eaC, this.iDz);
        aVar.c(this.ihz);
        aVar.a(this.iDB);
        this.YM.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (gVar.bhp() != null) {
            gVar.bhp().keyFromHomePage = this.mFrom;
        }
        if (!this.iDY) {
            if (!this.ihw) {
                aVar.cfU().a(gVar, i, this.ihx);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.rt();
                }
                aVar.cfU().mPosition = i;
                aVar.cfU().setOnVideoContainerForegroundClickListener(this.iDv);
            } else {
                aVar.cfU().c(gVar, i, this.ihx);
            }
        }
        if (aVar.cfU() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.cfU().setCurrentPlayCallBack(this.YN);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bw bwVar = new bw();
        bwVar.setId(gVar.threadId);
        bwVar.setTid(gVar.threadId);
        bwVar.setBaijiahaoData(gVar.mBaijiahao);
        bwVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bwVar.setThreadType(40);
        com.baidu.tieba.s.c.dzC().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean rx() {
        if (this.iDW != null) {
            return this.iDW.isPlaying();
        }
        return false;
    }

    public boolean cxA() {
        if (this.iDW != null) {
            return this.iDW.cxA();
        }
        return false;
    }

    public void rv() {
        if (this.iDW != null) {
            this.iDW.crW();
        }
    }

    public void rw() {
        if (this.iDW != null) {
            this.iDW.crX();
        }
    }

    public void cxN() {
        if (this.iDW != null) {
            this.iDW.cxB();
        }
    }

    public void onDestroy() {
        if (this.iDw != null) {
            this.iDw.cxT();
        }
        for (a aVar : this.YM) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean ya(int i) {
        if (this.iDW == null) {
            return false;
        }
        return this.iDW.ya(i);
    }

    public void cxO() {
        if (this.iDW != null) {
            this.iDW.cxH();
        }
    }
}
