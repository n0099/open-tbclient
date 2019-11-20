package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private String Gc;
    private boolean cqi;
    private NEGFeedBackView.a dSO;
    private ab<bh> dSl;
    private boolean fDf;
    private int fDh;
    private String mFrom;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fDf = false;
        this.cqi = false;
        this.fDh = 3;
        this.dSl = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (r.this.fug != null) {
                        r.this.fug.a(view, (View) bhVar, (Object) r.this.getType());
                    }
                    if ("c13010".equals(r.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 1).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root && bhVar.ajy()) {
                        r.this.ae(bhVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, r.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fDi, bhVar.agH());
                    } else if (view instanceof TbImageView) {
                        if (r.this.dSl.Hc instanceof Boolean) {
                            if (((Boolean) r.this.dSl.Hc).booleanValue()) {
                                com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 1);
                                com.baidu.tieba.frs.d.a.a(bhVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                                return;
                            }
                            com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 3);
                            com.baidu.tieba.frs.d.a.a(bhVar, 3, r.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bhVar.akb() != null && bhVar.akb().cop() != null && bhVar.akb().cop().azf() != null && bhVar.akb().cop().azf().size() > 0) {
                            i = bhVar.akb().jie ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, i);
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, r.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                    } else {
                        com.baidu.tieba.frs.d.c.bpH().a(com.baidu.tieba.frs.d.d.fDi, bhVar, 1);
                        com.baidu.tieba.frs.d.a.a(bhVar, 1, r.this.mPageId, com.baidu.tieba.frs.d.d.fDi);
                    }
                }
            }
        };
        this.dSO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.r.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new an("c11973").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new an("c11974").bS("obj_locate", sb.toString()).bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public void setInFrsAllThread(boolean z) {
        this.cqi = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.z<bh> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.aB(4280);
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
        com.baidu.card.x a = aVar.a(false, viewGroup, this.fcN);
        a.aF(3);
        com.baidu.card.z<bh> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        zVar.Y(false);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.r.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bh bhVar = ((bg) mVar).caz;
                    bhVar.objType = 1;
                    if (r.this.dSl != null) {
                        r.this.dSl.a(zVar2.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), r.this.fDh, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bh> zVar) {
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) zVar);
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        zVar.lV().setPage(this.Gc);
        zVar.lV().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.lV().lP(), this.fua);
        if (this.fua != null && this.fua.getForum() != null && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon_right())) {
            bgVar.caz.bI(this.fua.getForum().getTopic_special_icon(), this.fua.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.caz.aiE() == null || bgVar.caz.aiE().getUserId() == null || !bgVar.caz.aiE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.caz.ajM() && bgVar.caz.getFeedBackReasonMap() != null && !z) {
            zVar.lW().a(this.dSO);
        }
        zVar.lY();
        zVar.a(bgVar.caz);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.dSl);
        bgVar.caz.ajI();
        if (fDi != null) {
            bgVar.caz.cdI = (bgVar.position + 1) - (this.fua != null ? this.fua.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpH().a(fDi, bgVar.caz);
        bgVar.caz.ajI();
        com.baidu.tieba.frs.d.a.a(bgVar.caz, this.mPageId, fDi);
        if (bgVar != null) {
            bgVar.caz.ajI();
        }
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
        this.fDh = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void iM(boolean z) {
        this.fDf = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmV() {
        return fDi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bh bhVar) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", bjC() ? 2 : 1).p("obj_id", bhVar.aiX() == null ? -1L : bhVar.aiX().live_id).O("obj_type", 1));
    }
}
