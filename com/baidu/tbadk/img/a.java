package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0085a<T>> buv = null;
    private c buw = null;
    private a<T>.b bux = null;
    public T buy;
    private final f buz;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0085a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.buz = new f(str2);
    }

    public void p(int i, int i2, int i3, int i4) {
        this.buz.p(i, i2, i3, i4);
    }

    public void ck(boolean z) {
        if (this.bux == null) {
            this.bux = new b();
            this.bux.cl(z);
            this.bux.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean buA;

        private b() {
            this.buA = false;
        }

        protected void cl(boolean z) {
            this.buA = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return LX();
        }

        private ImageUploadResult LX() {
            a.this.buz.a(this, null);
            ImageUploadResult p = a.this.buz.p(a.this.mPath, this.buA);
            publishProgress(100);
            return p;
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
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.buv != null && a.this.buv.get() != null) {
                ((InterfaceC0085a) a.this.buv.get()).d(numArr[0].intValue(), a.this.buy);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.buw != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.buw.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.bux = null;
            a.this.buz.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.bux = null;
            if (a.this.buw != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.buw.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0085a<T> interfaceC0085a) {
        this.buv = new WeakReference<>(interfaceC0085a);
    }

    public void a(c cVar) {
        this.buw = cVar;
    }

    public void setGroupId(String str) {
        this.buz.setGroupId(str);
    }

    public T LV() {
        return this.buy;
    }

    public void aF(T t) {
        this.buy = t;
    }

    public void LW() {
        LocalViewSize.ImageSize Ca = LocalViewSize.BY().Ca();
        LocalViewSize.ImageSize Cb = LocalViewSize.BY().Cb();
        p(Cb.width, Cb.height, Ca.width, Ca.height);
    }
}
