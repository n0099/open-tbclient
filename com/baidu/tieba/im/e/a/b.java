package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.bm;
import com.baidu.tieba.im.message.bn;
/* loaded from: classes.dex */
public abstract class b implements com.baidu.adp.framework.task.a<bn> {
    private com.baidu.tieba.im.pushNotify.m a;
    private int b;

    public b(com.baidu.tieba.im.pushNotify.m mVar, int i) {
        this.a = mVar;
        this.b = i;
    }

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<bn> aVar) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(this.b);
        if (aVar == null || !(aVar instanceof bm)) {
            com.baidu.adp.lib.util.f.b("message error");
            return null;
        }
        bn a = aVar.a();
        String str = "";
        if (TbadkApplication.N() != null) {
            str = TbadkApplication.N().getID();
        }
        com.baidu.tieba.im.pushNotify.l b = this.a.b(str, a.b);
        if (b == null) {
            return null;
        }
        b.setDraft(a.a);
        this.a.a(b);
        return customResponsedMessage;
    }
}
