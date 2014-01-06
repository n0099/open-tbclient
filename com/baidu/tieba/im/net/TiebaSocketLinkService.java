package com.baidu.tieba.im.net;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.adp.lib.webSocket.r;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.j;
import com.baidu.tieba.log.i;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TiebaSocketLinkService extends Service {
    private static a b;
    private static b a = new b();
    private static final Handler c = new d(Looper.getMainLooper());
    private static r d = new e();

    public static void a(a aVar) {
        b = aVar;
    }

    private boolean c(String str) {
        com.baidu.tieba.im.messageCenter.e.a().a(false);
        com.baidu.tieba.log.a.b(i.a(str, "TiebaSocketLinkService:begin open", null));
        com.baidu.adp.lib.h.e.d("启动连接");
        c.removeMessages(1);
        f.a().c();
        c.sendEmptyMessageDelayed(1, f.a().d());
        return m.a().b();
    }

    public static void a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_CUID, com.baidu.tieba.im.i.a()));
        m.a().a(j.a, "im_version=2.1", null, arrayList);
        m.a().a(d);
    }

    public static void a(String str) {
        a(1, str);
    }

    public static void a(int i, String str) {
        if (!b()) {
            com.baidu.tieba.log.a.b(i.a(str, "TiebaSocketLinkService:close", null, i, null));
            com.baidu.adp.lib.h.e.d("关闭连接");
            c.removeMessages(1);
            m.a().a(i);
        }
    }

    public static boolean a(com.baidu.adp.lib.webSocket.d dVar) {
        if (dVar != null && m.a().e() && m.a().d()) {
            return m.a().a(dVar);
        }
        return false;
    }

    public static boolean b() {
        return (m.a().e() || m.a().f()) ? false : true;
    }

    public static boolean c() {
        return m.a().e();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void a(boolean z, String str) {
        Intent intent = new Intent(TiebaApplication.g(), TiebaSocketLinkService.class);
        intent.putExtra("reopen", z);
        intent.putExtra("reason", str);
        com.baidu.adp.lib.f.c.a(TiebaApplication.g(), intent);
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
                com.baidu.adp.lib.h.e.d("进行重连" + stringExtra);
                a(stringExtra);
                c(stringExtra);
            } else if (!m.a().e() && !m.a().f()) {
                com.baidu.adp.lib.h.e.d("进行连接" + stringExtra);
                a(stringExtra);
                c(stringExtra);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a("service onDestroy");
    }

    public static void b(String str) {
        if (a != null) {
            a.b(str);
        }
    }
}
