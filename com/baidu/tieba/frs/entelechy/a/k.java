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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class k extends com.baidu.tieba.frs.h<bi, com.baidu.card.af<bj>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.x, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String Lg;
    private NEGFeedBackView.a eJF;
    private com.baidu.tieba.card.z<bj> eJc;
    private boolean guH;
    private int gum;
    private String mFrom;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.guH = false;
        this.gum = 3;
        this.eJc = new com.baidu.tieba.card.z<bj>() { // from class: com.baidu.tieba.frs.entelechy.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                if (view != null && bjVar != null) {
                    if (k.this.glP != null) {
                        k.this.glP.a(view, (View) bjVar, (Object) k.this.getType());
                    }
                    if ("c13010".equals(k.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").Z("obj_type", 1).s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 2, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 5, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 14, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 12, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 13, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (k.this.eJc.Ms instanceof Boolean) {
                            if (((Boolean) k.this.eJc.Ms).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bjVar, 1, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bjVar, 3, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bjVar, 15, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bjVar, 1, k.this.mPageId, com.baidu.tieba.frs.d.d.gun, k.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && bjVar.aAX()) {
                        k.this.am(bjVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.gun, bjVar.axR());
                    } else if (view instanceof TbImageView) {
                        if (k.this.eJc.Ms instanceof Boolean) {
                            if (((Boolean) k.this.eJc.Ms).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bjVar.aBx() != null && bjVar.aBx().cJB() != null && bjVar.aBx().cJB().aRz() != null && bjVar.aBx().cJB().aRz().size() > 0) {
                            i = bjVar.aBx().kfY ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.bIf().a(com.baidu.tieba.frs.d.d.gun, bjVar, 1);
                    }
                }
            }
        };
        this.eJF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.k.4
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
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = this.guH ? 10 : 2;
        dVar.cJD = 2;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(2);
        agVar.setStType("frs_page");
        agVar.setShareReportFrom(1);
        agVar.aV(3);
        agVar.aH(16);
        aVar.b(agVar);
        com.baidu.card.ad a = aVar.a(true, viewGroup, this.fUA);
        a.aM(3);
        com.baidu.card.af<bj> afVar = new com.baidu.card.af<>(a);
        afVar.setPageId(this.mPageId);
        afVar.af(true);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.k.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof com.baidu.card.af)) {
                    com.baidu.card.af afVar2 = (com.baidu.card.af) view.getTag();
                    bj bjVar = ((bi) mVar).cNb;
                    bjVar.objType = 1;
                    if (k.this.eJc != null) {
                        k.this.eJc.a(afVar2.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), k.this.gum, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar2.mU().b(new a.C0050a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bi biVar, com.baidu.card.af afVar) {
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) afVar);
        if (biVar == null || afVar == null || afVar.getView() == null) {
            return null;
        }
        afVar.mU().setPage(this.Lg);
        afVar.mU().setPosition(i);
        com.baidu.tieba.frs.g.a(afVar.mU().mO(), this.glJ);
        if (this.glJ != null && this.glJ.getForum() != null && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.glJ.getForum().getTopic_special_icon_right())) {
            biVar.cNb.cg(this.glJ.getForum().getTopic_special_icon(), this.glJ.getForum().getTopic_special_icon_right());
        }
        boolean z = (biVar.cNb.azX() == null || biVar.cNb.azX().getUserId() == null || !biVar.cNb.azX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (biVar.cNb.aBk() && biVar.cNb.getFeedBackReasonMap() != null && !z) {
            afVar.ad(false).a(this.eJF);
        }
        if (biVar.cNb.aBk()) {
            afVar.mU().mO().aH(32);
        }
        if (afVar.mU().mO() instanceof ag) {
            ((ag) afVar.mU().mO()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.frs.entelechy.a.k.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup, view, i));
                    }
                }
            });
        }
        afVar.b((com.baidu.card.af) biVar.cNb);
        afVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.mU().a(this.eJc);
        biVar.cNb.aBh();
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    @Override // com.baidu.tieba.card.x
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.x
    public void po(int i) {
        this.gum = i;
    }

    @Override // com.baidu.tieba.card.y
    public void kp(boolean z) {
        this.guH = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bFt() {
        return gun;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(bj bjVar) {
        TiebaStatic.log(new an("c12126").cp("tid", bjVar.getId()).Z("obj_locate", bBX() ? 2 : 1).s("obj_id", bjVar.aAq() == null ? -1L : bjVar.aAq().live_id).Z("obj_type", 1));
    }
}
