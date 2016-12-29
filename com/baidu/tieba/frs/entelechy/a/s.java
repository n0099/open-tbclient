package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.frs.entelechy.view.bb;
import com.baidu.tieba.play.ax;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<bg, a<com.baidu.tieba.frs.entelechy.view.q>> implements bb, com.baidu.tieba.frs.g.e {
    private TbPageContext<?> GO;
    private cb<bg> bES;
    private String forumName;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.y$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, bg bgVar, a<com.baidu.tieba.frs.entelechy.view.q> aVar) {
        return a2(i, view, viewGroup, bgVar, (a) aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bES = new t(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public a a(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.view.q qVar = new com.baidu.tieba.frs.entelechy.view.q(this.GO);
        qVar.j(this.GO.getUniqueId());
        qVar.setForumName(this.forumName);
        return new a(qVar);
    }

    private ax j(bg bgVar) {
        if (bgVar == null) {
            return null;
        }
        ax axVar = new ax();
        axVar.mLocate = bgVar.sx() ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : "2";
        axVar.aRe = bMV.bMN;
        axVar.aRf = bgVar.getTid();
        bgVar.sB();
        return axVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(int i, View view, ViewGroup viewGroup, bg bgVar, a aVar) {
        if (aVar == null || aVar.Po() == null) {
            return null;
        }
        aVar.Po().a(j(bgVar));
        aVar.Po().onBindDataToView(bgVar);
        aVar.Po().setOnSubCardOnClickListenner(this.bES);
        com.baidu.tieba.frs.g.b.abq().a(bMV, bgVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.frs.entelechy.view.bb
    public void setForumName(String str) {
        this.forumName = str;
    }
}
