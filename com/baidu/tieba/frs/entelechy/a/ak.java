package com.baidu.tieba.frs.entelechy.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.an;
import com.baidu.card.b;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class ak extends com.baidu.tieba.frs.k<by, com.baidu.card.a<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private com.baidu.tieba.card.ab<by> hbz;
    private NEGFeedBackView.a hca;
    public boolean jbS;
    private int jcT;
    private com.baidu.tieba.frs.d.b jcU;
    private boolean jds;
    private boolean jdt;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public ak(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.alo = false;
        this.jds = false;
        this.jcT = 3;
        this.jcU = new com.baidu.tieba.frs.d.b();
        this.hbz = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.ak.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (ak.this.iSB != null) {
                        ak.this.iSB.a(view, (View) byVar, (Object) by.eJq);
                    }
                    if ("c13010".equals(ak.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 2).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(byVar, 4, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 4, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 12, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 13, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, ak.this.mPageId, ak.this.jcU, ak.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.cJI().a(ak.this.jcU, byVar, 1);
                        ak.this.as(byVar);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJI().a(ak.this.jcU, byVar, 2);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.k.a(ak.this.jcU, byVar.bmo());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.cJI().a(ak.this.jcU, byVar, 4);
                        ak.this.as(byVar);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        ak.this.as(byVar);
                    }
                }
            }
        };
        this.hca = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.ak.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new ar("c11973").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dY("obj_locate", sb.toString()).dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("source", atVar.source).dY("weight", atVar.weight).dY("ab_tag", atVar.abTag).dY("extra", atVar.extra).al(IntentConfig.CARD_TYPE, atVar.cardType).al("obj_floor", atVar.eHa));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bs(4272);
        eVar.setPageUniqueId(this.mPageId);
        aVar.a(eVar);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFrom("frs");
        hVar.setStageType("2003");
        if (this.jcT == 502) {
            hVar.setNeedFrsTabName(false);
        } else {
            hVar.setNeedFrsTabName(true);
        }
        hVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.ak.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bn = az.bn(hVar.getVideoContainer());
                    if (!(aVar2 instanceof by)) {
                        az.a(aVar2, ak.this.mContext, ak.this.jcT, false, bn);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, ak.this.mContext, ak.this.jcT, false, bn);
                }
            }
        });
        aVar.c(hVar);
        if (this.jdt) {
            aVar.a((com.baidu.card.i) new com.baidu.card.s(this.mPageContext.getPageActivity()));
        }
        aVar.a((com.baidu.card.i) new com.baidu.card.ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new com.baidu.card.l(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alo);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.i) nVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 2;
        dVar.eEK = 2;
        dVar.eEP = 2;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(2);
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(this.jcT);
        anVar.bs(48);
        if (this.jds) {
            anVar.bt(4);
        }
        aVar.b(anVar);
        aVar.tY().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ak tX = aVar.tX();
        com.baidu.card.a aVar2 = new com.baidu.card.a(tX);
        aVar2.setPageId(this.mPageId);
        tX.a(this.hbz);
        tX.setSourceForPb(this.jcT);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.ak.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof by) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar = (com.baidu.card.am) view.getTag();
                    by byVar = (by) qVar;
                    byVar.objType = 1;
                    if (ak.this.hbz != null) {
                        ak.this.hbz.a(amVar.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), ak.this.jcT, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tZ().b(new a.C0097a(1));
                }
            }
        });
        aVar2.ua();
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, by byVar, com.baidu.card.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (byVar == null) {
            return aVar.getView();
        }
        if (aVar.tZ().tT() instanceof an) {
            ((an) aVar.tZ().tT()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.ak.5
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        if (aVar.tZ() instanceof com.baidu.tieba.a.e) {
            aVar.tZ().setPage(this.aiw);
        }
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) aVar);
        com.baidu.tieba.frs.j.a(aVar.tZ().tT(), this.iSv);
        aVar.setVideoStatsData(ak(byVar));
        if (this.iSv != null && this.iSv.getForum() != null && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSv.getForum().getTopic_special_icon_right())) {
            byVar.dL(this.iSv.getForum().getTopic_special_icon(), this.iSv.getForum().getTopic_special_icon_right());
        }
        boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (byVar.bqg() && byVar.getFeedBackReasonMap() != null && !z) {
            aVar.aN(true).a(this.hca);
        }
        if (!byVar.isBjh()) {
            aVar.ub();
        }
        aVar.b((com.baidu.card.a) byVar);
        aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tZ().a((com.baidu.tieba.card.ab<T>) this.hbz);
        if (this.jcU != null) {
            byVar.eHa = (i + 1) - (this.iSv != null ? this.iSv.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cJI().a(this.jcU, byVar);
        com.baidu.tieba.frs.d.c.cJI().ay(byVar);
        com.baidu.tieba.frs.d.c.cJI().a(byVar, cBS());
        com.baidu.tieba.frs.d.a.a(byVar, this.mPageId, this.jcU, getTbPageTag());
        byVar.bqd();
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ak(by byVar) {
        if (byVar == null) {
            return null;
        }
        com.baidu.tieba.play.o oVar = new com.baidu.tieba.play.o();
        oVar.mLocate = byVar.bqa() ? "3" : "2";
        if (this.jcU.jtU == 501) {
            oVar.mLocate = "frs_tab";
        }
        oVar.fFV = this.jcU.jtT;
        oVar.amY = byVar.getTid();
        oVar.mSource = byVar.mRecomSource;
        oVar.myq = byVar.eLn;
        oVar.myr = byVar.mRecomWeight;
        oVar.myu = byVar.mRecomAbTag;
        if (byVar.bph() != null) {
            oVar.myv = byVar.bph().video_md5;
        }
        return oVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcT = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(by byVar) {
        TiebaStatic.log(new ar("c12126").dY("tid", byVar.getId()).al("obj_locate", cBS() ? 2 : 1).w("obj_id", byVar.bpj() == null ? -1L : byVar.bpj().live_id).al("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void oZ(boolean z) {
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcU;
    }

    public void qz(boolean z) {
        this.jds = z;
    }

    public void qA(boolean z) {
        this.jdt = z;
    }
}
