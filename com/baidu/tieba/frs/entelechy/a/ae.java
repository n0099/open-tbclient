package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.av;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes22.dex */
public class ae extends com.baidu.tieba.frs.k<bx, com.baidu.card.a<by>> implements com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private boolean alo;
    private com.baidu.tieba.card.ab<by> hbx;
    private int jcR;
    private com.baidu.tieba.frs.d.b jcS;
    private Set<String> jef;

    public ae(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.jcR = 3;
        this.jcS = new com.baidu.tieba.frs.d.b();
        this.alo = false;
        this.hbx = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.ae.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_interview_live) {
                        com.baidu.tieba.frs.d.a.a(byVar, 3, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 12, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 13, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, ae.this.mPageId, ae.this.jcS, ae.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJH().a(ae.this.jcS, byVar, 2);
                    } else if (view.getId() == R.id.thread_card_root) {
                        if (byVar.bpA() == 2 && byVar.bov() != null) {
                            String bol = byVar.bov().bol();
                            if (StringUtils.isNull(bol)) {
                                bol = byVar.bov().getTaskId();
                            }
                            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", String.valueOf(byVar.getFid()), byVar.boT(), byVar.bov().getThreadId(), "tieba.baidu.com/p/" + byVar.bov().getThreadId(), bol);
                            String taskId = byVar.bov().getTaskId();
                            ar arVar = new ar("c13329");
                            arVar.w("fid", byVar.getFid());
                            arVar.dY("obj_id", taskId);
                            TiebaStatic.log(arVar);
                        }
                        com.baidu.tieba.frs.d.c.cJH().a(ae.this.jcS, byVar, 1);
                    }
                }
            }
        };
        this.jef = new HashSet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bs(696);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        com.baidu.card.r rVar = new com.baidu.card.r(this.mPageContext.getPageActivity());
        rVar.setFromCDN(this.alo);
        aVar.c(rVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alo);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 2;
        dVar.eEP = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.jcR);
        anVar.bs(16);
        aVar.b(anVar);
        com.baidu.card.ak tX = aVar.tX();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tX);
        aVar2.setPageId(this.mPageId);
        tX.a(this.hbx);
        tX.setSourceForPb(this.jcR);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ae.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar = (com.baidu.card.am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (ae.this.hbx != null) {
                        ae.this.hbx.a(amVar.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), ae.this.jcR, false);
                    amVar.tZ().b(new a.C0097a(1));
                }
            }
        });
        aVar2.ua();
        return aVar2;
    }

    private com.baidu.tieba.play.o ak(by byVar) {
        if (byVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = byVar.bqa() ? "3" : "2";
        oVar.fFV = this.jcS.jtR;
        oVar.amY = byVar.getTid();
        oVar.mSource = byVar.mRecomSource;
        oVar.myo = byVar.eLn;
        oVar.myp = byVar.mRecomWeight;
        oVar.mys = byVar.mRecomAbTag;
        if (byVar.bph() != null) {
            oVar.myt = byVar.bph().video_md5;
        }
        return oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.a<by> aVar) {
        if (aVar == null) {
            return null;
        }
        if (this.jcS != null) {
            int i2 = 0;
            if (this.iSt != null) {
                i2 = this.iSt.getTopThreadSize();
            }
            bxVar.eCR.eHa = (i + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.cJH().a(this.jcS, bxVar.eCR);
        com.baidu.tieba.frs.d.a.a(bxVar.eCR, this.mPageId, this.jcS, getTbPageTag());
        bw bov = bxVar.eCR.bov();
        if (bov != null) {
            String taskId = bov.getTaskId();
            String bol = bov.bol();
            if (StringUtils.isNull(bol)) {
                bol = bov.getTaskId();
            }
            if (this.mPageContext.getOrignalPage() instanceof av) {
                av avVar = (av) this.mPageContext.getOrignalPage();
                if (this.jef.add(taskId)) {
                    com.baidu.tieba.tbadkCore.d.a.c("frs", "VIEW_TRUE", avVar.getForumId(), avVar.getForumName(), bov.getThreadId(), "tieba.baidu.com/p/" + bxVar.eCR.getTid(), bol);
                }
            }
            ar arVar = new ar("c13324");
            arVar.w("fid", bxVar.eCR.getFid());
            arVar.dY("tid", bxVar.eCR.getTid());
            arVar.dY("obj_id", taskId);
            arVar.al("thread_type", bxVar.eCR.getThreadType());
            TiebaStatic.log(arVar);
        }
        if (bxVar != null) {
            bxVar.eCR.bqd();
            if (bxVar.eCR.bph() != null ? true : true) {
                aVar.setVideoStatsData(ak(bxVar.eCR));
            }
            aVar.tZ().tT().bs(32);
            aVar.b((com.baidu.card.a<by>) bxVar.eCR);
            aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
            aVar.tZ().a(this.hbx);
            com.baidu.tieba.frs.j.a(aVar.tZ().tT(), this.iSt);
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.k
    public void release() {
        super.release();
        this.jef.clear();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcR = i;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcS;
    }
}
