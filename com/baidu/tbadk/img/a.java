package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<b<T>> ami = null;
    private d amj = null;
    private a<T>.c amk = null;
    public T aml;
    private final h amm;
    private String mPath;

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.amm = new h(str2);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.amm.f(i, i2, i3, i4);
    }

    public void An() {
        if (this.amk == null) {
            this.amk = new c(this, null);
            this.amk.execute(new String[0]);
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
            return Aq();
        }

        private ImageUploadResult Aq() {
            a.this.amm.a(this, null);
            ImageUploadResult eM = a.this.amm.eM(a.this.mPath);
            publishProgress(100);
            return eM;
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
            if (numArr != null && numArr.length != 0 && a.this.ami != null && a.this.ami.get() != null) {
                ((b) a.this.ami.get()).a(numArr[0].intValue(), a.this.aml);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.amj != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.send_error);
                a.this.amj.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.amk = null;
            a.this.amm.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.amk = null;
            if (a.this.amj != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.amj.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.ami = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.amj = dVar;
    }

    public void setGroupId(String str) {
        this.amm.setGroupId(str);
    }

    public T Ao() {
        return this.aml;
    }

    public void w(T t) {
        this.aml = t;
    }

    public void Ap() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.sR().getMsgSPicMaxSize();
        LocalViewSize.ImageSize sT = LocalViewSize.sR().sT();
        f(sT.width, sT.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
