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
    private WeakReference<b<T>> aaZ = null;
    private d aba = null;
    private a<T>.c abb = null;
    public T abc;
    private final h abd;
    private String mPath;

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.abd = new h(str2);
    }

    public void d(int i, int i2, int i3, int i4) {
        this.abd.d(i, i2, i3, i4);
    }

    public void vO() {
        if (this.abb == null) {
            this.abb = new c(this, null);
            this.abb.execute(new String[0]);
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
            return vR();
        }

        private ImageUploadResult vR() {
            a.this.abd.a(this, null);
            ImageUploadResult eo = a.this.abd.eo(a.this.mPath);
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
            if (numArr != null && numArr.length != 0 && a.this.aaZ != null && a.this.aaZ.get() != null) {
                ((b) a.this.aaZ.get()).a(numArr[0].intValue(), a.this.abc);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aba != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_error);
                a.this.aba.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.abb = null;
            a.this.abd.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.abb = null;
            if (a.this.aba != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m255getInst().getApp().getString(z.send_error);
                    TiebaStatic.imgError("", TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aba.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(b<T> bVar) {
        this.aaZ = new WeakReference<>(bVar);
    }

    public void a(d dVar) {
        this.aba = dVar;
    }

    public void setGroupId(String str) {
        this.abd.setGroupId(str);
    }

    public T vP() {
        return this.abc;
    }

    public void v(T t) {
        this.abc = t;
    }

    public void vQ() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.oQ().getMsgSPicMaxSize();
        LocalViewSize.ImageSize oS = LocalViewSize.oQ().oS();
        d(oS.width, oS.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
