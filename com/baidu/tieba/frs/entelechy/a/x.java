package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes9.dex */
public class x extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String LC;
    private boolean NK;
    private com.baidu.tieba.card.z<bj> eNG;
    private NEGFeedBackView.a eOk;
    private HashSet<String> gxj;
    private int gxk;
    private com.baidu.tieba.frs.d.b gxl;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.NK = true;
        this.gxk = 3;
        this.gxl = new com.baidu.tieba.frs.d.b();
        this.eNG = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if ("c13010".equals(x.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").X("obj_type", 3).s("fid", bjVar.getFid()).cx("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, x.this.mPageId, x.this.gxl, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, x.this.mPageId, x.this.gxl, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, x.this.mPageId, x.this.gxl, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, x.this.mPageId, x.this.gxl, x.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, x.this.mPageId, x.this.gxl, x.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, x.this.mPageId, x.this.gxl, x.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, x.this.mPageId, x.this.gxl, x.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bJX().a(x.this.gxl, bjVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bJX().a(x.this.gxl, bjVar, 1);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar.cx("obj_type", "1");
                        anVar.cx("tid", bjVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar2.cx("obj_type", "3");
                        anVar2.cx("tid", bjVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.eOk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.x.2
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
        eVar.aK(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.x.3
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
        com.baidu.card.ai aiVar = new com.baidu.card.ai(this.mPageContext.getPageActivity());
        aVar.c(aiVar);
        if (this.gxk == 502) {
            aiVar.setNeedFrsTabName(false);
        } else {
            aiVar.setNeedFrsTabName(true);
        }
        aiVar.ba(3);
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
        agVar.setShareReportFrom(3);
        agVar.aZ(2);
        agVar.aK(16);
        aVar.b(agVar);
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        com.baidu.card.ad nj = aVar.nj();
        nj.aQ(2);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(nj);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.x.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cRt;
                    bjVar.objType = 1;
                    if (x.this.eNG != null) {
                        x.this.eNG.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), x.this.gxk, false);
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
        com.baidu.tieba.frs.g.a(afVar.nk().ne(), this.goJ);
        if (this.goJ != null && this.goJ.getForum() != null && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.goJ.getForum().getTopic_special_icon_right())) {
            biVar.cRt.co(this.goJ.getForum().getTopic_special_icon(), this.goJ.getForum().getTopic_special_icon_right());
        }
        boolean z = (biVar.cRt.aCr() == null || biVar.cRt.aCr().getUserId() == null || !biVar.cRt.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.cRt.aDD() && biVar.cRt.getFeedBackReasonMap() != null && !z) {
            afVar.ag(true).a(this.eOk);
        }
        afVar.nm();
        if (biVar.cRt.aDD() && afVar.nk().ne() != null) {
            afVar.nk().ne().aK(32);
        }
        afVar.b((com.baidu.card.af<bj>) biVar.cRt);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.eNG);
        if (this.gxl != null) {
            biVar.cRt.cPT = (biVar.position + 1) - (this.goJ != null ? this.goJ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bJX().a(this.gxl, biVar.cRt);
        an(biVar.cRt);
        biVar.cRt.aDA();
        com.baidu.tieba.frs.d.a.a(biVar.cRt, this.mPageId, this.gxl, getTbPageTag());
        if (biVar.cRt != null) {
            biVar.cRt.aDA();
        }
        return afVar.getView();
    }

    private void an(bj bjVar) {
        if (this.gxj == null) {
            this.gxj = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bJX().a(bjVar, this.gxj);
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void pB(int i) {
        this.gxk = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }
}
