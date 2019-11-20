package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> EP;
    private String Gc;
    private boolean Hx;
    public BdUniqueId cJo;
    private NEGFeedBackView.a dcg;
    private TbPageContext<?> mPageContext;

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dcg = null;
        this.Hx = true;
        this.EP = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.k.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.agG() != null && !StringUtils.isNull(kVar.agG().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        an anVar = new an("c12352");
                        anVar.O("obj_locate", 2);
                        anVar.O("obj_type", 5);
                        anVar.bS("tid", kVar.caz.getTid());
                        anVar.p("fid", kVar.caz.getFid());
                        anVar.bS("obj_source", "1");
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.thread_card_voice) {
                        an anVar2 = new an("c12352");
                        anVar2.O("obj_locate", 2);
                        anVar2.O("obj_type", 5);
                        anVar2.bS("tid", kVar.caz.getTid());
                        anVar2.p("fid", kVar.caz.getFid());
                        anVar2.bS("obj_source", "1");
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.user_avatar) {
                        an anVar3 = new an("c12352");
                        anVar3.O("obj_locate", 1);
                        anVar3.O("obj_type", 5);
                        anVar3.bS("tid", kVar.caz.getTid());
                        anVar3.p("fid", kVar.caz.getFid());
                        anVar3.bS("obj_source", "1");
                        TiebaStatic.log(anVar3);
                    } else if (id == R.id.user_name) {
                        an anVar4 = new an("c12352");
                        anVar4.O("obj_locate", 1);
                        anVar4.O("obj_type", 5);
                        anVar4.bS("tid", kVar.caz.getTid());
                        anVar4.p("fid", kVar.caz.getFid());
                        anVar4.bS("obj_source", "1");
                        TiebaStatic.log(anVar4);
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar5 = new an("c13423");
                        anVar5.O("obj_locate", 4);
                        if (kVar != null) {
                            anVar5.bS("tid", kVar.tid);
                            if (kVar.caz != null && kVar.caz.akb() != null) {
                                anVar5.bS("pid", kVar.caz.akb().getId());
                            }
                        }
                        TiebaStatic.log(anVar5);
                    } else if (id == R.id.god_reply_content) {
                        an anVar6 = new an("c13423");
                        anVar6.O("obj_locate", 2);
                        if (kVar != null) {
                            anVar6.bS("tid", kVar.tid);
                            if (kVar.caz != null && kVar.caz.akb() != null) {
                                anVar6.bS("pid", kVar.caz.akb().getId());
                            }
                        }
                        TiebaStatic.log(anVar6);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar7 = new an("c13423");
                        anVar7.O("obj_locate", 1);
                        if (kVar != null) {
                            anVar7.bS("tid", kVar.tid);
                            if (kVar.caz != null && kVar.caz.akb() != null) {
                                anVar7.bS("pid", kVar.caz.akb().getId());
                            }
                        }
                        TiebaStatic.log(anVar7);
                    } else if (id == R.id.god_reply_agree_view) {
                        an anVar8 = new an("c13423");
                        anVar8.O("obj_locate", 5);
                        if (kVar != null) {
                            anVar8.bS("tid", kVar.tid);
                            if (kVar.caz != null && kVar.caz.akb() != null) {
                                anVar8.bS("pid", kVar.caz.akb().getId());
                            }
                        }
                        TiebaStatic.log(anVar8);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar9 = new an("c13423");
                            anVar9.O("obj_locate", 3);
                            if (kVar != null) {
                                anVar9.bS("tid", kVar.tid);
                                if (kVar.caz != null && kVar.caz.akb() != null) {
                                    anVar9.bS("pid", kVar.caz.akb().getId());
                                }
                            }
                            TiebaStatic.log(anVar9);
                            return;
                        }
                        an anVar10 = new an("c12352");
                        anVar10.O("obj_locate", 2);
                        anVar10.O("obj_type", 5);
                        anVar10.bS("tid", kVar.caz.getTid());
                        anVar10.p("fid", kVar.caz.getFid());
                        anVar10.bS("obj_source", "1");
                        TiebaStatic.log(anVar10);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cJo);
        dVar.aB(128);
        dVar.aC(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.concern.a.k.2
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
        com.baidu.card.ab abVar = new com.baidu.card.ab(this.mPageContext.getPageActivity());
        aVar.b(abVar);
        abVar.aM(2);
        aVar.a((com.baidu.card.f) new com.baidu.card.g(this.mPageContext.getPageActivity()));
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Hx);
        hVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.f) hVar);
        aa aaVar = new aa(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar2 = new com.baidu.tbadk.core.data.d();
        dVar2.bWZ = 1;
        dVar2.bXe = 1;
        aaVar.setAgreeStatisticData(dVar2);
        aaVar.setFrom(9);
        aaVar.setShareReportFrom(3);
        aaVar.aL(1);
        aVar.a(aaVar);
        x lU = aVar.lU();
        lU.aF(1);
        z<com.baidu.tieba.card.data.k> zVar = new z<>(lU);
        zVar.setPageId(this.cJo);
        a(new s() { // from class: com.baidu.tieba.homepage.concern.a.k.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (k.this.EP != null) {
                        k.this.EP.a(zVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
                    zVar2.lV().b(new a.C0044a(1));
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.caz == null) {
            return null;
        }
        kVar.oO(kVar.position + 1);
        t.bau().c(kVar.uF("c12351"));
        zVar.lV().setPage(this.Gc);
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.EP);
        return zVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }
}
