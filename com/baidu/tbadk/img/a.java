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
    private WeakReference<InterfaceC0099a<T>> aHc = null;
    private c aHd = null;
    private a<T>.b aHe = null;
    public T aHf;
    private final f aHg;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0099a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aHg = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aHg.h(i, i2, i3, i4);
    }

    public void bH(boolean z) {
        if (this.aHe == null) {
            this.aHe = new b();
            this.aHe.bI(z);
            this.aHe.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aHh;

        private b() {
            this.aHh = false;
        }

        protected void bI(boolean z) {
            this.aHh = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Fg();
        }

        private ImageUploadResult Fg() {
            a.this.aHg.a(this, null);
            ImageUploadResult m = a.this.aHg.m(a.this.mPath, this.aHh);
            publishProgress(100);
            return m;
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
            if (numArr != null && numArr.length != 0 && a.this.aHc != null && a.this.aHc.get() != null) {
                ((InterfaceC0099a) a.this.aHc.get()).b(numArr[0].intValue(), a.this.aHf);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aHd != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                a.this.aHd.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aHe = null;
            a.this.aHg.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aHe = null;
            if (a.this.aHd != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aHd.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0099a<T> interfaceC0099a) {
        this.aHc = new WeakReference<>(interfaceC0099a);
    }

    public void a(c cVar) {
        this.aHd = cVar;
    }

    public void setGroupId(String str) {
        this.aHg.setGroupId(str);
    }

    public T Fe() {
        return this.aHf;
    }

    public void A(T t) {
        this.aHf = t;
    }

    public void Ff() {
        LocalViewSize.ImageSize vd = LocalViewSize.vb().vd();
        LocalViewSize.ImageSize ve = LocalViewSize.vb().ve();
        h(ve.width, ve.height, vd.width, vd.height);
    }
}
