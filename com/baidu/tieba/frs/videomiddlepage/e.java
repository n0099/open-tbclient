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
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Zc;
    private com.baidu.tieba.lego.card.view.f Ze;
    private String emE;
    private a iSM;
    private boolean iSN;
    private boolean iSO;
    private int iSP;
    private c iSl;
    private com.baidu.tieba.frs.videomiddlepage.a.a iSm;
    private b iSp;
    private com.baidu.tieba.lego.card.view.g iSr;
    private boolean iwt;
    private com.baidu.tieba.frs.aggregation.a iwu;
    private boolean iwv;
    private aa<com.baidu.tieba.frs.aggregation.g> iww;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.iwB);
        this.Zc = new ArrayList();
        this.mHandler = new Handler();
        this.iSN = true;
        this.iSP = 1;
        this.iww = new aa<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.iSM != null && e.this.iSM != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.iSM.cvu();
                        }
                        if (e.this.iSM != aVar2) {
                            e.this.iSM = aVar2;
                        }
                        if (e.this.iSM != null) {
                            e.this.iSM.pV(e.this.iSN);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        aq aqVar = new aq("c12411");
                        aqVar.dK("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar);
                        if (e.this.iSM != null && !e.this.iSM.cBf()) {
                            com.baidu.tieba.s.c.dDn().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.hIz, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        aq aqVar2 = new aq("c12414");
                        aqVar2.dK("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        aq aqVar3 = new aq("c12415");
                        aqVar3.dK("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar3.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar3);
                        com.baidu.tieba.s.c.dDn().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.hIz, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        aq aqVar4 = new aq("c12412");
                        aqVar4.dK("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar4.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar4);
                        com.baidu.tieba.s.c.dDn().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.hIz, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        aq aqVar5 = new aq("c12413");
                        aqVar5.dK("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar5.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        aq aqVar6 = new aq("c12416");
                        aqVar6.dK("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            aqVar6.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(aqVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.iwu = aVar;
        this.iwv = z;
        this.iSl = cVar;
        this.mFrom = str;
        this.iSm = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.emE = str2;
        this.Ze = fVar;
        this.iSp = bVar;
        this.iSr = gVar;
    }

    public void qa(boolean z) {
        this.iSO = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.iSP) {
            this.iSP = i;
            if (this.iSM != null) {
                this.iwt = true;
                this.iSM.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.iwt) {
                                e.this.iwt = false;
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
    /* renamed from: aN */
    public com.baidu.tieba.card.a.a<a> c(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.iwv, this.mFrom, this.emE, this.iSp);
        aVar.c(this.iww);
        aVar.a(this.iSr);
        this.Zc.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (gVar.bjY() != null) {
            gVar.bjY().keyFromHomePage = this.mFrom;
        }
        if (!this.iSO) {
            if (!this.iwt) {
                aVar.cjq().a(gVar, i, this.iwu);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.rt();
                }
                aVar.cjq().mPosition = i;
                aVar.cjq().setOnVideoContainerForegroundClickListener(this.iSl);
            } else {
                aVar.cjq().c(gVar, i, this.iwu);
            }
        }
        if (aVar.cjq() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.cjq().setCurrentPlayCallBack(this.Ze);
        }
        String a2 = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bw bwVar = new bw();
        bwVar.setId(gVar.threadId);
        bwVar.setTid(gVar.threadId);
        bwVar.setBaijiahaoData(gVar.mBaijiahao);
        bwVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bwVar.setThreadType(40);
        com.baidu.tieba.s.c.dDn().a(this.mBdUniqueId, a2, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean rx() {
        if (this.iSM != null) {
            return this.iSM.isPlaying();
        }
        return false;
    }

    public boolean cAX() {
        if (this.iSM != null) {
            return this.iSM.cAX();
        }
        return false;
    }

    public void rv() {
        if (this.iSM != null) {
            this.iSM.pauseVideo();
        }
    }

    public void rw() {
        if (this.iSM != null) {
            this.iSM.cvu();
        }
    }

    public void cBk() {
        if (this.iSM != null) {
            this.iSM.cAY();
        }
    }

    public void onDestroy() {
        if (this.iSm != null) {
            this.iSm.cBq();
        }
        for (a aVar : this.Zc) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean yG(int i) {
        if (this.iSM == null) {
            return false;
        }
        return this.iSM.yG(i);
    }

    public void cBl() {
        if (this.iSM != null) {
            this.iSM.cBe();
        }
    }
}
