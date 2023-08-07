package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes6.dex */
public interface hb1 extends na1 {
    void C(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void D0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void E0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void I0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean M0(AbsNadBrowserView absNadBrowserView, String str);

    boolean N(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    void R(AbsNadBrowserView absNadBrowserView, String str);

    void S0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void T0(AbsNadBrowserView absNadBrowserView, ib1 ib1Var, String str, String str2);

    void X0();

    void d(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void e(AbsNadBrowserView absNadBrowserView, String str);

    void f(AbsNadBrowserView absNadBrowserView);

    void l0();

    kb1 n0(AbsNadBrowserView absNadBrowserView, String str);

    void p1(AbsNadBrowserView absNadBrowserView, int i);

    void s(AbsNadBrowserView absNadBrowserView, String str);

    void s0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);
}
