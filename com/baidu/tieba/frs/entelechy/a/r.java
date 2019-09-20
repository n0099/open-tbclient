package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class r extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WM;
    private boolean ccM;
    private NEGFeedBackView.a dGG;
    private ab<bh> dGe;
    private boolean fEF;
    private int fEH;
    private String mFrom;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fEF = false;
        this.ccM = false;
        this.fEH = 3;
        this.dGe = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (r.this.fvK != null) {
                        r.this.fvK.a(view, (View) bhVar, (Object) r.this.getType());
                    }
                    if ("c13010".equals(r.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).n("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.afw()) {
                        r.this.ag(bhVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bsF().a(com.baidu.tieba.frs.d.d.fEI, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, r.this.mPageId, com.baidu.tieba.frs.d.d.fEI);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fEI, bhVar.acD());
                    } else if (view instanceof TbImageView) {
                        if (r.this.dGe.XI instanceof Boolean) {
                            if (((Boolean) r.this.dGe.XI).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bsF().a(com.baidu.tieba.frs.d.d.fEI, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fEI);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bsF().a(com.baidu.tieba.frs.d.d.fEI, bhVar, 3);
                            com.baidu.tieba.frs.d.a.a(bhVar, 3, r.this.mPageId, com.baidu.tieba.frs.d.d.fEI);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bsF().a(com.baidu.tieba.frs.d.d.fEI, bhVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bhVar.aga() != null && bhVar.aga().cqB() != null && bhVar.aga().cqB().ayZ() != null && bhVar.aga().cqB().ayZ().size() > 0) {
                            i = bhVar.aga().jjh ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bsF().a(com.baidu.tieba.frs.d.d.fEI, bhVar, i);
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, r.this.mPageId, com.baidu.tieba.frs.d.d.fEI);
                    } else {
                        com.baidu.tieba.frs.d.c.bsF().a(com.baidu.tieba.frs.d.d.fEI, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fEI);
                    }
                }
            }
        };
        this.dGG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new an("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
                if (arrayList != null && ajVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new an("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public void setInFrsAllThread(boolean z) {
        this.ccM = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.card.z<bh> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(4280);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.3
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
        aVar.c(dVar);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.faT);
        a.bq(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.aD(false);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).threadData;
                    bhVar.objType = 1;
                    if (r.this.dGe != null) {
                        r.this.dGe.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), r.this.fEH, false);
                    zVar2.qQ().b(new a.C0038a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bh> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bgVar, zVar);
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.qQ().setPage(this.WM);
        zVar.qQ().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.qQ().qK(), this.fvE);
        if (this.fvE != null && this.fvE.getForum() != null && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fvE.getForum().getTopic_special_icon_right())) {
            bgVar.threadData.bC(this.fvE.getForum().getTopic_special_icon(), this.fvE.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.threadData.aeC() == null || bgVar.threadData.aeC().getUserId() == null || !bgVar.threadData.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.threadData.afL() && bgVar.threadData.adl() != null && !z) {
            zVar.qR().a(this.dGG);
        }
        zVar.qT();
        zVar.a(bgVar.threadData);
        zVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qQ().a(this.dGe);
        bgVar.threadData.afG();
        if (fEI != null) {
            bgVar.threadData.bMQ = (bgVar.position + 1) - (this.fvE != null ? this.fvE.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bsF().a(fEI, bgVar.threadData);
        bgVar.threadData.afG();
        com.baidu.tieba.frs.d.a.a(bgVar.threadData, this.mPageId, fEI);
        if (bgVar != null) {
            bgVar.threadData.afG();
        }
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nH(int i) {
        this.fEH = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void iJ(boolean z) {
        this.fEF = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return fEI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", bmy() ? 2 : 1).n(VideoPlayActivityConfig.OBJ_ID, bhVar.aeV() == null ? -1L : bhVar.aeV().live_id).P("obj_type", 1));
    }
}
