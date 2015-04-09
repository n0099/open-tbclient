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
    private WeakReference<b<T>> alh = null;
    private d ali = null;
    private a<T>.c alj = null;
    public T alk;
    private final h all;
    private String mPath;

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.all = new h(str2);
    }

    public void e(int i, int i2, int i3, int i4) {
        this.all.e(i, i2, i3, i4);
    }

    public void zB() {
        if (this.alj == null) {
            this.alj = new c(this, null);
            this.alj.execute(new String[0]);
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
            return zE();
        }

        private ImageUploadResult zE() {
            a.this.all.a(this, null);
            ImageUploadResult ev = a.this.all.ev(a.this.mPath);
            publishProgress(100);
            return ev;
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
            if (numArr != null && numArr.length != 0 && a.this.alh != null && a.this.alh.get() != null) {
                ((b) a.this.alh.get()).a(numArr[0].intValue(), a.this.alk);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.ali != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(y.send_error);
                a.this.ali.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.alj = null;
            a.this.all.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.alj = null;
            if (a.this.ali != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(y.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.ali.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.alh = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.ali = dVar;
    }

    public void setGroupId(String str) {
        this.all.setGroupId(str);
    }

    public T zC() {
        return this.alk;
    }

    public void w(T t) {
        this.alk = t;
    }

    public void zD() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.sj().getMsgSPicMaxSize();
        LocalViewSize.ImageSize sl = LocalViewSize.sj().sl();
        e(sl.width, sl.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
