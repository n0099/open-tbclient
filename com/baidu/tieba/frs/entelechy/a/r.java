package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.am;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class r extends com.baidu.tieba.frs.k<bv, com.baidu.card.al<bw>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.d.d {
    private String agH;
    private boolean ajr;
    private com.baidu.tieba.card.aa<bw> giJ;
    private NEGFeedBackView.a gjn;
    private int icK;
    private com.baidu.tieba.frs.d.b icL;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.ajr = true;
        this.icK = 3;
        this.icL = new com.baidu.tieba.frs.d.b();
        this.giJ = new com.baidu.tieba.card.aa<bw>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                if (view != null && bwVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 2, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 5, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 14, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 12, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 13, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (r.this.giJ.ahT instanceof Boolean) {
                            if (((Boolean) r.this.giJ.ahT).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(bwVar, 1, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(bwVar, 3, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(bwVar, 15, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(bwVar, 1, r.this.mPageId, r.this.icL, r.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.csu().a(r.this.icL, bwVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.csu().a(r.this.icL, bwVar, 7);
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 3));
                    }
                }
            }
        };
        this.gjn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
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
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.al<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.mPageId);
        eVar.bk(4272);
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
        aVar.c(new com.baidu.card.s(this.mPageContext.getPageActivity()));
        com.baidu.card.m mVar = new com.baidu.card.m(this.mPageContext.getPageActivity());
        mVar.setFromCDN(this.ajr);
        mVar.setForm("frs");
        aVar.a((com.baidu.card.h) mVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 2;
        cVar.dWQ = 2;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(this.icK);
        amVar.setFromForPb(this.icK);
        amVar.bk(16);
        aVar.b(amVar);
        com.baidu.card.aj tQ = aVar.tQ();
        tQ.setSourceForPb(this.icK);
        com.baidu.card.al<bw> alVar = new com.baidu.card.al<>(tQ);
        alVar.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof com.baidu.card.al)) {
                    com.baidu.card.al alVar2 = (com.baidu.card.al) view.getTag();
                    bw bwVar = ((bv) qVar).dUS;
                    bwVar.objType = 1;
                    if (r.this.giJ != null) {
                        r.this.giJ.a(alVar2.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), r.this.icK, false);
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        alVar.tS();
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.al<bw> alVar) {
        if (bvVar == null || alVar == null || alVar.tR() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) bvVar, (bv) alVar);
        if (alVar.tR() instanceof com.baidu.tieba.a.e) {
            alVar.tR().setPage(this.agH);
        }
        com.baidu.tieba.frs.j.a(alVar.tR().tL(), this.hSn);
        boolean z = (bvVar.dUS.beE() == null || bvVar.dUS.beE().getUserId() == null || !bvVar.dUS.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bvVar.dUS.bfT() && bvVar.dUS.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.aa aL = alVar.aL(true);
            aL.a(this.gjn);
            aL.F(bvVar.dUS.bcg());
        }
        alVar.tT();
        alVar.b((com.baidu.card.al<bw>) bvVar.dUS);
        alVar.b(this.giJ);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.icL != null) {
            bvVar.dUS.dZb = (bvVar.position + 1) - (this.hSn != null ? this.hSn.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.csu().a(this.icL, bvVar.dUS);
        com.baidu.tieba.frs.d.a.a(bvVar.dUS, this.mPageId, this.icL, getTbPageTag());
        if (bvVar != null) {
            bvVar.dUS.bfQ();
        }
        return alVar.getView();
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void tz(int i) {
        this.icK = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icL;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.ajr = z;
    }
}
