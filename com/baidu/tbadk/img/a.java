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
    public T aPC;
    private final f aPD;
    private String mPath;
    private WeakReference<InterfaceC0116a<T>> aPz = null;
    private c aPA = null;
    private a<T>.b aPB = null;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0116a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aPD = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aPD.h(i, i2, i3, i4);
    }

    public void bL(boolean z) {
        if (this.aPB == null) {
            this.aPB = new b();
            this.aPB.bM(z);
            this.aPB.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aPE;

        private b() {
            this.aPE = false;
        }

        protected void bM(boolean z) {
            this.aPE = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return IL();
        }

        private ImageUploadResult IL() {
            a.this.aPD.a(this, null);
            ImageUploadResult m = a.this.aPD.m(a.this.mPath, this.aPE);
            publishProgress(100);
            return m;
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.aPz != null && a.this.aPz.get() != null) {
                ((InterfaceC0116a) a.this.aPz.get()).b(numArr[0].intValue(), a.this.aPC);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aPA != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                a.this.aPA.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aPB = null;
            a.this.aPD.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aPB = null;
            if (a.this.aPA != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aPA.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0116a<T> interfaceC0116a) {
        this.aPz = new WeakReference<>(interfaceC0116a);
    }

    public void a(c cVar) {
        this.aPA = cVar;
    }

    public void setGroupId(String str) {
        this.aPD.setGroupId(str);
    }

    public T IJ() {
        return this.aPC;
    }

    public void D(T t) {
        this.aPC = t;
    }

    public void IK() {
        LocalViewSize.ImageSize yE = LocalViewSize.yC().yE();
        LocalViewSize.ImageSize yF = LocalViewSize.yC().yF();
        h(yF.width, yF.height, yE.width, yE.height);
    }
}
