package com.baidu.tieba.enterForum.d;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    final /* synthetic */ e bIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
        this.bIi = eVar;
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eV(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.tbadkCore.w) {
            if (((com.baidu.tieba.tbadkCore.w) item).getType() == 1) {
                return 1;
            }
        } else if (item instanceof com.baidu.tieba.enterForum.b.a) {
            return 2;
        }
        return 0;
    }
}
