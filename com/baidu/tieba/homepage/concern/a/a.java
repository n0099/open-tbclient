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
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private com.baidu.tieba.homepage.concern.view.d cQi;
    private x<com.baidu.tieba.homepage.concern.b.b> cQj;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.concern.b.b.cQz);
        this.cQj = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.cQi != null) {
                    boolean z = view instanceof CommonUserLikeButton;
                    aj ajVar = new aj("c12354");
                    ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    if ((a.this.cQi.aoS != null && view.getId() == a.this.cQi.getView().getId()) || view.getId() == a.this.cQi.cQQ.getId()) {
                        ajVar.g("obj_id", bVar.cQA.getId());
                    }
                    ajVar.r("obj_locate", z ? 1 : 2);
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cQi = new com.baidu.tieba.homepage.concern.view.d(this.alI);
        this.cQi.j(this.aOM);
        this.cQi.a(this.cQj);
        return new com.baidu.tieba.card.a.a(this.cQi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.d> aVar) {
        if (bVar.cQA == null || aVar == null || StringUtils.isNull(bVar.cQA.getName()) || StringUtils.isNull(bVar.cQA.getUserId())) {
            return null;
        }
        aVar.Xc().a(bVar);
        aVar.Xc().a(this.cQj);
        aVar.Xc().d(this.alI, TbadkCoreApplication.getInst().getSkinType());
        u.WB().a(new aj("c12353").g(SapiAccountManager.SESSION_UID, bVar.cQA.getId()));
        return aVar.getView();
    }
}
