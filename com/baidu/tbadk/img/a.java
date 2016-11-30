package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.r;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0045a<T>> ayW = null;
    private c ayX = null;
    private a<T>.b ayY = null;
    public T ayZ;
    private final com.baidu.tbadk.img.c aza;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0045a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aza = new com.baidu.tbadk.img.c(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.aza.g(i, i2, i3, i4);
    }

    public void bL(boolean z) {
        if (this.ayY == null) {
            this.ayY = new b(this, null);
            this.ayY.bM(z);
            this.ayY.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean azb;

        private b() {
            this.azb = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bM(boolean z) {
            this.azb = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return Et();
        }

        private ImageUploadResult Et() {
            a.this.aza.a(this, null);
            ImageUploadResult u = a.this.aza.u(a.this.mPath, this.azb);
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
            if (numArr != null && numArr.length != 0 && a.this.ayW != null && a.this.ayW.get() != null) {
                ((InterfaceC0045a) a.this.ayW.get()).b(numArr[0].intValue(), a.this.ayZ);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.ayX != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(r.j.send_error);
                a.this.ayX.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.ayY = null;
            a.this.aza.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.ayY = null;
            if (a.this.ayX != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(r.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.ayX.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0045a<T> interfaceC0045a) {
        this.ayW = new WeakReference<>(interfaceC0045a);
    }

    public void a(c cVar) {
        this.ayX = cVar;
    }

    public void setGroupId(String str) {
        this.aza.setGroupId(str);
    }

    public T Er() {
        return this.ayZ;
    }

    public void B(T t) {
        this.ayZ = t;
    }

    public void Es() {
        LocalViewSize.ImageSize uR = LocalViewSize.uP().uR();
        LocalViewSize.ImageSize uS = LocalViewSize.uP().uS();
        g(uS.width, uS.height, uR.width, uR.height);
    }
}
