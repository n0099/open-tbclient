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
    private List<a> DE;
    private com.baidu.tieba.lego.card.view.f DG;
    private String cPf;
    private c gOT;
    private com.baidu.tieba.frs.videomiddlepage.a.a gOU;
    private b gOX;
    private com.baidu.tieba.lego.card.view.g gOZ;
    private a gPu;
    private boolean gPv;
    private boolean gPw;
    private int gPx;
    private boolean gvc;
    private com.baidu.tieba.frs.aggregation.a gvd;
    private boolean gve;
    private z<com.baidu.tieba.frs.aggregation.g> gvf;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.gvk);
        this.DE = new ArrayList();
        this.mHandler = new Handler();
        this.gPv = true;
        this.gPx = 1;
        this.gvf = new z<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.gPu != null && e.this.gPu != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gPu.bGx();
                        }
                        if (e.this.gPu != aVar2) {
                            e.this.gPu = aVar2;
                        }
                        if (e.this.gPu != null) {
                            e.this.gPu.mo(e.this.gPv);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cx("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.gPu != null && !e.this.gPu.bLG()) {
                            com.baidu.tieba.s.c.cKv().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.fNo, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cx("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cx("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.s.c.cKv().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.fNo, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cx("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.s.c.cKv().b(e.this.mBdUniqueId, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.fNo, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cx("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cx("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cx("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gvd = aVar;
        this.gve = z;
        this.gOT = cVar;
        this.mFrom = str;
        this.gOU = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.cPf = str2;
        this.DG = fVar;
        this.gOX = bVar;
        this.gOZ = gVar;
    }

    public void mt(boolean z) {
        this.gPw = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.gPx) {
            this.gPx = i;
            if (this.gPu != null) {
                this.gvc = true;
                this.gPu.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.gvc) {
                                e.this.gvc = false;
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
    /* renamed from: aw */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.gve, this.mFrom, this.cPf, this.gOX);
        aVar.c(this.gvf);
        aVar.a(this.gOZ);
        this.DE.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.gPw) {
            if (!this.gvc) {
                aVar.bvQ().a(gVar, i, this.gvd);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.kN();
                }
                aVar.bvQ().mPosition = i;
                aVar.bvQ().setOnVideoContainerForegroundClickListener(this.gOT);
            } else {
                aVar.bvQ().c(gVar, i, this.gvd);
            }
        }
        if (aVar.bvQ() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bvQ().setCurrentPlayCallBack(this.DG);
        }
        String a = com.baidu.tieba.s.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bj bjVar = new bj();
        bjVar.setId(gVar.threadId);
        bjVar.setTid(gVar.threadId);
        bjVar.setBaijiahaoData(gVar.mBaijiahao);
        bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bjVar.setThreadType(40);
        com.baidu.tieba.s.c.cKv().a(this.mBdUniqueId, a, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean kR() {
        if (this.gPu != null) {
            return this.gPu.isPlaying();
        }
        return false;
    }

    public boolean bLy() {
        if (this.gPu != null) {
            return this.gPu.bLy();
        }
        return false;
    }

    public void kP() {
        if (this.gPu != null) {
            this.gPu.bGw();
        }
    }

    public void kQ() {
        if (this.gPu != null) {
            this.gPu.bGx();
        }
    }

    public void bLL() {
        if (this.gPu != null) {
            this.gPu.bLz();
        }
    }

    public void onDestroy() {
        if (this.gOU != null) {
            this.gOU.bLR();
        }
        for (a aVar : this.DE) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean th(int i) {
        if (this.gPu == null) {
            return false;
        }
        return this.gPu.th(i);
    }

    public void bLM() {
        if (this.gPu != null) {
            this.gPu.bLF();
        }
    }
}
