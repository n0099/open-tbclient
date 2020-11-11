package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.ao;
import com.baidu.card.b;
import com.baidu.card.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    public BdUniqueId fsQ;
    private TbPageContext<?> mPageContext;

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && lVar != null && lVar.bjZ() != null && !StringUtils.isNull(lVar.bjZ().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.c.a(view, lVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c13423");
                        aqVar.al("obj_locate", 4);
                        if (lVar != null) {
                            aqVar.dR("tid", lVar.tid);
                            if (lVar.exA != null && lVar.exA.bod() != null) {
                                aqVar.dR("pid", lVar.exA.bod().getId());
                            }
                        }
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c13423");
                        aqVar2.al("obj_locate", 2);
                        if (lVar != null) {
                            aqVar2.dR("tid", lVar.tid);
                            if (lVar.exA != null && lVar.exA.bod() != null) {
                                aqVar2.dR("pid", lVar.exA.bod().getId());
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c13423");
                        aqVar3.al("obj_locate", 1);
                        if (lVar != null) {
                            aqVar3.dR("tid", lVar.tid);
                            if (lVar.exA != null && lVar.exA.bod() != null) {
                                aqVar3.dR("pid", lVar.exA.bod().getId());
                            }
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        aq aqVar4 = new aq("c13423");
                        aqVar4.al("obj_locate", 5);
                        if (lVar != null) {
                            aqVar4.dR("tid", lVar.tid);
                            if (lVar.exA != null && lVar.exA.bod() != null) {
                                aqVar4.dR("pid", lVar.exA.bod().getId());
                            }
                        }
                        TiebaStatic.log(aqVar4);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.homepage.concern.c.a(view, lVar, 7);
                    } else if (id == R.id.thread_card_title || id == R.id.thread_card_abstract) {
                        com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
                    } else if (view instanceof TbImageView) {
                        if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                            aq aqVar5 = new aq("c13423");
                            aqVar5.al("obj_locate", 3);
                            if (lVar != null) {
                                aqVar5.dR("tid", lVar.tid);
                                if (lVar.exA != null && lVar.exA.bod() != null) {
                                    aqVar5.dR("pid", lVar.exA.bod().getId());
                                }
                            }
                            TiebaStatic.log(aqVar5);
                            return;
                        }
                        com.baidu.tieba.homepage.concern.c.a(view, lVar, 6);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aV */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsQ);
        eVar.bo(128);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.adapter.d.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        af afVar = new af(this.mPageContext);
        afVar.b((Boolean) false);
        afVar.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar.e(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds27));
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds28));
        aVar.c(afVar);
        final af afVar2 = new af(this.mPageContext);
        afVar2.b((Boolean) true);
        afVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
        afVar2.e(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds29), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds37));
        afVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.d.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    ay.a(absThreadDataSupport.bjZ().eGn, d.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.c.a(afVar2.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        final ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.d.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null && absThreadDataSupport.bjZ().eGn != null) {
                    ay.a(absThreadDataSupport.bjZ().eGn, d.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.c.a(aoVar.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) aoVar);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setTopMargin(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds24));
        aVar.a((com.baidu.card.i) kVar);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 9;
        cVar.ezz = 9;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(9);
        anVar.setShareReportFrom(4);
        anVar.setFromForPb(1);
        anVar.bo(32);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak a2 = aVar.a(true, viewGroup, this.alD);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.l> amVar = new am<>(a2);
        amVar.setPageId(this.fsQ);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.d.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (d.this.afF != null) {
                        d.this.afF.a(amVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false);
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.exA == null) {
            return null;
        }
        lVar.xj(lVar.position + 1);
        amVar.tW().setPosition(i);
        com.baidu.tieba.card.t.cor().e(lVar.Jf("c12351"));
        amVar.tW().setPage(this.ahu);
        amVar.a(true, Align.ALIGN_RIGHT_TOP);
        amVar.tZ();
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afF);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }
}
