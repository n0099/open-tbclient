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
    private WeakReference<InterfaceC0099a<T>> aHb = null;
    private c aHc = null;
    private a<T>.b aHd = null;
    public T aHe;
    private final f aHf;
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
        this.aHf = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aHf.h(i, i2, i3, i4);
    }

    public void bH(boolean z) {
        if (this.aHd == null) {
            this.aHd = new b();
            this.aHd.bI(z);
            this.aHd.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aHg;

        private b() {
            this.aHg = false;
        }

        protected void bI(boolean z) {
            this.aHg = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Fi();
        }

        private ImageUploadResult Fi() {
            a.this.aHf.a(this, null);
            ImageUploadResult m = a.this.aHf.m(a.this.mPath, this.aHg);
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
            if (numArr != null && numArr.length != 0 && a.this.aHb != null && a.this.aHb.get() != null) {
                ((InterfaceC0099a) a.this.aHb.get()).b(numArr[0].intValue(), a.this.aHe);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aHc != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                a.this.aHc.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aHd = null;
            a.this.aHf.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aHd = null;
            if (a.this.aHc != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.k.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aHc.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0099a<T> interfaceC0099a) {
        this.aHb = new WeakReference<>(interfaceC0099a);
    }

    public void a(c cVar) {
        this.aHc = cVar;
    }

    public void setGroupId(String str) {
        this.aHf.setGroupId(str);
    }

    public T Fg() {
        return this.aHe;
    }

    public void A(T t) {
        this.aHe = t;
    }

    public void Fh() {
        LocalViewSize.ImageSize ve = LocalViewSize.vc().ve();
        LocalViewSize.ImageSize vf = LocalViewSize.vc().vf();
        h(vf.width, vf.height, ve.width, ve.height);
    }
}
