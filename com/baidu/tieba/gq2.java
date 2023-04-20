package com.baidu.tieba;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.Map;
/* loaded from: classes4.dex */
public interface gq2 extends sl2 {

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);

        void b(int i);

        void c(String str);

        void d(@NonNull String str);

        void e(String str);

        void f();

        void onEnded();

        void onError(int i);

        void onPrepared();

        void onRelease(String str);
    }

    void B(boolean z);

    void C();

    void G(int i);

    void H();

    void L(int i, int i2, int i3, int i4);

    void N(ZeusPluginFactory.Invoker invoker);

    boolean O(String str, String str2, String str3, boolean z);

    boolean P();

    a Q();

    void S(Map map);

    void T();

    void V();

    int a();

    void a0(String str);

    void b0();

    String c();

    ZeusPluginFactory.Invoker e0();

    void f0(int i);

    void g0(@NonNull a aVar);

    Context getContext();

    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    boolean i0();

    boolean isPlaying();

    void l(boolean z);

    void m0();

    void pause();

    boolean prepareAsync();

    void release();

    void seekTo(int i);

    void setSpeed(float f);

    void setSurface(Surface surface);

    void start();
}
