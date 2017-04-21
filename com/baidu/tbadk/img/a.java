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
    private WeakReference<InterfaceC0042a<T>> aDb = null;
    private c aDc = null;
    private a<T>.b aDd = null;
    public T aDe;
    private final com.baidu.tbadk.img.c aDf;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0042a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aDf = new com.baidu.tbadk.img.c(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.aDf.g(i, i2, i3, i4);
    }

    public void bM(boolean z) {
        if (this.aDd == null) {
            this.aDd = new b(this, null);
            this.aDd.bN(z);
            this.aDd.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean aDg;

        private b() {
            this.aDg = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bN(boolean z) {
            this.aDg = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return EN();
        }

        private ImageUploadResult EN() {
            a.this.aDf.a(this, null);
            ImageUploadResult u = a.this.aDf.u(a.this.mPath, this.aDg);
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.aDb != null && a.this.aDb.get() != null) {
                ((InterfaceC0042a) a.this.aDb.get()).b(numArr[0].intValue(), a.this.aDe);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aDc != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                a.this.aDc.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aDd = null;
            a.this.aDf.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aDd = null;
            if (a.this.aDc != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aDc.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0042a<T> interfaceC0042a) {
        this.aDb = new WeakReference<>(interfaceC0042a);
    }

    public void a(c cVar) {
        this.aDc = cVar;
    }

    public void setGroupId(String str) {
        this.aDf.setGroupId(str);
    }

    public T EL() {
        return this.aDe;
    }

    public void B(T t) {
        this.aDe = t;
    }

    public void EM() {
        LocalViewSize.ImageSize vr = LocalViewSize.vp().vr();
        LocalViewSize.ImageSize vs = LocalViewSize.vp().vs();
        g(vs.width, vs.height, vr.width, vr.height);
    }
}
