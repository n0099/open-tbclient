package com.baidu.tieba.card;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e extends d {
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    private static void a(com.baidu.tbadk.core.data.c cVar, int i) {
        com.baidu.tbadk.distribute.a.AK().a(cVar, "", 0L, "NEWINDEX", "show", i);
        com.baidu.tieba.recapp.report.b.aLG().a(com.baidu.tieba.recapp.report.e.a(cVar, "show", i));
    }

    @Override // com.baidu.tieba.card.d, com.baidu.tieba.card.f
    protected String JP() {
        return "NEWINDEX";
    }

    public static void a(com.baidu.tieba.card.a.d dVar, int i) {
        a(dVar.Kt(), i);
    }

    public static void L(int i, int i2) {
        com.baidu.tieba.recapp.report.a i3 = com.baidu.tieba.recapp.report.e.i("store", i2, i);
        i3.bE("page", "NEWINDEX");
        com.baidu.tieba.recapp.report.b.aLG().a(i3);
    }
}
