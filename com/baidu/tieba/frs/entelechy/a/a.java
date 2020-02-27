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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.frs.h<bj, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.z<bj> JZ;
    private String LC;
    private NEGFeedBackView.a eNy;
    private int gwk;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.gwk = 3;
        this.JZ = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                com.baidu.tieba.card.r.bve().ib(true);
                com.baidu.tieba.a.d.aXD().cv("page_recommend", "show_");
                if (view != null && bjVar != null && !StringUtils.isNull(bjVar.getTid())) {
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bJH().a(com.baidu.tieba.frs.d.d.gwo, bjVar, 13);
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, a.this.mPageId, com.baidu.tieba.frs.d.d.gwo, a.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, a.this.mPageId, com.baidu.tieba.frs.d.d.gwo, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, a.this.mPageId, com.baidu.tieba.frs.d.d.gwo, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, a.this.mPageId, com.baidu.tieba.frs.d.d.gwo, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, a.this.mPageId, com.baidu.tieba.frs.d.d.gwo, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, a.this.mPageId, com.baidu.tieba.frs.d.d.gwo, a.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, a.this.mPageId, com.baidu.tieba.frs.d.d.gwo, a.this.getTbPageTag());
                    }
                }
            }
        };
        this.eNy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.a.2
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
                    TiebaStatic.log(new an("c11974").cy("obj_locate", sb.toString()).cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("source", alVar.source).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cy(TiebaInitialize.Params.AB_TAG, alVar.cPD).cy("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPE));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = 2;
        dVar.cNG = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(1);
        agVar.aZ(3);
        aVar.b(agVar);
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.ni().aS(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        aVar.ni().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ad a = aVar.a(true, viewGroup, this.fWB);
        a.aQ(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.a.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, mVar);
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.af<bj> afVar) {
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) afVar);
        if (bjVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.c.bJH().a(gwo, bjVar);
        afVar.nk().setPage(this.LC);
        afVar.nk().setPosition(i);
        if (this.gwk == 1) {
            afVar.ag(true).a(this.eNy);
        }
        afVar.ah(true);
        afVar.b((com.baidu.card.af<bj>) bjVar);
        afVar.nk().a(this.JZ);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return afVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.m mVar) {
        if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
            bj bjVar = (bj) mVar;
            bjVar.objType = 1;
            au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
            ((com.baidu.card.af) view.getTag()).nk().b(new a.C0052a(1));
        }
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.a.f
    public void wO(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pz(int i) {
        this.gwk = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGV() {
        return gwo;
    }
}
