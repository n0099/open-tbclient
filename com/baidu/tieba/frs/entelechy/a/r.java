package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.card.a.a;
import com.baidu.card.ad;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class r extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String LC;
    private boolean NK;
    private com.baidu.tieba.card.z<bj> eNG;
    private NEGFeedBackView.a eOk;
    private int gxk;
    private com.baidu.tieba.frs.d.b gxl;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.NK = true;
        this.gxk = 3;
        this.gxl = new com.baidu.tieba.frs.d.b();
        this.eNG = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (r.this.eNG.MV instanceof Boolean) {
                            if (((Boolean) r.this.eNG.MV).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, r.this.mPageId, r.this.gxl, r.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().a(r.this.gxl, bjVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bJX().a(r.this.gxl, bjVar, 7);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                }
            }
        };
        this.eOk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cx("obj_locate", sb.toString()).cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("source", alVar.source).cx(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cx(TiebaInitialize.Params.AB_TAG, alVar.cPS).cx("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPT));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.af<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.aK(4272);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.3
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
        aVar.c(new com.baidu.card.p(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NK);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        com.baidu.card.ag agVar = new com.baidu.card.ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 2;
        dVar.cNV = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(this.gxk);
        agVar.aZ(this.gxk);
        agVar.aK(16);
        aVar.b(agVar);
        com.baidu.card.ad nj = aVar.nj();
        nj.aQ(this.gxk);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(nj);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRt;
                    bjVar.objType = 1;
                    if (r.this.eNG != null) {
                        r.this.eNG.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), r.this.gxk, false);
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
        if (biVar == null || afVar == null || afVar.nk() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        if (afVar.nk() instanceof com.baidu.tieba.a.e) {
            afVar.nk().setPage(this.LC);
        }
        com.baidu.tieba.frs.g.a(afVar.nk().ne(), this.goJ);
        boolean z = (biVar.cRt.aCr() == null || biVar.cRt.aCr().getUserId() == null || !biVar.cRt.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.cRt.aDD() && biVar.cRt.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.w ag = afVar.ag(true);
            ag.a(this.eOk);
            ag.A(biVar.cRt.aAl());
        }
        afVar.nm();
        afVar.b((com.baidu.card.af<bj>) biVar.cRt);
        afVar.b(this.eNG);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.gxl != null) {
            biVar.cRt.cPT = (biVar.position + 1) - (this.goJ != null ? this.goJ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bJX().a(this.gxl, biVar.cRt);
        com.baidu.tieba.frs.d.a.a(biVar.cRt, this.mPageId, this.gxl, getTbPageTag());
        if (biVar != null) {
            biVar.cRt.aDA();
        }
        return afVar.getView();
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
        this.gxk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wQ(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NK = z;
    }
}
