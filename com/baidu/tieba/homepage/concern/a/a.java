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
    public BdUniqueId aON;
    private com.baidu.tieba.homepage.concern.view.d cSh;
    private x<com.baidu.tieba.homepage.concern.b.b> cSi;
    private TbPageContext<?> oV;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), com.baidu.tieba.homepage.concern.b.b.cSy);
        this.cSi = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.cSh != null) {
                    boolean z = view instanceof CommonUserLikeButton;
                    aj ajVar = new aj("c12354");
                    ajVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                    if ((a.this.cSh.aoT != null && view.getId() == a.this.cSh.getView().getId()) || view.getId() == a.this.cSh.cSP.getId()) {
                        ajVar.g("obj_id", bVar.cSz.getId());
                    }
                    ajVar.r("obj_locate", z ? 1 : 2);
                    TiebaStatic.log(ajVar);
                }
            }
        };
        this.oV = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cSh = new com.baidu.tieba.homepage.concern.view.d(this.oV);
        this.cSh.j(this.aON);
        this.cSh.b(this.cSi);
        return new com.baidu.tieba.card.a.a(this.cSh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.d> aVar) {
        if (bVar.cSz == null || aVar == null || StringUtils.isNull(bVar.cSz.getName()) || StringUtils.isNull(bVar.cSz.getUserId())) {
            return null;
        }
        aVar.Xy().a(bVar);
        aVar.Xy().b(this.cSi);
        aVar.Xy().d(this.oV, TbadkCoreApplication.getInst().getSkinType());
        u.WX().a(new aj("c12353").g(SapiAccountManager.SESSION_UID, bVar.cSz.getId()));
        return aVar.getView();
    }
}
