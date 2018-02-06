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
    private WeakReference<InterfaceC0109a<T>> bwO = null;
    private c bwP = null;
    private a<T>.b bwQ = null;
    public T bwR;
    private final f bwS;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0109a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.bwS = new f(str2);
    }

    public void p(int i, int i2, int i3, int i4) {
        this.bwS.p(i, i2, i3, i4);
    }

    public void cp(boolean z) {
        if (this.bwQ == null) {
            this.bwQ = new b();
            this.bwQ.cq(z);
            this.bwQ.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean bwT;

        private b() {
            this.bwT = false;
        }

        protected void cq(boolean z) {
            this.bwT = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return MF();
        }

        private ImageUploadResult MF() {
            a.this.bwS.a(this, null);
            ImageUploadResult p = a.this.bwS.p(a.this.mPath, this.bwT);
            publishProgress(100);
            return p;
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
            if (numArr != null && numArr.length != 0 && a.this.bwO != null && a.this.bwO.get() != null) {
                ((InterfaceC0109a) a.this.bwO.get()).d(numArr[0].intValue(), a.this.bwR);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.bwP != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.bwP.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.bwQ = null;
            a.this.bwS.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.bwQ = null;
            if (a.this.bwP != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.bwP.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0109a<T> interfaceC0109a) {
        this.bwO = new WeakReference<>(interfaceC0109a);
    }

    public void a(c cVar) {
        this.bwP = cVar;
    }

    public void setGroupId(String str) {
        this.bwS.setGroupId(str);
    }

    public T MD() {
        return this.bwR;
    }

    public void aF(T t) {
        this.bwR = t;
    }

    public void ME() {
        LocalViewSize.ImageSize Cu = LocalViewSize.Cs().Cu();
        LocalViewSize.ImageSize Cv = LocalViewSize.Cs().Cv();
        p(Cv.width, Cv.height, Cu.width, Cu.height);
    }
}
