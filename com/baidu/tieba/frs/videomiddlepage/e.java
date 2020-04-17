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
    private List<a> WY;
    private com.baidu.tieba.lego.card.view.f WZ;
    private String dol;
    private boolean hen;
    private com.baidu.tieba.frs.aggregation.a heo;
    private boolean hep;
    private z<com.baidu.tieba.frs.aggregation.g> heq;
    private c hyS;
    private com.baidu.tieba.frs.videomiddlepage.a.a hyT;
    private b hyW;
    private com.baidu.tieba.lego.card.view.g hyY;
    private a hzt;
    private boolean hzu;
    private boolean hzv;
    private int hzw;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.hev);
        this.WY = new ArrayList();
        this.mHandler = new Handler();
        this.hzu = true;
        this.hzw = 1;
        this.heq = new z<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.hzt != null && e.this.hzt != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.hzt.bQY();
                        }
                        if (e.this.hzt != aVar2) {
                            e.this.hzt = aVar2;
                        }
                        if (e.this.hzt != null) {
                            e.this.hzt.ns(e.this.hzu);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.hzt != null && !e.this.hzt.bWm()) {
                            com.baidu.tieba.s.c.cVr().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.grV, false, (String) null, (String) null));
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
                        com.baidu.tieba.s.c.cVr().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.grV, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cI("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.s.c.cVr().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.grV, false, (String) null, (String) null));
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
        this.heo = aVar;
        this.hep = z;
        this.hyS = cVar;
        this.mFrom = str;
        this.hyT = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.dol = str2;
        this.WZ = fVar;
        this.hyW = bVar;
        this.hyY = gVar;
    }

    public void nx(boolean z) {
        this.hzv = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.hzw) {
            this.hzw = i;
            if (this.hzt != null) {
                this.hen = true;
                this.hzt.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.hen) {
                                e.this.hen = false;
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
        a aVar = new a(this.mPageContext, this.hep, this.mFrom, this.dol, this.hyW);
        aVar.c(this.heq);
        aVar.a(this.hyY);
        this.WY.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.hzv) {
            if (!this.hen) {
                aVar.bFB().a(gVar, i, this.heo);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.pr();
                }
                aVar.bFB().mPosition = i;
                aVar.bFB().setOnVideoContainerForegroundClickListener(this.hyS);
            } else {
                aVar.bFB().c(gVar, i, this.heo);
            }
        }
        if (aVar.bFB() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bFB().setCurrentPlayCallBack(this.WZ);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bj bjVar = new bj();
        bjVar.setId(gVar.threadId);
        bjVar.setTid(gVar.threadId);
        bjVar.setBaijiahaoData(gVar.mBaijiahao);
        bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bjVar.setThreadType(40);
        com.baidu.tieba.s.c.cVr().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean pv() {
        if (this.hzt != null) {
            return this.hzt.isPlaying();
        }
        return false;
    }

    public boolean bWe() {
        if (this.hzt != null) {
            return this.hzt.bWe();
        }
        return false;
    }

    public void pt() {
        if (this.hzt != null) {
            this.hzt.bQX();
        }
    }

    public void pu() {
        if (this.hzt != null) {
            this.hzt.bQY();
        }
    }

    public void bWr() {
        if (this.hzt != null) {
            this.hzt.bWf();
        }
    }

    public void onDestroy() {
        if (this.hyT != null) {
            this.hyT.bWx();
        }
        for (a aVar : this.WY) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean tF(int i) {
        if (this.hzt == null) {
            return false;
        }
        return this.hzt.tF(i);
    }

    public void bWs() {
        if (this.hzt != null) {
            this.hzt.bWl();
        }
    }
}
