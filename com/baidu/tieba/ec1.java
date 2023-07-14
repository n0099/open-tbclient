package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes5.dex */
public interface ec1 extends kb1 {
    void C(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void E0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void F0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void J0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean N(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean N0(AbsNadBrowserView absNadBrowserView, String str);

    void T(AbsNadBrowserView absNadBrowserView, String str);

    void U0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void V0(AbsNadBrowserView absNadBrowserView, fc1 fc1Var, String str, String str2);

    void a1();

    void b(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void e(AbsNadBrowserView absNadBrowserView, String str);

    void f(AbsNadBrowserView absNadBrowserView);

    void l0();

    hc1 p0(AbsNadBrowserView absNadBrowserView, String str);

    void q1(AbsNadBrowserView absNadBrowserView, int i);

    void t(AbsNadBrowserView absNadBrowserView, String str);

    void t0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);
}
