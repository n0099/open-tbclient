package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class z extends com.baidu.tieba.frs.h<bh, com.baidu.card.a<bh>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Gc;
    private boolean Hx;
    private boolean cqi;
    private NEGFeedBackView.a dSO;
    private ab<bh> dSq;
    public boolean fCj;
    private boolean fDf;
    private boolean fDg;
    private int fDh;
    private com.baidu.tieba.frs.d.b fDi;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.cqi = false;
        this.fDf = false;
        this.Hx = false;
        this.fDg = false;
        this.fDh = 3;
        this.fDi = new com.baidu.tieba.frs.d.b();
        this.dSq = new ab<bh>() { // from class: com.baidu.tieba.frs.entelechy.a.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                if (view != null && bhVar != null) {
                    if (z.this.fug != null) {
                        z.this.fug.a(view, (View) bhVar, (Object) bh.caR);
                    }
                    if ("c13010".equals(z.this.mFrom)) {
                        TiebaStatic.log(new an("c13010").O("obj_type", 2).p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()));
                    }
                    if (view.getId() == R.id.thread_card_root) {
                        com.baidu.tieba.frs.d.c.bpH().a(z.this.fDi, bhVar, 1);
                        z.this.ae(bhVar);
                    } else if (view.getId() == R.id.video_play) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 4, z.this.mPageId, z.this.fDi);
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 3));
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpH().a(z.this.fDi, bhVar, 2);
                        com.baidu.tieba.frs.d.a.a(bhVar, 2, z.this.mPageId, z.this.fDi);
                    } else if (view.getId() == R.id.header_divider) {
                        com.baidu.tieba.frs.f.h.a(z.this.fDi, bhVar.agH());
                    } else if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpH().a(z.this.fDi, bhVar, 4);
                        z.this.ae(bhVar);
                    } else if (view.getId() == R.id.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bhVar, 5, z.this.mPageId, z.this.fDi);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        z.this.ae(bhVar);
                    }
                    if (view.getId() == R.id.operable_video_container) {
                        com.baidu.tieba.frs.d.c.bpH().b(z.this.fDi, bhVar, 1);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.bpH().b(z.this.fDi, bhVar, 2);
                    } else if (view.getId() == R.id.share_num_container) {
                        com.baidu.tieba.frs.d.c.bpH().b(z.this.fDi, bhVar, 5);
                    } else if (view.getId() == R.id.new_agree_view) {
                        com.baidu.tieba.frs.d.c.bpH().b(z.this.fDi, bhVar, 4);
                    } else {
                        com.baidu.tieba.frs.d.c.bpH().b(z.this.fDi, bhVar, 3);
                    }
                }
            }
        };
        this.dSO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.z.2
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.aB(4272);
        dVar.setPageUniqueId(this.mPageId);
        aVar.c(dVar);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setFrom("frs");
        aVar.b(eVar);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Hx);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bWZ = 2;
        dVar2.bXa = 2;
        dVar2.bXe = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(2);
        aaVar.setShareReportFrom(1);
        aaVar.aL(this.fDh);
        aaVar.aB(16);
        if (this.fDg) {
            aaVar.aC(4);
        }
        aVar.a(aaVar);
        com.baidu.card.x lU = aVar.lU();
        com.baidu.card.a aVar2 = new com.baidu.card.a(lU);
        aVar2.setPageId(this.mPageId);
        lU.b(this.dSq);
        lU.aF(this.fDh);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.z.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bh) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar = (com.baidu.card.z) view.getTag();
                    bh bhVar = (bh) mVar;
                    bhVar.objType = 1;
                    if (z.this.dSq != null) {
                        z.this.dSq.a(zVar.getView(), bhVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bhVar, view.getContext(), z.this.fDh, false);
                    zVar.lV().b(new a.C0044a(1));
                }
            }
        });
        aVar2.lX();
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, com.baidu.card.a<bh> aVar) {
        if (aVar == null) {
            return null;
        }
        if (bhVar == null) {
            return aVar.getView();
        }
        if (aVar.lV() instanceof com.baidu.tieba.a.e) {
            aVar.lV().setPage(this.Gc);
        }
        super.a(i, view, viewGroup, (ViewGroup) bhVar, (bh) aVar);
        com.baidu.tieba.frs.g.a(aVar.lV().lP(), this.fua);
        aVar.setVideoStatsData(af(bhVar));
        if (this.fua != null && this.fua.getForum() != null && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.fua.getForum().getTopic_special_icon_right())) {
            bhVar.bI(this.fua.getForum().getTopic_special_icon(), this.fua.getForum().getTopic_special_icon_right());
        }
        boolean z = (bhVar.aiE() == null || bhVar.aiE().getUserId() == null || !bhVar.aiE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bhVar.ajM() && bhVar.getFeedBackReasonMap() != null && !z) {
            aVar.lW().a(this.dSO);
        }
        aVar.lY();
        aVar.a(bhVar);
        aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.lV().b(this.dSq);
        if (this.fDi != null) {
            bhVar.cdI = (i + 1) - (this.fua != null ? this.fua.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bpH().a(this.fDi, bhVar);
        com.baidu.tieba.frs.d.c.bpH().ak(bhVar);
        com.baidu.tieba.frs.d.c.bpH().a(bhVar, bjC());
        com.baidu.tieba.frs.d.a.a(bhVar, this.mPageId, this.fDi);
        bhVar.ajI();
        return aVar.getView();
    }

    private com.baidu.tieba.play.z af(bh bhVar) {
        if (bhVar == null) {
            return null;
        }
        com.baidu.tieba.play.z zVar = new com.baidu.tieba.play.z();
        zVar.mLocate = bhVar.ajF() ? "3" : "2";
        if (this.fDi.fPN == 501) {
            zVar.mLocate = "frs_tab";
        }
        zVar.ePc = this.fDi.fPM;
        zVar.cma = bhVar.getTid();
        zVar.mSource = bhVar.mRecomSource;
        zVar.iyj = bhVar.ccP;
        zVar.iyk = bhVar.mRecomWeight;
        zVar.iym = bhVar.mRecomAbTag;
        if (bhVar.aiV() != null) {
            zVar.iyn = bhVar.aiV().video_md5;
        }
        return zVar;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mW(int i) {
        this.fDh = i;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(bh bhVar) {
        TiebaStatic.log(new an("c12126").bS("tid", bhVar.getId()).O("obj_locate", bjC() ? 2 : 1).p("obj_id", bhVar.aiX() == null ? -1L : bhVar.aiX().live_id).O("obj_type", 1));
    }

    @Override // com.baidu.tieba.card.aa
    public void iM(boolean z) {
        this.fDf = z;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmV() {
        return this.fDi;
    }

    public void kn(boolean z) {
        this.fDg = z;
    }
}
