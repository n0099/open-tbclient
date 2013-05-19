package com.baidu.tieba.d;

import android.content.Context;
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
        String A = TiebaApplication.A();
        if (A != null) {
            this.a.a("BDUSS", A);
        }
    }

    private void n() {
        String A = TiebaApplication.A();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", A);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.d().K());
        ae.a("NetWork", "modSessionData", "== BDUSS:" + A);
        ae.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.d().K());
        if (A != null) {
            ArrayList s = this.a.s();
            int size = s.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) s.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    s.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.i()) {
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
        this.a.a("_client_version", com.baidu.tieba.a.i.h());
        if (TiebaApplication.d().k() != null) {
            this.a.a("_phone_imei", TiebaApplication.d().k());
        }
        String L = TiebaApplication.L();
        if (L != null) {
            this.a.a("_client_id", L);
        }
        String u = TiebaApplication.u();
        if (u != null && u.length() > 0) {
            this.a.a("from", u);
        }
        String b = this.a.b();
        if (b != null) {
            this.a.a("net_type", b);
        }
        if (this.c) {
            if (TiebaApplication.i()) {
                this.a.a("tbs", "ignore");
            } else {
                this.a.a("tbs", TiebaApplication.d().K());
            }
        }
        String j = TiebaApplication.d().j();
        if (j != null) {
            this.a.a("cuid", j);
        }
        this.a.a("timestamp", Long.toString(System.currentTimeMillis()));
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

    public com.baidu.tieba.c.af a(String str, String str2, boolean z) {
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
            com.baidu.tieba.c.af afVar = new com.baidu.tieba.c.af();
            afVar.a(n);
            String a = afVar.a().a();
            if (a == null || a.length() <= 0) {
                this.b.b(this.b.r().getString(R.string.neterror));
                return null;
            }
            com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
            aVar.b(afVar.a().c());
            if (afVar.a().g() != null) {
                aVar.c(afVar.a().g());
            } else {
                aVar.c(str2);
            }
            aVar.a(afVar.a().a());
            aVar.d(afVar.a().j());
            aVar.a(1);
            if (afVar.b() != null) {
                aVar.e(afVar.b().b());
            }
            k.a(aVar);
            TiebaApplication.b(aVar);
            com.baidu.tieba.account.a.a().b();
            return afVar;
        }
        if (this.b.g()) {
            switch (this.b.h()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TiebaApplication.d().c.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("account", str);
                        obtainMessage.setData(bundle);
                        TiebaApplication.d().c.sendMessage(obtainMessage);
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
        TiebaApplication.d().c.sendMessage(TiebaApplication.d().c.obtainMessage(1));
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
                if (TiebaApplication.i()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.d()).backgroundReLogin(TiebaApplication.D(), TiebaApplication.A(), new u(this), new v(this));
                    if (backgroundReLogin != null) {
                        k.b(TiebaApplication.D(), backgroundReLogin);
                        TiebaApplication.f(backgroundReLogin);
                        p = b(i);
                    } else {
                        p = null;
                    }
                } else {
                    com.baidu.tieba.a.a C = TiebaApplication.C();
                    if (C == null) {
                        C = k.m();
                    }
                    if (C == null) {
                        TiebaApplication.d().c.sendMessage(TiebaApplication.d().c.obtainMessage(1));
                        return null;
                    } else if (a(C.b(), C.c(), true) == null) {
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
