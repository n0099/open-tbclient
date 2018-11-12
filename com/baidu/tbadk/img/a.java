package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.e;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0162a<T>> aYX = null;
    private c aYY = null;
    private a<T>.b aYZ = null;
    public T aZa;
    private final f aZb;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0162a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aZb = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aZb.h(i, i2, i3, i4);
    }

    public void cz(boolean z) {
        if (this.aYZ == null) {
            this.aYZ = new b();
            this.aYZ.cA(z);
            this.aYZ.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aZc;

        private b() {
            this.aZc = false;
        }

        protected void cA(boolean z) {
            this.aZc = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ImageUploadResult doInBackground(String... strArr) {
            return My();
        }

        private ImageUploadResult My() {
            a.this.aZb.a(this, null);
            ImageUploadResult u = a.this.aZb.u(a.this.mPath, this.aZc);
            publishProgress(100);
            return u;
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
        /* renamed from: c */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.aYX != null && a.this.aYX.get() != null) {
                ((InterfaceC0162a) a.this.aYX.get()).b(numArr[0].intValue(), a.this.aZa);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aYY != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                a.this.aYY.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aYZ = null;
            a.this.aZb.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aYZ = null;
            if (a.this.aYY != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aYY.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0162a<T> interfaceC0162a) {
        this.aYX = new WeakReference<>(interfaceC0162a);
    }

    public void a(c cVar) {
        this.aYY = cVar;
    }

    public void setGroupId(String str) {
        this.aZb.setGroupId(str);
    }

    public T Mw() {
        return this.aZa;
    }

    public void I(T t) {
        this.aZa = t;
    }

    public void Mx() {
        LocalViewSize.ImageSize Ca = LocalViewSize.BY().Ca();
        LocalViewSize.ImageSize Cb = LocalViewSize.BY().Cb();
        h(Cb.width, Cb.height, Ca.width, Ca.height);
    }
}
