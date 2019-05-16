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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class r extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Wt;
    private boolean caI;
    private ab<bg> dAP;
    private NEGFeedBackView.a dBr;
    private boolean fxh;
    private int fxj;
    private String mFrom;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fxh = false;
        this.caI = false;
        this.fxj = 3;
        this.dAP = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (r.this.foy != null) {
                        r.this.foy.a(view, (View) bgVar, (Object) r.this.getType());
                    }
                    if ("c13010".equals(r.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").P("obj_type", 1).l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bgVar.aep()) {
                        r.this.ae(bgVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpz().a(com.baidu.tieba.frs.d.d.fxk, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, r.this.mPageId, com.baidu.tieba.frs.d.d.fxk);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fxk, bgVar.abw());
                    } else if (view instanceof TbImageView) {
                        if (r.this.dAP.Xp instanceof Boolean) {
                            if (((Boolean) r.this.dAP.Xp).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bpz().a(com.baidu.tieba.frs.d.d.fxk, bgVar, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fxk);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bpz().a(com.baidu.tieba.frs.d.d.fxk, bgVar, 3);
                            com.baidu.tieba.frs.d.a.a(bgVar, 3, r.this.mPageId, com.baidu.tieba.frs.d.d.fxk);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").P("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bpz().a(com.baidu.tieba.frs.d.d.fxk, bgVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bgVar.aeT() != null && bgVar.aeT().cmw() != null && bgVar.aeT().cmw().axy() != null && bgVar.aeT().cmw().axy().size() > 0) {
                            i = bgVar.aeT().iZh ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bpz().a(com.baidu.tieba.frs.d.d.fxk, bgVar, i);
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, r.this.mPageId, com.baidu.tieba.frs.d.d.fxk);
                    } else {
                        com.baidu.tieba.frs.d.c.bpz().a(com.baidu.tieba.frs.d.d.fxk, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fxk);
                    }
                }
            }
        };
        this.dBr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new am("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public void setInFrsAllThread(boolean z) {
        this.caI = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public com.baidu.card.z<bg> onCreateViewHolder(ViewGroup viewGroup) {
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
        aVar.qq().setBackgroundResource(R.color.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eTX);
        a.bq(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.aA(false);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (r.this.dAP != null) {
                        r.this.dAP.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), r.this.fxj, false);
                    zVar2.qs().b(new a.C0038a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bf bfVar, com.baidu.card.z<bg> zVar) {
        super.onFillViewHolder(i, view, viewGroup, bfVar, zVar);
        if (bfVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.qs().setPage(this.Wt);
        zVar.qs().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.qs().qm(), this.fos);
        if (this.fos != null && this.fos.getForum() != null && !StringUtils.isNull(this.fos.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fos.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bC(this.fos.getForum().getTopic_special_icon(), this.fos.getForum().getTopic_special_icon_right());
        }
        boolean z = (bfVar.threadData.adv() == null || bfVar.threadData.adv().getUserId() == null || !bfVar.threadData.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bfVar.threadData.aeE() && bfVar.threadData.ace() != null && !z) {
            zVar.qt().a(this.dBr);
        }
        zVar.qv();
        zVar.a(bfVar.threadData);
        zVar.qs().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.qs().a(this.dAP);
        bfVar.threadData.aez();
        if (fxk != null) {
            bfVar.threadData.bLm = (bfVar.position + 1) - (this.fos != null ? this.fos.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpz().a(fxk, bfVar.threadData);
        bfVar.threadData.aez();
        com.baidu.tieba.frs.d.a.a(bfVar.threadData, this.mPageId, fxk);
        if (bfVar != null) {
            bfVar.threadData.aez();
        }
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rV(String str) {
        this.Wt = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void nt(int i) {
        this.fxj = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void ix(boolean z) {
        this.fxh = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmQ() {
        return fxk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bg bgVar) {
        TiebaStatic.log(new am("c12126").bT("tid", bgVar.getId()).P("obj_locate", bjB() ? 2 : 1).l(VideoPlayActivityConfig.OBJ_ID, bgVar.adO() == null ? -1L : bgVar.adO().live_id).P("obj_type", 1));
    }
}
