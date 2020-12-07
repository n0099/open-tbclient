package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.frs.k<by, com.baidu.card.am<by>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String aiw;
    private boolean alo;
    private boolean fdm;
    private NEGFeedBackView.a hbY;
    private com.baidu.tieba.card.ab<by> hbu;
    private HashSet<String> jcQ;
    private int jcR;
    private com.baidu.tieba.frs.d.b jcS;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fdm = false;
        this.alo = true;
        this.jcR = 3;
        this.jcS = new com.baidu.tieba.frs.d.b();
        this.hbu = new com.baidu.tieba.card.ab<by>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                if (view != null && byVar != null) {
                    if ("c13010".equals(c.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").al("obj_type", 3).w("fid", byVar.getFid()).dY("tid", byVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(byVar, 2, c.this.mPageId, c.this.jcS, c.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(byVar, 15, c.this.mPageId, c.this.jcS, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 5, c.this.mPageId, c.this.jcS, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(byVar, 14, c.this.mPageId, c.this.jcS, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 12, c.this.mPageId, c.this.jcS, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(byVar, 13, c.this.mPageId, c.this.jcS, c.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(byVar, 1, c.this.mPageId, c.this.jcS, c.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cJH().a(c.this.jcS, byVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cJH().a(c.this.jcS, byVar, 1);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar.dY("obj_type", "1");
                        arVar.dY("tid", byVar.getTid());
                        TiebaStatic.log(arVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        ar arVar2 = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar2.dY("obj_type", "3");
                        arVar2.dY("tid", byVar.getTid());
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        };
        this.hbY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.2
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
        eVar.bs(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.3
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom("frs");
        if (this.jcR == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        aVar.tY().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom("frs");
        if (this.jcR == 502) {
            afVar2.setNeedFrsTabName(false);
        } else {
            afVar2.setNeedFrsTabName(true);
        }
        afVar2.e(com.baidu.tbadk.a.b.a.bkK(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.a.bkK(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    az.a(aVar2.bmn().eLH, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.5
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bmn() != null && aVar2.bmn().eLH != null) {
                    az.a(aVar2.bmn().eLH, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
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
        anVar.setFromForPb(3);
        anVar.bs(48);
        aVar.b(anVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.iyt);
        a2.setSourceForPb(3);
        com.baidu.card.am<by> amVar = new com.baidu.card.am<>(a2);
        amVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.c.6
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof by) && (view.getTag() instanceof com.baidu.card.am)) {
                    com.baidu.card.am amVar2 = (com.baidu.card.am) view.getTag();
                    by byVar = (by) qVar;
                    byVar.objType = 1;
                    if (c.this.hbu != null) {
                        c.this.hbu.a(amVar2.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), c.this.jcR, false);
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
    public View a(int i, View view, ViewGroup viewGroup, by byVar, com.baidu.card.am<by> amVar) {
        if (byVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        amVar.tZ().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) amVar);
        com.baidu.tieba.frs.j.a(amVar.tZ().tT(), this.iSt);
        if (this.iSt != null && this.iSt.getForum() != null && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.iSt.getForum().getTopic_special_icon_right())) {
            byVar.dL(this.iSt.getForum().getTopic_special_icon(), this.iSt.getForum().getTopic_special_icon_right());
        }
        boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (byVar.bqg() && byVar.getFeedBackReasonMap() != null && !z) {
            amVar.aN(true).a(this.hbY);
        }
        amVar.ub();
        if (amVar.tZ().tT() != null) {
            amVar.tZ().tT().bs(32);
        }
        amVar.b((com.baidu.card.am<by>) byVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.hbu);
        if (this.jcS != null) {
            byVar.eHa = (byVar.position + 1) - (this.iSt != null ? this.iSt.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cJH().a(this.jcS, byVar);
        aq(byVar);
        byVar.bqd();
        com.baidu.tieba.frs.d.a.a(byVar, this.mPageId, this.jcS, getTbPageTag());
        if (byVar != null) {
            byVar.bqd();
        }
        return amVar.getView();
    }

    private void aq(by byVar) {
        if (this.jcQ == null) {
            this.jcQ = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.cJH().a(byVar, this.jcQ);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void wi(int i) {
        this.jcR = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
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
