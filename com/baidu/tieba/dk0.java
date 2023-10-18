package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface dk0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "rewardCriusPop");

    void a(bk0 bk0Var);

    void b(pm0 pm0Var, Context context);

    View getView();

    void release();

    void show();
}
