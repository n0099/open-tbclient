package com.baidu.tieba;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
/* loaded from: classes4.dex */
public interface ea1 extends k91 {
    void B(AbsNadBrowserView absNadBrowserView, float f, float f2);

    void C0(AbsNadBrowserView absNadBrowserView, String str, boolean z);

    void D0(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError);

    void I0(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean M(AbsNadBrowserView absNadBrowserView, KeyEvent keyEvent);

    boolean N0(AbsNadBrowserView absNadBrowserView, String str);

    void S(AbsNadBrowserView absNadBrowserView, String str);

    void S0(AbsNadBrowserView absNadBrowserView, String str, Bitmap bitmap);

    void T0(AbsNadBrowserView absNadBrowserView, fa1 fa1Var, String str, String str2);

    void a1();

    void b(AbsNadBrowserView absNadBrowserView, int i, String str, String str2);

    void i(AbsNadBrowserView absNadBrowserView, String str);

    void j(AbsNadBrowserView absNadBrowserView);

    void k0();

    void m1(AbsNadBrowserView absNadBrowserView, int i);

    ha1 n0(AbsNadBrowserView absNadBrowserView, String str);

    void r0(AbsNadBrowserView absNadBrowserView, Message message, Message message2);

    void w(AbsNadBrowserView absNadBrowserView, String str);
}
