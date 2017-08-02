package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.d>> {
    public BdUniqueId aNy;
    private TbPageContext<?> ako;
    private com.baidu.tieba.homepage.concern.view.d cOP;
    private x<com.baidu.tieba.homepage.concern.b.b> cOQ;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.concern.b.b.cPg);
        this.cOQ = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.cOP != null) {
                    boolean z = view instanceof CommonUserLikeButton;
                    aj ajVar = new aj("c12354");
                    ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    if ((a.this.cOP.anz != null && view.getId() == a.this.cOP.getView().getId()) || view.getId() == a.this.cOP.cPx.getId()) {
                        ajVar.f("obj_id", bVar.cPh.getId());
                    }
                    ajVar.r("obj_locate", z ? 1 : 2);
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cOP = new com.baidu.tieba.homepage.concern.view.d(this.ako);
        this.cOP.j(this.aNy);
        this.cOP.a(this.cOQ);
        return new com.baidu.tieba.card.a.a(this.cOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.d> aVar) {
        if (bVar.cPh == null || aVar == null || StringUtils.isNull(bVar.cPh.getName()) || StringUtils.isNull(bVar.cPh.getUserId())) {
            return null;
        }
        aVar.WX().a(bVar);
        aVar.WX().a(this.cOQ);
        aVar.WX().d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        u.Ww().a(new aj("c12353").f(SapiAccountManager.SESSION_UID, bVar.cPh.getId()));
        return aVar.getView();
    }
}
