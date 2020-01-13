package com.baidu.tieba.ala.frsgamelive.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.ala.frsgamelive.c.e;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.gamelist.b.a, e.a> {
    private com.baidu.tieba.ala.d exk;
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
    /* renamed from: U */
    public e.a b(ViewGroup viewGroup) {
        com.baidu.tieba.ala.frsgamelive.c.e eVar = new com.baidu.tieba.ala.frsgamelive.c.e(this.mPageContext);
        eVar.setLabelName(this.labelName);
        return new e.a(eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.gamelist.b.a aVar, e.a aVar2) {
        aVar2.eyS.a(aVar);
        aVar2.eyS.c(this.exk);
        String str = "";
        if (!StringUtils.isNull(aVar.ezw.aAq().appId)) {
            str = aVar.ezw.aAq().appId;
        }
        com.baidu.tieba.ala.c.aZz().c(new an("c12115").s("obj_id", aVar.ezw.aAq().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, str));
        if (aVar.ezx != null) {
            String str2 = "";
            if (!StringUtils.isNull(aVar.ezx.aAq().appId)) {
                str2 = aVar.ezx.aAq().appId;
            }
            com.baidu.tieba.ala.c.aZz().c(new an("c12115").s("obj_id", aVar.ezx.aAq().live_id).cp(TiebaInitialize.Params.OBJ_PARAM3, str2));
        }
        return aVar2.getView();
    }

    public void a(com.baidu.tieba.ala.d dVar) {
        this.exk = dVar;
    }
}
