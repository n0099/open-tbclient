package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface hp0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "rewardCriusPop");

    void a(fp0 fp0Var);

    void b(tr0 tr0Var, Context context);

    View getView();

    void release();

    void show();
}
