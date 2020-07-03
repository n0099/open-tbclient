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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.frs.j<bu, com.baidu.card.ak<bu>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private com.baidu.tieba.card.aa<bu> adX;
    private String afG;
    private NEGFeedBackView.a fRV;
    private int hIA;

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.hIA = 3;
        this.adX = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                com.baidu.tieba.card.s.bOA().jI(true);
                com.baidu.tieba.a.d.boA().dh("page_recommend", "show_");
                if (view != null && buVar != null && !StringUtils.isNull(buVar.getTid())) {
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.ceq().a(com.baidu.tieba.frs.d.d.hIE, buVar, 13);
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(buVar, 2, a.this.mPageId, com.baidu.tieba.frs.d.d.hIE, a.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(buVar, 15, a.this.mPageId, com.baidu.tieba.frs.d.d.hIE, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 5, a.this.mPageId, com.baidu.tieba.frs.d.d.hIE, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(buVar, 14, a.this.mPageId, com.baidu.tieba.frs.d.d.hIE, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 12, a.this.mPageId, com.baidu.tieba.frs.d.d.hIE, a.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(buVar, 13, a.this.mPageId, com.baidu.tieba.frs.d.d.hIE, a.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar, 1, a.this.mPageId, com.baidu.tieba.frs.d.d.hIE, a.this.getTbPageTag());
                    }
                }
            }
        };
        this.fRV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.a.2
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.b(this.mPageContext);
        aVar.a(eVar);
        aVar.c(new com.baidu.card.c(this.mPageContext.getPageActivity()));
        com.baidu.card.al alVar = new com.baidu.card.al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 2;
        cVar.dHw = 2;
        alVar.setAgreeStatisticData(cVar);
        alVar.setFrom(2);
        alVar.setShareReportFrom(1);
        alVar.setFromForPb(3);
        aVar.b(alVar);
        aVar.sc().bk(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
        aVar.sc().bl(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds17));
        aVar.sc().setBackgroundResource(R.drawable.addresslist_item_bg);
        com.baidu.card.ai a = aVar.a(true, viewGroup, this.hfK);
        a.setSourceForPb(3);
        com.baidu.card.ak<bu> akVar = new com.baidu.card.ak<>(a);
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
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.ak<bu> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) buVar, (bu) akVar);
        if (buVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        com.baidu.tieba.frs.d.c.ceq().a(hIE, buVar);
        akVar.se().setPage(this.afG);
        akVar.se().setPosition(i);
        if (this.hIA == 1) {
            akVar.aI(true).a(this.fRV);
        }
        akVar.a(true, buVar.aPZ() ? Align.ALIGN_RIGHT_TOP : Align.ALIGN_RIGHT_BOTTOM);
        akVar.b((com.baidu.card.ak<bu>) buVar);
        akVar.se().a(this.adX);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.adp.widget.ListView.q qVar) {
        if ((qVar instanceof bu) && (view.getTag() instanceof com.baidu.card.ak)) {
            bu buVar = (bu) qVar;
            buVar.objType = 1;
            aw.a((AbsThreadDataSupport) buVar, view.getContext(), 3, false);
            ((com.baidu.card.ak) view.getTag()).se().b(new a.C0098a(1));
        }
    }

    @Override // com.baidu.tieba.frs.j
    public void setFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.hIA = i;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hIE;
    }
}
