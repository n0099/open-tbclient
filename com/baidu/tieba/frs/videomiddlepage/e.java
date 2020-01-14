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
/* loaded from: classes7.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Dk;
    private com.baidu.tieba.lego.card.view.f Dl;
    private String cKN;
    private com.baidu.tieba.frs.videomiddlepage.a.a gLA;
    private b gLD;
    private com.baidu.tieba.lego.card.view.g gLF;
    private c gLz;
    private a gMa;
    private boolean gMb;
    private boolean gMc;
    private int gMd;
    private boolean gsj;
    private com.baidu.tieba.frs.aggregation.a gsk;
    private boolean gsl;
    private z<com.baidu.tieba.frs.aggregation.g> gsm;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.gsr);
        this.Dk = new ArrayList();
        this.mHandler = new Handler();
        this.gMb = true;
        this.gMd = 1;
        this.gsm = new z<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                        if (e.this.gMa != null && e.this.gMa != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.gMa.bEG();
                        }
                        if (e.this.gMa != aVar2) {
                            e.this.gMa = aVar2;
                        }
                        if (e.this.gMa != null) {
                            e.this.gMa.mg(e.this.gMb);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.gMa != null && !e.this.gMa.bJO()) {
                            com.baidu.tieba.r.c.cIu().b(e.this.mBdUniqueId, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.fJU, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.r.c.cIu().b(e.this.mBdUniqueId, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.fJU, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.r.c.cIu().b(e.this.mBdUniqueId, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.fJU, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.cp("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.cp("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gsk = aVar;
        this.gsl = z;
        this.gLz = cVar;
        this.mFrom = str;
        this.gLA = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.cKN = str2;
        this.Dl = fVar;
        this.gLD = bVar;
        this.gLF = gVar;
    }

    public void ml(boolean z) {
        this.gMc = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.gMd) {
            this.gMd = i;
            if (this.gMa != null) {
                this.gsj = true;
                this.gMa.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.gsj) {
                                e.this.gsj = false;
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
    /* renamed from: av */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.gsl, this.mFrom, this.cKN, this.gLD);
        aVar.c(this.gsm);
        aVar.a(this.gLF);
        this.Dk.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.gMc) {
            if (!this.gsj) {
                aVar.bue().a(gVar, i, this.gsk);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.ky();
                }
                aVar.bue().mPosition = i;
                aVar.bue().setOnVideoContainerForegroundClickListener(this.gLz);
            } else {
                aVar.bue().c(gVar, i, this.gsk);
            }
        }
        if (aVar.bue() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.bue().setCurrentPlayCallBack(this.Dl);
        }
        String a = com.baidu.tieba.r.a.a(gVar.threadId, "", "", gVar.mBaijiahao);
        bj bjVar = new bj();
        bjVar.setId(gVar.threadId);
        bjVar.setTid(gVar.threadId);
        bjVar.setBaijiahaoData(gVar.mBaijiahao);
        bjVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        bjVar.setThreadType(40);
        com.baidu.tieba.r.c.cIu().a(this.mBdUniqueId, a, com.baidu.tieba.r.a.a(bjVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean kC() {
        if (this.gMa != null) {
            return this.gMa.isPlaying();
        }
        return false;
    }

    public boolean bJG() {
        if (this.gMa != null) {
            return this.gMa.bJG();
        }
        return false;
    }

    public void kA() {
        if (this.gMa != null) {
            this.gMa.bEF();
        }
    }

    public void kB() {
        if (this.gMa != null) {
            this.gMa.bEG();
        }
    }

    public void bJT() {
        if (this.gMa != null) {
            this.gMa.bJH();
        }
    }

    public void onDestroy() {
        if (this.gLA != null) {
            this.gLA.bJY();
        }
        for (a aVar : this.Dk) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean sZ(int i) {
        if (this.gMa == null) {
            return false;
        }
        return this.gMa.sZ(i);
    }

    public void bJU() {
        if (this.gMa != null) {
            this.gMa.bJN();
        }
    }
}
