package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> EP;
    private String Gc;
    private boolean Hx;
    private r Iu;
    public BdUniqueId cJo;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Hx = true;
        this.EP = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.agG() != null && !StringUtils.isNull(kVar.agG().getTid())) {
                    g.this.a(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.Iu = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, false);
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c13423");
            anVar.O("obj_locate", 4);
            if (kVar != null) {
                anVar.bS("tid", kVar.tid);
                if (kVar.caz != null && kVar.caz.akb() != null) {
                    anVar.bS("pid", kVar.caz.akb().getId());
                }
            }
            TiebaStatic.log(anVar);
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c13423");
            anVar2.O("obj_locate", 2);
            if (kVar != null) {
                anVar2.bS("tid", kVar.tid);
                if (kVar.caz != null && kVar.caz.akb() != null) {
                    anVar2.bS("pid", kVar.caz.akb().getId());
                }
            }
            TiebaStatic.log(anVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c13423");
            anVar3.O("obj_locate", 1);
            if (kVar != null) {
                anVar3.bS("tid", kVar.tid);
                if (kVar.caz != null && kVar.caz.akb() != null) {
                    anVar3.bS("pid", kVar.caz.akb().getId());
                }
            }
            TiebaStatic.log(anVar3);
        } else if (id == R.id.god_reply_agree_view) {
            an anVar4 = new an("c13423");
            anVar4.O("obj_locate", 5);
            if (kVar != null) {
                anVar4.bS("tid", kVar.tid);
                if (kVar.caz != null && kVar.caz.akb() != null) {
                    anVar4.bS("pid", kVar.caz.akb().getId());
                }
            }
            TiebaStatic.log(anVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            an anVar5 = new an("c13423");
            anVar5.O("obj_locate", 3);
            if (kVar != null) {
                anVar5.bS("tid", kVar.tid);
                if (kVar.caz != null && kVar.caz.akb() != null) {
                    anVar5.bS("pid", kVar.caz.akb().getId());
                }
            }
            TiebaStatic.log(anVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.setFromCDN(this.Hx);
        hVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.f) hVar);
        x a = aVar.a(false, viewGroup, this.Iu);
        a.aF(1);
        z zVar = new z(a);
        zVar.setPageId(this.cJo);
        a(new s() { // from class: com.baidu.tieba.homepage.concern.a.g.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof z)) {
                    z zVar2 = (z) view.getTag();
                    com.baidu.tieba.card.data.k kVar = (com.baidu.tieba.card.data.k) mVar;
                    kVar.objType = 1;
                    if (g.this.EP != null) {
                        g.this.EP.a(zVar2.getView(), kVar);
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
        t.bau().c(new an("c13424"));
        zVar.lV().setPosition(i);
        if (zVar.lV() instanceof com.baidu.tieba.a.e) {
            zVar.lV().setPage(this.Gc);
        }
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
