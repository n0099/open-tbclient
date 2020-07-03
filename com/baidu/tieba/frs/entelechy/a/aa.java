package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class aa extends com.baidu.tieba.frs.j<bt, com.baidu.card.ak<bu>> implements com.baidu.tieba.a.f, com.baidu.tieba.card.y, com.baidu.tieba.card.z, com.baidu.tieba.frs.d.d {
    private String afG;
    private com.baidu.tieba.card.aa<bu> fRr;
    private int hID;
    private String mFrom;

    public aa(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        this.hID = 3;
        this.fRr = new com.baidu.tieba.card.aa<bu>() { // from class: com.baidu.tieba.frs.entelechy.a.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                if (view != null && buVar != null) {
                    if (aa.this.hzo != null) {
                        aa.this.hzo.a(view, (View) buVar, (Object) aa.this.getType());
                    }
                    if ("c13010".equals(aa.this.mFrom)) {
                        TiebaStatic.log(new ao("c13010").ag("obj_type", 1).s("fid", buVar.getFid()).dk("tid", buVar.getTid()));
                    }
                    if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.a.a(buVar, 2, aa.this.mPageId, com.baidu.tieba.frs.d.d.hIE, aa.this.getTbPageTag());
                    } else if (view instanceof TbImageView) {
                        if (aa.this.fRr.agT instanceof Boolean) {
                            if (((Boolean) aa.this.fRr.agT).booleanValue()) {
                                com.baidu.tieba.frs.d.a.a(buVar, 1, aa.this.mPageId, com.baidu.tieba.frs.d.d.hIE, aa.this.getTbPageTag());
                            } else {
                                com.baidu.tieba.frs.d.a.a(buVar, 3, aa.this.mPageId, com.baidu.tieba.frs.d.d.hIE, aa.this.getTbPageTag());
                            }
                        }
                    } else if (view instanceof ThreadGodReplyLayout) {
                        com.baidu.tieba.frs.d.a.a(buVar, 15, aa.this.mPageId, com.baidu.tieba.frs.d.d.hIE, aa.this.getTbPageTag());
                    } else {
                        com.baidu.tieba.frs.d.a.a(buVar, 1, aa.this.mPageId, com.baidu.tieba.frs.d.d.hIE, aa.this.getTbPageTag());
                    }
                    if (view.getId() == R.id.thread_card_root && buVar.aQV()) {
                        aa.this.as(buVar);
                    } else if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                        com.baidu.tieba.frs.d.c.ceq().a(com.baidu.tieba.frs.d.d.hIE, buVar, 2);
                    } else if (view.getId() == R.id.card_divider_tv) {
                        com.baidu.tieba.frs.f.h.a(com.baidu.tieba.frs.d.d.hIE, buVar.aPT());
                    } else if (view instanceof TbImageView) {
                        if (aa.this.fRr.agT instanceof Boolean) {
                            if (((Boolean) aa.this.fRr.agT).booleanValue()) {
                                com.baidu.tieba.frs.d.c.ceq().a(com.baidu.tieba.frs.d.d.hIE, buVar, 1);
                            } else {
                                com.baidu.tieba.frs.d.c.ceq().a(com.baidu.tieba.frs.d.d.hIE, buVar, 3);
                            }
                        }
                    } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 3));
                    } else if (view.getId() == R.id.thread_card_voice) {
                        com.baidu.tieba.frs.d.c.ceq().a(com.baidu.tieba.frs.d.d.hIE, buVar, 5);
                    } else if (view instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (buVar.aTS() != null && buVar.aTS().dia() != null && buVar.aTS().dia().bkO() != null && buVar.aTS().dia().bkO().size() > 0) {
                            i = buVar.aTS().lGt ? 9 : 8;
                        }
                        com.baidu.tieba.frs.d.c.ceq().a(com.baidu.tieba.frs.d.d.hIE, buVar, i);
                    } else {
                        com.baidu.tieba.frs.d.c.ceq().a(com.baidu.tieba.frs.d.d.hIE, buVar, 1);
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
    /* renamed from: aQ */
    public com.baidu.card.ak<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), true);
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.bd(4280);
        eVar.setPageUniqueId(this.mPageId);
        eVar.a(new e.a() { // from class: com.baidu.tieba.frs.entelechy.a.aa.2
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
        com.baidu.card.ai a = aVar.a(false, viewGroup, this.hfK);
        a.setSourceForPb(3);
        com.baidu.card.ak<bu> akVar = new com.baidu.card.ak<>(a);
        akVar.setPageId(this.mPageId);
        akVar.aJ(false);
        a(new com.baidu.adp.widget.ListView.z() { // from class: com.baidu.tieba.frs.entelechy.a.aa.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bt) && (view.getTag() instanceof com.baidu.card.ak)) {
                    com.baidu.card.ak akVar2 = (com.baidu.card.ak) view.getTag();
                    bu buVar = ((bt) qVar).dLi;
                    buVar.objType = 1;
                    if (aa.this.fRr != null) {
                        aa.this.fRr.a(akVar2.getView(), buVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), aa.this.hID, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, com.baidu.card.ak<bu> akVar) {
        super.a(i, view, viewGroup, (ViewGroup) btVar, (bt) akVar);
        if (btVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.se().setPage(this.afG);
        akVar.se().setPosition(i);
        com.baidu.tieba.frs.i.a(akVar.se().rY(), this.hzi);
        if (this.hzi != null && this.hzi.getForum() != null && !StringUtils.isNull(this.hzi.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.hzi.getForum().getTopic_special_icon_right())) {
            btVar.dLi.db(this.hzi.getForum().getTopic_special_icon(), this.hzi.getForum().getTopic_special_icon_right());
        }
        akVar.a(btVar.aPZ(), Align.ALIGN_RIGHT_TOP, null);
        if (!btVar.dLi.isBjh()) {
            akVar.sg();
        }
        akVar.b((com.baidu.card.ak<bu>) btVar.dLi);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.fRr);
        btVar.dLi.aTB();
        if (hIE != null) {
            int i2 = 0;
            if (this.hzi != null) {
                i2 = this.hzi.getTopThreadSize();
            }
            btVar.dLi.dJw = (btVar.position + 1) - i2;
        }
        com.baidu.tieba.frs.d.c.ceq().a(hIE, btVar.dLi);
        btVar.dLi.aTB();
        com.baidu.tieba.frs.d.a.a(btVar.dLi, this.mPageId, hIE, getTbPageTag());
        if (btVar != null) {
            btVar.dLi.aTB();
        }
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }

    @Override // com.baidu.tieba.card.y
    public void setForumName(String str) {
    }

    @Override // com.baidu.tieba.card.y
    public void qX(int i) {
        this.hID = i;
    }

    @Override // com.baidu.tieba.card.z
    public void me(boolean z) {
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return hIE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(bu buVar) {
        TiebaStatic.log(new ao("c12126").dk("tid", buVar.getId()).ag("obj_locate", bXM() ? 2 : 1).s("obj_id", buVar.aSJ() == null ? -1L : buVar.aSJ().live_id).ag("obj_type", 1));
    }
}
