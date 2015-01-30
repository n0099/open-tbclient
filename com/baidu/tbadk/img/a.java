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
    private WeakReference<b<T>> abB = null;
    private d abC = null;
    private a<T>.c abD = null;
    public T abE;
    private final h abF;
    private String mPath;

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.abF = new h(str2);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.abF.d(i, i2, i3, i4);
    }

    public void wh() {
        if (this.abD == null) {
            this.abD = new c(this, null);
            this.abD.execute(new String[0]);
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
            return wk();
        }

        private ImageUploadResult wk() {
            a.this.abF.a(this, null);
            ImageUploadResult eo = a.this.abF.eo(a.this.mPath);
            publishProgress(100);
            return eo;
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
            if (numArr != null && numArr.length != 0 && a.this.abB != null && a.this.abB.get() != null) {
                ((b) a.this.abB.get()).a(numArr[0].intValue(), a.this.abE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.abC != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_error);
                a.this.abC.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.abD = null;
            a.this.abF.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.abD = null;
            if (a.this.abC != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.abC.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.abB = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.abC = dVar;
    }

    public void setGroupId(String str) {
        this.abF.setGroupId(str);
    }

    public T wi() {
        return this.abE;
    }

    public void v(T t) {
        this.abE = t;
    }

    public void wj() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.oT().getMsgSPicMaxSize();
        LocalViewSize.ImageSize oV = LocalViewSize.oT().oV();
        d(oV.width, oV.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
