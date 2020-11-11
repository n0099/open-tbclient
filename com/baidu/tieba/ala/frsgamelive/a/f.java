package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.ala.frsgamelive.c.e;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, e.a> {
    private com.baidu.tieba.ala.f gCB;
    private String labelName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: am */
    public e.a c(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.e eVar = new com.baidu.tieba.ala.frsgamelive.c.e(this.mPageContext);
        eVar.setLabelName(this.labelName);
        return new e.a(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, e.a aVar2) {
        aVar2.gEg.a(aVar);
        aVar2.gEg.c(this.gCB);
        String str = "";
        if (!StringUtils.isNull(aVar.gEK.bmU().appId)) {
            str = aVar.gEK.bmU().appId;
        }
        com.baidu.tieba.ala.c.bMo().e(new aq("c12115").w("obj_id", aVar.gEK.bmU().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gEL != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gEL.bmU().appId)) {
                str2 = aVar.gEL.bmU().appId;
            }
            com.baidu.tieba.ala.c.bMo().e(new aq("c12115").w("obj_id", aVar.gEL.bmU().live_id).dR(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.f fVar) {
        this.gCB = fVar;
    }
}
