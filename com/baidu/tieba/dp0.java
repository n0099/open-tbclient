package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes5.dex */
public interface dp0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "rewardCriusPop");

    void a(bp0 bp0Var);

    void b(mr0 mr0Var, Context context);

    View getView();

    void release();

    void show();
}
