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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.frs.k<ca, ThreadCardViewHolder<cb>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.b.d {
    private String aif;
    private boolean akO;
    private boolean fkD;
    private NEGFeedBackView.a hnH;
    private com.baidu.tieba.card.ab<cb> hnd;
    private HashSet<String> jqC;
    private int jqD;
    private com.baidu.tieba.frs.b.b jqE;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fkD = false;
        this.akO = true;
        this.jqD = 3;
        this.jqE = new com.baidu.tieba.frs.b.b();
        this.hnd = new com.baidu.tieba.card.ab<cb>() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                if (view != null && cbVar != null) {
                    if ("c13010".equals(b.this.mFrom)) {
                        TiebaStatic.log(new ar("c13010").ap("obj_type", 3).v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 2, b.this.mPageId, b.this.jqE, b.this.getTbPageTag());
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 15, b.this.mPageId, b.this.jqE, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 5, b.this.mPageId, b.this.jqE, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 14, b.this.mPageId, b.this.jqE, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_agree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 12, b.this.mPageId, b.this.jqE, b.this.getTbPageTag());
                    } else if (view.getId() == R.id.img_disagree) {
                        com.baidu.tieba.frs.b.a.a(cbVar, 13, b.this.mPageId, b.this.jqE, b.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.b.a.a(cbVar, 1, b.this.mPageId, b.this.jqE, b.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.b.c.cKl().a(b.this.jqE, cbVar, 2);
                    } else if (view.getId() != R.id.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.b.c.cKl().a(b.this.jqE, cbVar, 1);
                    } else {
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 3));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        ar arVar = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar.dR("obj_type", "1");
                        arVar.dR("tid", cbVar.getTid());
                        TiebaStatic.log(arVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        ar arVar2 = new ar(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        arVar2.dR("obj_type", "3");
                        arVar2.dR("tid", cbVar.getTid());
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        };
        this.hnH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.2
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
        dVar.bq(4280);
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
        if (this.jqD == 502) {
            afVar.setNeedFrsTabName(false);
        } else {
            afVar.setNeedFrsTabName(true);
        }
        aVar.ti().bx(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds38));
        aVar.c(afVar);
        com.baidu.card.af afVar2 = new com.baidu.card.af(this.mPageContext);
        afVar2.c(true);
        afVar2.setFrom("frs");
        if (this.jqD == 502) {
            afVar2.setNeedFrsTabName(false);
        } else {
            afVar2.setNeedFrsTabName(true);
        }
        afVar2.e(com.baidu.tbadk.a.b.b.bjL(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), com.baidu.tbadk.a.b.b.bjL(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
        afVar2.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.4
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bln() != null && aVar2.bln().eTc != null) {
                    az.a(aVar2.bln().eTc, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) afVar2);
        an anVar = new an(this.mPageContext.getPageActivity());
        anVar.c(true);
        anVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.5
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.bln() != null && aVar2.bln().eTc != null) {
                    az.a(aVar2.bln().eTc, b.this.mContext, 3);
                }
            }
        });
        aVar.a((com.baidu.card.h) anVar);
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
        amVar.setShareReportFrom(1);
        amVar.setFromForPb(3);
        amVar.bq(16);
        aVar.b(amVar);
        com.baidu.card.ak a2 = aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.iLY);
        a2.setSourceForPb(3);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.mPageId);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.frs.entelechy.adapter.b.6
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar2 instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar2).eJQ;
                    cbVar.objType = 1;
                    if (b.this.hnd != null) {
                        b.this.hnd.a(threadCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), b.this.jqD, false);
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
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        if (threadCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tj().setPage(this.aif);
        }
        threadCardViewHolder.tj().setPosition(i);
        super.a(i, view, viewGroup, (ViewGroup) caVar, (ca) threadCardViewHolder);
        com.baidu.tieba.frs.j.a(threadCardViewHolder.tj().td(), this.jfU);
        if (this.jfU != null && this.jfU.getForum() != null && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.jfU.getForum().getTopic_special_icon_right())) {
            caVar.eJQ.dD(this.jfU.getForum().getTopic_special_icon(), this.jfU.getForum().getTopic_special_icon_right());
        }
        boolean z = (caVar.eJQ.bnQ() == null || caVar.eJQ.bnQ().getUserId() == null || !caVar.eJQ.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (caVar.eJQ.bph() && caVar.eJQ.getFeedBackReasonMap() != null && !z) {
            threadCardViewHolder.aK(true).a(this.hnH);
        }
        threadCardViewHolder.tl();
        if (threadCardViewHolder.tj().td() != null) {
            threadCardViewHolder.tj().td().bq(32);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.hnd);
        if (this.jqE != null) {
            caVar.eJQ.eOs = (caVar.position + 1) - (this.jfU != null ? this.jfU.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.b.c.cKl().a(this.jqE, caVar.eJQ);
        ar(caVar.eJQ);
        caVar.eJQ.bpd();
        com.baidu.tieba.frs.b.a.a(caVar.eJQ, this.mPageId, this.jqE, getTbPageTag());
        if (caVar.eJQ != null) {
            caVar.eJQ.bpd();
        }
        return threadCardViewHolder.getView();
    }

    private void ar(cb cbVar) {
        if (this.jqC == null) {
            this.jqC = new HashSet<>();
        }
        com.baidu.tieba.frs.b.c.cKl().a(cbVar, this.jqC);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void uX(int i) {
        this.jqD = i;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }

    public void setInFrsAllThread(boolean z) {
        this.fkD = z;
    }

    @Override // com.baidu.tieba.frs.k
    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jqE;
    }
}
