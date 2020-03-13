package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.b;
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
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.k> JZ;
    private String LC;
    private com.baidu.adp.widget.ListView.r OR;
    public BdUniqueId dBx;
    private TbPageContext<?> mPageContext;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JZ = new z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aAg() != null && !StringUtils.isNull(kVar.aAg().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        an anVar = new an("c13423");
                        anVar.X("obj_locate", 4);
                        if (kVar != null) {
                            anVar.cy("tid", kVar.tid);
                            if (kVar.cRg != null && kVar.cRg.aDM() != null) {
                                anVar.cy("pid", kVar.cRg.aDM().getId());
                            }
                        }
                        TiebaStatic.log(anVar);
                    } else if (id == R.id.god_reply_content) {
                        an anVar2 = new an("c13423");
                        anVar2.X("obj_locate", 2);
                        if (kVar != null) {
                            anVar2.cy("tid", kVar.tid);
                            if (kVar.cRg != null && kVar.cRg.aDM() != null) {
                                anVar2.cy("pid", kVar.cRg.aDM().getId());
                            }
                        }
                        TiebaStatic.log(anVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        an anVar3 = new an("c13423");
                        anVar3.X("obj_locate", 1);
                        if (kVar != null) {
                            anVar3.cy("tid", kVar.tid);
                            if (kVar.cRg != null && kVar.cRg.aDM() != null) {
                                anVar3.cy("pid", kVar.cRg.aDM().getId());
                            }
                        }
                        TiebaStatic.log(anVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        an anVar4 = new an("c13423");
                        anVar4.X("obj_locate", 5);
                        if (kVar != null) {
                            anVar4.cy("tid", kVar.tid);
                            if (kVar.cRg != null && kVar.cRg.aDM() != null) {
                                anVar4.cy("pid", kVar.cRg.aDM().getId());
                            }
                        }
                        TiebaStatic.log(anVar4);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 7);
                    } else if (id == R.id.thread_card_title || id == R.id.thread_card_abstract) {
                        com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            an anVar5 = new an("c13423");
                            anVar5.X("obj_locate", 3);
                            if (kVar != null) {
                                anVar5.cy("tid", kVar.tid);
                                if (kVar.cRg != null && kVar.cRg.aDM() != null) {
                                    anVar5.cy("pid", kVar.cRg.aDM().getId());
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
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBx);
        eVar.aK(128);
        eVar.aL(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.a.b.2
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
        com.baidu.card.z zVar = new com.baidu.card.z(this.mPageContext);
        zVar.b((Boolean) false);
        zVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        zVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        aVar.c(zVar);
        final com.baidu.card.z zVar2 = new com.baidu.card.z(this.mPageContext);
        zVar2.b((Boolean) true);
        zVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        zVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        zVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.b.3
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aAg() != null && aVar2.aAg().cTR != null) {
                    au.a(aVar2.aAg().cTR, b.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.b.a(zVar2.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) zVar2);
        final ah ahVar = new ah(this.mPageContext.getPageActivity());
        ahVar.b((Boolean) true);
        ahVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.b.4
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null && aVar2.aAg() != null && aVar2.aAg().cTR != null) {
                    au.a(aVar2.aAg().cTR, b.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.b.a(ahVar.getView(), aVar2, 6);
                }
            }
        });
        aVar.a((com.baidu.card.h) ahVar);
        com.baidu.card.i iVar = new com.baidu.card.i(this.mPageContext.getPageActivity());
        iVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.h) iVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 9;
        dVar.cNI = 9;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(9);
        agVar.setShareReportFrom(4);
        agVar.aZ(1);
        agVar.aK(32);
        aVar.b(agVar);
        aVar.ni().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad a = aVar.a(true, viewGroup, this.OR);
        a.aQ(1);
        af<com.baidu.tieba.card.data.k> afVar = new af<>(a);
        afVar.setPageId(this.dBx);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.concern.a.b.5
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (b.this.JZ != null) {
                        b.this.JZ.a(afVar2.getView(), kVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 1, false);
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
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRg == null) {
            return null;
        }
        kVar.rt(kVar.position + 1);
        afVar.nk().setPosition(i);
        com.baidu.tieba.card.r.bvh().d(kVar.zZ("c12351"));
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

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.OR = rVar;
    }
}
