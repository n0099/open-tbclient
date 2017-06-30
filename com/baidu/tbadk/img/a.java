package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.e;
import com.baidu.tieba.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0048a<T>> aDY = null;
    private c aDZ = null;
    private a<T>.b aEa = null;
    public T aEb;
    private final e aEc;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aEc = new e(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.aEc.g(i, i2, i3, i4);
    }

    public void bM(boolean z) {
        if (this.aEa == null) {
            this.aEa = new b(this, null);
            this.aEa.bN(z);
            this.aEa.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements e.a {
        private boolean aEd;

        private b() {
            this.aEd = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bN(boolean z) {
            this.aEd = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ei();
        }

        private ImageUploadResult Ei() {
            a.this.aEc.a(this, null);
            ImageUploadResult s = a.this.aEc.s(a.this.mPath, this.aEd);
            publishProgress(100);
            return s;
        }

        @Override // com.baidu.tbadk.img.e.a
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
            if (numArr != null && numArr.length != 0 && a.this.aDY != null && a.this.aDY.get() != null) {
                ((InterfaceC0048a) a.this.aDY.get()).b(numArr[0].intValue(), a.this.aEb);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aDZ != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                a.this.aDZ.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aEa = null;
            a.this.aEc.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aEa = null;
            if (a.this.aDZ != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aDZ.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0048a<T> interfaceC0048a) {
        this.aDY = new WeakReference<>(interfaceC0048a);
    }

    public void a(c cVar) {
        this.aDZ = cVar;
    }

    public void setGroupId(String str) {
        this.aEc.setGroupId(str);
    }

    public T Eg() {
        return this.aEb;
    }

    public void B(T t) {
        this.aEb = t;
    }

    public void Eh() {
        LocalViewSize.ImageSize uQ = LocalViewSize.uO().uQ();
        LocalViewSize.ImageSize uR = LocalViewSize.uO().uR();
        g(uR.width, uR.height, uQ.width, uQ.height);
    }
}
