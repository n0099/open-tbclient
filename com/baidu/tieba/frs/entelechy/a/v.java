package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.ag;
import com.baidu.card.ai;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class v extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String LC;
    private boolean NJ;
    private com.baidu.tieba.card.z<bj> eMX;
    private NEGFeedBackView.a eNz;
    private HashSet<String> gwo;
    private int gwp;
    private com.baidu.tieba.frs.d.b gwq;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public v(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.NJ = true;
        this.gwp = 3;
        this.gwq = new com.baidu.tieba.frs.d.b();
        this.eMX = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if ("c13010".equals(v.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 3).s("fid", bjVar.getFid()).cy("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, v.this.mPageId, v.this.gwq, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, v.this.mPageId, v.this.gwq, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, v.this.mPageId, v.this.gwq, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, v.this.mPageId, v.this.gwq, v.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, v.this.mPageId, v.this.gwq, v.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, v.this.mPageId, v.this.gwq, v.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, v.this.mPageId, v.this.gwq, v.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJJ().a(v.this.gwq, bjVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bJJ().a(v.this.gwq, bjVar, 1);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar.cy("obj_type", "1");
                        anVar.cy("tid", bjVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar2.cy("obj_type", "3");
                        anVar2.cy("tid", bjVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.eNz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, al alVar) {
                if (arrayList != null && alVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").cy("obj_locate", sb.toString()).cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("source", alVar.source).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cy(TiebaInitialize.Params.AB_TAG, alVar.cPE).cy("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPF));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aK(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.v.3
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
        ai aiVar = new ai(this.mPageContext.getPageActivity());
        aVar.c(aiVar);
        aiVar.ba(2);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NJ);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNB = 2;
        dVar.cNH = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        agVar.aK(16);
        aVar.b(agVar);
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad nj = aVar.nj();
        nj.aQ(2);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(nj);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.v.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRf;
                    bjVar.objType = 1;
                    if (v.this.eMX != null) {
                        v.this.eMX.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), v.this.gwp, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        afVar.nl();
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.af<bj> afVar) {
        if (biVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        if (afVar.nk() instanceof com.baidu.tieba.a.e) {
            afVar.nk().setPage(this.LC);
        }
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        com.baidu.tieba.frs.g.a(afVar.nk().ne(), this.gnM);
        if (this.gnM != null && this.gnM.getForum() != null && !StringUtils.isNull(this.gnM.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.gnM.getForum().getTopic_special_icon_right())) {
            biVar.cRf.cp(this.gnM.getForum().getTopic_special_icon(), this.gnM.getForum().getTopic_special_icon_right());
        }
        boolean z = (biVar.cRf.aCo() == null || biVar.cRf.aCo().getUserId() == null || !biVar.cRf.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.cRf.aDz() && biVar.cRf.getFeedBackReasonMap() != null && !z) {
            afVar.ag(true).a(this.eNz);
        }
        afVar.nm();
        if (biVar.cRf.aDz() && afVar.nk().ne() != null) {
            afVar.nk().ne().aK(32);
        }
        afVar.b((com.baidu.card.af<bj>) biVar.cRf);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.eMX);
        if (this.gwq != null) {
            biVar.cRf.cPF = (biVar.position + 1) - (this.gnM != null ? this.gnM.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bJJ().a(this.gwq, biVar.cRf);
        am(biVar.cRf);
        biVar.cRf.aDw();
        com.baidu.tieba.frs.d.a.a(biVar.cRf, this.mPageId, this.gwq, getTbPageTag());
        if (biVar.cRf != null) {
            biVar.cRf.aDw();
        }
        return afVar.getView();
    }

    private void am(bj bjVar) {
        if (this.gwo == null) {
            this.gwo = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bJJ().a(bjVar, this.gwo);
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwp = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGX() {
        return this.gwq;
    }
}
