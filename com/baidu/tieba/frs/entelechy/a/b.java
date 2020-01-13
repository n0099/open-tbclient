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
import com.baidu.card.ah;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.frs.d.d {
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

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ddJ = false;
        this.Nj = true;
        this.gum = 3;
        this.gun = new com.baidu.tieba.frs.d.b();
        this.eJc = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if ("c13010".equals(b.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 3).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, b.this.mPageId, b.this.gun, b.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, b.this.mPageId, b.this.gun, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, b.this.mPageId, b.this.gun, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, b.this.mPageId, b.this.gun, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, b.this.mPageId, b.this.gun, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, b.this.mPageId, b.this.gun, b.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, b.this.mPageId, b.this.gun, b.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().a(b.this.gun, bjVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bIf().a(b.this.gun, bjVar, 1);
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
        this.eJF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.2
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
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.3
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
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext);
        zVar.b((Boolean) false);
        zVar.setFrom("frs");
        zVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        aVar.mS().aN(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(zVar);
        com.baidu.card.z zVar2 = new com.baidu.card.z(this.mPageContext);
        zVar2.b((Boolean) true);
        zVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        zVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39));
        zVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.axQ() != null && aVar2.axQ().cPN != null) {
                    au.a(aVar2.axQ().cPN, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) zVar2);
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        ahVar.b((Boolean) true);
        ahVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.b.5
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.axQ() != null && aVar2.axQ().cPN != null) {
                    au.a(aVar2.axQ().cPN, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) ahVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.Nj);
        kVar.setForm("frs");
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 2;
        dVar.cJD = 2;
        agVar.setAgreeStatisticData(dVar);
        if (this.gum == 15) {
            agVar.setFrom(10);
        } else {
            agVar.setFrom(2);
        }
        agVar.setShareReportFrom(3);
        agVar.aV(2);
        agVar.aH(16);
        aVar.b(agVar);
        aVar.mS().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ad a = aVar.a(true, viewGroup, this.fUA);
        a.aM(2);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.b.6
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cNb;
                    bjVar.objType = 1;
                    if (b.this.eJc != null) {
                        b.this.eJc.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), b.this.gum, false);
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
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.af<bj> afVar) {
        if (biVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        if (afVar.mU() instanceof com.baidu.tieba.a.e) {
            afVar.mU().setPage(this.Lg);
        }
        afVar.mU().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        com.baidu.tieba.frs.g.a(afVar.mU().mO(), this.glJ);
        if (this.glJ != null && this.glJ.getForum() != null && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon_right())) {
            biVar.cNb.cg(this.glJ.getForum().getTopic_special_icon(), this.glJ.getForum().getTopic_special_icon_right());
        }
        boolean z = (biVar.cNb.azX() == null || biVar.cNb.azX().getUserId() == null || !biVar.cNb.azX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.cNb.aBk() && biVar.cNb.getFeedBackReasonMap() != null && !z) {
            afVar.ad(true).a(this.eJF);
        }
        afVar.mW();
        if (biVar.cNb.aBk() && afVar.mU().mO() != null) {
            afVar.mU().mO().aH(32);
        }
        afVar.b((com.baidu.card.af<bj>) biVar.cNb);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.eJc);
        if (this.gun != null) {
            biVar.cNb.cLB = (biVar.position + 1) - (this.glJ != null ? this.glJ.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bIf().a(this.gun, biVar.cNb);
        al(biVar.cNb);
        biVar.cNb.aBh();
        com.baidu.tieba.frs.d.a.a(biVar.cNb, this.mPageId, this.gun, getTbPageTag());
        if (biVar.cNb != null) {
            biVar.cNb.aBh();
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

    public void setInFrsAllThread(boolean z) {
        this.ddJ = z;
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
