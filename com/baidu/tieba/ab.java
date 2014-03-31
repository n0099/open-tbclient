package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements com.baidu.adp.framework.task.a<Intent> {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Intent> aVar) {
        UtilHelper.a(TbadkApplication.j(), aVar.a());
        return null;
    }
}
