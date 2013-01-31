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
        String x = TiebaApplication.x();
        if (x != null) {
            this.a.a("BDUSS", x);
        }
    }

    private void n() {
        String x = TiebaApplication.x();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", x);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.b().H());
        af.a("NetWork", "modSessionData", "== BDUSS:" + x);
        af.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.b().H());
        if (x != null) {
            ArrayList q = this.a.q();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) q.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    q.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.g()) {
                    q.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int a() {
        return this.a.m();
    }

    private void o() {
        this.a.a("_client_type", "2");
        this.a.a("_client_version", com.baidu.tieba.a.i.h());
        if (TiebaApplication.b().h() != null) {
            this.a.a("_phone_imei", TiebaApplication.b().h());
        }
        String I = TiebaApplication.I();
        if (I != null) {
            this.a.a("_client_id", I);
        }
        String q = TiebaApplication.q();
        if (q != null && q.length() > 0) {
            this.a.a("from", q);
        }
        String a = this.a.a();
        if (a != null) {
            this.a.a("net_type", a);
        }
        if (this.c) {
            if (TiebaApplication.g()) {
                this.a.a("tbs", "ignore");
            } else {
                this.a.a("tbs", TiebaApplication.b().H());
            }
        }
    }

    public boolean b() {
        return this.a.d();
    }

    public boolean c() {
        return this.a.e();
    }

    public int d() {
        return this.a.f();
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

    public com.baidu.tieba.b.g a(String str, String str2, boolean z) {
        String l;
        try {
            af.a(getClass().toString(), "login", "=== need auto login");
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
            af.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.d() && l != null) {
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
        if (this.b.e()) {
            switch (this.b.f()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TiebaApplication.b().c.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("account", str);
                        obtainMessage.setData(bundle);
                        TiebaApplication.b().c.sendMessage(obtainMessage);
                    }
                    this.b.h();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] h() {
        o();
        return this.a.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        TiebaApplication.a((com.baidu.tieba.a.a) null);
        TiebaApplication.b().c.sendMessage(TiebaApplication.b().c.obtainMessage(1));
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
                if (TiebaApplication.g()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.b()).backgroundReLogin(TiebaApplication.A(), TiebaApplication.x(), new u(this), new v(this));
                    if (backgroundReLogin != null) {
                        k.b(TiebaApplication.A(), backgroundReLogin);
                        TiebaApplication.f(backgroundReLogin);
                        n = b(i);
                    } else {
                        n = null;
                    }
                } else {
                    com.baidu.tieba.a.a z = TiebaApplication.z();
                    if (z == null) {
                        z = k.l();
                    }
                    if (z == null) {
                        TiebaApplication.b().c.sendMessage(TiebaApplication.b().c.obtainMessage(1));
                        return null;
                    } else if (a(z.b(), z.c(), true) == null) {
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

    public String i() {
        return a(2);
    }

    public String j() {
        return a(3);
    }

    public String b(String str) {
        af.e("NetWork", "uploadImage", "upload image");
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
        return this.a.o();
    }

    public Boolean a(String str, Handler handler) {
        m();
        return this.a.a(str, handler);
    }

    public void d(boolean z) {
        this.c = z;
    }
}
