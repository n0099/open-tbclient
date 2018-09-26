package com.baidu.tieba;

import android.app.Application;
import cn.jpush.android.api.JPushInterface;
import com.baidu.tieba.q.b;
/* loaded from: classes3.dex */
public class c implements b.a {
    @Override // com.baidu.tieba.q.b.a
    public void b(Application application) {
        JPushInterface.init(application);
    }
}
