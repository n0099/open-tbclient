package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes5.dex */
public interface e1 extends Application {
    Window getApplicationWindow();

    Context getContext();

    r2<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    p1 mo6getInput();

    g3<a1> getLifecycleListeners();

    r2<Runnable> getRunnables();

    WindowManager getWindowManager();
}
