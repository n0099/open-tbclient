package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.data.k> {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(p pVar) {
        this.a = pVar;
    }

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.data.k> aVar) {
        UtilHelper.a(TbadkApplication.j(), aVar.a(), 13);
        return null;
    }
}
