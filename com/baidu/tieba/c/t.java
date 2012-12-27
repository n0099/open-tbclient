package com.baidu.tieba.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
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

    public t() {
        l();
    }

    public t(Context context, String str) {
        l();
        this.a.b(context);
        this.a.a(str);
    }

    public t(String str) {
        l();
        this.a.a(str);
    }

    private String a(int i) {
        String n;
        switch (i) {
            case 1:
                o();
                n = this.a.k();
                break;
            case 2:
                m();
                o();
                n = this.a.l();
                break;
            case 3:
                m();
                o();
                n = this.a.n();
                break;
            default:
                return null;
        }
        if (!this.a.d() && this.a.e()) {
            if (this.a.f() == 1 && this.d) {
                this.a.h();
                if (TiebaApplication.f()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.a()).backgroundReLogin(TiebaApplication.x(), TiebaApplication.v(), new u(this), new v(this));
                    if (backgroundReLogin != null) {
                        k.b(TiebaApplication.x(), backgroundReLogin);
                        TiebaApplication.f(backgroundReLogin);
                        n = b(i);
                    } else {
                        n = null;
                    }
                } else {
                    com.baidu.tieba.a.a w = TiebaApplication.w();
                    if (w == null) {
                        w = k.l();
                    }
                    if (w == null) {
                        TiebaApplication.a().c.sendMessage(TiebaApplication.a().c.obtainMessage(1));
                        return null;
                    } else if (a(w.b(), w.c(), true) == null) {
                        if (this.b != null) {
                            this.a.b(this.b.g());
                            return null;
                        }
                        return null;
                    } else {
                        n = b(i);
                    }
                }
            }
            return n;
        }
        return n;
    }

    private String b(int i) {
        n();
        switch (i) {
            case 1:
                return this.a.k();
            case 2:
                return this.a.l();
            case 3:
                return this.a.n();
            default:
                return null;
        }
    }

    private void l() {
        this.a = new w();
        this.b = null;
        this.c = false;
        this.d = true;
    }

    private void m() {
        String v = TiebaApplication.v();
        if (v != null) {
            this.a.a("BDUSS", v);
        }
    }

    private void n() {
        String v = TiebaApplication.v();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", v);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.a().D());
        ae.a("NetWork", "modSessionData", "== BDUSS:" + v);
        ae.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.a().D());
        if (v != null) {
            ArrayList q = this.a.q();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) q.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    q.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.f()) {
                    q.set(i, basicNameValuePair2);
                }
            }
        }
    }

    private void o() {
        this.a.a("_client_type", "2");
        this.a.a("_client_version", com.baidu.tieba.a.h.h());
        if (TiebaApplication.a().g() != null) {
            this.a.a("_phone_imei", TiebaApplication.a().g());
        }
        String E = TiebaApplication.E();
        if (E != null) {
            this.a.a("_client_id", E);
        }
        String o = TiebaApplication.o();
        if (o != null && o.length() > 0) {
            this.a.a("from", o);
        }
        String a = this.a.a();
        if (a != null) {
            this.a.a("net_type", a);
        }
        if (this.c) {
            if (TiebaApplication.f()) {
                this.a.a("tbs", "ignore");
            } else {
                this.a.a("tbs", TiebaApplication.a().D());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        TiebaApplication.a((com.baidu.tieba.a.a) null);
        TiebaApplication.a().c.sendMessage(TiebaApplication.a().c.obtainMessage(1));
    }

    public int a() {
        return this.a.m();
    }

    public com.baidu.tieba.b.g a(String str, String str2, boolean z) {
        String l;
        try {
            ae.a(getClass().toString(), "login", "=== need auto login");
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/s/login");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", "0"));
            if (this.b == null) {
                this.b = new w();
            } else {
                this.b.i();
            }
            this.b.a(stringBuffer.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.b(this.a.p());
            l = this.b.l();
        } catch (Exception e) {
            ae.b(getClass().toString(), "login", e.getMessage());
        }
        if (!this.b.d() || l == null) {
            if (this.b.e()) {
                switch (this.b.f()) {
                    case 1:
                    case 2:
                    case 5:
                        if (z) {
                            Message obtainMessage = TiebaApplication.a().c.obtainMessage(1);
                            Bundle bundle = new Bundle();
                            bundle.putString("account", str);
                            obtainMessage.setData(bundle);
                            TiebaApplication.a().c.sendMessage(obtainMessage);
                        }
                        this.b.h();
                        break;
                }
                return null;
            }
            return null;
        }
        com.baidu.tieba.b.g gVar = new com.baidu.tieba.b.g();
        gVar.a(l);
        String a = gVar.a().a();
        if (a == null || a.length() <= 0) {
            this.b.b(this.b.p().getString(R.string.neterror));
            return null;
        }
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(gVar.a().b());
        if (gVar.a().e() != null) {
            aVar.c(gVar.a().e());
        } else {
            aVar.c(str2);
        }
        aVar.a(gVar.a().a());
        aVar.d(gVar.a().j());
        aVar.a(1);
        if (gVar.b() != null) {
            aVar.e(gVar.b().b());
        }
        k.a(aVar);
        TiebaApplication.b(aVar);
        com.baidu.tieba.account.a.a().b();
        return gVar;
    }

    public Boolean a(String str, Handler handler) {
        m();
        return this.a.a(str, handler);
    }

    public void a(Context context) {
        this.a.b(context);
    }

    public void a(String str) {
        this.a.a(str);
    }

    public void a(String str, String str2) {
        this.a.a(str, str2);
    }

    public void a(String str, byte[] bArr) {
        this.a.a(str, bArr);
    }

    public void a(ArrayList arrayList) {
        this.a.a(arrayList);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.a.a(basicNameValuePair);
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public String b(String str) {
        ae.c("NetWork", "uploadImage", "upload image");
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

    public void b(boolean z) {
        this.d = z;
    }

    public boolean b() {
        return this.a.d();
    }

    public void c(boolean z) {
        this.a.b(z);
    }

    public boolean c() {
        return this.a.e();
    }

    public int d() {
        return this.a.f();
    }

    public void d(boolean z) {
        this.c = z;
    }

    public String e() {
        return this.a.a();
    }

    public String f() {
        return this.a.g();
    }

    public void g() {
        if (this.a != null) {
            this.a.i();
        }
        if (this.b != null) {
            this.b.i();
        }
    }

    public byte[] h() {
        o();
        return this.a.j();
    }

    public String i() {
        return a(2);
    }

    public String j() {
        return a(3);
    }

    public boolean k() {
        return this.a.o();
    }
}
