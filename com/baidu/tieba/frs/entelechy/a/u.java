package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class u extends com.baidu.tieba.frs.h<bg, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String YB;
    private boolean ZR;
    private boolean bSQ;
    private NEGFeedBackView.a dqM;
    private ab<bg> dqk;
    private HashSet<String> fgN;
    private int fgP;
    private com.baidu.tieba.frs.d.b fgQ;
    private String mForumName;
    private String mFrom;
    private TbPageContext<?> mPageContext;

    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.bSQ = false;
        this.ZR = true;
        this.fgP = 3;
        this.fgQ = new com.baidu.tieba.frs.d.b();
        this.dqk = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if ("c13010".equals(u.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 3).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        com.baidu.tieba.frs.d.c.bij().a(u.this.fgQ, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, u.this.mPageId, u.this.fgQ);
                    } else if (view.getId() == d.g.thread_info_commont_container) {
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, u.this.mPageId, u.this.fgQ);
                    } else if (view.getId() != d.g.card_home_page_normal_thread_user_icon) {
                        com.baidu.tieba.frs.d.c.bij().a(u.this.fgQ, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, u.this.mPageId, u.this.fgQ);
                    } else {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    }
                    if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        am amVar = new am("c12940");
                        amVar.bJ("obj_type", "1");
                        amVar.bJ("tid", bgVar.getTid());
                        TiebaStatic.log(amVar);
                    } else if (view instanceof OriginalThreadCardView) {
                        am amVar2 = new am("c12940");
                        amVar2.bJ("obj_type", "3");
                        amVar2.bJ("tid", bgVar.getTid());
                        TiebaStatic.log(amVar2);
                    }
                }
            }
        };
        this.dqM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.entelechy.a.u.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(aj ajVar) {
                TiebaStatic.log(new am("c11973").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
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
                    TiebaStatic.log(new am("c11974").bJ("obj_locate", sb.toString()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aH */
    public com.baidu.card.z<bg> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.bt(184);
        dVar.setPageUniqueId(this.mPageId);
        dVar.a(new d.a() { // from class: com.baidu.tieba.frs.entelechy.a.u.3
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == d.g.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == d.g.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.c(dVar);
        com.baidu.card.ab abVar = new com.baidu.card.ab(this.mPageContext.getPageActivity());
        aVar.b(abVar);
        abVar.bA(2);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.ZR);
        hVar.setForm("frs");
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bxn = 2;
        dVar2.bxs = 2;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(1);
        aaVar.setShareReportFrom(3);
        aaVar.bz(2);
        aaVar.bt(16);
        aVar.a(aaVar);
        aVar.rv().setBackgroundResource(d.f.addresslist_item_bg);
        com.baidu.card.x rw = aVar.rw();
        rw.bx(2);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(rw);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.frs.entelechy.a.u.4
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bg) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = (bg) mVar;
                    bgVar.objType = 1;
                    if (u.this.dqk != null) {
                        u.this.dqk.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), 2, false);
                    zVar2.rx().b(new a.C0039a(1));
                }
            }
        });
        zVar.rz();
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bg bgVar, com.baidu.card.z<bg> zVar) {
        if (bgVar == null || zVar == null || zVar.getView() == null) {
            return null;
        }
        if (zVar.rx() instanceof com.baidu.tieba.a.e) {
            zVar.rx().setPage(this.YB);
        }
        super.onFillViewHolder(i, view, viewGroup, bgVar, zVar);
        com.baidu.tieba.frs.g.a(zVar.rx().rr(), this.eYi);
        if (this.eYi != null && this.eYi.getForum() != null && !StringUtils.isNull(this.eYi.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYi.getForum().getTopic_special_icon_right())) {
            bgVar.bt(this.eYi.getForum().getTopic_special_icon(), this.eYi.getForum().getTopic_special_icon_right());
        }
        boolean z = (bgVar.YO() == null || bgVar.YO().getUserId() == null || !bgVar.YO().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        if (bgVar.ZX() && bgVar.Xx() != null && !z) {
            zVar.ry().a(this.dqM);
        }
        zVar.rA();
        zVar.a(bgVar);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.dqk);
        if (this.fgQ != null) {
            bgVar.bDV = (i + 1) - (this.eYi != null ? this.eYi.getTopThreadSize() : 0);
        }
        com.baidu.tieba.frs.d.c.bij().a(this.fgQ, bgVar);
        ad(bgVar);
        bgVar.ZS();
        com.baidu.tieba.frs.d.a.a(bgVar, this.mPageId, this.fgQ);
        if (bgVar != null) {
            bgVar.ZS();
        }
        return zVar.getView();
    }

    private void ad(bg bgVar) {
        if (this.fgN == null) {
            this.fgN = new HashSet<>();
        }
        com.baidu.tieba.frs.d.c.bij().a(bgVar, this.fgN);
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
        this.mForumName = str;
    }

    @Override // com.baidu.tieba.card.z
    public void mC(int i) {
        this.fgP = i;
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.ZR = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfx() {
        return this.fgQ;
    }
}
