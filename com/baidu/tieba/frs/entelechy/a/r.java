package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class r extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String afx;
    private boolean aib;
    private com.baidu.tieba.card.aa<bv> fWK;
    private NEGFeedBackView.a fXo;
    private int hOD;
    private com.baidu.tieba.frs.d.b hOE;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aib = true;
        this.hOD = 3;
        this.hOE = new com.baidu.tieba.frs.d.b();
        this.fWK = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                if (view != null && bvVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 12, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 13, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (r.this.fWK.agK instanceof Boolean) {
                            if (((Boolean) r.this.fWK.agK).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bvVar, 1, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bvVar, 3, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, r.this.mPageId, r.this.hOE, r.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.chQ().a(r.this.hOE, bvVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.chQ().a(r.this.hOE, bvVar, 7);
                    } else {
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 3));
                    }
                }
            }
        };
        this.fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aq aqVar) {
                TiebaStatic.log(new ap("c11973").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
                if (arrayList != null && aqVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ap("c11974").dn("obj_locate", sb.toString()).dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("source", aqVar.source).dn("weight", aqVar.weight).dn("ab_tag", aqVar.abTag).dn("extra", aqVar.extra).ah(IntentConfig.CARD_TYPE, aqVar.cardType).ah("obj_floor", aqVar.dPI));
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
    public com.baidu.card.ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.bf(4272);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.3
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
        aVar.c(new com.baidu.card.r(this.mPageContext.getPageActivity()));
        com.baidu.card.l lVar = new com.baidu.card.l(this.mPageContext.getPageActivity());
        lVar.setFromCDN(this.aib);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 2;
        cVar.dNH = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(this.hOD);
        alVar.setFromForPb(this.hOD);
        alVar.bf(16);
        aVar.b(alVar);
        com.baidu.card.ai sf = aVar.sf();
        sf.setSourceForPb(this.hOD);
        com.baidu.card.ak<bv> akVar = new com.baidu.card.ak<>(sf);
        akVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (r.this.fWK != null) {
                        r.this.fWK.a(akVar2.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), r.this.hOD, false);
                    akVar2.sg().b(new a.C0096a(1));
                }
            }
        });
        akVar.sh();
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.ak<bv> akVar) {
        if (buVar == null || akVar == null || akVar.sg() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) akVar);
        if (akVar.sg() instanceof com.baidu.tieba.a.e) {
            akVar.sg().setPage(this.afx);
        }
        com.baidu.tieba.frs.i.a(akVar.sg().sa(), this.hEX);
        boolean z = (buVar.dLK.aWl() == null || buVar.dLK.aWl().getUserId() == null || !buVar.dLK.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (buVar.dLK.aXA() && buVar.dLK.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.z aK = akVar.aK(true);
            aK.a(this.fXo);
            aK.D(buVar.dLK.aTP());
        }
        akVar.si();
        akVar.b((com.baidu.card.ak<bv>) buVar.dLK);
        akVar.b(this.fWK);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.hOE != null) {
            buVar.dLK.dPI = (buVar.position + 1) - (this.hEX != null ? this.hEX.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.chQ().a(this.hOE, buVar.dLK);
        com.baidu.tieba.frs.d.a.a(buVar.dLK, this.mPageId, this.hOE, getTbPageTag());
        if (buVar != null) {
            buVar.dLK.aXx();
        }
        return akVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOD = i;
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOE;
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aib = z;
    }
}
