package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.e;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0138a<T>> aYj = null;
    private c aYk = null;
    private a<T>.b aYl = null;
    public T aYm;
    private final f aYn;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0138a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aYn = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aYn.h(i, i2, i3, i4);
    }

    public void ci(boolean z) {
        if (this.aYl == null) {
            this.aYl = new b();
            this.aYl.cj(z);
            this.aYl.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aYo;

        private b() {
            this.aYo = false;
        }

        protected void cj(boolean z) {
            this.aYo = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Mm();
        }

        private ImageUploadResult Mm() {
            a.this.aYn.a(this, null);
            ImageUploadResult u = a.this.aYn.u(a.this.mPath, this.aYo);
            publishProgress(100);
            return u;
        }

        @Override // com.baidu.tbadk.img.f.a
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
            if (numArr != null && numArr.length != 0 && a.this.aYj != null && a.this.aYj.get() != null) {
                ((InterfaceC0138a) a.this.aYj.get()).b(numArr[0].intValue(), a.this.aYm);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aYk != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                a.this.aYk.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aYl = null;
            a.this.aYn.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aYl = null;
            if (a.this.aYk != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aYk.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0138a<T> interfaceC0138a) {
        this.aYj = new WeakReference<>(interfaceC0138a);
    }

    public void a(c cVar) {
        this.aYk = cVar;
    }

    public void setGroupId(String str) {
        this.aYn.setGroupId(str);
    }

    public T Mk() {
        return this.aYm;
    }

    public void I(T t) {
        this.aYm = t;
    }

    public void Ml() {
        LocalViewSize.ImageSize BT = LocalViewSize.BR().BT();
        LocalViewSize.ImageSize BU = LocalViewSize.BR().BU();
        h(BU.width, BU.height, BT.width, BT.height);
    }
}
