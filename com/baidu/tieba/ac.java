package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.data.k> {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.data.k> aVar) {
        UtilHelper.showNotification(TbadkApplication.j(), aVar.a(), 13);
        return null;
    }
}
