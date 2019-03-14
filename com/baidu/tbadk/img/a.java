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
    private WeakReference<InterfaceC0239a<T>> cmI = null;
    private c cmJ = null;
    private a<T>.b cmK = null;
    public T cmL;
    private final f cmM;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0239a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.cmM = new f(str2);
    }

    public void l(int i, int i2, int i3, int i4) {
        this.cmM.l(i, i2, i3, i4);
    }

    public void eR(boolean z) {
        if (this.cmK == null) {
            this.cmK = new b();
            this.cmK.eS(z);
            this.cmK.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean cmN;

        private b() {
            this.cmN = false;
        }

        protected void eS(boolean z) {
            this.cmN = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return anx();
        }

        private ImageUploadResult anx() {
            a.this.cmM.a(this, null);
            ImageUploadResult P = a.this.cmM.P(a.this.mPath, this.cmN);
            publishProgress(100);
            return P;
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
            if (numArr != null && numArr.length != 0 && a.this.cmI != null && a.this.cmI.get() != null) {
                ((InterfaceC0239a) a.this.cmI.get()).d(numArr[0].intValue(), a.this.cmL);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.cmJ != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.cmJ.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.cmK = null;
            a.this.cmM.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.cmK = null;
            if (a.this.cmJ != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.cmJ.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0239a<T> interfaceC0239a) {
        this.cmI = new WeakReference<>(interfaceC0239a);
    }

    public void a(c cVar) {
        this.cmJ = cVar;
    }

    public void setGroupId(String str) {
        this.cmM.setGroupId(str);
    }

    public T anv() {
        return this.cmL;
    }

    public void ac(T t) {
        this.cmL = t;
    }

    public void anw() {
        LocalViewSize.ImageSize acC = LocalViewSize.acA().acC();
        LocalViewSize.ImageSize acD = LocalViewSize.acA().acD();
        l(acD.width, acD.height, acC.width, acC.height);
    }
}
