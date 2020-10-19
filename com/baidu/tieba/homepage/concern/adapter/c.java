package com.baidu.tieba.homepage.concern.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
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
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> afE;
    private String aht;
    private com.baidu.adp.widget.ListView.v alC;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afE = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && lVar != null && lVar.bfG() != null && !StringUtils.isNull(lVar.bfG().getTid())) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                        com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
                    } else if (id == R.id.user_avatar || id == R.id.user_name) {
                        com.baidu.tieba.homepage.concern.c.a(view, lVar, 1);
                    } else if (id == R.id.god_reply_voice_btn) {
                        aq aqVar = new aq("c13423");
                        aqVar.aj("obj_locate", 4);
                        if (lVar != null) {
                            aqVar.dK("tid", lVar.tid);
                            if (lVar.eji != null && lVar.eji.bjK() != null) {
                                aqVar.dK("pid", lVar.eji.bjK().getId());
                            }
                        }
                        TiebaStatic.log(aqVar);
                    } else if (id == R.id.god_reply_content) {
                        aq aqVar2 = new aq("c13423");
                        aqVar2.aj("obj_locate", 2);
                        if (lVar != null) {
                            aqVar2.dK("tid", lVar.tid);
                            if (lVar.eji != null && lVar.eji.bjK() != null) {
                                aqVar2.dK("pid", lVar.eji.bjK().getId());
                            }
                        }
                        TiebaStatic.log(aqVar2);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        aq aqVar3 = new aq("c13423");
                        aqVar3.aj("obj_locate", 1);
                        if (lVar != null) {
                            aqVar3.dK("tid", lVar.tid);
                            if (lVar.eji != null && lVar.eji.bjK() != null) {
                                aqVar3.dK("pid", lVar.eji.bjK().getId());
                            }
                        }
                        TiebaStatic.log(aqVar3);
                    } else if (id == R.id.god_reply_agree_view) {
                        aq aqVar4 = new aq("c13423");
                        aqVar4.aj("obj_locate", 5);
                        if (lVar != null) {
                            aqVar4.dK("tid", lVar.tid);
                            if (lVar.eji != null && lVar.eji.bjK() != null) {
                                aqVar4.dK("pid", lVar.eji.bjK().getId());
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
                            aqVar5.aj("obj_locate", 3);
                            if (lVar != null) {
                                aqVar5.dK("tid", lVar.tid);
                                if (lVar.eji != null && lVar.eji.bjK() != null) {
                                    aqVar5.dK("pid", lVar.eji.bjK().getId());
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
    /* renamed from: aT */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fey);
        eVar.bo(128);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.2
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
        afVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.3
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null && absThreadDataSupport.bfG().erY != null) {
                    ay.a(absThreadDataSupport.bfG().erY, c.this.mContext, 1);
                    com.baidu.tieba.homepage.concern.c.a(afVar2.getView(), absThreadDataSupport, 6);
                }
            }
        });
        aVar.a((com.baidu.card.i) afVar2);
        final ao aoVar = new ao(this.mPageContext.getPageActivity());
        aoVar.b((Boolean) true);
        aoVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.c.4
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null && absThreadDataSupport.bfG().erY != null) {
                    ay.a(absThreadDataSupport.bfG().erY, c.this.mContext, 1);
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
        cVar.ela = 9;
        cVar.elg = 9;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(9);
        anVar.setShareReportFrom(4);
        anVar.setFromForPb(1);
        anVar.bo(32);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak a2 = aVar.a(true, viewGroup, this.alC);
        a2.setSourceForPb(1);
        am<com.baidu.tieba.card.data.l> amVar = new am<>(a2);
        amVar.setPageId(this.fey);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.adapter.c.5
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (c.this.afE != null) {
                        c.this.afE.a(amVar2.getView(), lVar);
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
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.eji == null) {
            return null;
        }
        lVar.wD(lVar.position + 1);
        amVar.tW().setPosition(i);
        com.baidu.tieba.card.s.ciJ().e(lVar.Ip("c12351"));
        amVar.tW().setPage(this.aht);
        amVar.a(true, Align.ALIGN_RIGHT_TOP);
        amVar.tZ();
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afE);
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alC = vVar;
    }
}
