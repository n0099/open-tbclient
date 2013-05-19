package com.baidu.tieba.d;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.NotificationProxy;
import com.slidingmenu.lib.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class w {
    private static /* synthetic */ int[] A;
    private static String a = "\r\n";
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = 2097152;
    private static Handler e = null;
    private static volatile String f = null;
    private static volatile boolean g = false;
    private static Pattern h = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    private static ArrayList y = new ArrayList();
    private static AtomicInteger z = new AtomicInteger(0);
    private HttpURLConnection i;
    private String j;
    private int k;
    private int l;
    private String m;
    private int n;
    private ArrayList o;
    private HashMap p;
    private boolean q;
    private Context r;
    private boolean s;
    private boolean t;
    private volatile boolean u;
    private boolean v = true;
    private boolean w = true;
    private int x = 0;

    static /* synthetic */ int[] t() {
        int[] iArr = A;
        if (iArr == null) {
            iArr = new int[z.valuesCustom().length];
            try {
                iArr[z.ThreeG.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[z.TwoG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[z.UNAVAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[z.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            A = iArr;
        }
        return iArr;
    }

    public static int a(int i) {
        return z.getAndSet(i);
    }

    public static int b(int i) {
        return z.addAndGet(i);
    }

    public static synchronized void a(aa aaVar) {
        synchronized (w.class) {
            if (aaVar != null) {
                if (y.size() <= 20) {
                    y.add(aaVar);
                }
            }
        }
    }

    public static synchronized aa a() {
        aa aaVar;
        synchronized (w.class) {
            int size = y.size();
            aaVar = size > 0 ? (aa) y.remove(size - 1) : null;
        }
        return aaVar;
    }

    private int a(z zVar) {
        switch (t()[zVar.ordinal()]) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
    }

    private void u() {
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.o = null;
        this.r = null;
        this.q = true;
        this.n = 0;
        this.u = false;
        this.s = false;
        this.p = null;
        this.t = false;
        this.w = true;
        c();
    }

    public void a(boolean z2) {
        this.w = z2;
    }

    public String b() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.r.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return "3";
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return "2";
                    }
                }
                return "1";
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void c() {
        synchronized (w.class) {
            if (!g) {
                g = true;
                d();
            }
        }
    }

    public static synchronized void d() {
        synchronized (w.class) {
            try {
                Cursor query = TiebaApplication.d().getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("user"));
                    String string2 = query.getString(query.getColumnIndex("password"));
                    query.close();
                    f = "Basic " + ad.b((String.valueOf(string) + ":" + string2).getBytes());
                }
            } catch (Exception e2) {
            }
        }
    }

    public static void e() {
        e = new x();
    }

    public w() {
        u();
        this.r = TiebaApplication.d();
    }

    public w(String str) {
        u();
        this.r = TiebaApplication.d();
        this.j = str;
    }

    public void a(Boolean bool) {
        this.q = bool.booleanValue();
    }

    public static y a(Context context) {
        y yVar;
        y yVar2 = y.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                yVar = y.UNAVAIL;
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                yVar = y.WIFI;
            } else {
                yVar = y.MOBILE;
            }
            return yVar;
        } catch (Exception e2) {
            return yVar2;
        }
    }

    public void a(String str) {
        this.j = str;
    }

    public boolean f() {
        return this.k == 200 && this.l == 0;
    }

    public boolean g() {
        return this.k == 200;
    }

    public int h() {
        return this.l;
    }

    public String i() {
        return this.m;
    }

    public void j() {
        this.m = "";
    }

    public void b(String str) {
        this.m = str;
    }

    public void k() {
        this.u = true;
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e2) {
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00c1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    private HttpURLConnection a(URL url) {
        ?? r0;
        Exception e2;
        String defaultHost;
        HttpURLConnection httpURLConnection = null;
        y a2 = a(this.r);
        this.t = false;
        try {
            if (a2 == y.UNAVAIL) {
                return null;
            }
            if (a2 == y.MOBILE && (defaultHost = Proxy.getDefaultHost()) != null && defaultHost.length() > 0) {
                r0 = d(defaultHost);
                try {
                    if (r0 != 0) {
                        this.t = true;
                        StringBuilder sb = new StringBuilder(80);
                        sb.append(com.baidu.loginshare.e.f);
                        sb.append(Proxy.getDefaultHost());
                        String file = url.getFile();
                        if (file != null && file.startsWith("?")) {
                            sb.append("/");
                        }
                        sb.append(file);
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(sb.toString()).openConnection();
                        httpURLConnection2.setRequestProperty("X-Online-Host", url.getHost());
                        httpURLConnection = httpURLConnection2;
                    } else {
                        HttpURLConnection httpURLConnection3 = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
                        if (f != null) {
                            httpURLConnection3.setRequestProperty("Proxy-Authorization", f);
                        }
                        httpURLConnection = httpURLConnection3;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    ae.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                    return r0;
                }
            }
            if (httpURLConnection == null) {
                try {
                    return (HttpURLConnection) url.openConnection();
                } catch (Exception e4) {
                    r0 = httpURLConnection;
                    e2 = e4;
                    ae.b(getClass().getName(), "getConnect", "error = " + e2.getMessage());
                    return r0;
                }
            }
            return httpURLConnection;
        } catch (Exception e5) {
            r0 = 0;
            e2 = e5;
        }
    }

    private boolean d(String str) {
        if (h.matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [589=8, 590=8, 594=8, 595=8, 597=8] */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015e, code lost:
        if (0 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
        r4.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03c7 A[Catch: Exception -> 0x03e5, TRY_LEAVE, TryCatch #13 {Exception -> 0x03e5, blocks: (B:157:0x03c1, B:159:0x03c7), top: B:205:0x03c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] l() {
        String str;
        InputStream inputStream;
        InputStream inputStream2;
        Exception e2;
        int read;
        byte[] bArr = null;
        try {
            if (this.o == null || this.o.size() <= 0) {
                str = this.j;
            } else {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.j);
                if (this.j.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.j.endsWith("?") && !this.j.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.o.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(((BasicNameValuePair) this.o.get(i)).getName());
                    sb.append("=");
                    sb.append(ad.d(((BasicNameValuePair) this.o.get(i)).getValue()));
                }
                str = sb.toString();
            }
            URL url = new URL(str);
            if (com.baidu.tieba.a.i.r()) {
                ae.e(getClass().getName(), "getNetData", str);
            }
            boolean z2 = true;
            byte[] bArr2 = bArr;
            int i2 = 0;
            while (true) {
                if (this.u || !z2 || i2 >= 10) {
                    break;
                }
                InputStream inputStream3 = null;
                try {
                    this.i = a(url);
                } catch (SocketException e3) {
                } catch (SocketTimeoutException e4) {
                } catch (Exception e5) {
                    inputStream2 = null;
                    e2 = e5;
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                if (this.i == null) {
                    throw new SocketException();
                }
                this.i.setConnectTimeout(5000);
                this.i.setReadTimeout(30000);
                if (this.q && !this.s) {
                    this.i.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.u) {
                    break;
                }
                long time = new Date().getTime();
                this.i.connect();
                this.k = this.i.getResponseCode();
                if (this.k != 200) {
                    throw new SocketException();
                }
                if (!this.i.getContentType().contains("text/vnd.wap.wml")) {
                    String contentEncoding = this.i.getContentEncoding();
                    inputStream = this.i.getInputStream();
                    try {
                        byte[] bArr3 = new byte[NotificationProxy.MAX_URL_LENGTH];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        int i3 = 0;
                        if (this.s) {
                            byte[] bArr4 = new byte[23];
                            int read2 = inputStream.read(bArr4, 0, 23);
                            if (!new String(bArr4, 0, bArr4.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                                byteArrayOutputStream.write(bArr4, 0, read2);
                                i3 = 0 + read2;
                            }
                        }
                        while (!this.u && i3 < d && (read = inputStream.read(bArr3)) != -1) {
                            byteArrayOutputStream.write(bArr3, 0, read);
                            i3 += read;
                        }
                        if (this.u) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e6) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e7) {
                            }
                        } else {
                            this.x = i3;
                            long time2 = new Date().getTime() - time;
                            ae.a(getClass().getName(), "getNetData", "time = " + String.valueOf(time2) + "ms");
                            if (i3 < d) {
                                bArr2 = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                ae.a(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(i3));
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                    q.a(byteArrayInputStream, byteArrayOutputStream2);
                                    bArr2 = byteArrayOutputStream2.toByteArray();
                                }
                            } else {
                                this.k = -1;
                                this.m = this.r.getResources().getString(R.string.data_too_big);
                            }
                            aa aaVar = new aa(this);
                            aaVar.e = a(c(this.r));
                            aaVar.c = this.x;
                            aaVar.b = time2;
                            aaVar.d = i2 + 1;
                            aaVar.a = 2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e8) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e9) {
                            }
                        }
                    } catch (SocketException e10) {
                        inputStream3 = inputStream;
                        try {
                            this.k = 0;
                            z.incrementAndGet();
                            z2 = true;
                            this.m = this.r.getResources().getString(R.string.neterror);
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Exception e11) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e12) {
                            }
                            i2++;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStream3;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e13) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e14) {
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e15) {
                        inputStream3 = inputStream;
                        z.incrementAndGet();
                        this.k = 0;
                        z2 = true;
                        this.m = this.r.getResources().getString(R.string.neterror);
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Exception e16) {
                            }
                        }
                        try {
                            if (this.i != null) {
                                this.i.disconnect();
                            }
                        } catch (Exception e17) {
                        }
                        i2++;
                    } catch (Exception e18) {
                        e2 = e18;
                        inputStream2 = inputStream;
                        try {
                            this.k = 0;
                            z2 = false;
                            this.m = this.r.getResources().getString(R.string.neterror);
                            ae.b(getClass().getName(), "getNetData", "error = " + e2.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e19) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e20) {
                            }
                            i2++;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                            }
                            if (this.i != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (inputStream != null) {
                        }
                        if (this.i != null) {
                        }
                        throw th;
                    }
                } else if (this.n >= 1) {
                    break;
                } else {
                    this.i.disconnect();
                    this.n++;
                    this.k = 0;
                    i2--;
                    if (0 != 0) {
                        try {
                            inputStream3.close();
                        } catch (Exception e21) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e22) {
                    }
                    i2++;
                }
            }
            try {
                if (this.i != null) {
                    this.i.disconnect();
                }
            } catch (Exception e23) {
            }
            this.n = 0;
            return bArr2;
            this.n = 0;
            return bArr2;
        } catch (Exception e24) {
            ae.b(getClass().getName(), "getNetData", e24.getMessage());
            return bArr;
        }
    }

    private String v() {
        int indexOf;
        String str = null;
        if (this.i != null) {
            str = this.i.getContentType();
        }
        if (str == null || (indexOf = str.indexOf("charset")) == -1) {
            return BdUtil.UTF8;
        }
        int indexOf2 = str.indexOf(32, indexOf);
        if (indexOf2 == -1) {
            return str.substring(indexOf + 8);
        }
        return str.substring(indexOf + 8, indexOf2);
    }

    public void c(String str) {
        this.l = -1;
        if (str != null) {
            try {
                com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                oVar.b(str);
                this.l = oVar.a();
                if (this.l == -1) {
                    this.m = this.r.getString(R.string.error_unkown);
                } else if (this.l != 0) {
                    this.m = oVar.b();
                }
            } catch (Exception e2) {
                ae.b("NetWork", "parseServerCode", "error = " + e2.getMessage());
                this.m = this.r.getString(R.string.error_unkown);
            }
        }
    }

    public String m() {
        String str;
        Exception e2;
        byte[] l = l();
        if (this.k != 200) {
            return null;
        }
        try {
            str = new String(l, 0, l.length, v());
            try {
                c(str);
                return str;
            } catch (Exception e3) {
                e2 = e3;
                ae.b(getClass().getName(), "getNetString", "error = " + e2.getMessage());
                return str;
            }
        } catch (Exception e4) {
            str = null;
            e2 = e4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [830=9, 831=9, 835=9, 836=9, 838=9] */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ed, code lost:
        if (0 == 0) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ef, code lost:
        r3.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03f1 A[Catch: Exception -> 0x040f, TRY_LEAVE, TryCatch #12 {Exception -> 0x040f, blocks: (B:153:0x03ed, B:155:0x03f1), top: B:211:0x03ed }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String n() {
        InputStream inputStream;
        Exception exc;
        InputStream inputStream2;
        SocketTimeoutException socketTimeoutException;
        InputStream inputStream3;
        SocketException socketException;
        int read;
        StringBuilder sb = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
        StringBuilder sb2 = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.o == null || i2 >= this.o.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) this.o.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(String.valueOf(name) + "=");
                sb.append(ad.d(value));
                sb2.append(name);
                sb2.append("=");
                sb2.append(value);
            }
            i = i2 + 1;
        }
        if (this.v) {
            sb2.append("tiebaclient!!!");
            String a2 = ad.a(sb2.toString());
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("sign=");
            sb.append(a2);
        }
        String sb3 = sb.toString();
        if (com.baidu.tieba.a.i.r()) {
            ae.e(getClass().getName(), "postNetData", String.valueOf(this.j) + "?" + sb3);
        }
        int i3 = 0;
        boolean z2 = true;
        String str = null;
        while (true) {
            if (this.u || !z2 || i3 >= 10) {
                break;
            }
            InputStream inputStream4 = null;
            try {
                try {
                    this.i = a(new URL(this.j));
                } catch (Throwable th) {
                    th = th;
                    if (inputStream4 != null) {
                        try {
                            inputStream4.close();
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            } catch (SocketException e4) {
                inputStream3 = null;
                socketException = e4;
            } catch (SocketTimeoutException e5) {
                inputStream2 = null;
                socketTimeoutException = e5;
            } catch (Exception e6) {
                inputStream = null;
                exc = e6;
            }
            if (this.i != null) {
                this.i.setConnectTimeout(5000);
                this.i.setReadTimeout(15000);
                this.i.setDoOutput(true);
                this.i.setDoInput(true);
                this.i.setRequestMethod("POST");
                this.i.setRequestProperty("Charset", "UTF-8");
                this.i.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                if (this.q) {
                    this.i.setRequestProperty("Accept-Encoding", "gzip");
                }
                if (this.u) {
                    break;
                }
                long time = new Date().getTime();
                this.i.connect();
                DataOutputStream dataOutputStream = new DataOutputStream(this.i.getOutputStream());
                if (!this.u) {
                    dataOutputStream.writeBytes(sb3);
                }
                dataOutputStream.flush();
                ae.a("NetWork", "postNetData", "Post data.zise = " + String.valueOf(dataOutputStream.size()));
                dataOutputStream.close();
                this.k = this.i.getResponseCode();
                if (this.k != 200) {
                    throw new SocketException();
                }
                if (!this.v || !this.i.getContentType().contains("text/vnd.wap.wml")) {
                    String contentEncoding = this.i.getContentEncoding();
                    InputStream inputStream5 = this.i.getInputStream();
                    try {
                        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        int i4 = 0;
                        while (!this.u && (read = inputStream5.read(bArr)) != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                            i4 += read;
                        }
                        inputStream5.close();
                        this.i.disconnect();
                        if (this.u) {
                            if (inputStream5 != null) {
                                try {
                                    inputStream5.close();
                                } catch (Exception e7) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e8) {
                            }
                        } else {
                            this.x = i4;
                            long time2 = new Date().getTime() - time;
                            ae.a(getClass().getName(), "postNetData", "time = " + String.valueOf(time2) + "ms");
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            ae.a(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                q.a(byteArrayInputStream, byteArrayOutputStream2);
                                byteArray = byteArrayOutputStream2.toByteArray();
                                ae.a(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(byteArray.length));
                            }
                            byte[] bArr2 = byteArray;
                            String str2 = new String(bArr2, 0, bArr2.length, v());
                            try {
                                if (this.v && this.w) {
                                    c(str2);
                                }
                                aa aaVar = new aa(this);
                                aaVar.e = a(c(this.r));
                                aaVar.c = this.x;
                                aaVar.b = time2;
                                aaVar.d = i3 + 1;
                                aaVar.a = 1;
                                a(aaVar);
                                if (inputStream5 != null) {
                                    try {
                                        inputStream5.close();
                                    } catch (Exception e9) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                        str = str2;
                                    } else {
                                        str = str2;
                                    }
                                } catch (Exception e10) {
                                    str = str2;
                                }
                            } catch (SocketException e11) {
                                inputStream3 = inputStream5;
                                socketException = e11;
                                str = str2;
                                z.incrementAndGet();
                                this.k = 0;
                                z2 = true;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                ae.b(getClass().getName(), "postNetData", "SocketException " + socketException.getMessage());
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Exception e12) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e13) {
                                }
                                i3++;
                            } catch (SocketTimeoutException e14) {
                                inputStream2 = inputStream5;
                                socketTimeoutException = e14;
                                str = str2;
                                try {
                                    z.incrementAndGet();
                                    this.k = 0;
                                    z2 = true;
                                    this.m = this.r.getResources().getString(R.string.neterror);
                                    ae.b(getClass().getName(), "postNetData", "SocketTimeoutException " + socketTimeoutException.getMessage());
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e15) {
                                        }
                                    }
                                    try {
                                        if (this.i != null) {
                                            this.i.disconnect();
                                        }
                                    } catch (Exception e16) {
                                    }
                                    i3++;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream4 = inputStream2;
                                    if (inputStream4 != null) {
                                    }
                                    if (this.i != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e17) {
                                inputStream = inputStream5;
                                exc = e17;
                                str = str2;
                                this.k = 0;
                                z2 = false;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                ae.b(getClass().getName(), "postNetData", exc.getMessage());
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e19) {
                                }
                                i3++;
                            }
                        }
                    } catch (SocketException e20) {
                        inputStream3 = inputStream5;
                        socketException = e20;
                    } catch (SocketTimeoutException e21) {
                        inputStream2 = inputStream5;
                        socketTimeoutException = e21;
                    } catch (Exception e22) {
                        inputStream = inputStream5;
                        exc = e22;
                    }
                } else if (this.n < 1) {
                    this.i.disconnect();
                    this.n++;
                    this.k = 0;
                    i3--;
                    if (0 != 0) {
                        try {
                            inputStream4.close();
                        } catch (Exception e23) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e24) {
                    }
                    i3++;
                } else {
                    if (0 != 0) {
                        try {
                            inputStream4.close();
                        } catch (Exception e25) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e26) {
                    }
                }
            } else {
                this.m = this.r.getResources().getString(R.string.neterror);
                break;
            }
        }
        this.n = 0;
        return str;
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e27) {
        }
        this.n = 0;
        return str;
    }

    public int o() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [995=9, 996=9, 998=9, 1000=9, 1001=9, 1003=5, 1005=9, 1006=9, 1008=9, 1009=9, 1010=9] */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (0 == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        r6.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02d9 A[Catch: Exception -> 0x049f, TRY_LEAVE, TryCatch #21 {Exception -> 0x049f, blocks: (B:99:0x02d5, B:101:0x02d9), top: B:292:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x044d A[Catch: Exception -> 0x0494, TRY_LEAVE, TryCatch #32 {Exception -> 0x0494, blocks: (B:178:0x0449, B:180:0x044d), top: B:310:0x0449 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0446 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x02e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x02d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0454 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x018c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0185 A[Catch: Exception -> 0x04d5, TRY_LEAVE, TryCatch #31 {Exception -> 0x04d5, blocks: (B:60:0x0181, B:62:0x0185), top: B:308:0x0181 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0226 A[Catch: Exception -> 0x04bc, TRY_LEAVE, TryCatch #37 {Exception -> 0x04bc, blocks: (B:80:0x0222, B:82:0x0226), top: B:318:0x0222 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String p() {
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Throwable th;
        String str;
        int i;
        Exception exc;
        DataOutputStream dataOutputStream3;
        InputStream inputStream;
        boolean z2;
        byte[] bArr;
        int read;
        String str2 = null;
        boolean z3 = true;
        int i2 = 0;
        while (true) {
            if (this.u || !z3 || i2 >= 10) {
                break;
            }
            InputStream inputStream2 = null;
            dataOutputStream = null;
            try {
                this.i = a(new URL(this.j));
            } catch (SocketException e2) {
                str = str2;
                dataOutputStream3 = null;
                i = i2;
                inputStream = null;
            } catch (SocketTimeoutException e3) {
                dataOutputStream2 = null;
                str = str2;
                i = i2;
            } catch (Exception e4) {
                dataOutputStream2 = null;
                str = str2;
                i = i2;
                exc = e4;
            } catch (Throwable th2) {
                dataOutputStream2 = null;
                th = th2;
            }
            if (this.i == null) {
                this.m = this.r.getResources().getString(R.string.neterror);
                break;
            }
            this.i.setConnectTimeout(5000);
            this.i.setReadTimeout(15000);
            this.i.setDoOutput(true);
            this.i.setDoInput(true);
            this.i.setRequestMethod("POST");
            this.i.setRequestProperty("Charset", "UTF-8");
            this.i.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + c);
            if (this.q) {
                this.i.setRequestProperty("Accept-Encoding", "gzip");
            }
            if (this.u) {
                break;
            }
            long time = new Date().getTime();
            this.i.connect();
            dataOutputStream2 = new DataOutputStream(this.i.getOutputStream());
            for (int i3 = 0; this.o != null && i3 < this.o.size() && !this.u; i3++) {
                try {
                    try {
                        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) this.o.get(i3);
                        if (basicNameValuePair != null) {
                            String name = basicNameValuePair.getName();
                            String value = basicNameValuePair.getValue();
                            dataOutputStream2.writeBytes(String.valueOf(b) + c + a);
                            byte[] bytes = value.getBytes("UTF-8");
                            dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + a);
                            dataOutputStream2.writeBytes(a);
                            dataOutputStream2.write(bytes);
                            dataOutputStream2.writeBytes(a);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (SocketException e5) {
                    i = i2;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    inputStream = null;
                } catch (SocketTimeoutException e6) {
                    i = i2;
                    str = str2;
                } catch (Exception e7) {
                    str = str2;
                    exc = e7;
                    i = i2;
                }
            }
            if (!this.u && this.p != null) {
                for (Map.Entry entry : this.p.entrySet()) {
                    String str3 = (String) entry.getKey();
                    byte[] bArr2 = (byte[]) entry.getValue();
                    if (this.u) {
                        break;
                    } else if (bArr2 != null) {
                        dataOutputStream2.writeBytes(String.valueOf(b) + c + a);
                        dataOutputStream2.writeBytes("Content-Disposition: form-data; name=\"" + str3 + "\"; filename=\"file\"" + a);
                        dataOutputStream2.writeBytes(a);
                        dataOutputStream2.write(bArr2);
                        dataOutputStream2.writeBytes(a);
                    }
                }
            }
            dataOutputStream2.writeBytes(String.valueOf(b) + c + b + a);
            dataOutputStream2.flush();
            ae.a("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(dataOutputStream2.size()));
            dataOutputStream2.close();
            if (e != null) {
                e.sendMessageDelayed(e.obtainMessage(0, this), 45000L);
            }
            this.k = this.i.getResponseCode();
            if (e != null) {
                e.removeMessages(0, this);
            }
            if (this.k != 200) {
                throw new SocketException();
                break;
            } else if (!this.i.getContentType().contains("text/vnd.wap.wml")) {
                String contentEncoding = this.i.getContentEncoding();
                InputStream inputStream3 = this.i.getInputStream();
                try {
                    try {
                        byte[] bArr3 = new byte[NotificationProxy.MAX_URL_LENGTH];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                        while (!this.u && (read = inputStream3.read(bArr3)) != -1) {
                            byteArrayOutputStream.write(bArr3, 0, read);
                        }
                        if (this.u) {
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (Exception e8) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e9) {
                            }
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (Exception e10) {
                                }
                            }
                            if (e != null) {
                                e.removeMessages(0, this);
                            }
                        } else {
                            inputStream3.close();
                            this.i.disconnect();
                            ae.a("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            ae.a("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(byteArray.length));
                            if (contentEncoding == null || !contentEncoding.contains("gzip")) {
                                bArr = byteArray;
                            } else {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                                q.a(byteArrayInputStream, byteArrayOutputStream2);
                                bArr = byteArrayOutputStream2.toByteArray();
                            }
                            String str4 = new String(bArr, 0, bArr.length, v());
                            try {
                                c(str4);
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (Exception e11) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e12) {
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (Exception e13) {
                                    }
                                }
                                if (e != null) {
                                    e.removeMessages(0, this);
                                    str2 = str4;
                                } else {
                                    str2 = str4;
                                }
                            } catch (SocketException e14) {
                                dataOutputStream3 = dataOutputStream2;
                                str = str4;
                                i = i2;
                                inputStream = inputStream3;
                                z2 = true;
                                this.k = 0;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                if (inputStream != null) {
                                }
                                if (this.i != null) {
                                }
                                if (dataOutputStream3 != null) {
                                }
                                if (e == null) {
                                }
                                i2 = i + 1;
                                str2 = str;
                                z3 = z2;
                            } catch (SocketTimeoutException e15) {
                                inputStream2 = inputStream3;
                                str = str4;
                                i = i2;
                                this.k = 0;
                                z2 = true;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                if (inputStream2 != null) {
                                }
                                if (this.i != null) {
                                }
                                if (dataOutputStream2 != null) {
                                }
                                if (e == null) {
                                }
                                i2 = i + 1;
                                str2 = str;
                                z3 = z2;
                            } catch (Exception e16) {
                                exc = e16;
                                inputStream2 = inputStream3;
                                str = str4;
                                i = i2;
                                this.k = 0;
                                z2 = false;
                                this.m = this.r.getResources().getString(R.string.neterror);
                                ae.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                                if (inputStream2 != null) {
                                }
                                if (this.i != null) {
                                }
                                if (dataOutputStream2 != null) {
                                }
                                if (e == null) {
                                }
                                i2 = i + 1;
                                str2 = str;
                                z3 = z2;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream2 = inputStream3;
                        if (inputStream2 != null) {
                        }
                        if (this.i != null) {
                        }
                        if (dataOutputStream2 != null) {
                        }
                        if (e != null) {
                        }
                        throw th;
                    }
                } catch (SocketException e17) {
                    i = i2;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    inputStream = inputStream3;
                } catch (SocketTimeoutException e18) {
                    inputStream2 = inputStream3;
                    i = i2;
                    str = str2;
                } catch (Exception e19) {
                    inputStream2 = inputStream3;
                    str = str2;
                    exc = e19;
                    i = i2;
                }
            } else if (this.n < 1) {
                this.i.disconnect();
                this.n++;
                i = i2 - 1;
                try {
                    this.k = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e20) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e21) {
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e22) {
                        }
                    }
                    if (e != null) {
                        e.removeMessages(0, this);
                        z2 = z3;
                        str = str2;
                    } else {
                        z2 = z3;
                        str = str2;
                    }
                } catch (SocketException e23) {
                    inputStream = null;
                    str = str2;
                    dataOutputStream3 = dataOutputStream2;
                    z2 = true;
                    try {
                        this.k = 0;
                        this.m = this.r.getResources().getString(R.string.neterror);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e24) {
                            }
                        }
                        try {
                            if (this.i != null) {
                                this.i.disconnect();
                            }
                        } catch (Exception e25) {
                        }
                        if (dataOutputStream3 != null) {
                            try {
                                dataOutputStream3.close();
                            } catch (Exception e26) {
                            }
                        }
                        if (e == null) {
                            e.removeMessages(0, this);
                        }
                        i2 = i + 1;
                        str2 = str;
                        z3 = z2;
                    } catch (Throwable th5) {
                        th = th5;
                        dataOutputStream2 = dataOutputStream3;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e27) {
                            }
                        }
                        try {
                            if (this.i != null) {
                                this.i.disconnect();
                            }
                        } catch (Exception e28) {
                        }
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e29) {
                            }
                        }
                        if (e != null) {
                            e.removeMessages(0, this);
                        }
                        throw th;
                    }
                } catch (SocketTimeoutException e30) {
                    str = str2;
                    this.k = 0;
                    z2 = true;
                    this.m = this.r.getResources().getString(R.string.neterror);
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e31) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e32) {
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e33) {
                        }
                    }
                    if (e == null) {
                        e.removeMessages(0, this);
                    }
                    i2 = i + 1;
                    str2 = str;
                    z3 = z2;
                } catch (Exception e34) {
                    str = str2;
                    exc = e34;
                    this.k = 0;
                    z2 = false;
                    this.m = this.r.getResources().getString(R.string.neterror);
                    ae.b("NetWork", "postMultiNetData", "error = " + exc.getMessage());
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e35) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e36) {
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e37) {
                        }
                    }
                    if (e == null) {
                        e.removeMessages(0, this);
                    }
                    i2 = i + 1;
                    str2 = str;
                    z3 = z2;
                }
                i2 = i + 1;
                str2 = str;
                z3 = z2;
            } else {
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e38) {
                    }
                }
                try {
                    if (this.i != null) {
                        this.i.disconnect();
                    }
                } catch (Exception e39) {
                }
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Exception e40) {
                    }
                }
                if (e != null) {
                    e.removeMessages(0, this);
                }
            }
        }
        this.n = 0;
        return str2;
        if (0 != 0) {
            try {
                dataOutputStream.close();
            } catch (Exception e41) {
            }
        }
        if (e != null) {
            e.removeMessages(0, this);
        }
        this.n = 0;
        return str2;
        if (e != null) {
        }
        this.n = 0;
        return str2;
        try {
            if (this.i != null) {
                this.i.disconnect();
            }
        } catch (Exception e42) {
        }
        if (0 != 0) {
        }
        if (e != null) {
        }
        this.n = 0;
        return str2;
    }

    public boolean q() {
        return this.k == 200 || this.k == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1152=7, 1156=7, 1157=7, 1159=7, 1144=7, 1146=7, 1147=7, 1151=7] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035c A[Catch: Exception -> 0x0385, TRY_LEAVE, TryCatch #28 {Exception -> 0x0385, blocks: (B:164:0x0356, B:166:0x035c), top: B:254:0x0356 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0365 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0353 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean a(String str, Handler handler) {
        FileOutputStream fileOutputStream;
        Exception e2;
        InputStream inputStream;
        String headerField;
        int indexOf;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                this.i = a(new URL(this.j));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e3) {
            inputStream = null;
        } catch (Exception e4) {
            fileOutputStream = null;
            e2 = e4;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        if (this.i == null) {
            throw new SocketException();
        }
        this.i.setConnectTimeout(5000);
        this.i.setReadTimeout(30000);
        this.i.setInstanceFollowRedirects(false);
        if (this.u) {
            r1 = false;
            this.n = 0;
            if (0 != 0) {
                try {
                    inputStream2.close();
                } catch (Exception e5) {
                }
            }
            try {
                if (this.i != null) {
                    this.i.disconnect();
                }
            } catch (Exception e6) {
            }
            if (0 != 0) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e7) {
                }
            }
        } else {
            long time = new Date().getTime();
            File f2 = o.f(str);
            if (f2 == null) {
                throw new FileNotFoundException();
            }
            long length = f2.length();
            fileOutputStream = new FileOutputStream(f2, true);
            try {
                if (this.t) {
                    this.i.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-" + String.valueOf(200000 + length));
                } else {
                    this.i.addRequestProperty("Range", "bytes=" + String.valueOf(length) + "-");
                }
                this.i.connect();
                this.k = this.i.getResponseCode();
                if (!q()) {
                    throw new SocketException();
                }
                if (!this.i.getContentType().contains("text/vnd.wap.wml") || this.n >= 1) {
                    this.n = 0;
                    int i = 0;
                    String headerField2 = this.i.getHeaderField("Content-Range");
                    if (headerField2 != null && (indexOf = headerField2.indexOf("/")) != -1) {
                        i = Integer.valueOf(headerField2.substring(indexOf + 1)).intValue();
                    }
                    int intValue = (i == 0 && this.k == 200 && (headerField = this.i.getHeaderField("Content-Length")) != null) ? Integer.valueOf(headerField).intValue() : i;
                    if (length >= intValue) {
                        r1 = true;
                        this.n = 0;
                        if (0 != 0) {
                            try {
                                inputStream2.close();
                            } catch (Exception e8) {
                            }
                        }
                        try {
                            if (this.i != null) {
                                this.i.disconnect();
                            }
                        } catch (Exception e9) {
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e10) {
                            }
                        }
                    } else {
                        InputStream inputStream3 = this.i.getInputStream();
                        try {
                            try {
                                byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                                int i2 = 0;
                                int i3 = intValue > 0 ? intValue / 50 : 0;
                                int i4 = 0;
                                if (handler != null && length > 0) {
                                    handler.sendMessage(handler.obtainMessage(900002, (int) length, intValue));
                                }
                                while (!this.u) {
                                    int read = inputStream3.read(bArr);
                                    if (read != -1) {
                                        try {
                                            fileOutputStream.write(bArr, 0, read);
                                            i2 += read;
                                            i4 += read;
                                            if (handler != null && (i4 > i3 || i2 == intValue)) {
                                                i4 = 0;
                                                handler.sendMessage(handler.obtainMessage(900002, (int) (i2 + length), intValue));
                                            }
                                        } catch (Exception e11) {
                                            throw new FileNotFoundException();
                                        }
                                    }
                                }
                                try {
                                    fileOutputStream.flush();
                                    ae.a("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                                    if (intValue != -1) {
                                        ae.a("NetWork", "downloadFile", "data.zise = " + String.valueOf(intValue));
                                    }
                                    r1 = ((long) i2) + length >= ((long) intValue);
                                    this.n = 0;
                                    if (inputStream3 != null) {
                                        try {
                                            inputStream3.close();
                                        } catch (Exception e12) {
                                        }
                                    }
                                    try {
                                        if (this.i != null) {
                                            this.i.disconnect();
                                        }
                                    } catch (Exception e13) {
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception e14) {
                                        }
                                    }
                                } catch (Exception e15) {
                                    throw new FileNotFoundException();
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream2 = inputStream3;
                                this.n = 0;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e16) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e17) {
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e18) {
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e19) {
                            inputStream = inputStream3;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                this.k = -2;
                                this.m = this.r.getResources().getString(R.string.FileWriteError);
                                this.n = 0;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e20) {
                                    }
                                }
                                try {
                                    if (this.i != null) {
                                        this.i.disconnect();
                                    }
                                } catch (Exception e21) {
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Exception e22) {
                                    }
                                }
                                return r1;
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStream;
                                fileOutputStream = fileOutputStream2;
                                this.n = 0;
                                if (inputStream2 != null) {
                                }
                                if (this.i != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e23) {
                            inputStream2 = inputStream3;
                            e2 = e23;
                            this.k = 0;
                            this.m = this.r.getResources().getString(R.string.neterror);
                            ae.b("NetWork", "downloadFile", "error = " + e2.getMessage());
                            this.n = 0;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e24) {
                                }
                            }
                            try {
                                if (this.i != null) {
                                    this.i.disconnect();
                                }
                            } catch (Exception e25) {
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e26) {
                                }
                            }
                            return r1;
                        }
                    }
                } else {
                    this.i.disconnect();
                    this.n++;
                    this.k = 0;
                    r1 = a(str, handler);
                    this.n = 0;
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e27) {
                        }
                    }
                    try {
                        if (this.i != null) {
                            this.i.disconnect();
                        }
                    } catch (Exception e28) {
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e29) {
                        }
                    }
                }
            } catch (FileNotFoundException e30) {
                fileOutputStream2 = fileOutputStream;
                inputStream = null;
            } catch (Exception e31) {
                e2 = e31;
            }
        }
        return r1;
    }

    public void b(Context context) {
        this.r = context;
    }

    public Context r() {
        return this.r;
    }

    public ArrayList s() {
        return this.o;
    }

    public void a(ArrayList arrayList) {
        if (this.o != null) {
            this.o.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a((BasicNameValuePair) arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void a(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    public void a(String str, byte[] bArr) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        this.p.put(str, bArr);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.o == null) {
                this.o = new ArrayList();
            }
            int a2 = a(this.o, basicNameValuePair.getName());
            int size = this.o.size();
            if (a2 >= 0 && a2 < size) {
                if (basicNameValuePair.getName().equals(((BasicNameValuePair) this.o.get(a2)).getName())) {
                    this.o.set(a2, basicNameValuePair);
                } else {
                    this.o.add(a2, basicNameValuePair);
                }
            } else if (a2 == size) {
                this.o.add(a2, basicNameValuePair);
            }
        }
    }

    private int a(ArrayList arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(((BasicNameValuePair) arrayList.get(i)).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    public void b(boolean z2) {
        this.s = z2;
    }

    public void c(boolean z2) {
        this.v = z2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0069 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tieba.d.z] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static z c(Context context) {
        z zVar;
        ?? e2 = z.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                zVar = z.UNAVAIL;
                try {
                    e2 = "NetWorkCore";
                    ae.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e3) {
                    e2 = e3;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                ae.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                zVar = z.WIFI;
            } else {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        ae.a("NetWorkCore", "NetworkStateInfo", "TwoG");
                        zVar = z.TwoG;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        ae.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        zVar = z.ThreeG;
                        break;
                    default:
                        ae.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        zVar = z.TwoG;
                        break;
                }
            }
            return zVar;
        } catch (Exception e4) {
            return e2;
        }
    }
}
