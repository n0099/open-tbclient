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
    private WeakReference<InterfaceC0042a<T>> aCZ = null;
    private c aDa = null;
    private a<T>.b aDb = null;
    public T aDc;
    private final com.baidu.tbadk.img.c aDd;
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
        this.aDd = new com.baidu.tbadk.img.c(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.aDd.g(i, i2, i3, i4);
    }

    public void bM(boolean z) {
        if (this.aDb == null) {
            this.aDb = new b(this, null);
            this.aDb.bN(z);
            this.aDb.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean aDe;

        private b() {
            this.aDe = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bN(boolean z) {
            this.aDe = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return EN();
        }

        private ImageUploadResult EN() {
            a.this.aDd.a(this, null);
            ImageUploadResult u = a.this.aDd.u(a.this.mPath, this.aDe);
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
            if (numArr != null && numArr.length != 0 && a.this.aCZ != null && a.this.aCZ.get() != null) {
                ((InterfaceC0042a) a.this.aCZ.get()).b(numArr[0].intValue(), a.this.aDc);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aDa != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                a.this.aDa.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aDb = null;
            a.this.aDd.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aDb = null;
            if (a.this.aDa != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aDa.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0042a<T> interfaceC0042a) {
        this.aCZ = new WeakReference<>(interfaceC0042a);
    }

    public void a(c cVar) {
        this.aDa = cVar;
    }

    public void setGroupId(String str) {
        this.aDd.setGroupId(str);
    }

    public T EL() {
        return this.aDc;
    }

    public void B(T t) {
        this.aDc = t;
    }

    public void EM() {
        LocalViewSize.ImageSize vr = LocalViewSize.vp().vr();
        LocalViewSize.ImageSize vs = LocalViewSize.vp().vs();
        g(vs.width, vs.height, vr.width, vr.height);
    }
}
