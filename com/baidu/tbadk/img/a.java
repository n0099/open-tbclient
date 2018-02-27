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
    private WeakReference<InterfaceC0110a<T>> bwB = null;
    private c bwC = null;
    private a<T>.b bwD = null;
    public T bwE;
    private final f bwF;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0110a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.bwF = new f(str2);
    }

    public void p(int i, int i2, int i3, int i4) {
        this.bwF.p(i, i2, i3, i4);
    }

    public void cp(boolean z) {
        if (this.bwD == null) {
            this.bwD = new b();
            this.bwD.cq(z);
            this.bwD.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean bwG;

        private b() {
            this.bwG = false;
        }

        protected void cq(boolean z) {
            this.bwG = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return ME();
        }

        private ImageUploadResult ME() {
            a.this.bwF.a(this, null);
            ImageUploadResult o = a.this.bwF.o(a.this.mPath, this.bwG);
            publishProgress(100);
            return o;
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
            if (numArr != null && numArr.length != 0 && a.this.bwB != null && a.this.bwB.get() != null) {
                ((InterfaceC0110a) a.this.bwB.get()).d(numArr[0].intValue(), a.this.bwE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.bwC != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.bwC.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.bwD = null;
            a.this.bwF.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.bwD = null;
            if (a.this.bwC != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.bwC.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0110a<T> interfaceC0110a) {
        this.bwB = new WeakReference<>(interfaceC0110a);
    }

    public void a(c cVar) {
        this.bwC = cVar;
    }

    public void setGroupId(String str) {
        this.bwF.setGroupId(str);
    }

    public T MC() {
        return this.bwE;
    }

    public void aF(T t) {
        this.bwE = t;
    }

    public void MD() {
        LocalViewSize.ImageSize Ct = LocalViewSize.Cr().Ct();
        LocalViewSize.ImageSize Cu = LocalViewSize.Cr().Cu();
        p(Cu.width, Cu.height, Ct.width, Ct.height);
    }
}
