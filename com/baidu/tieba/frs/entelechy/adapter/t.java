package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.d;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class t extends com.baidu.tieba.frs.k<ca, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private boolean akO;
    private NEGFeedBackView.a hnH;
    private com.baidu.tieba.card.ab<cb> hnd;
    private int jqD;
    private com.baidu.tieba.frs.b.b jqE;
    private TbPageContext<?> mPageContext;

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.akO = true;
        this.jqD = 3;
        this.jqE = new com.baidu.tieba.frs.b.b();
        this.hnd = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (t.this.hnd.ajn instanceof Boolean) {
                            if (((Boolean) t.this.hnd.ajn).booleanValue()) {
                                com.baidu.tieba.frs.b.a.a(cbVar, 1, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.b.a.a(cbVar, 3, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, t.this.mPageId, t.this.jqE, t.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKl().a(t.this.jqE, cbVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.b.c.cKl().a(t.this.jqE, cbVar, 7);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                }
            }
        };
        this.hnH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.t.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(av avVar) {
                TiebaStatic.log(new ar("c11973").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
                if (arrayList != null && avVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).ap(IntentConfig.CARD_TYPE, avVar.cardType).ap("obj_floor", avVar.eOs));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.mPageId);
        dVar.bq(4272);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.t.3
            @Override // com.baidu.card.d.a
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
        aVar.a(dVar);
        aVar.c(new com.baidu.card.t(this.mPageContext.getPageActivity()));
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.akO);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eMa = 2;
        eVar.eMg = 2;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(2);
        amVar.setShareReportFrom(this.jqD);
        amVar.setFromForPb(this.jqD);
        amVar.bq(48);
        aVar.b(amVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup);
        a2.setSourceForPb(this.jqD);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.t.4
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar2).eJQ;
                    cbVar.objType = 1;
                    if (t.this.hnd != null) {
                        t.this.hnd.a(threadCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), t.this.jqD, false);
                    threadCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        threadCardViewHolder.tk();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.tj() == null) {
            return null;
        }
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) threadCardViewHolder);
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jfU);
        boolean z = (caVar.eJQ.bnQ() == null || caVar.eJQ.bnQ().getUserId() == null || !caVar.eJQ.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (caVar.eJQ.bph() && caVar.eJQ.getFeedBackReasonMap() != null && !z) {
            com.baidu.card.ab aK = threadCardViewHolder.aK(true);
            aK.a(this.hnH);
            aK.C(caVar.eJQ.blp());
        }
        threadCardViewHolder.tl();
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.b(this.hnd);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (this.jqE != null) {
            caVar.eJQ.eOs = (caVar.position + 1) - (this.jfU != null ? this.jfU.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cKl().a(this.jqE, caVar.eJQ);
        com.baidu.tieba.frs.b.a.a(caVar.eJQ, this.mPageId, this.jqE, getTbPageTag());
        if (caVar != null) {
            caVar.eJQ.bpd();
        }
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqD = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqE;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akO = z;
    }
}
