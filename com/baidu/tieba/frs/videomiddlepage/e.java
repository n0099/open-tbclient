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
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Ze;
    private com.baidu.tieba.lego.card.view.f Zf;
    private String eAX;
    private boolean iOM;
    private com.baidu.tieba.frs.aggregation.a iON;
    private boolean iOO;
    private ab<com.baidu.tieba.frs.aggregation.g> iOP;
    private c jkF;
    private com.baidu.tieba.frs.videomiddlepage.a.a jkG;
    private b jkJ;
    private com.baidu.tieba.lego.card.view.g jkL;
    private a jlg;
    private boolean jlh;
    private boolean jli;
    private int jlj;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.iOU);
        this.Ze = new ArrayList();
        this.mHandler = new Handler();
        this.jlh = true;
        this.jlj = 1;
        this.iOP = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
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
                        if (e.this.jlg != null && e.this.jlg != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.jlg.cBc();
                        }
                        if (e.this.jlg != aVar2) {
                            e.this.jlg = aVar2;
                        }
                        if (e.this.jlg != null) {
                            e.this.jlg.qw(e.this.jlh);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                        if (e.this.jlg != null && !e.this.jlg.cGN()) {
                            com.baidu.tieba.s.c.dIX().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.iaT, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                        com.baidu.tieba.s.c.dIX().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.iaT, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                        com.baidu.tieba.s.c.dIX().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.iaT, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dR("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iON = aVar;
        this.iOO = z;
        this.jkF = cVar;
        this.mFrom = str;
        this.jkG = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.eAX = str2;
        this.Zf = fVar;
        this.jkJ = bVar;
        this.jkL = gVar;
    }

    public void qB(boolean z) {
        this.jli = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.jlj) {
            this.jlj = i;
            if (this.jlg != null) {
                this.iOM = true;
                this.jlg.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.iOM) {
                                e.this.iOM = false;
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
    /* renamed from: aP */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.iOO, this.mFrom, this.eAX, this.jkJ);
        aVar.c(this.iOP);
        aVar.a(this.jkL);
        this.Ze.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (gVar.bor() != null) {
            gVar.bor().keyFromHomePage = this.mFrom;
        }
        if (!this.jli) {
            if (!this.iOM) {
                aVar.coY().a(gVar, i, this.iON);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.rt();
                }
                aVar.coY().mPosition = i;
                aVar.coY().setOnVideoContainerForegroundClickListener(this.jkF);
            } else {
                aVar.coY().c(gVar, i, this.iON);
            }
        }
        if (aVar.coY() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.coY().setCurrentPlayCallBack(this.Zf);
        }
        String a2 = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bw bwVar = new bw();
        bwVar.setId(gVar.threadId);
        bwVar.setTid(gVar.threadId);
        bwVar.setBaijiahaoData(gVar.mBaijiahao);
        bwVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bwVar.setThreadType(40);
        com.baidu.tieba.s.c.dIX().a(this.mBdUniqueId, a2, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean rx() {
        if (this.jlg != null) {
            return this.jlg.isPlaying();
        }
        return false;
    }

    public boolean cGF() {
        if (this.jlg != null) {
            return this.jlg.cGF();
        }
        return false;
    }

    public void rv() {
        if (this.jlg != null) {
            this.jlg.pauseVideo();
        }
    }

    public void rw() {
        if (this.jlg != null) {
            this.jlg.cBc();
        }
    }

    public void cGS() {
        if (this.jlg != null) {
            this.jlg.cGG();
        }
    }

    public void onDestroy() {
        if (this.jkG != null) {
            this.jkG.cGY();
        }
        for (a aVar : this.Ze) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean zm(int i) {
        if (this.jlg == null) {
            return false;
        }
        return this.jlg.zm(i);
    }

    public void cGT() {
        if (this.jlg != null) {
            this.jlg.cGM();
        }
    }
}
