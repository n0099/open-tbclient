package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
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
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.k> ada;
    private String aeB;
    private boolean agw;
    private com.baidu.adp.widget.ListView.r ahy;
    public BdUniqueId ebA;
    private TbPageContext<?> mPageContext;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agw = true;
        this.ada = new z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.concern.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                if (view != null && kVar != null && kVar.aIu() != null && !StringUtils.isNull(kVar.aIu().getTid())) {
                    i.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.ahy = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.k kVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root) {
            com.baidu.tieba.homepage.concern.b.a(view, kVar, 2);
        } else if (id == R.id.god_reply_voice_btn) {
            an anVar = new an("c13423");
            anVar.af("obj_locate", 4);
            if (kVar != null) {
                anVar.cI("tid", kVar.tid);
                if (kVar.dqE != null && kVar.dqE.aMc() != null) {
                    anVar.cI("pid", kVar.dqE.aMc().getId());
                }
            }
            TiebaStatic.log(anVar);
        } else if (id == R.id.god_reply_content) {
            an anVar2 = new an("c13423");
            anVar2.af("obj_locate", 2);
            if (kVar != null) {
                anVar2.cI("tid", kVar.tid);
                if (kVar.dqE != null && kVar.dqE.aMc() != null) {
                    anVar2.cI("pid", kVar.dqE.aMc().getId());
                }
            }
            TiebaStatic.log(anVar2);
        } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
            an anVar3 = new an("c13423");
            anVar3.af("obj_locate", 1);
            if (kVar != null) {
                anVar3.cI("tid", kVar.tid);
                if (kVar.dqE != null && kVar.dqE.aMc() != null) {
                    anVar3.cI("pid", kVar.dqE.aMc().getId());
                }
            }
            TiebaStatic.log(anVar3);
        } else if (id == R.id.god_reply_agree_view) {
            an anVar4 = new an("c13423");
            anVar4.af("obj_locate", 5);
            if (kVar != null) {
                anVar4.cI("tid", kVar.tid);
                if (kVar.dqE != null && kVar.dqE.aMc() != null) {
                    anVar4.cI("pid", kVar.dqE.aMc().getId());
                }
            }
            TiebaStatic.log(anVar4);
        } else if ((view instanceof TbImageView) && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            an anVar5 = new an("c13423");
            anVar5.af("obj_locate", 3);
            if (kVar != null) {
                anVar5.cI("tid", kVar.tid);
                if (kVar.dqE != null && kVar.dqE.aMc() != null) {
                    anVar5.cI("pid", kVar.dqE.aMc().getId());
                }
            }
            TiebaStatic.log(anVar5);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        com.baidu.card.k kVar = new com.baidu.card.k(this.mPageContext.getPageActivity());
        kVar.setFromCDN(this.agw);
        kVar.setForm(ImageViewerConfig.FROM_CONCERN);
        aVar.a((com.baidu.card.h) kVar);
        ad a = aVar.a(false, viewGroup, this.ahy);
        a.bc(1);
        af afVar = new af(a);
        afVar.setPageId(this.ebA);
        a(new v() { // from class: com.baidu.tieba.homepage.concern.a.i.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    com.baidu.tieba.card.data.k kVar2 = (com.baidu.tieba.card.data.k) mVar;
                    kVar2.objType = 1;
                    if (i.this.ada != null) {
                        i.this.ada.a(afVar2.getView(), kVar2);
                    }
                    au.a((com.baidu.tbadk.core.data.a) kVar2, view.getContext(), 1, false);
                    afVar2.rD().b(new a.C0095a(1));
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqE == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        com.baidu.tieba.card.r.bEW().e(new an("c13424"));
        afVar.rD().setPosition(i);
        if (afVar.rD() instanceof com.baidu.tieba.a.e) {
            afVar.rD().setPage(this.aeB);
        }
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.ada);
        return afVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
        this.aeB = str;
    }
}
