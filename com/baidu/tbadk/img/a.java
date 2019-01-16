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
    private WeakReference<InterfaceC0172a<T>> bdi = null;
    private c bdj = null;
    private a<T>.b bdk = null;
    public T bdl;
    private final f bdm;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0172a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.bdm = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.bdm.h(i, i2, i3, i4);
    }

    public void cD(boolean z) {
        if (this.bdk == null) {
            this.bdk = new b();
            this.bdk.cE(z);
            this.bdk.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean bdn;

        private b() {
            this.bdn = false;
        }

        protected void cE(boolean z) {
            this.bdn = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ImageUploadResult doInBackground(String... strArr) {
            return NU();
        }

        private ImageUploadResult NU() {
            a.this.bdm.a(this, null);
            ImageUploadResult v = a.this.bdm.v(a.this.mPath, this.bdn);
            publishProgress(100);
            return v;
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
            if (numArr != null && numArr.length != 0 && a.this.bdi != null && a.this.bdi.get() != null) {
                ((InterfaceC0172a) a.this.bdi.get()).b(numArr[0].intValue(), a.this.bdl);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.bdj != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                a.this.bdj.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.bdk = null;
            a.this.bdm.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.bdk = null;
            if (a.this.bdj != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.bdj.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0172a<T> interfaceC0172a) {
        this.bdi = new WeakReference<>(interfaceC0172a);
    }

    public void a(c cVar) {
        this.bdj = cVar;
    }

    public void setGroupId(String str) {
        this.bdm.setGroupId(str);
    }

    public T NS() {
        return this.bdl;
    }

    public void I(T t) {
        this.bdl = t;
    }

    public void NT() {
        LocalViewSize.ImageSize Dr = LocalViewSize.Dp().Dr();
        LocalViewSize.ImageSize Ds = LocalViewSize.Dp().Ds();
        h(Ds.width, Ds.height, Dr.width, Dr.height);
    }
}
