package com.baidu.tieba.im.net;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.baidu.adp.lib.webSocket.q;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.cb;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TiebaSocketLinkService extends Service {
    private static a b;
    private static l a = new l();
    private static final Handler c = new n(Looper.getMainLooper());
    private static q d = new o();

    public static void a(a aVar) {
        b = aVar;
    }

    private static boolean d(String str) {
        com.baidu.tieba.im.messageCenter.d.a().a(false);
        cb.b(str, "TiebaSocketLinkService:begin open", null);
        com.baidu.adp.lib.util.e.e("启动连接");
        c.removeMessages(1);
        p.a().c();
        c.sendEmptyMessageDelayed(1, p.a().d());
        try {
            return com.baidu.adp.lib.webSocket.l.a().b();
        } catch (Throwable th) {
            th.printStackTrace();
            com.baidu.adp.lib.util.e.b(th.getMessage());
            return false;
        }
    }

    public static void a() {
        b bVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_CUID, com.baidu.tieba.im.e.b()));
        bVar = e.a;
        String b2 = bVar.b();
        if (b2 != null) {
            com.baidu.tieba.im.f.a = b2;
        } else {
            com.baidu.tieba.im.f.a = "ws://im.tieba.baidu.com:8000";
        }
        com.baidu.adp.lib.webSocket.l.a().a(com.baidu.tieba.im.f.a, "im_version=2.1", null, arrayList);
        com.baidu.adp.lib.webSocket.l.a().a(d);
    }

    public static void a(String str) {
        com.baidu.tieba.im.f.a = str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_CUID, com.baidu.tieba.im.e.b()));
        com.baidu.adp.lib.webSocket.l.a().a(com.baidu.tieba.im.f.a, "im_version=2.1", null, arrayList);
        com.baidu.adp.lib.webSocket.l.a().a(d);
    }

    public static void b(String str) {
        cb.a("TiebaSocketLinkService", 0, 0, "close():" + str, 0);
        a(1, str);
    }

    public static void a(int i, String str) {
        if (!b()) {
            cb.a(str, "TiebaSocketLinkService:close", (String) null, i, (String) null);
            cb.a("TiebaSocketLinkService", 0, 0, "close():" + str, i);
            com.baidu.adp.lib.util.e.e("关闭连接");
            c.removeMessages(1);
            com.baidu.adp.lib.webSocket.l.a().a(i);
        }
    }

    public static boolean a(com.baidu.adp.lib.webSocket.d dVar) {
        if (dVar != null && com.baidu.adp.lib.webSocket.l.a().d() && com.baidu.adp.lib.webSocket.l.a().c()) {
            return com.baidu.adp.lib.webSocket.l.a().a(dVar);
        }
        return false;
    }

    public static boolean b() {
        return (com.baidu.adp.lib.webSocket.l.a().d() || com.baidu.adp.lib.webSocket.l.a().e()) ? false : true;
    }

    public static boolean c() {
        return com.baidu.adp.lib.webSocket.l.a().d();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void a(boolean z, String str) {
        Intent intent = new Intent(TiebaApplication.g().b(), TiebaSocketLinkService.class);
        intent.putExtra("reopen", z);
        intent.putExtra("reason", str);
        com.baidu.adp.lib.f.c.a(TiebaApplication.g().b(), intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("reason");
            if (stringExtra == null) {
                stringExtra = "--";
            }
            if (intent.getBooleanExtra("reopen", false)) {
                com.baidu.adp.lib.util.e.e("进行重连" + stringExtra);
                b(stringExtra);
                d(stringExtra);
            } else if (!com.baidu.adp.lib.webSocket.l.a().d() && !com.baidu.adp.lib.webSocket.l.a().e()) {
                com.baidu.adp.lib.util.e.e("进行连接" + stringExtra);
                b(stringExtra);
                d(stringExtra);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        b("service onDestroy");
    }

    public static void c(String str) {
        if (a != null) {
            a.b(str);
        }
    }
}
