package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0045a<T>> ayB = null;
    private c ayC = null;
    private a<T>.b ayD = null;
    public T ayE;
    private final com.baidu.tbadk.img.c ayF;
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
        this.ayF = new com.baidu.tbadk.img.c(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.ayF.g(i, i2, i3, i4);
    }

    public void bI(boolean z) {
        if (this.ayD == null) {
            this.ayD = new b(this, null);
            this.ayD.bJ(z);
            this.ayD.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean ayG;

        private b() {
            this.ayG = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bJ(boolean z) {
            this.ayG = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return Eo();
        }

        private ImageUploadResult Eo() {
            a.this.ayF.a(this, null);
            ImageUploadResult t = a.this.ayF.t(a.this.mPath, this.ayG);
            publishProgress(100);
            return t;
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
            if (numArr != null && numArr.length != 0 && a.this.ayB != null && a.this.ayB.get() != null) {
                ((InterfaceC0045a) a.this.ayB.get()).b(numArr[0].intValue(), a.this.ayE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.ayC != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(t.j.send_error);
                a.this.ayC.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.ayD = null;
            a.this.ayF.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.ayD = null;
            if (a.this.ayC != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(t.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.ayC.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0045a<T> interfaceC0045a) {
        this.ayB = new WeakReference<>(interfaceC0045a);
    }

    public void a(c cVar) {
        this.ayC = cVar;
    }

    public void setGroupId(String str) {
        this.ayF.setGroupId(str);
    }

    public T Em() {
        return this.ayE;
    }

    public void B(T t) {
        this.ayE = t;
    }

    public void En() {
        LocalViewSize.ImageSize uy = LocalViewSize.uw().uy();
        LocalViewSize.ImageSize uz = LocalViewSize.uw().uz();
        g(uz.width, uz.height, uy.width, uy.height);
    }
}
