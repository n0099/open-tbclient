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
    private WeakReference<InterfaceC0059a<T>> aFC = null;
    private c aFD = null;
    private a<T>.b aFE = null;
    public T aFF;
    private final f aFG;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aFG = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aFG.h(i, i2, i3, i4);
    }

    public void bH(boolean z) {
        if (this.aFE == null) {
            this.aFE = new b();
            this.aFE.bI(z);
            this.aFE.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aFH;

        private b() {
            this.aFH = false;
        }

        protected void bI(boolean z) {
            this.aFH = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ep();
        }

        private ImageUploadResult Ep() {
            a.this.aFG.a(this, null);
            ImageUploadResult p = a.this.aFG.p(a.this.mPath, this.aFH);
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
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.aFC != null && a.this.aFC.get() != null) {
                ((InterfaceC0059a) a.this.aFC.get()).b(numArr[0].intValue(), a.this.aFF);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aFD != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.aFD.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aFE = null;
            a.this.aFG.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aFE = null;
            if (a.this.aFD != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aFD.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0059a<T> interfaceC0059a) {
        this.aFC = new WeakReference<>(interfaceC0059a);
    }

    public void a(c cVar) {
        this.aFD = cVar;
    }

    public void setGroupId(String str) {
        this.aFG.setGroupId(str);
    }

    public T En() {
        return this.aFF;
    }

    public void A(T t) {
        this.aFF = t;
    }

    public void Eo() {
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        LocalViewSize.ImageSize uJ = LocalViewSize.uG().uJ();
        h(uJ.width, uJ.height, uI.width, uI.height);
    }
}
