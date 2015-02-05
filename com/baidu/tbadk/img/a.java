package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.z;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    public T abB;
    private final h abC;
    private String mPath;
    private WeakReference<b<T>> aby = null;
    private d abz = null;
    private a<T>.c abA = null;

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.abC = new h(str2);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.abC.d(i, i2, i3, i4);
    }

    public void wb() {
        if (this.abA == null) {
            this.abA = new c(this, null);
            this.abA.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements i {
        private c() {
        }

        /* synthetic */ c(a aVar, c cVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return we();
        }

        private ImageUploadResult we() {
            a.this.abC.a(this, null);
            ImageUploadResult el = a.this.abC.el(a.this.mPath);
            publishProgress(100);
            return el;
        }

        @Override // com.baidu.tbadk.img.i
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
            if (numArr != null && numArr.length != 0 && a.this.aby != null && a.this.aby.get() != null) {
                ((b) a.this.aby.get()).a(numArr[0].intValue(), a.this.abB);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.abz != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_error);
                a.this.abz.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.abA = null;
            a.this.abC.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.abA = null;
            if (a.this.abz != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.abz.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.aby = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.abz = dVar;
    }

    public void setGroupId(String str) {
        this.abC.setGroupId(str);
    }

    public T wc() {
        return this.abB;
    }

    public void v(T t) {
        this.abB = t;
    }

    public void wd() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.oM().getMsgSPicMaxSize();
        LocalViewSize.ImageSize oO = LocalViewSize.oM().oO();
        d(oO.width, oO.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
