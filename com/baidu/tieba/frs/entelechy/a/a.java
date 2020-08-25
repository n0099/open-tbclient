package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.frs.k<bw, com.baidu.card.al<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.aa<bw> aeT;
    private String agH;
    private NEGFeedBackView.a gjn;
    private int icH;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.icH = 3;
        this.aeT = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                com.baidu.tieba.card.s.cbX().kK(true);
                com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
                if (view != null && bwVar != null && !StringUtils.isNull(bwVar.getTid())) {
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.csu().a(com.baidu.tieba.frs.d.d.icL, bwVar, 13);
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, a.this.mPageId, com.baidu.tieba.frs.d.d.icL, a.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, a.this.mPageId, com.baidu.tieba.frs.d.d.icL, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, a.this.mPageId, com.baidu.tieba.frs.d.d.icL, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, a.this.mPageId, com.baidu.tieba.frs.d.d.icL, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, a.this.mPageId, com.baidu.tieba.frs.d.d.icL, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, a.this.mPageId, com.baidu.tieba.frs.d.d.icL, a.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, a.this.mPageId, com.baidu.tieba.frs.d.d.icL, a.this.getTbPageTag());
                    }
                }
            }
        };
        this.gjn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.a.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
                TiebaStatic.log(new aq("c11973").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
                if (arrayList != null && arVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aq("c11974").dD("obj_locate", sb.toString()).dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("source", arVar.source).dD("weight", arVar.weight).dD("ab_tag", arVar.abTag).dD("extra", arVar.extra).ai(IntentConfig.CARD_TYPE, arVar.cardType).ai("obj_floor", arVar.dZb));
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.al<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 2;
        cVar.dWQ = 2;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        aVar.b(amVar);
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.tP().bs(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.aj a = aVar.a(true, viewGroup, this.hyl);
        a.setSourceForPb(3);
        com.baidu.card.al<bw> alVar = new com.baidu.card.al<>(a);
        alVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.a.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                a.this.a(view, qVar);
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.card.al<bw> alVar) {
        super.a(i, view, viewGroup, (ViewGroup) bwVar, (bw) alVar);
        if (bwVar == null || alVar == null || alVar.getView() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.c.csu().a(icL, bwVar);
        alVar.tR().setPage(this.agH);
        alVar.tR().setPosition(i);
        if (this.icH == 1) {
            alVar.aL(true).a(this.gjn);
        }
        alVar.a(true, Align.ALIGN_RIGHT_TOP);
        alVar.b((com.baidu.card.al<bw>) bwVar);
        alVar.tR().a(this.aeT);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return alVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof bw) && (view.getTag() instanceof com.baidu.card.al)) {
            bw bwVar = (bw) qVar;
            bwVar.objType = 1;
            ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 3, false);
            ((com.baidu.card.al) view.getTag()).tR().b(new a.C0095a(1));
        }
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icH = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return icL;
    }
}
