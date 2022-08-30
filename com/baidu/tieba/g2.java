package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes4.dex */
public interface g2 extends Application {
    Window getApplicationWindow();

    Context getContext();

    a7<Runnable> getExecutedRunnables();

    s2 getInput();

    g8<g1> getLifecycleListeners();

    a7<Runnable> getRunnables();

    WindowManager getWindowManager();
}
