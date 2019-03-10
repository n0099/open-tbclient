package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d.b;
import com.baidu.tieba.frs.d.c;
/* loaded from: classes4.dex */
public class h extends com.baidu.tieba.frs.h<bf, com.baidu.card.z<bg>> implements com.baidu.tieba.a.f, aa, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String Yz;
    private boolean ZO;
    private boolean bSM;
    private ab<bg> dqk;
    private boolean fhd;
    private int fhe;
    private String mFrom;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.fhd = false;
        this.bSM = false;
        this.ZO = true;
        this.fhe = 3;
        this.dqk = new ab<bg>() { // from class: com.baidu.tieba.frs.entelechy.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bg bgVar) {
                if (view != null && bgVar != null) {
                    if (h.this.eYC != null) {
                        h.this.eYC.a(view, (View) bgVar, (Object) h.this.getType());
                    }
                    if ("c13010".equals(h.this.mFrom)) {
                        TiebaStatic.log(new am("c13010").T("obj_type", 1).k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()));
                    }
                    if (view.getId() == d.g.thread_card_root && bgVar.ZL()) {
                        h.this.af(bgVar);
                    } else if (view.getId() == d.g.user_name || view.getId() == d.g.user_avatar) {
                        c.bim().a(com.baidu.tieba.frs.d.d.fhf, bgVar, 2);
                        com.baidu.tieba.frs.d.a.a(bgVar, 2, h.this.mPageId, com.baidu.tieba.frs.d.d.fhf);
                    } else if (view.getId() == d.g.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.fhf, bgVar.WS());
                    } else if (view instanceof TbImageView) {
                        if (h.this.dqk.Zv instanceof Boolean) {
                            if (((Boolean) h.this.dqk.Zv).booleanValue()) {
                                c.bim().a(com.baidu.tieba.frs.d.d.fhf, bgVar, 1);
                                com.baidu.tieba.frs.d.a.a(bgVar, 1, h.this.mPageId, com.baidu.tieba.frs.d.d.fhf);
                                return;
                            }
                            c.bim().a(com.baidu.tieba.frs.d.d.fhf, bgVar, 3);
                            com.baidu.tieba.frs.d.a.a(bgVar, 3, h.this.mPageId, com.baidu.tieba.frs.d.d.fhf);
                        }
                    } else if (view.getId() == d.g.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new am("c10134").T("obj_type", 3));
                    } else if (view.getId() == d.g.thread_card_voice) {
                        c.bim().a(com.baidu.tieba.frs.d.d.fhf, bgVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (bgVar.aap() != null && bgVar.aap().cet() != null && bgVar.aap().cet().asx() != null && bgVar.aap().cet().asx().size() > 0) {
                            i = bgVar.aap().iGP ? 9 : 8;
                        }
                        c.bim().a(com.baidu.tieba.frs.d.d.fhf, bgVar, i);
                        com.baidu.tieba.frs.d.a.a(bgVar, 5, h.this.mPageId, com.baidu.tieba.frs.d.d.fhf);
                    } else {
                        c.bim().a(com.baidu.tieba.frs.d.d.fhf, bgVar, 1);
                        com.baidu.tieba.frs.d.a.a(bgVar, 1, h.this.mPageId, com.baidu.tieba.frs.d.d.fhf);
                    }
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
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        aVar.a((com.baidu.card.f) hVar);
        hVar.setFromCDN(this.ZO);
        hVar.setForm("frs");
        aVar.rv().setBackgroundResource(d.C0236d.cp_bg_line_d);
        com.baidu.card.x a = aVar.a(false, viewGroup, this.eEv);
        a.by(3);
        com.baidu.card.z<bg> zVar = new com.baidu.card.z<>(a);
        zVar.setPageId(this.mPageId);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.frs.entelechy.a.h.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bf) && (view.getTag() instanceof com.baidu.card.z)) {
                    com.baidu.card.z zVar2 = (com.baidu.card.z) view.getTag();
                    bg bgVar = ((bf) mVar).threadData;
                    bgVar.objType = 1;
                    if (h.this.dqk != null) {
                        h.this.dqk.a(zVar2.getView(), bgVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bgVar, view.getContext(), h.this.fhe, false);
                    zVar2.rx().b(new a.C0037a(1));
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
        zVar.rx().setPage(this.Yz);
        zVar.rx().setPosition(i);
        com.baidu.tieba.frs.g.a(zVar.rx().rr(), this.eYw);
        if (this.eYw != null && this.eYw.getForum() != null && !StringUtils.isNull(this.eYw.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.eYw.getForum().getTopic_special_icon_right())) {
            bfVar.threadData.bt(this.eYw.getForum().getTopic_special_icon(), this.eYw.getForum().getTopic_special_icon_right());
        }
        zVar.a(bfVar.threadData);
        zVar.rx().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.rx().a(this.dqk);
        bfVar.threadData.ZV();
        return zVar.getView();
    }

    @Override // com.baidu.tieba.frs.h
    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    @Override // com.baidu.tieba.a.f
    public void qN(String str) {
        this.Yz = str;
    }

    @Override // com.baidu.tieba.card.z
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.z
    public void mD(int i) {
        this.fhe = i;
    }

    @Override // com.baidu.tieba.card.aa
    public void hS(boolean z) {
        this.fhd = z;
    }

    @Override // com.baidu.tieba.frs.d.d
    public b bfA() {
        return fhf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(bg bgVar) {
        TiebaStatic.log(new am("c12126").bJ("tid", bgVar.getId()).T("obj_locate", bck() ? 2 : 1).k(VideoPlayActivityConfig.OBJ_ID, bgVar.Zk() == null ? -1L : bgVar.Zk().live_id).T("obj_type", 1));
    }
}
