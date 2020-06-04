package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
public class c extends com.baidu.tieba.frs.h<bk, com.baidu.card.ag<bk>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String aeX;
    private boolean aha;
    private boolean dWD;
    private NEGFeedBackView.a fGM;
    private com.baidu.tieba.card.aa<bk> fGi;
    private HashSet<String> hvJ;
    private int hvK;
    private com.baidu.tieba.frs.d.b hvL;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.dWD = false;
        this.aha = true;
        this.hvK = 3;
        this.hvL = new com.baidu.tieba.frs.d.b();
        this.fGi = new com.baidu.tieba.card.aa<bk>() { // from class: com.baidu.tieba.frs.entelechy.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                if (view != null && bkVar != null) {
                    if ("c13010".equals(c.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").ag("obj_type", 3).s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 2, c.this.mPageId, c.this.hvL, c.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 15, c.this.mPageId, c.this.hvL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 5, c.this.mPageId, c.this.hvL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 14, c.this.mPageId, c.this.hvL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 12, c.this.mPageId, c.this.hvL, c.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bkVar, 13, c.this.mPageId, c.this.hvL, c.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bkVar, 1, c.this.mPageId, c.this.hvL, c.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.caY().a(c.this.hvL, bkVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.caY().a(c.this.hvL, bkVar, 1);
                    } else {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        an anVar = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar.dh("obj_type", "1");
                        anVar.dh("tid", bkVar.getTid());
                        TiebaStatic.log(anVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        an anVar2 = new an(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        anVar2.dh("obj_type", "3");
                        anVar2.dh("tid", bkVar.getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.fGM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ak akVar) {
                TiebaStatic.log(new an("c11973").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ak akVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
                if (arrayList != null && akVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").dh("obj_locate", sb.toString()).dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("source", akVar.source).dh("weight", akVar.weight).dh("ab_tag", akVar.abTag).dh("extra", akVar.extra).ag(IntentConfig.CARD_TYPE, akVar.cardType).ag("obj_floor", akVar.dDb));
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
    public com.baidu.card.ag<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.aX(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.3
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext);
        aaVar.b((Boolean) false);
        aaVar.setFrom("frs");
        if (this.hvK == 502) {
            aaVar.setNeedFrsTabName(false);
        } else {
            aaVar.setNeedFrsTabName(true);
        }
        aaVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds20));
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(aaVar);
        com.baidu.card.aa aaVar2 = new com.baidu.card.aa(this.mPageContext);
        aaVar2.b((Boolean) true);
        aaVar2.setFrom("frs");
        if (this.hvK == 502) {
            aaVar2.setNeedFrsTabName(false);
        } else {
            aaVar2.setNeedFrsTabName(true);
        }
        aaVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds39));
        aaVar2.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) aaVar2);
        com.baidu.card.ai aiVar = new com.baidu.card.ai(this.mPageContext.getPageActivity());
        aiVar.b((Boolean) true);
        aiVar.a(new b.a() { // from class: com.baidu.tieba.frs.entelechy.a.c.5
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null && absThreadDataSupport.aOi().dHm != null) {
                    au.a(absThreadDataSupport.aOi().dHm, c.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) aiVar);
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aha);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.ah ahVar = new com.baidu.card.ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 2;
        cVar.dBf = 2;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(2);
        ahVar.setShareReportFrom(1);
        ahVar.bm(3);
        ahVar.aX(16);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ae a = aVar.a(true, viewGroup, this.gTb);
        a.setSourceForPb(3);
        com.baidu.card.ag<bk> agVar = new com.baidu.card.ag<>(a);
        agVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.frs.entelechy.a.c.6
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bk) && (view.getTag() instanceof com.baidu.card.ag)) {
                    com.baidu.card.ag agVar2 = (com.baidu.card.ag) view.getTag();
                    bk bkVar = (bk) oVar;
                    bkVar.objType = 1;
                    if (c.this.fGi != null) {
                        c.this.fGi.a(agVar2.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), c.this.hvK, false);
                    agVar2.rM().b(new a.C0097a(1));
                }
            }
        });
        agVar.rN();
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bk bkVar, com.baidu.card.ag<bk> agVar) {
        if (bkVar == null || agVar == null || agVar.getView() == null) {
            return null;
        }
        if (agVar.rM() instanceof com.baidu.tieba.a.e) {
            agVar.rM().setPage(this.aeX);
        }
        agVar.rM().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) bkVar, (bk) agVar);
        com.baidu.tieba.frs.g.a(agVar.rM().rG(), this.hmR);
        if (this.hmR != null && this.hmR.getForum() != null && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hmR.getForum().getTopic_special_icon_right())) {
            bkVar.cY(this.hmR.getForum().getTopic_special_icon(), this.hmR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bkVar.aQx() == null || bkVar.aQx().getUserId() == null || !bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bkVar.aRN() && bkVar.getFeedBackReasonMap() != null && !z) {
            agVar.aH(true).a(this.fGM);
        }
        agVar.rO();
        if (bkVar.aRN() && agVar.rM().rG() != null) {
            agVar.rM().rG().aX(32);
        }
        agVar.b((com.baidu.card.ag<bk>) bkVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.fGi);
        if (this.hvL != null) {
            bkVar.dDb = (bkVar.position + 1) - (this.hmR != null ? this.hmR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.caY().a(this.hvL, bkVar);
        aq(bkVar);
        bkVar.aRK();
        com.baidu.tieba.frs.d.a.a(bkVar, this.mPageId, this.hvL, getTbPageTag());
        if (bkVar != null) {
            bkVar.aRK();
        }
        return agVar.getView();
    }

    private void aq(bk bkVar) {
        if (this.hvJ == null) {
            this.hvJ = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.caY().a(bkVar, this.hvJ);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void qy(int i) {
        this.hvK = i;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvL;
    }
}
