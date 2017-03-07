package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.w;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0044a<T>> aCJ = null;
    private c aCK = null;
    private a<T>.b aCL = null;
    public T aCM;
    private final com.baidu.tbadk.img.c aCN;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aCN = new com.baidu.tbadk.img.c(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.aCN.g(i, i2, i3, i4);
    }

    public void bK(boolean z) {
        if (this.aCL == null) {
            this.aCL = new b(this, null);
            this.aCL.bL(z);
            this.aCL.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean aCO;

        private b() {
            this.aCO = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bL(boolean z) {
            this.aCO = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ep();
        }

        private ImageUploadResult Ep() {
            a.this.aCN.a(this, null);
            ImageUploadResult u = a.this.aCN.u(a.this.mPath, this.aCO);
            publishProgress(100);
            return u;
        }

        @Override // com.baidu.tbadk.img.c.a
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
        /* renamed from: a */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.aCJ != null && a.this.aCJ.get() != null) {
                ((InterfaceC0044a) a.this.aCJ.get()).b(numArr[0].intValue(), a.this.aCM);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aCK != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                a.this.aCK.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aCL = null;
            a.this.aCN.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aCL = null;
            if (a.this.aCK != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aCK.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0044a<T> interfaceC0044a) {
        this.aCJ = new WeakReference<>(interfaceC0044a);
    }

    public void a(c cVar) {
        this.aCK = cVar;
    }

    public void setGroupId(String str) {
        this.aCN.setGroupId(str);
    }

    public T En() {
        return this.aCM;
    }

    public void B(T t) {
        this.aCM = t;
    }

    public void Eo() {
        LocalViewSize.ImageSize uU = LocalViewSize.uS().uU();
        LocalViewSize.ImageSize uV = LocalViewSize.uS().uV();
        g(uV.width, uV.height, uU.width, uU.height);
    }
}
