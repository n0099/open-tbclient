package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.i;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0050a<T>> atN = null;
    private c atO = null;
    private a<T>.b atP = null;
    public T atQ;
    private final com.baidu.tbadk.img.c atR;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0050a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.atR = new com.baidu.tbadk.img.c(str2);
    }

    public void i(int i, int i2, int i3, int i4) {
        this.atR.i(i, i2, i3, i4);
    }

    public void Cg() {
        if (this.atP == null) {
            this.atP = new b(this, null);
            this.atP.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(String... strArr) {
            return Cj();
        }

        private ImageUploadResult Cj() {
            a.this.atR.a(this, null);
            ImageUploadResult fc = a.this.atR.fc(a.this.mPath);
            publishProgress(100);
            return fc;
        }

        @Override // com.baidu.tbadk.img.c.a
        public void a(String str, Object obj, long j, long j2) {
            int i;
            if (j2 == 0) {
                i = 0;
            } else {
                i = (int) ((((float) j) * 100.0f) / ((float) j2));
                if (i > 100) {
                    i = 90;
                }
            }
            publishProgress(Integer.valueOf(i));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.atN != null && a.this.atN.get() != null) {
                ((InterfaceC0050a) a.this.atN.get()).b(numArr[0].intValue(), a.this.atQ);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.atO != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.send_error);
                a.this.atO.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.atP = null;
            a.this.atR.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.atP = null;
            if (a.this.atO != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.atO.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0050a<T> interfaceC0050a) {
        this.atN = new WeakReference<>(interfaceC0050a);
    }

    public void a(c cVar) {
        this.atO = cVar;
    }

    public void setGroupId(String str) {
        this.atR.setGroupId(str);
    }

    public T Ch() {
        return this.atQ;
    }

    public void x(T t) {
        this.atQ = t;
    }

    public void Ci() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.tY().getMsgSPicMaxSize();
        LocalViewSize.ImageSize ua = LocalViewSize.tY().ua();
        i(ua.width, ua.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
