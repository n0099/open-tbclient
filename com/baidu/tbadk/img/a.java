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
    private WeakReference<InterfaceC0172a<T>> bcv = null;
    private c bcw = null;
    private a<T>.b bcx = null;
    public T bcy;
    private final f bcz;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0172a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.bcz = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.bcz.h(i, i2, i3, i4);
    }

    public void cA(boolean z) {
        if (this.bcx == null) {
            this.bcx = new b();
            this.bcx.cB(z);
            this.bcx.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean bcA;

        private b() {
            this.bcA = false;
        }

        protected void cB(boolean z) {
            this.bcA = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ImageUploadResult doInBackground(String... strArr) {
            return NC();
        }

        private ImageUploadResult NC() {
            a.this.bcz.a(this, null);
            ImageUploadResult v = a.this.bcz.v(a.this.mPath, this.bcA);
            publishProgress(100);
            return v;
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
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.bcv != null && a.this.bcv.get() != null) {
                ((InterfaceC0172a) a.this.bcv.get()).b(numArr[0].intValue(), a.this.bcy);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.bcw != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                a.this.bcw.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.bcx = null;
            a.this.bcz.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.bcx = null;
            if (a.this.bcw != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.bcw.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0172a<T> interfaceC0172a) {
        this.bcv = new WeakReference<>(interfaceC0172a);
    }

    public void a(c cVar) {
        this.bcw = cVar;
    }

    public void setGroupId(String str) {
        this.bcz.setGroupId(str);
    }

    public T NA() {
        return this.bcy;
    }

    public void I(T t) {
        this.bcy = t;
    }

    public void NB() {
        LocalViewSize.ImageSize De = LocalViewSize.Dc().De();
        LocalViewSize.ImageSize Df = LocalViewSize.Dc().Df();
        h(Df.width, Df.height, De.width, De.height);
    }
}
