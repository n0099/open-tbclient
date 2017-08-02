package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.d;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0058a<T>> aFd = null;
    private c aFe = null;
    private a<T>.b aFf = null;
    public T aFg;
    private final d aFh;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aFh = new d(str2);
    }

    public void i(int i, int i2, int i3, int i4) {
        this.aFh.i(i, i2, i3, i4);
    }

    public void bP(boolean z) {
        if (this.aFf == null) {
            this.aFf = new b();
            this.aFf.bQ(z);
            this.aFf.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements d.a {
        private boolean aFi;

        private b() {
            this.aFi = false;
        }

        protected void bQ(boolean z) {
            this.aFi = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ex();
        }

        private ImageUploadResult Ex() {
            a.this.aFh.a(this, null);
            ImageUploadResult s = a.this.aFh.s(a.this.mPath, this.aFi);
            publishProgress(100);
            return s;
        }

        @Override // com.baidu.tbadk.img.d.a
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.aFd != null && a.this.aFd.get() != null) {
                ((InterfaceC0058a) a.this.aFd.get()).b(numArr[0].intValue(), a.this.aFg);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aFe != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                a.this.aFe.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aFf = null;
            a.this.aFh.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aFf = null;
            if (a.this.aFe != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aFe.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0058a<T> interfaceC0058a) {
        this.aFd = new WeakReference<>(interfaceC0058a);
    }

    public void a(c cVar) {
        this.aFe = cVar;
    }

    public void setGroupId(String str) {
        this.aFh.setGroupId(str);
    }

    public T Ev() {
        return this.aFg;
    }

    public void B(T t) {
        this.aFg = t;
    }

    public void Ew() {
        LocalViewSize.ImageSize uW = LocalViewSize.uU().uW();
        LocalViewSize.ImageSize uX = LocalViewSize.uU().uX();
        i(uX.width, uX.height, uW.width, uW.height);
    }
}
