package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class s extends com.baidu.tieba.frs.k<bx, com.baidu.card.am<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private com.baidu.tieba.card.ab<by> hbw;
    private NEGFeedBackView.a hca;
    private int jcT;
    private com.baidu.tieba.frs.d.b jcU;
    private TbPageContext<?> mPageContext;

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.alo = true;
        this.jcT = 3;
        this.jcU = new com.baidu.tieba.frs.d.b();
        this.hbw = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 12, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 13, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (s.this.hbw.ajN instanceof Boolean) {
                            if (((Boolean) s.this.hbw.ajN).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(byVar, 1, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(byVar, 3, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, s.this.mPageId, s.this.jcU, s.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJI().a(s.this.jcU, byVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cJI().a(s.this.jcU, byVar, 7);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                }
            }
        };
        this.hca = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.s.2
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
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.bs(4272);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.s.3
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        aVar.c(new com.baidu.card.t(this.mPageContext.getPageActivity()));
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
        anVar.setShareReportFrom(this.jcT);
        anVar.setFromForPb(this.jcT);
        anVar.bs(48);
        aVar.b(anVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup);
        a2.setSourceForPb(this.jcT);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.s.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar2 = (com.baidu.card.am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (s.this.hbw != null) {
                        s.this.hbw.a(amVar2.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), s.this.jcT, false);
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        amVar.ua();
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.am<by> amVar) {
        if (bxVar == null || amVar == null || amVar.tZ() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) bxVar, (bx) amVar);
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        com.baidu.tieba.frs.j.a(amVar.tZ().tT(), this.iSv);
        boolean z = (bxVar.eCR.boP() == null || bxVar.eCR.boP().getUserId() == null || !bxVar.eCR.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bxVar.eCR.bqg() && bxVar.eCR.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.ab aN = amVar.aN(true);
            aN.a(this.hca);
            aN.H(bxVar.eCR.bmp());
        }
        amVar.ub();
        amVar.b((com.baidu.card.am<by>) bxVar.eCR);
        amVar.b(this.hbw);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.jcU != null) {
            bxVar.eCR.eHa = (bxVar.position + 1) - (this.iSv != null ? this.iSv.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cJI().a(this.jcU, bxVar.eCR);
        com.baidu.tieba.frs.d.a.a(bxVar.eCR, this.mPageId, this.jcU, getTbPageTag());
        if (bxVar != null) {
            bxVar.eCR.bqd();
        }
        return amVar.getView();
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

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcU;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alo = z;
    }
}
