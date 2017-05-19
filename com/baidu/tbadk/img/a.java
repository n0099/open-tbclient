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
    private WeakReference<InterfaceC0046a<T>> aDa = null;
    private c aDb = null;
    private a<T>.b aDc = null;
    public T aDd;
    private final com.baidu.tbadk.img.c aDe;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aDe = new com.baidu.tbadk.img.c(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.aDe.g(i, i2, i3, i4);
    }

    public void bN(boolean z) {
        if (this.aDc == null) {
            this.aDc = new b(this, null);
            this.aDc.bO(z);
            this.aDc.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean aDf;

        private b() {
            this.aDf = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bO(boolean z) {
            this.aDf = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return DR();
        }

        private ImageUploadResult DR() {
            a.this.aDe.a(this, null);
            ImageUploadResult u = a.this.aDe.u(a.this.mPath, this.aDf);
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
            if (numArr != null && numArr.length != 0 && a.this.aDa != null && a.this.aDa.get() != null) {
                ((InterfaceC0046a) a.this.aDa.get()).b(numArr[0].intValue(), a.this.aDd);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aDb != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                a.this.aDb.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aDc = null;
            a.this.aDe.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aDc = null;
            if (a.this.aDb != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(w.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aDb.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0046a<T> interfaceC0046a) {
        this.aDa = new WeakReference<>(interfaceC0046a);
    }

    public void a(c cVar) {
        this.aDb = cVar;
    }

    public void setGroupId(String str) {
        this.aDe.setGroupId(str);
    }

    public T DP() {
        return this.aDd;
    }

    public void B(T t) {
        this.aDd = t;
    }

    public void DQ() {
        LocalViewSize.ImageSize uE = LocalViewSize.uC().uE();
        LocalViewSize.ImageSize uF = LocalViewSize.uC().uF();
        g(uF.width, uF.height, uE.width, uE.height);
    }
}
