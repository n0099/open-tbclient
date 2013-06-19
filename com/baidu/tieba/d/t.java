package com.baidu.tieba.d;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class t {
    private w a = null;
    private w b = null;
    private boolean c = false;
    private boolean d = true;
    private aa e = null;
    private int f = 0;

    private void l() {
        this.a = new w();
        this.b = null;
        this.c = false;
        this.d = true;
    }

    public t() {
        l();
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public void b(boolean z) {
        this.d = z;
    }

    public t(String str) {
        l();
        this.a.a(str);
    }

    public t(Context context, String str) {
        l();
        this.a.b(context);
        this.a.a(str);
    }

    public void a(String str) {
        this.a.a(str);
    }

    public void a(Context context) {
        this.a.b(context);
    }

    public void a(ArrayList arrayList) {
        this.a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.a.a(str, bArr);
    }

    public void c(boolean z) {
        this.a.b(z);
    }

    private void m() {
        String D = TiebaApplication.D();
        if (D != null) {
            this.a.a("BDUSS", D);
        }
    }

    private void n() {
        String D = TiebaApplication.D();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", D);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.e().N());
        ae.a("NetWork", "modSessionData", "== BDUSS:" + D);
        ae.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.e().N());
        if (D != null) {
            ArrayList s = this.a.s();
            int size = s.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) s.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    s.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.j()) {
                    s.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int a() {
        return this.a.o();
    }

    private void o() {
        this.a.a("_client_type", "2");
        this.a.a("_client_version", com.baidu.tieba.a.i.i());
        if (TiebaApplication.e().l() != null) {
            this.a.a("_phone_imei", TiebaApplication.e().l());
        }
        String O = TiebaApplication.O();
        if (O != null) {
            this.a.a("_client_id", O);
        }
        String w = TiebaApplication.w();
        if (w != null && w.length() > 0) {
            this.a.a("from", w);
        }
        String b = this.a.b();
        if (b != null) {
            this.a.a("net_type", b);
        }
        if (this.c) {
            this.a.a("tbs", TiebaApplication.e().N());
        }
        String k = TiebaApplication.e().k();
        if (k != null) {
            this.a.a("cuid", k);
        }
        this.a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.a.a("model", Build.MODEL);
    }

    private void p() {
        if (this.e == null) {
            this.e = w.a();
        }
        if (this.e != null) {
            this.a.a("stTime", String.valueOf(this.e.b));
            this.a.a("stSize", String.valueOf(this.e.c));
            this.a.a("stTimesNum", String.valueOf(this.e.d));
            this.a.a("stMode", String.valueOf(this.e.e));
            this.a.a("stMethod", String.valueOf(this.e.a));
        }
        this.f = w.a(0);
        this.a.a("stErrorNums", String.valueOf(this.f));
    }

    public boolean b() {
        return this.a.f();
    }

    public boolean c() {
        return this.a.g();
    }

    public int d() {
        return this.a.h();
    }

    public String e() {
        return this.a.b();
    }

    public String f() {
        return this.a.i();
    }

    public void g() {
        if (this.a != null) {
            this.a.k();
        }
        if (this.b != null) {
            this.b.k();
        }
    }

    public com.baidu.tieba.c.ai a(String str, String str2, boolean z) {
        String n;
        try {
            ae.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.a.i.e);
            sb.append("c/s/login");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", "0"));
            if (this.b == null) {
                this.b = new w();
            } else {
                this.b.k();
            }
            this.b.a(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.b(this.a.r());
            n = this.b.n();
        } catch (Exception e) {
            ae.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.f() && n != null) {
            com.baidu.tieba.c.ai aiVar = new com.baidu.tieba.c.ai();
            aiVar.a(n);
            String a = aiVar.a().a();
            if (a == null || a.length() <= 0) {
                this.b.b(this.b.r().getString(R.string.neterror));
                return null;
            }
            com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
            aVar.b(aiVar.a().c());
            if (aiVar.a().g() != null) {
                aVar.c(aiVar.a().g());
            } else {
                aVar.c(str2);
            }
            aVar.a(aiVar.a().a());
            aVar.d(aiVar.a().l());
            aVar.a(1);
            if (aiVar.b() != null) {
                aVar.e(aiVar.b().b());
            }
            k.a(aVar);
            TiebaApplication.b(aVar);
            com.baidu.tieba.account.a.a().b();
            return aiVar;
        }
        if (this.b.g()) {
            switch (this.b.h()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TiebaApplication.e().c.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("account", str);
                        obtainMessage.setData(bundle);
                        TiebaApplication.e().c.sendMessage(obtainMessage);
                    }
                    this.b.j();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] h() {
        o();
        return this.a.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        TiebaApplication.a((com.baidu.tieba.a.a) null);
        TiebaApplication.e().c.sendMessage(TiebaApplication.e().c.obtainMessage(1));
    }

    private String a(int i) {
        String p;
        switch (i) {
            case 1:
                o();
                p();
                p = this.a.m();
                break;
            case 2:
                m();
                o();
                p();
                p = this.a.n();
                break;
            case 3:
                m();
                o();
                p = this.a.p();
                break;
            default:
                return null;
        }
        if (!this.a.g()) {
            w.a(this.e);
            w.b(this.f);
            return p;
        } else if (this.a.f()) {
            return p;
        } else {
            if (this.a.h() == 1 && this.d) {
                this.a.j();
                if (TiebaApplication.j()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.e()).backgroundReLogin(TiebaApplication.G(), TiebaApplication.D(), new u(this), new v(this));
                    if (backgroundReLogin != null) {
                        k.b(TiebaApplication.G(), backgroundReLogin);
                        TiebaApplication.f(backgroundReLogin);
                        p = b(i);
                    } else {
                        p = null;
                    }
                } else {
                    com.baidu.tieba.a.a F = TiebaApplication.F();
                    if (F == null) {
                        F = k.n();
                    }
                    if (F == null) {
                        TiebaApplication.e().c.sendMessage(TiebaApplication.e().c.obtainMessage(1));
                        return null;
                    } else if (a(F.b(), F.c(), true) == null) {
                        if (this.b != null) {
                            this.a.b(this.b.i());
                            return null;
                        }
                        return null;
                    } else {
                        p = b(i);
                    }
                }
            }
            return p;
        }
    }

    private String b(int i) {
        n();
        switch (i) {
            case 1:
                return this.a.m();
            case 2:
                return this.a.n();
            case 3:
                return this.a.p();
            default:
                return null;
        }
    }

    public String i() {
        return a(2);
    }

    public String j() {
        return a(3);
    }

    public String b(String str) {
        ae.e("NetWork", "uploadImage", "upload image");
        byte[] bArr = null;
        try {
            InputStream g = o.g(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = g.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        a("pic", bArr);
        return j();
    }

    public boolean k() {
        return this.a.q();
    }

    public Boolean a(String str, Handler handler) {
        m();
        return this.a.a(str, handler);
    }

    public void d(boolean z) {
        this.c = z;
    }
}
