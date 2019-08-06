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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class r extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String WN;
    private boolean cbS;
    private NEGFeedBackView.a dEV;
    private ab<bh> dEt;
    private boolean fCS;
    private int fCU;
    private String mFrom;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fCS = false;
        this.cbS = false;
        this.fCU = 3;
        this.dEt = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (r.this.ftX != null) {
                        r.this.ftX.a(view, (View) bhVar, (Object) r.this.getType());
                    }
                    if ("c13010".equals(r.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").P("obj_type", 1).l("fid", bhVar.getFid()).bT("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.afs()) {
                        r.this.af(bhVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, r.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fCV, bhVar.acz());
                    } else if (view instanceof TbImageView) {
                        if (r.this.dEt.XJ instanceof Boolean) {
                            if (((Boolean) r.this.dEt.XJ).booleanValue()) {
                                com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 3);
                            com.baidu.tieba.frs.d.a.a(bhVar, 3, r.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bhVar.afW() != null && bhVar.afW().cpN() != null && bhVar.afW().cpN().ayN() != null && bhVar.afW().cpN().ayN().size() > 0) {
                            i = bhVar.afW().jgL ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, i);
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, r.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                    } else {
                        com.baidu.tieba.frs.d.c.brS().a(com.baidu.tieba.frs.d.d.fCV, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fCV);
                    }
                }
            }
        };
        this.dEV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
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
        this.cbS = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.card.z<bh> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bm(184);
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
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eZn);
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
                    if (r.this.dEt != null) {
                        r.this.dEt.a(zVar2.getView(), bhVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), r.this.fCU, false);
                    zVar2.qP().b(new a.C0038a(1));
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
        zVar.qP().setPage(this.WN);
        zVar.qP().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.qP().qJ(), this.ftR);
        if (this.ftR != null && this.ftR.getForum() != null && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.ftR.getForum().getTopic_special_icon_right())) {
            bgVar.threadData.bC(this.ftR.getForum().getTopic_special_icon(), this.ftR.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.threadData.aey() == null || bgVar.threadData.aey().getUserId() == null || !bgVar.threadData.aey().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.threadData.afH() && bgVar.threadData.adh() != null && !z) {
            zVar.qQ().a(this.dEV);
        }
        zVar.qS();
        zVar.a(bgVar.threadData);
        zVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qP().a(this.dEt);
        bgVar.threadData.afC();
        if (fCV != null) {
            bgVar.threadData.bMs = (bgVar.position + 1) - (this.ftR != null ? this.ftR.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.brS().a(fCV, bgVar.threadData);
        bgVar.threadData.afC();
        com.baidu.tieba.frs.d.a.a(bgVar.threadData, this.mPageId, fCV);
        if (bgVar != null) {
            bgVar.threadData.afC();
        }
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nD(int i) {
        this.fCU = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void iG(boolean z) {
        this.fCS = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bph() {
        return fCV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bh bhVar) {
        TiebaStatic.log(new an("c12126").bT("tid", bhVar.getId()).P("obj_locate", blN() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bhVar.aeR() == null ? -1L : bhVar.aeR().live_id).P("obj_type", 1));
    }
}
