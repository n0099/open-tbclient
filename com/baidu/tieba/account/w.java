package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class w implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.ak> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<byte[]> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.ak> aVar) {
        if (aVar != null && aVar.a() != null) {
            Intent d = aVar.a().d();
            if (aVar.a().c() instanceof Activity) {
                ReLoginShareActivity.l = (Activity) aVar.a().c();
            }
            d.setClass(aVar.a().c(), ReLoginShareActivity.class);
            d.putExtra("user_name", aVar.a().a.c);
            d.putExtra("bduss", aVar.a().a.a);
            d.putExtra("ptoken", aVar.a().a.b);
            d.putExtra("locate_type", aVar.a().b);
            aVar.a().f();
        }
        return null;
    }
}
