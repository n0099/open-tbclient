package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.frsgamelive.c.c;
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, c.a> {
    private com.baidu.tieba.ala.f gLh;
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
    /* renamed from: ag */
    public c.a c(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.c cVar = new com.baidu.tieba.ala.frsgamelive.c.c(this.mPageContext);
        cVar.setLabelName(this.labelName);
        return new c.a(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, c.a aVar2) {
        aVar2.gMy.a(aVar);
        aVar2.gMy.c(this.gLh);
        String str = "";
        if (!StringUtils.isNull(aVar.gNq.bpj().appId)) {
            str = aVar.gNq.bpj().appId;
        }
        com.baidu.tieba.ala.c.bPr().e(new ar("c12115").w("obj_id", aVar.gNq.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gNr != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gNr.bpj().appId)) {
                str2 = aVar.gNr.bpj().appId;
            }
            com.baidu.tieba.ala.c.bPr().e(new ar("c12115").w("obj_id", aVar.gNr.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.f fVar) {
        this.gLh = fVar;
    }
}
