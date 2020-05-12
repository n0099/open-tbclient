package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class g extends com.baidu.adp.widget.ListView.a<bi, af<bj>> {
    private z<bi> ada;
    private r ahy;
    public BdUniqueId ebA;
    private NEGFeedBackView.a euX;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, bi biVar, af<bj> afVar) {
        return a2(i, view, viewGroup, biVar, (af) afVar);
    }

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ada = new z<bi>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bi biVar) {
                if (biVar != null) {
                    com.baidu.tieba.card.r.bEX().jd(true);
                    g.this.e(view, biVar.dqE);
                }
            }
        };
        this.euX = new NEGFeedBackView.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.g.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(al alVar) {
                TiebaStatic.log(com.baidu.tieba.enterForum.a.a(alVar, g.this.mTabName));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(al alVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str2, al alVar) {
            }
        };
        this.mPageContext = tbPageContext;
        this.ebA = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(r rVar) {
        this.ahy = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(View view, bj bjVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bjVar, this.mTabName));
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bjVar, this.mTabName));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bjVar, this.mTabName));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.m(bjVar, this.mTabName));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bjVar, this.mTabName));
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.k(bjVar, this.mTabName));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 22;
        dVar.dnd = 19;
        agVar.setAgreeStatisticData(dVar);
        agVar.setTabName(this.mTabName);
        agVar.setFrom(18);
        agVar.setStType("personalize_page");
        agVar.setShareReportFrom(18);
        agVar.bl(2);
        agVar.aW(32);
        aVar.b(agVar);
        ad a = aVar.a(true, viewGroup, this.ahy);
        a.bc(2);
        af afVar = new af(a);
        afVar.setPageId(this.ebA);
        a(new v() { // from class: com.baidu.tieba.enterForum.tabfeed.a.g.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof af)) {
                    af afVar2 = (af) view.getTag();
                    bj bjVar = ((bi) mVar).dqE;
                    bjVar.objType = 1;
                    if (g.this.ada != null) {
                        g.this.ada.a(afVar2.getView(), (bi) mVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 2, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar2.rD().b(new a.C0095a(1));
                }
            }
        });
        return afVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, bi biVar, af afVar) {
        if (biVar == null || afVar == null || afVar.getView() == null || biVar.dqE == null) {
            return null;
        }
        biVar.dqE.dpd = getPositionByType(i) + 1;
        afVar.rD().setPosition(i);
        if (afVar.rD().rx() instanceof ag) {
            ((ag) afVar.rD().rx()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.g.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((r) viewGroup, view, i));
                    }
                }
            });
        }
        afVar.aF(false).a(this.euX);
        afVar.b((af) biVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.ada);
        return afVar.getView();
    }
}
