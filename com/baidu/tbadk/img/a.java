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
    private WeakReference<InterfaceC0072a<T>> aGs = null;
    private c aGt = null;
    private a<T>.b aGu = null;
    public T aGv;
    private final f aGw;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aGw = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aGw.h(i, i2, i3, i4);
    }

    public void bI(boolean z) {
        if (this.aGu == null) {
            this.aGu = new b();
            this.aGu.bJ(z);
            this.aGu.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aGx;

        private b() {
            this.aGx = false;
        }

        protected void bJ(boolean z) {
            this.aGx = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return EJ();
        }

        private ImageUploadResult EJ() {
            a.this.aGw.a(this, null);
            ImageUploadResult q = a.this.aGw.q(a.this.mPath, this.aGx);
            publishProgress(100);
            return q;
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
            if (numArr != null && numArr.length != 0 && a.this.aGs != null && a.this.aGs.get() != null) {
                ((InterfaceC0072a) a.this.aGs.get()).b(numArr[0].intValue(), a.this.aGv);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aGt != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.aGt.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aGu = null;
            a.this.aGw.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aGu = null;
            if (a.this.aGt != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aGt.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0072a<T> interfaceC0072a) {
        this.aGs = new WeakReference<>(interfaceC0072a);
    }

    public void a(c cVar) {
        this.aGt = cVar;
    }

    public void setGroupId(String str) {
        this.aGw.setGroupId(str);
    }

    public T EH() {
        return this.aGv;
    }

    public void A(T t) {
        this.aGv = t;
    }

    public void EI() {
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        LocalViewSize.ImageSize uJ = LocalViewSize.uG().uJ();
        h(uJ.width, uJ.height, uI.width, uI.height);
    }
}
