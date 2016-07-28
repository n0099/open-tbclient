package com.baidu.tieba.card;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class e extends d {
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    private static void a(com.baidu.tbadk.core.data.b bVar, int i) {
        com.baidu.tbadk.distribute.a.AU().a(bVar, "", 0L, "NEWINDEX", "show", i);
        com.baidu.tieba.recapp.report.b.aYc().a(com.baidu.tieba.recapp.report.e.a(bVar, "show", i));
    }

    @Override // com.baidu.tieba.card.d, com.baidu.tieba.card.f
    protected String KP() {
        return "NEWINDEX";
    }

    public static void a(com.baidu.tieba.card.a.d dVar, int i) {
        a(dVar.Lr(), i);
    }

    public static void N(int i, int i2) {
        com.baidu.tieba.recapp.report.a i3 = com.baidu.tieba.recapp.report.e.i("store", i2, i);
        i3.bL("page", "NEWINDEX");
        com.baidu.tieba.recapp.report.b.aYc().a(i3);
    }
}
