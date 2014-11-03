package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.y;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<b<T>> UV = null;
    private d UW = null;
    private a<T>.c UX = null;
    public T UY;
    private final h UZ;
    private String dM;

    public a(String str, String str2) {
        this.dM = null;
        this.dM = str;
        this.UZ = new h(str2);
    }

    public void b(int i, int i2, int i3, int i4) {
        this.UZ.b(i, i2, i3, i4);
    }

    public void sl() {
        if (this.UX == null) {
            this.UX = new c(this, null);
            this.UX.execute(new String[0]);
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
        /* renamed from: m */
        public ImageUploadResult doInBackground(String... strArr) {
            return so();
        }

        private ImageUploadResult so() {
            a.this.UZ.a(this, null);
            ImageUploadResult du = a.this.UZ.du(a.this.dM);
            publishProgress(100);
            return du;
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.UV != null && a.this.UV.get() != null) {
                ((b) a.this.UV.get()).a(numArr[0].intValue(), a.this.UY);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.UW != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkApplication.m251getInst().getApp().getString(y.send_error);
                a.this.UW.a(a.this.dM, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.UX = null;
            a.this.UZ.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.UX = null;
            if (a.this.UW != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkApplication.m251getInst().getApp().getString(y.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.UW.a(a.this.dM, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.UV = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.UW = dVar;
    }

    public void setGroupId(String str) {
        this.UZ.setGroupId(str);
    }

    public T sm() {
        return this.UY;
    }

    public void q(T t) {
        this.UY = t;
    }

    public void sn() {
        LocalViewSize.ImageSize lX = LocalViewSize.lV().lX();
        LocalViewSize.ImageSize lY = LocalViewSize.lV().lY();
        b(lY.width, lY.height, lX.width, lX.height);
    }
}
