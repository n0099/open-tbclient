package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.ai;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private boolean NK;
    public BdUniqueId dBK;
    private TbPageContext<?> mPageContext;

    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.NK = true;
        this.JZ = new z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aAj() != null && !StringUtils.isNull(kVar.aAj().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (id == R.id.thread_card_voice) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 6);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c13423");
                        anVar.X("obj_locate", 4);
                        if (kVar != null) {
                            anVar.cx("tid", kVar.tid);
                            if (kVar.cRt != null && kVar.cRt.aDQ() != null) {
                                anVar.cx("pid", kVar.cRt.aDQ().getId());
                            }
                        }
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c13423");
                        anVar2.X("obj_locate", 2);
                        if (kVar != null) {
                            anVar2.cx("tid", kVar.tid);
                            if (kVar.cRt != null && kVar.cRt.aDQ() != null) {
                                anVar2.cx("pid", kVar.cRt.aDQ().getId());
                            }
                        }
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c13423");
                        anVar3.X("obj_locate", 1);
                        if (kVar != null) {
                            anVar3.cx("tid", kVar.tid);
                            if (kVar.cRt != null && kVar.cRt.aDQ() != null) {
                                anVar3.cx("pid", kVar.cRt.aDQ().getId());
                            }
                        }
                        TiebaStatic.log(anVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        an anVar4 = new an("c13423");
                        anVar4.X("obj_locate", 5);
                        if (kVar != null) {
                            anVar4.cx("tid", kVar.tid);
                            if (kVar.cRt != null && kVar.cRt.aDQ() != null) {
                                anVar4.cx("pid", kVar.cRt.aDQ().getId());
                            }
                        }
                        TiebaStatic.log(anVar4);
                    } else if (view.getId() == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 7);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar5 = new an("c13423");
                            anVar5.X("obj_locate", 3);
                            if (kVar != null) {
                                anVar5.cx("tid", kVar.tid);
                                if (kVar.cRt != null && kVar.cRt.aDQ() != null) {
                                    anVar5.cx("pid", kVar.cRt.aDQ().getId());
                                }
                            }
                            TiebaStatic.log(anVar5);
                            return;
                        }
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 6);
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
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBK);
        eVar.aK(128);
        eVar.aL(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.a.r.2
            @Override // com.baidu.card.e.a
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
        aVar.a(eVar);
        ai aiVar = new ai(this.mPageContext.getPageActivity());
        aVar.c(aiVar);
        aiVar.ba(2);
        aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.NK);
        kVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) kVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 9;
        dVar.cNV = 9;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(9);
        agVar.setShareReportFrom(4);
        agVar.aZ(1);
        aVar.b(agVar);
        ad nj = aVar.nj();
        nj.aQ(1);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(nj);
        afVar.setPageId(this.dBK);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.concern.a.r.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar2 = (com.baidu.tieba.card.data.k) mVar;
                    kVar2.objType = 1;
                    if (r.this.JZ != null) {
                        r.this.JZ.a(afVar2.getView(), kVar2);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar2, view.getContext(), 1, false);
                    afVar2.nk().b(new a.C0052a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRt == null) {
            return null;
        }
        kVar.rv(kVar.position + 1);
        com.baidu.tieba.card.r.bvm().e(kVar.Aa("c12351"));
        afVar.nk().setPage(this.LC);
        afVar.ah(true);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
        this.LC = str;
    }
}
