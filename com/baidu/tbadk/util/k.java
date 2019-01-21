package com.baidu.tbadk.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, String, b> {
    private Activity activity;
    private a bji;
    private String bjj;
    private File bjk;
    private int from = 0;
    private String imagePath;
    private String url;

    public k(Activity activity, String str, a aVar) {
        this.activity = activity;
        this.url = str;
        this.bji = aVar;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public b doInBackground(String... strArr) {
        if (TextUtils.isEmpty(this.url)) {
            return new b(false, "url is null");
        }
        if (!Qn()) {
            return new b(false, "make file error");
        }
        if (!Qo()) {
            return new b(false, "download error");
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
            if (this.bji != null) {
                this.bji.onError(-2, AiAppsTouchHelper.TouchEventName.TOUCH_ERROR);
            }
        } else if (!bVar.isSuccess()) {
            if (this.bji != null) {
                this.bji.onError(-1, bVar.getMessage());
            }
        } else {
            Qp();
            if (this.bji != null) {
                this.bji.onSuccess(this.imagePath);
            }
        }
    }

    private boolean Qn() {
        File externalStoragePublicDirectory;
        String lowerCase;
        try {
            if (this.from == 1) {
                com.baidu.tbadk.core.util.l.fa(com.baidu.tbadk.core.util.l.FL + "/" + TbConfig.getTempDirName() + "/");
                com.baidu.tbadk.core.util.l.fa(com.baidu.tbadk.core.util.l.FL + "/" + TbConfig.getTempDirName() + "/temp/");
                com.baidu.tbadk.core.util.l.fa(com.baidu.tbadk.core.util.l.FL + "/" + TbConfig.getTempDirName() + "/temp/.nomedia/");
                externalStoragePublicDirectory = new File(com.baidu.tbadk.core.util.l.FL + "/" + TbConfig.getTempDirName() + "/temp/.nomedia/");
            } else {
                externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            }
            if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.exists()) {
                this.bjj = externalStoragePublicDirectory.getAbsolutePath();
                if (!TextUtils.isEmpty(this.bjj) && !this.bjj.endsWith("/")) {
                    this.bjj += "/";
                }
            } else {
                this.bjj = Environment.getExternalStorageDirectory().getPath() + "/tieba/";
            }
            File file = new File(this.bjj);
            if (!file.exists()) {
                file.mkdir();
            }
            if (this.from == 1) {
                lowerCase = "shareDialogTempImg";
            } else {
                lowerCase = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase();
            }
            this.imagePath = this.bjj + lowerCase + iT(this.url);
            this.bjk = new File(this.imagePath);
            if (this.bjk.exists()) {
                this.bjk.delete();
            }
            if (this.bjk.exists()) {
                return true;
            }
            this.bjk.createNewFile();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean Qo() {
        return f(this.url, this.imagePath, 3);
    }

    private boolean f(String str, String str2, int i) {
        boolean z = false;
        int hr = com.baidu.adp.framework.c.b.hn().hq().hr();
        int hr2 = com.baidu.adp.framework.c.b.hn().ho().hr();
        for (int i2 = 0; i2 < i; i2++) {
            try {
                z = c(str, str2, hr2, hr);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [291=5, 292=4, 293=4] */
    private boolean c(String str, String str2, int i, int i2) throws Exception {
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
                fileOutputStream = new FileOutputStream(iS(str2), true);
                try {
                    a2.connect();
                    responseCode = a2.getResponseCode();
                    if (responseCode == 302) {
                        String headerField2 = a2.getHeaderField("Location");
                        com.baidu.adp.lib.g.a.h(a2);
                        try {
                            if (this.bjk != null) {
                                this.bjk.delete();
                            }
                        } catch (Exception e) {
                        }
                        this.imagePath = this.bjj + (this.from == 1 ? "shareDialogTempImg" : UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase()) + iT(headerField2);
                        this.bjk = new File(this.imagePath);
                        if (this.bjk.exists()) {
                            this.bjk.delete();
                        }
                        if (!this.bjk.exists()) {
                            this.bjk.createNewFile();
                        }
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(this.bjk, true);
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
            com.baidu.adp.lib.g.a.h((InputStream) null);
            com.baidu.adp.lib.g.a.h(a2);
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
            return false;
        }
        try {
            headerField = a2.getHeaderField(HTTP.CONTENT_LEN);
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = a2;
            inputStream = null;
            fileOutputStream2 = fileOutputStream;
        }
        if ((headerField != null ? com.baidu.adp.lib.g.b.l(headerField, 0) : 0) == 0) {
            com.baidu.adp.lib.g.a.h((InputStream) null);
            com.baidu.adp.lib.g.a.h(a2);
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
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
                    com.baidu.adp.lib.g.a.h(inputStream2);
                    com.baidu.adp.lib.g.a.h(a2);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
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
            com.baidu.adp.lib.g.a.h(inputStream);
            com.baidu.adp.lib.g.a.h(httpURLConnection);
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            throw th;
        }
    }

    private File iS(String str) {
        com.baidu.adp.lib.util.f.bo(str);
        return new File(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection a(URL url, int i, int i2) throws SocketException, ProtocolException {
        HttpURLConnection httpURLConnection;
        String le;
        HttpURLConnection httpURLConnection2 = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!com.baidu.adp.lib.util.j.kV()) {
            return null;
        }
        if (com.baidu.adp.lib.util.j.kX() && (le = com.baidu.adp.lib.util.j.le()) != null && le.length() > 0) {
            if (com.baidu.adp.lib.util.j.bu(le) && com.baidu.adp.lib.util.j.lg()) {
                StringBuilder sb = new StringBuilder(80);
                sb.append("http://");
                sb.append(le);
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    sb.append("/");
                }
                sb.append(file);
                httpURLConnection2 = (HttpURLConnection) new URL(sb.toString()).openConnection();
            } else {
                httpURLConnection2 = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(le, com.baidu.adp.lib.util.j.lf())));
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

    private void Qp() {
        if (this.bjk != null) {
            TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.bjk)));
        }
    }

    private String iT(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".jpg";
        }
        if (str.endsWith(".png")) {
            return ".png";
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
            if (str2.startsWith(CanvasToTempFileModel.IMAGE_EXT_PNG)) {
                return ".png";
            }
            if (str2.startsWith("PNG")) {
                return ".PNG";
            }
            if (str2.startsWith(CanvasToTempFileModel.IMAGE_EXT_JPG)) {
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
