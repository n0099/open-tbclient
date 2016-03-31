package com.baidu.tieba.enterForum.d;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.g.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.g.a<Object, com.baidu.tbadk.mvc.d.b>> {
    final /* synthetic */ e bdf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, TbPageContext tbPageContext, Class[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
        this.bdf = eVar;
    }

    @Override // com.baidu.tbadk.mvc.g.b
    public int eY(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.tbadkCore.v) {
            if (((com.baidu.tieba.tbadkCore.v) item).getType() == 1) {
                return 1;
            }
        } else if (item instanceof com.baidu.tieba.enterForum.b.a) {
            return 2;
        }
        return 0;
    }
}
