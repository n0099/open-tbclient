package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.frsgamelive.c.c;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, c.a> {
    private com.baidu.tieba.ala.d ful;
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
    /* renamed from: ab */
    public c.a b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.c cVar = new com.baidu.tieba.ala.frsgamelive.c.c(this.mPageContext);
        cVar.setLabelName(this.labelName);
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, c.a aVar2) {
        aVar2.fvC.a(aVar);
        aVar2.fvC.c(this.ful);
        String str = "";
        if (!StringUtils.isNull(aVar.fwu.aQS().appId)) {
            str = aVar.fwu.aQS().appId;
        }
        com.baidu.tieba.ala.c.bpq().e(new an("c12115").s("obj_id", aVar.fwu.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.fwv != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.fwv.aQS().appId)) {
                str2 = aVar.fwv.aQS().appId;
            }
            com.baidu.tieba.ala.c.bpq().e(new an("c12115").s("obj_id", aVar.fwv.aQS().live_id).dh(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.d dVar) {
        this.ful = dVar;
    }
}
