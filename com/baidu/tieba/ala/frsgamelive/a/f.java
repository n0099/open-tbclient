package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.ala.frsgamelive.c.e;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, e.a> {
    private com.baidu.tieba.ala.f gLf;
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
    /* renamed from: ai */
    public e.a c(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.e eVar = new com.baidu.tieba.ala.frsgamelive.c.e(this.mPageContext);
        eVar.setLabelName(this.labelName);
        return new e.a(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, e.a aVar2) {
        aVar2.gMK.a(aVar);
        aVar2.gMK.c(this.gLf);
        String str = "";
        if (!StringUtils.isNull(aVar.gNo.bpj().appId)) {
            str = aVar.gNo.bpj().appId;
        }
        com.baidu.tieba.ala.c.bPq().e(new ar("c12115").w("obj_id", aVar.gNo.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.gNp != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.gNp.bpj().appId)) {
                str2 = aVar.gNp.bpj().appId;
            }
            com.baidu.tieba.ala.c.bPq().e(new ar("c12115").w("obj_id", aVar.gNp.bpj().live_id).dY(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.f fVar) {
        this.gLf = fVar;
    }
}
