package com.baidu.tieba;

import android.app.Application;
import cn.jpush.android.api.JPushInterface;
import com.baidu.tieba.r.b;
/* loaded from: classes3.dex */
public class c implements b.a {
    @Override // com.baidu.tieba.r.b.a
    public void d(Application application) {
        JPushInterface.init(application);
    }
}
