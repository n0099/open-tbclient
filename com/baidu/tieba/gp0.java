package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes6.dex */
public interface gp0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "rewardCriusPop");

    void a(ep0 ep0Var);

    void b(sr0 sr0Var, Context context);

    View getView();

    void release();

    void show();
}
