package com.baidu.tieba.barselect.idCard;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class a extends BdAsyncTask<Void, String, String> {
    private int fxS;
    private com.baidu.tieba.barselect.data.c fxT;
    private String imagePath;

    public a(String str, int i, com.baidu.tieba.barselect.data.c cVar) {
        this.fxS = i;
        this.fxT = cVar;
        this.imagePath = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Void... voidArr) {
        if (this.imagePath == null) {
            return null;
        }
        return zp(this.imagePath);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((a) str);
        if (this.fxT != null && str != null) {
            this.fxT.o("", this.fxS, str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [70=4] */
    public String zp(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        byte[] bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        str2 = Base64.encodeToString(bArr, 0);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return str2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th) {
                    fileInputStream = null;
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
