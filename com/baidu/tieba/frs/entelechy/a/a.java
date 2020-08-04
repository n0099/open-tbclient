package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.frs.j<bv, com.baidu.card.ak<bv>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.aa<bv> adN;
    private String afx;
    private NEGFeedBackView.a fXo;
    private int hOC;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hOC = 3;
        this.adN = new com.baidu.tieba.card.aa<bv>() { // from class: com.baidu.tieba.frs.entelechy.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                com.baidu.tieba.card.s.bRL().km(true);
                com.baidu.tieba.a.d.brD().dk("page_recommend", "show_");
                if (view != null && bvVar != null && !StringUtils.isNull(bvVar.getTid())) {
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.chQ().a(com.baidu.tieba.frs.d.d.hOG, bvVar, 13);
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 2, a.this.mPageId, com.baidu.tieba.frs.d.d.hOG, a.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 15, a.this.mPageId, com.baidu.tieba.frs.d.d.hOG, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 5, a.this.mPageId, com.baidu.tieba.frs.d.d.hOG, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 14, a.this.mPageId, com.baidu.tieba.frs.d.d.hOG, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 12, a.this.mPageId, com.baidu.tieba.frs.d.d.hOG, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bvVar, 13, a.this.mPageId, com.baidu.tieba.frs.d.d.hOG, a.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bvVar, 1, a.this.mPageId, com.baidu.tieba.frs.d.d.hOG, a.this.getTbPageTag());
                    }
                }
            }
        };
        this.fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.a.2
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.ak<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dNB = 2;
        cVar.dNH = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(3);
        aVar.b(alVar);
        aVar.se().bm(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.se().bn(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        aVar.se().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ai a = aVar.a(true, viewGroup, this.hlu);
        a.setSourceForPb(3);
        com.baidu.card.ak<bv> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.a.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.ak<bv> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) akVar);
        if (bvVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.c.chQ().a(hOG, bvVar);
        akVar.sg().setPage(this.afx);
        akVar.sg().setPosition(i);
        if (this.hOC == 1) {
            akVar.aK(true).a(this.fXo);
        }
        akVar.a(true, Align.ALIGN_RIGHT_TOP);
        akVar.b((com.baidu.card.ak<bv>) bvVar);
        akVar.sg().a(this.adN);
        akVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.ak)) {
            bv bvVar = (bv) qVar;
            bvVar.objType = 1;
            ax.a((AbsThreadDataSupport) bvVar, view.getContext(), 3, false);
            ((com.baidu.card.ak) view.getTag()).sg().b(new a.C0096a(1));
        }
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.a.f
    public void AP(String str) {
        this.afx = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void rn(int i) {
        this.hOC = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hOG;
    }
}
