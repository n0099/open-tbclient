package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes5.dex */
public interface a2 extends Application {
    Window getApplicationWindow();

    Context getContext();

    u6<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    m2 mo6getInput();

    a8<a1> getLifecycleListeners();

    u6<Runnable> getRunnables();

    WindowManager getWindowManager();
}
