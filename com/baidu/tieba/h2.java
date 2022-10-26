package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes4.dex */
public interface h2 extends Application {
    Window getApplicationWindow();

    Context getContext();

    b7 getExecutedRunnables();

    t2 getInput();

    h8 getLifecycleListeners();

    b7 getRunnables();

    WindowManager getWindowManager();
}
