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
    private WeakReference<InterfaceC0059a<T>> aFf = null;
    private c aFg = null;
    private a<T>.b aFh = null;
    public T aFi;
    private final f aFj;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a<T> {
        void a(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aFj = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aFj.h(i, i2, i3, i4);
    }

    public void bN(boolean z) {
        if (this.aFh == null) {
            this.aFh = new b();
            this.aFh.bO(z);
            this.aFh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aFk;

        private b() {
            this.aFk = false;
        }

        protected void bO(boolean z) {
            this.aFk = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ei();
        }

        private ImageUploadResult Ei() {
            a.this.aFj.a(this, null);
            ImageUploadResult r = a.this.aFj.r(a.this.mPath, this.aFk);
            publishProgress(100);
            return r;
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
            if (numArr != null && numArr.length != 0 && a.this.aFf != null && a.this.aFf.get() != null) {
                ((InterfaceC0059a) a.this.aFf.get()).a(numArr[0].intValue(), a.this.aFi);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aFg != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                a.this.aFg.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aFh = null;
            a.this.aFj.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aFh = null;
            if (a.this.aFg != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aFg.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0059a<T> interfaceC0059a) {
        this.aFf = new WeakReference<>(interfaceC0059a);
    }

    public void a(c cVar) {
        this.aFg = cVar;
    }

    public void setGroupId(String str) {
        this.aFj.setGroupId(str);
    }

    public T Eg() {
        return this.aFi;
    }

    public void A(T t) {
        this.aFi = t;
    }

    public void Eh() {
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        LocalViewSize.ImageSize uJ = LocalViewSize.uG().uJ();
        h(uJ.width, uJ.height, uI.width, uI.height);
    }
}
