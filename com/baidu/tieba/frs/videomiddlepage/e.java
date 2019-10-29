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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.frs.aggregation.g, com.baidu.tieba.card.a.a<a>> {
    private List<a> Bb;
    private com.baidu.tieba.lego.card.view.f Bc;
    private String bZb;
    private boolean fBv;
    private com.baidu.tieba.frs.aggregation.a fBw;
    private boolean fBx;
    private ab<com.baidu.tieba.frs.aggregation.g> fBy;
    private c fUE;
    private com.baidu.tieba.frs.videomiddlepage.a.a fUF;
    private b fUI;
    private com.baidu.tieba.lego.card.view.g fUK;
    private a fVe;
    private boolean fVf;
    private boolean fVg;
    private int fVh;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private Handler mHandler;
    private TbPageContext mPageContext;

    public e(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.aggregation.a aVar, c cVar, boolean z, String str, String str2, com.baidu.tieba.lego.card.view.f fVar, BdUniqueId bdUniqueId, b bVar, com.baidu.tieba.lego.card.view.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.frs.aggregation.g.fBD);
        this.Bb = new ArrayList();
        this.mHandler = new Handler();
        this.fVf = true;
        this.fVh = 1;
        this.fBy = new ab<com.baidu.tieba.frs.aggregation.g>() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.frs.aggregation.g gVar2) {
                if (view != null && gVar2 != null) {
                    String str3 = gVar2.threadId != null ? gVar2.threadId : null;
                    bh bhVar = new bh();
                    bhVar.setId(str3);
                    bhVar.setTid(str3);
                    bhVar.setFid(com.baidu.adp.lib.g.b.toLong(gVar2.forumId, 0L));
                    bhVar.setThreadType(40);
                    if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof a)) {
                        a aVar2 = (a) view.getTag();
                        if (e.this.fVe != null && e.this.fVe != aVar2 && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                            e.this.fVe.bmj();
                        }
                        if (e.this.fVe != aVar2) {
                            e.this.fVe = aVar2;
                        }
                        if (e.this.fVe != null) {
                            e.this.fVe.kI(e.this.fVf);
                        }
                    }
                    if (view.getId() == R.id.title) {
                        an anVar = new an("c12411");
                        anVar.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar);
                        if (e.this.fVe != null && !e.this.fVe.brn()) {
                            com.baidu.tieba.q.c.cnk().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 1, gVar2.ePN, false, (String) null, (String) null));
                        }
                    } else if (view.getId() == R.id.agree_view_container) {
                        an anVar2 = new an("c12414");
                        anVar2.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar2.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar2);
                    } else if (view.getId() == R.id.thread_info_commont_container || view.getId() == R.id.card_root_view) {
                        an anVar3 = new an("c12415");
                        anVar3.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar3.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar3);
                        com.baidu.tieba.q.c.cnk().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 5, gVar2.ePN, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.user_icon || view.getId() == R.id.user_name) {
                        an anVar4 = new an("c12412");
                        anVar4.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar4.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar4);
                        com.baidu.tieba.q.c.cnk().b(e.this.mBdUniqueId, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_click", 2, gVar2.ePN, false, (String) null, (String) null));
                    } else if (view.getId() == R.id.attention) {
                        an anVar5 = new an("c12413");
                        anVar5.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar5.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar5);
                    } else if (view.getId() == R.id.mobile_network_play) {
                        an anVar6 = new an("c12416");
                        anVar6.bS("fid", gVar2.forumId);
                        if (TbadkCoreApplication.isLogin()) {
                            anVar6.bS("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(anVar6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.fBw = aVar;
        this.fBx = z;
        this.fUE = cVar;
        this.mFrom = str;
        this.fUF = new com.baidu.tieba.frs.videomiddlepage.a.a();
        this.bZb = str2;
        this.Bc = fVar;
        this.fUI = bVar;
        this.fUK = gVar;
    }

    public void kM(boolean z) {
        this.fVg = z;
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i = configuration.orientation;
        if (i != this.fVh) {
            this.fVh = i;
            if (this.fVe != null) {
                this.fBv = true;
                this.fVe.onConfigurationChanged(configuration);
                if (configuration.orientation == 1) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.fBv) {
                                e.this.fBv = false;
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
    /* renamed from: as */
    public com.baidu.tieba.card.a.a<a> b(ViewGroup viewGroup) {
        a aVar = new a(this.mPageContext, this.fBx, this.mFrom, this.bZb, this.fUI);
        aVar.d(this.fBy);
        aVar.a(this.fUK);
        this.Bb.add(aVar);
        return new com.baidu.tieba.card.a.a<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.frs.aggregation.g gVar, com.baidu.tieba.card.a.a<a> aVar) {
        if (gVar == null || aVar == null) {
            return null;
        }
        if (!this.fVg) {
            if (!this.fBv) {
                aVar.baZ().a(gVar, i, this.fBw);
                i trigger = gVar.getTrigger();
                if (trigger != null) {
                    trigger.kg();
                }
                aVar.baZ().mPosition = i;
                aVar.baZ().setOnVideoContainerForegroundClickListener(this.fUE);
            } else {
                aVar.baZ().c(gVar, i, this.fBw);
            }
        }
        if (aVar.baZ() instanceof com.baidu.tieba.lego.card.view.h) {
            aVar.baZ().setCurrentPlayCallBack(this.Bc);
        }
        gVar.ePN = i + 1;
        String str = gVar.threadId != null ? gVar.threadId : null;
        bh bhVar = new bh();
        bhVar.setId(str);
        bhVar.setTid(str);
        bhVar.setFid(com.baidu.adp.lib.g.b.toLong(gVar.forumId, 0L));
        bhVar.setThreadType(40);
        com.baidu.tieba.q.c.cnk().a(this.mBdUniqueId, str, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.VIDEO_LIST, "common_exp", i + 1, false, null, null));
        return aVar.getView();
    }

    public boolean kk() {
        if (this.fVe != null) {
            return this.fVe.isPlaying();
        }
        return false;
    }

    public boolean brf() {
        if (this.fVe != null) {
            return this.fVe.brf();
        }
        return false;
    }

    public void ki() {
        if (this.fVe != null) {
            this.fVe.bmi();
        }
    }

    public void kj() {
        if (this.fVe != null) {
            this.fVe.bmj();
        }
    }

    public void brr() {
        if (this.fVe != null) {
            this.fVe.brg();
        }
    }

    public void onDestroy() {
        if (this.fUF != null) {
            this.fUF.brw();
        }
        for (a aVar : this.Bb) {
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public boolean qP(int i) {
        if (this.fVe == null) {
            return false;
        }
        return this.fVe.qP(i);
    }

    public void brs() {
        if (this.fVe != null) {
            this.fVe.brm();
        }
    }
}
