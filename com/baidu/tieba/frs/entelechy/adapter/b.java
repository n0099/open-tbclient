package com.baidu.tieba.frs.entelechy.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.d;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.frs.k<by, ThreadCardViewHolder<bz>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.frs.b.d {
    private String aji;
    private boolean alQ;
    private boolean fmV;
    private NEGFeedBackView.a hnM;
    private com.baidu.tieba.card.aa<bz> hni;
    private HashSet<String> jpo;
    private int jpp;
    private com.baidu.tieba.frs.b.b jpq;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fmV = false;
        this.alQ = true;
        this.jpp = 3;
        this.jpq = new com.baidu.tieba.frs.b.b();
        this.hni = new com.baidu.tieba.card.aa<bz>() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                if (view != null && bzVar != null) {
                    if ("c13010".equals(b.this.mFrom)) {
                        TiebaStatic.log(new aq("c13010").an("obj_type", 3).w("fid", bzVar.getFid()).dX("tid", bzVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 2, b.this.mPageId, b.this.jpq, b.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 15, b.this.mPageId, b.this.jpq, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 5, b.this.mPageId, b.this.jpq, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 14, b.this.mPageId, b.this.jpq, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 12, b.this.mPageId, b.this.jpq, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(bzVar, 13, b.this.mPageId, b.this.jpq, b.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(bzVar, 1, b.this.mPageId, b.this.jpq, b.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cMI().a(b.this.jpq, bzVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.b.c.cMI().a(b.this.jpq, bzVar, 1);
                    } else {
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        aq aqVar = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar.dX("obj_type", "1");
                        aqVar.dX("tid", bzVar.getTid());
                        TiebaStatic.log(aqVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        aq aqVar2 = new aq(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        aqVar2.dX("obj_type", "3");
                        aqVar2.dX("tid", bzVar.getTid());
                        TiebaStatic.log(aqVar2);
                    }
                }
            }
        };
        this.hnM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
                TiebaStatic.log(new aq("c11973").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
                if (arrayList != null && atVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + ",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new aq("c11974").dX("obj_locate", sb.toString()).dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX(IntentConfig.NID, atVar.bpO()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("source", atVar.source).dX("weight", atVar.weight).dX("ab_tag", atVar.abTag).dX("extra", atVar.extra).an(IntentConfig.CARD_TYPE, atVar.cardType).an("obj_floor", atVar.eQR));
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
    public ThreadCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bs(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.3
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
        com.baidu.card.af afVar = new com.baidu.card.af(this.mPageContext);
        afVar.c(false);
        afVar.setFrom("frs");
        if (this.jpp == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        aVar.tx().bz(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.c(true);
        afVar2.setFrom("frs");
        if (this.jpp == 502) {
            afVar2.setNeedFrsTabName(false);
        } else {
            afVar2.setNeedFrsTabName(true);
        }
        afVar2.e(com.baidu.tbadk.a.b.b.bnj(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.b.bnj(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new a.InterfaceC0089a() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.4
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.boO() != null && aVar2.boO().eVB != null) {
                    ay.a(aVar2.boO().eVB, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) afVar2);
        an anVar = new an(this.mPageContext.getPageActivity());
        anVar.c(true);
        anVar.a(new a.InterfaceC0089a() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.5
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.boO() != null && aVar2.boO().eVB != null) {
                    ay.a(aVar2.boO().eVB, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) anVar);
        com.baidu.card.n nVar = new com.baidu.card.n(this.mPageContext.getPageActivity());
        nVar.setFromCDN(this.alQ);
        nVar.setForm("frs");
        aVar.a((com.baidu.card.h) nVar);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.eOz = 2;
        dVar2.eOF = 2;
        amVar.setAgreeStatisticData(dVar2);
        amVar.setFrom(2);
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bs(16);
        aVar.b(amVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.iKI);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<bz> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.6
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar2).eMv;
                    bzVar.objType = 1;
                    if (b.this.hni != null) {
                        b.this.hni.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), b.this.jpp, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        threadCardViewHolder.tz();
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        if (threadCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.ty().setPage(this.aji);
        }
        threadCardViewHolder.ty().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) byVar, (by) threadCardViewHolder);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.ty().ts(), this.jeH);
        if (this.jeH != null && this.jeH.getForum() != null && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jeH.getForum().getTopic_special_icon_right())) {
            byVar.eMv.dK(this.jeH.getForum().getTopic_special_icon(), this.jeH.getForum().getTopic_special_icon_right());
        }
        boolean z = (byVar.eMv.brq() == null || byVar.eMv.brq().getUserId() == null || !byVar.eMv.brq().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (byVar.eMv.bsI() && byVar.eMv.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hnM);
        }
        threadCardViewHolder.tA();
        if (threadCardViewHolder.ty().ts() != null) {
            threadCardViewHolder.ty().ts().bs(32);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eMv);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.hni);
        if (this.jpq != null) {
            byVar.eMv.eQR = (byVar.position + 1) - (this.jeH != null ? this.jeH.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cMI().a(this.jpq, byVar.eMv);
        aq(byVar.eMv);
        byVar.eMv.bsE();
        com.baidu.tieba.frs.b.a.a(byVar.eMv, this.mPageId, this.jpq, getTbPageTag());
        if (byVar.eMv != null) {
            byVar.eMv.bsE();
        }
        return threadCardViewHolder.getView();
    }

    private void aq(bz bzVar) {
        if (this.jpo == null) {
            this.jpo = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cMI().a(bzVar, this.jpo);
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.y
    public void wt(int i) {
        this.jpp = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.fmV = z;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jpq;
    }
}
