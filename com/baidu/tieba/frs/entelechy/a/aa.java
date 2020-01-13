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
/* loaded from: classes7.dex */
public class aa extends com.baidu.tieba.frs.h<bj, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
    private String Lg;
    private boolean Nj;
    private boolean ddJ;
    private NEGFeedBackView.a eJF;
    private com.baidu.tieba.card.z<bj> eJc;
    private HashSet<String> gul;
    private int gum;
    private com.baidu.tieba.frs.d.b gun;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ddJ = false;
        this.Nj = true;
        this.gum = 3;
        this.gun = new com.baidu.tieba.frs.d.b();
        this.eJc = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if ("c13010".equals(aa.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 3).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, aa.this.mPageId, aa.this.gun, aa.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, aa.this.mPageId, aa.this.gun, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, aa.this.mPageId, aa.this.gun, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, aa.this.mPageId, aa.this.gun, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, aa.this.mPageId, aa.this.gun, aa.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, aa.this.mPageId, aa.this.gun, aa.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, aa.this.mPageId, aa.this.gun, aa.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().a(aa.this.gun, bjVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bIf().a(aa.this.gun, bjVar, 1);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar.cp("obj_type", "1");
                        anVar.cp("tid", bjVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar2.cp("obj_type", "3");
                        anVar2.cp("tid", bjVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.eJF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.aa.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(new an("c11973").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").cp("obj_locate", sb.toString()).cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("source", alVar.source).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cp(TiebaInitialize.Params.AB_TAG, alVar.cLA).cp("extra", alVar.extra).Z("card_type", alVar.cardType).Z("obj_floor", alVar.cLB));
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
        eVar.aH(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.aa.3
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
        aiVar.aW(3);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Nj);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 2;
        dVar.cJD = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setShareReportFrom(2);
        agVar.aV(3);
        agVar.aH(16);
        aVar.b(agVar);
        com.baidu.card.ad mT = aVar.mT();
        mT.aM(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(mT);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.aa.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bj) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = (bj) mVar;
                    bjVar.objType = 1;
                    if (aa.this.eJc != null) {
                        aa.this.eJc.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 3, false);
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        afVar.mV();
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.af<bj> afVar) {
        if (bjVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        if (afVar.mU() instanceof com.baidu.tieba.a.e) {
            afVar.mU().setPage(this.Lg);
        }
        super.a(i, view, viewGroup, (ViewGroup) bjVar, (bj) afVar);
        com.baidu.tieba.frs.g.a(afVar.mU().mO(), this.glJ);
        if (this.glJ != null && this.glJ.getForum() != null && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon_right())) {
            bjVar.cg(this.glJ.getForum().getTopic_special_icon(), this.glJ.getForum().getTopic_special_icon_right());
        }
        boolean z = (bjVar.azX() == null || bjVar.azX().getUserId() == null || !bjVar.azX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bjVar.aBk() && bjVar.getFeedBackReasonMap() != null && !z) {
            afVar.ad(true).a(this.eJF);
        }
        afVar.mW();
        afVar.b((com.baidu.card.af<bj>) bjVar);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.eJc);
        if (this.gun != null) {
            bjVar.cLB = (i + 1) - (this.glJ != null ? this.glJ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bIf().a(this.gun, bjVar);
        al(bjVar);
        bjVar.aBh();
        com.baidu.tieba.frs.d.a.a(bjVar, this.mPageId, this.gun, getTbPageTag());
        if (bjVar != null) {
            bjVar.aBh();
        }
        return afVar.getView();
    }

    private void al(bj bjVar) {
        if (this.gul == null) {
            this.gul = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bIf().a(bjVar, this.gul);
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
        this.gum = i;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bFt() {
        return this.gun;
    }
}
