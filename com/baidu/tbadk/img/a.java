package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.y;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<b<T>> akZ = null;
    private d ala = null;
    private a<T>.c alb = null;
    public T alc;
    private final h ald;
    private String mPath;

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.ald = new h(str2);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.ald.e(i, i2, i3, i4);
    }

    public void zv() {
        if (this.alb == null) {
            this.alb = new c(this, null);
            this.alb.execute(new String[0]);
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
        /* renamed from: k */
        public ImageUploadResult doInBackground(String... strArr) {
            return zy();
        }

        private ImageUploadResult zy() {
            a.this.ald.a(this, null);
            ImageUploadResult es = a.this.ald.es(a.this.mPath);
            publishProgress(100);
            return es;
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
            if (numArr != null && numArr.length != 0 && a.this.akZ != null && a.this.akZ.get() != null) {
                ((b) a.this.akZ.get()).a(numArr[0].intValue(), a.this.alc);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.ala != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(y.send_error);
                a.this.ala.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.alb = null;
            a.this.ald.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.alb = null;
            if (a.this.ala != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(y.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.ala.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.akZ = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.ala = dVar;
    }

    public void setGroupId(String str) {
        this.ald.setGroupId(str);
    }

    public T zw() {
        return this.alc;
    }

    public void w(T t) {
        this.alc = t;
    }

    public void zx() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.sj().getMsgSPicMaxSize();
        LocalViewSize.ImageSize sl = LocalViewSize.sj().sl();
        e(sl.width, sl.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
