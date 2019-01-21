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
    private WeakReference<InterfaceC0172a<T>> bdj = null;
    private c bdk = null;
    private a<T>.b bdl = null;
    public T bdm;
    private final f bdn;
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
        this.bdn = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.bdn.h(i, i2, i3, i4);
    }

    public void cD(boolean z) {
        if (this.bdl == null) {
            this.bdl = new b();
            this.bdl.cE(z);
            this.bdl.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean bdo;

        private b() {
            this.bdo = false;
        }

        protected void cE(boolean z) {
            this.bdo = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public ImageUploadResult doInBackground(String... strArr) {
            return NU();
        }

        private ImageUploadResult NU() {
            a.this.bdn.a(this, null);
            ImageUploadResult v = a.this.bdn.v(a.this.mPath, this.bdo);
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
            if (numArr != null && numArr.length != 0 && a.this.bdj != null && a.this.bdj.get() != null) {
                ((InterfaceC0172a) a.this.bdj.get()).b(numArr[0].intValue(), a.this.bdm);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.bdk != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                a.this.bdk.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.bdl = null;
            a.this.bdn.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.bdl = null;
            if (a.this.bdk != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(e.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.bdk.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0172a<T> interfaceC0172a) {
        this.bdj = new WeakReference<>(interfaceC0172a);
    }

    public void a(c cVar) {
        this.bdk = cVar;
    }

    public void setGroupId(String str) {
        this.bdn.setGroupId(str);
    }

    public T NS() {
        return this.bdm;
    }

    public void I(T t) {
        this.bdm = t;
    }

    public void NT() {
        LocalViewSize.ImageSize Dr = LocalViewSize.Dp().Dr();
        LocalViewSize.ImageSize Ds = LocalViewSize.Dp().Ds();
        h(Ds.width, Ds.height, Dr.width, Dr.height);
    }
}
