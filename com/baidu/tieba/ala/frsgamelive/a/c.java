package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.frsgamelive.c.c;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, c.a> {
    private com.baidu.tieba.ala.d dHN;
    private String labelName;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public c.a b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.c cVar = new com.baidu.tieba.ala.frsgamelive.c.c(this.mPageContext);
        cVar.setLabelName(this.labelName);
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, c.a aVar2) {
        aVar2.dJd.a(aVar);
        aVar2.dJd.c(this.dHN);
        String str = "";
        if (!StringUtils.isNull(aVar.dJV.aiX().appId)) {
            str = aVar.dJV.aiX().appId;
        }
        com.baidu.tieba.ala.c.aII().c(new an("c12115").p("obj_id", aVar.dJV.aiX().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.dJW != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.dJW.aiX().appId)) {
                str2 = aVar.dJW.aiX().appId;
            }
            com.baidu.tieba.ala.c.aII().c(new an("c12115").p("obj_id", aVar.dJW.aiX().live_id).bS(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.d dVar) {
        this.dHN = dVar;
    }
}
