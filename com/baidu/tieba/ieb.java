package com.baidu.tieba;

import android.view.View;
import android.view.Window;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes4.dex */
public interface ieb {
    void attachWindow(Window window);

    View getContentView();

    void refreshView();

    void refreshWindow(WindowParams windowParams);
}
