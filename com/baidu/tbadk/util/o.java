package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.UUID;
/* loaded from: classes.dex */
public class o extends BdAsyncTask<String, String, b> {
    private Activity activity;
    private String cmy;
    private a evd;
    private File eve;
    private boolean evf;
    private int from = 0;
    private String imagePath;
    private String url;

    public o(Activity activity, String str, a aVar) {
        this.activity = activity;
        this.url = str;
        this.evd = aVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public o iw(boolean z) {
        this.evf = z;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: F */
    public b doInBackground(String... strArr) {
        if (TextUtils.isEmpty(this.url)) {
            return new b(false, "url is null");
        }
        if (!bgz()) {
            return new b(false, "make file error");
        }
        if (!this.evf) {
            if (!bgA()) {
                return new b(false, "download error");
            }
        } else if (!bgB()) {
            return new b(false, "decode base64 error");
        }
        return new b(true, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(b bVar) {
        super.onPostExecute(bVar);
        if (bVar == null) {
            if (this.evd != null) {
                this.evd.onError(-2, BdStatsConstant.StatsType.ERROR);
            }
        } else if (!bVar.isSuccess()) {
            if (this.evd != null) {
                this.evd.onError(-1, bVar.getMessage());
            }
        } else {
            bgC();
            if (this.evd != null) {
                this.evd.onSuccess(this.imagePath);
            }
        }
    }

    private boolean bgz() {
        File externalStoragePublicDirectory;
        String lowerCase;
        try {
            if (this.from == 1) {
                com.baidu.tbadk.core.util.m.CheckTempDir(com.baidu.tbadk.core.util.m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
                com.baidu.tbadk.core.util.m.CheckTempDir(com.baidu.tbadk.core.util.m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/temp/");
                com.baidu.tbadk.core.util.m.CheckTempDir(com.baidu.tbadk.core.util.m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/temp/.nomedia/");
                externalStoragePublicDirectory = new File(com.baidu.tbadk.core.util.m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/temp/.nomedia/");
            } else {
                externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            }
            if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                this.cmy = externalStoragePublicDirectory.getAbsolutePath();
                if (!TextUtils.isEmpty(this.cmy) && !this.cmy.endsWith("/")) {
                    this.cmy += "/";
                }
            } else {
                this.cmy = Environment.getExternalStorageDirectory().getPath() + "/tieba/";
            }
            File file = new File(this.cmy);
            if (!file.exists()) {
                file.mkdir();
            }
            if (this.from == 1) {
                lowerCase = "shareDialogTempImg";
            } else {
                lowerCase = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase();
            }
            this.imagePath = this.cmy + lowerCase + yw(this.url);
            this.eve = new File(this.imagePath);
            if (this.eve.exists()) {
                this.eve.delete();
            }
            if (this.eve.exists()) {
                return true;
            }
            this.eve.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean bgA() {
        return m(this.url, this.imagePath, 3);
    }

    private boolean m(String str, String str2, int i) {
        boolean z = false;
        int timeOutAuto = com.baidu.adp.framework.d.b.jJ().jM().getTimeOutAuto();
        int timeOutAuto2 = com.baidu.adp.framework.d.b.jJ().jK().getTimeOutAuto();
        for (int i2 = 0; i2 < i; i2++) {
            try {
                z = a(str, str2, timeOutAuto2, timeOutAuto);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [304=5, 305=4, 306=4] */
    private boolean a(String str, String str2, int i, int i2) throws Exception {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        HttpURLConnection a2;
        FileOutputStream fileOutputStream;
        int responseCode;
        String headerField;
        byte[] bArr;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = a(new URL(str), i, i2);
            try {
                fileOutputStream = new FileOutputStream(yQ(str2), true);
                try {
                    a2.connect();
                    responseCode = a2.getResponseCode();
                    if (responseCode == 302) {
                        String headerField2 = a2.getHeaderField(Headers.LOCATION);
                        com.baidu.adp.lib.f.a.close(a2);
                        try {
                            if (this.eve != null) {
                                this.eve.delete();
                            }
                        } catch (Exception e) {
                        }
                        this.imagePath = this.cmy + (this.from == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase()) + yw(headerField2);
                        this.eve = new File(this.imagePath);
                        if (this.eve.exists()) {
                            this.eve.delete();
                        }
                        if (!this.eve.exists()) {
                            this.eve.createNewFile();
                        }
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(this.eve, true);
                        try {
                            a2 = a(new URL(headerField2), i, i2);
                            a2.connect();
                            fileOutputStream = fileOutputStream3;
                            responseCode = a2.getResponseCode();
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection = a2;
                            inputStream = null;
                            fileOutputStream2 = fileOutputStream3;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = a2;
                    inputStream = null;
                    fileOutputStream2 = fileOutputStream;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = a2;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
        if (responseCode != 200) {
            com.baidu.adp.lib.f.a.close((InputStream) null);
            com.baidu.adp.lib.f.a.close(a2);
            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
            return false;
        }
        try {
            headerField = a2.getHeaderField("Content-Length");
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = a2;
            inputStream = null;
            fileOutputStream2 = fileOutputStream;
        }
        if ((headerField != null ? com.baidu.adp.lib.f.b.toInt(headerField, 0) : 0) == 0) {
            com.baidu.adp.lib.f.a.close((InputStream) null);
            com.baidu.adp.lib.f.a.close(a2);
            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
            return false;
        }
        InputStream inputStream2 = a2.getInputStream();
        try {
            bArr = new byte[1024];
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = a2;
            inputStream = inputStream2;
            fileOutputStream2 = fileOutputStream;
        }
        while (true) {
            int read = inputStream2.read(bArr);
            if (read == -1) {
                try {
                    fileOutputStream.flush();
                    com.baidu.adp.lib.f.a.close(inputStream2);
                    com.baidu.adp.lib.f.a.close(a2);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    return true;
                } catch (Exception e2) {
                    throw new FileNotFoundException();
                }
            }
            try {
                fileOutputStream.write(bArr, 0, read);
            } catch (Exception e3) {
                throw new FileNotFoundException();
            }
            th = th6;
            httpURLConnection = a2;
            inputStream = inputStream2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.adp.lib.f.a.close(inputStream);
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
            throw th;
        }
    }

    private boolean bgB() {
        FileOutputStream fileOutputStream;
        byte[] decode = Base64.decode(this.url.substring(this.url.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SP) + 1, this.url.length()), 0);
        for (int i = 0; i < decode.length; i++) {
            if (decode[i] < 0) {
                decode[i] = (byte) (decode[i] + 256);
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            FileOutputStream fileOutputStream3 = new FileOutputStream(this.eve, true);
            try {
                fileOutputStream3.write(decode);
                fileOutputStream3.flush();
                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream3);
                return true;
            } catch (Exception e) {
                e = e;
                fileOutputStream = fileOutputStream3;
                try {
                    e.printStackTrace();
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream3;
                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private File yQ(String str) {
        com.baidu.adp.lib.util.f.delFile(str);
        return new File(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection a(URL url, int i, int i2) throws SocketException, ProtocolException {
        HttpURLConnection httpURLConnection;
        String curMobileProxyHost;
        HttpURLConnection httpURLConnection2 = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return null;
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && (curMobileProxyHost = com.baidu.adp.lib.util.j.curMobileProxyHost()) != null && curMobileProxyHost.length() > 0) {
            if (com.baidu.adp.lib.util.j.isWap(curMobileProxyHost) && com.baidu.adp.lib.util.j.isSupportWap()) {
                StringBuilder sb = new StringBuilder(80);
                sb.append("http://");
                sb.append(curMobileProxyHost);
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    sb.append("/");
                }
                sb.append(file);
                httpURLConnection2 = (HttpURLConnection) new URL(sb.toString()).openConnection();
            } else {
                httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(curMobileProxyHost, com.baidu.adp.lib.util.j.curMobileProxyPort())));
            }
        }
        if (httpURLConnection2 == null) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection == null) {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i2);
                return httpURLConnection;
            }
            throw new SocketException();
        }
        httpURLConnection = httpURLConnection2;
        if (httpURLConnection == null) {
        }
    }

    private void bgC() {
        if (this.eve != null) {
            TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.eve)));
        }
    }

    private String yw(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        if (str.endsWith(ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX)) {
            return ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX;
        }
        if (str.endsWith(".PNG")) {
            return ".PNG";
        }
        if (str.endsWith(".jpg")) {
            return ".jpg";
        }
        if (str.endsWith(".jpeg")) {
            return ".jpeg";
        }
        if (str.endsWith(".JPEG")) {
            return ".JPEG";
        }
        if (str.endsWith(".gif")) {
            return ".gif";
        }
        if (str.endsWith(".GIF")) {
            return ".GIF";
        }
        String[] split = str.split("\\.");
        if (split != null && split.length > 0) {
            String str2 = split[split.length - 1];
            if (str2.startsWith("png")) {
                return ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX;
            }
            if (str2.startsWith("PNG")) {
                return ".PNG";
            }
            if (str2.startsWith("jpg")) {
                return ".jpg";
            }
            if (str2.startsWith("jpeg")) {
                return ".jpeg";
            }
            if (str2.startsWith("JPEG")) {
                return ".JPEG";
            }
            if (str2.startsWith("gif")) {
                return ".gif";
            }
            if (str2.startsWith("GIF")) {
                return ".GIF";
            }
        }
        return ".jpg";
    }

    /* loaded from: classes.dex */
    public class b {
        private String message;
        private boolean success;

        public b(boolean z, String str) {
            this.success = z;
            this.message = str;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public String getMessage() {
            return this.message;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public void onError(int i, String str) {
        }

        public void onSuccess(String str) {
        }
    }
}
