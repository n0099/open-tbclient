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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class r extends com.baidu.tieba.frs.j<bt, com.baidu.card.ak<bu>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String afG;
    private boolean aik;
    private NEGFeedBackView.a fRV;
    private com.baidu.tieba.card.aa<bu> fRr;
    private int hID;
    private com.baidu.tieba.frs.d.b hIE;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.aik = true;
        this.hID = 3;
        this.hIE = new com.baidu.tieba.frs.d.b();
        this.fRr = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                if (view != null && buVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(buVar, 2, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 5, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 14, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 12, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 13, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (r.this.fRr.agT instanceof Boolean) {
                            if (((Boolean) r.this.fRr.agT).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(buVar, 1, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(buVar, 3, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(buVar, 15, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar, 1, r.this.mPageId, r.this.hIE, r.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.cer().a(r.this.hIE, buVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.cer().a(r.this.hIE, buVar, 7);
                    } else {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    }
                }
            }
        };
        this.fRV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ap apVar) {
                TiebaStatic.log(new ao("c11973").dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ap apVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
                if (arrayList != null && apVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ao("c11974").dk("obj_locate", sb.toString()).dk("fid", apVar.getFid()).dk("tid", apVar.getTid()).dk("nid", apVar.getNid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("source", apVar.source).dk("weight", apVar.weight).dk("ab_tag", apVar.abTag).dk("extra", apVar.extra).ag(IntentConfig.CARD_TYPE, apVar.cardType).ag("obj_floor", apVar.dJw));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.bd(4272);
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
        lVar.setFromCDN(this.aik);
        lVar.setForm("frs");
        aVar.a((com.baidu.card.h) lVar);
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 2;
        cVar.dHw = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(this.hID);
        alVar.setFromForPb(this.hID);
        alVar.bd(16);
        aVar.b(alVar);
        com.baidu.card.ai sd = aVar.sd();
        sd.setSourceForPb(this.hID);
        com.baidu.card.ak<bu> akVar = new com.baidu.card.ak<>(sd);
        akVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bt) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bu buVar = ((bt) qVar).dLi;
                    buVar.objType = 1;
                    if (r.this.fRr != null) {
                        r.this.fRr.a(akVar2.getView(), buVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), r.this.hID, false);
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        akVar.sf();
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, com.baidu.card.ak<bu> akVar) {
        if (btVar == null || akVar == null || akVar.se() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) btVar, (bt) akVar);
        if (akVar.se() instanceof com.baidu.tieba.a.e) {
            akVar.se().setPage(this.afG);
        }
        com.baidu.tieba.frs.i.a(akVar.se().rY(), this.hzi);
        boolean z = (btVar.dLi.aSp() == null || btVar.dLi.aSp().getUserId() == null || !btVar.dLi.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (btVar.dLi.aTE() && btVar.dLi.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.z aI = akVar.aI(true);
            aI.a(this.fRV);
            aI.D(btVar.dLi.aPU());
        }
        akVar.sg();
        akVar.b((com.baidu.card.ak<bu>) btVar.dLi);
        akVar.b(this.fRr);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.hIE != null) {
            btVar.dLi.dJw = (btVar.position + 1) - (this.hzi != null ? this.hzi.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.cer().a(this.hIE, btVar.dLi);
        com.baidu.tieba.frs.d.a.a(btVar.dLi, this.mPageId, this.hIE, getTbPageTag());
        if (btVar != null) {
            btVar.dLi.aTB();
        }
        return akVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.hID = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hIE;
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
        this.aik = z;
    }
}
