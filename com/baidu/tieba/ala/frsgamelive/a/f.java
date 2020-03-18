package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.frsgamelive.c.e;
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, e.a> {
    private com.baidu.tieba.ala.d eCe;
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
    /* renamed from: V */
    public e.a b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.e eVar = new com.baidu.tieba.ala.frsgamelive.c.e(this.mPageContext);
        eVar.setLabelName(this.labelName);
        return new e.a(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, e.a aVar2) {
        aVar2.eDJ.a(aVar);
        aVar2.eDJ.c(this.eCe);
        String str = "";
        if (!StringUtils.isNull(aVar.eEn.aCK().appId)) {
            str = aVar.eEn.aCK().appId;
        }
        com.baidu.tieba.ala.c.bbV().e(new an("c12115").s("obj_id", aVar.eEn.aCK().live_id).cx(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.eEo != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.eEo.aCK().appId)) {
                str2 = aVar.eEo.aCK().appId;
            }
            com.baidu.tieba.ala.c.bbV().e(new an("c12115").s("obj_id", aVar.eEo.aCK().live_id).cx(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.d dVar) {
        this.eCe = dVar;
    }
}
