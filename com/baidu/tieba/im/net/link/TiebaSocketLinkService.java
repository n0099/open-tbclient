package com.baidu.tieba.im.net.link;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.baidu.adp.lib.webSocket.am;
import com.baidu.adp.lib.webSocket.l;
import com.baidu.adp.lib.webSocket.q;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.j;
import com.baidu.tieba.util.y;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class TiebaSocketLinkService extends Service {
    private static a b;

    /* renamed from: a  reason: collision with root package name */
    private static b f1766a = new b();
    private static final Handler c = new d();
    private static q d = new e();

    public static void a(a aVar) {
        b = aVar;
    }

    private boolean b(String str) {
        y.a(str, "TiebaSocketLinkService:begin open", null);
        com.baidu.adp.lib.h.d.d("启动连接");
        c.removeMessages(1);
        c.sendEmptyMessageDelayed(1, j.d);
        return l.a().b();
    }

    public static void a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_CUID, i.a()));
        l.a().a(j.f1722a, j.b, null, arrayList);
        l.a().a(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        b(1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, String str) {
        y.a(str, "TiebaSocketLinkService:close", null);
        com.baidu.adp.lib.h.d.d("关闭连接");
        c.removeMessages(1);
        l.a().a(i);
    }

    public static void b() {
        c.sendEmptyMessage(2);
    }

    public static boolean a(am amVar) {
        if (amVar != null) {
            if (l.a().e()) {
                if (l.a().d()) {
                    return l.a().a(amVar);
                }
                return false;
            } else if (l.a().f()) {
                return false;
            } else {
                a(true, "sendMessage");
                return false;
            }
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void a(boolean z, String str) {
        Intent intent = new Intent(TiebaApplication.g(), TiebaSocketLinkService.class);
        intent.putExtra("reopen", z);
        intent.putExtra("reason", str);
        TiebaApplication.g().startService(intent);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("reason");
            if (intent.getBooleanExtra("reopen", false)) {
                com.baidu.adp.lib.h.d.d("进行重连");
                c(stringExtra);
                b(stringExtra);
            } else if (!l.a().e() && !l.a().f()) {
                com.baidu.adp.lib.h.d.d("进行连接");
                c(stringExtra);
                b(stringExtra);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c("service onDestroy");
    }
}
