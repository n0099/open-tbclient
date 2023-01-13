package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes4.dex */
public interface i2 extends Application {
    Window getApplicationWindow();

    Context getContext();

    c7<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    u2 mo6getInput();

    i8<i1> getLifecycleListeners();

    c7<Runnable> getRunnables();

    WindowManager getWindowManager();
}
