package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0045a<T>> avu = null;
    private c avv = null;
    private a<T>.b avw = null;
    public T avx;
    private final com.baidu.tbadk.img.c avy;
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
        this.avy = new com.baidu.tbadk.img.c(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.avy.g(i, i2, i3, i4);
    }

    public void bG(boolean z) {
        if (this.avw == null) {
            this.avw = new b(this, null);
            this.avw.bH(z);
            this.avw.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean avz;

        private b() {
            this.avz = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bH(boolean z) {
            this.avz = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return CT();
        }

        private ImageUploadResult CT() {
            a.this.avy.a(this, null);
            ImageUploadResult s = a.this.avy.s(a.this.mPath, this.avz);
            publishProgress(100);
            return s;
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
            if (numArr != null && numArr.length != 0 && a.this.avu != null && a.this.avu.get() != null) {
                ((InterfaceC0045a) a.this.avu.get()).b(numArr[0].intValue(), a.this.avx);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.avv != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m10getInst().getApp().getString(u.j.send_error);
                a.this.avv.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.avw = null;
            a.this.avy.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.avw = null;
            if (a.this.avv != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m10getInst().getApp().getString(u.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.avv.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0045a<T> interfaceC0045a) {
        this.avu = new WeakReference<>(interfaceC0045a);
    }

    public void a(c cVar) {
        this.avv = cVar;
    }

    public void setGroupId(String str) {
        this.avy.setGroupId(str);
    }

    public T CR() {
        return this.avx;
    }

    public void B(T t) {
        this.avx = t;
    }

    public void CS() {
        LocalViewSize.ImageSize ts = LocalViewSize.tq().ts();
        LocalViewSize.ImageSize tt = LocalViewSize.tq().tt();
        g(tt.width, tt.height, ts.width, ts.height);
    }
}
