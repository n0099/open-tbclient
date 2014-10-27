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
    private WeakReference<b<T>> UR = null;
    private d US = null;
    private a<T>.c UT = null;
    public T UU;
    private final h UV;
    private String dM;

    public a(String str, String str2) {
        this.dM = null;
        this.dM = str;
        this.UV = new h(str2);
    }

    public void b(int i, int i2, int i3, int i4) {
        this.UV.b(i, i2, i3, i4);
    }

    public void sj() {
        if (this.UT == null) {
            this.UT = new c(this, null);
            this.UT.execute(new String[0]);
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
            return sm();
        }

        private ImageUploadResult sm() {
            a.this.UV.a(this, null);
            ImageUploadResult du = a.this.UV.du(a.this.dM);
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
            if (numArr != null && numArr.length != 0 && a.this.UR != null && a.this.UR.get() != null) {
                ((b) a.this.UR.get()).a(numArr[0].intValue(), a.this.UU);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.US != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkApplication.m251getInst().getApp().getString(y.send_error);
                a.this.US.a(a.this.dM, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.UT = null;
            a.this.UV.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.UT = null;
            if (a.this.US != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkApplication.m251getInst().getApp().getString(y.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.US.a(a.this.dM, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.UR = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.US = dVar;
    }

    public void setGroupId(String str) {
        this.UV.setGroupId(str);
    }

    public T sk() {
        return this.UU;
    }

    public void q(T t) {
        this.UU = t;
    }

    public void sl() {
        LocalViewSize.ImageSize lX = LocalViewSize.lV().lX();
        LocalViewSize.ImageSize lY = LocalViewSize.lV().lY();
        b(lY.width, lY.height, lX.width, lX.height);
    }
}
