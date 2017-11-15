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
    private WeakReference<InterfaceC0059a<T>> aFK = null;
    private c aFL = null;
    private a<T>.b aFM = null;
    public T aFN;
    private final f aFO;
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
        this.aFO = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aFO.h(i, i2, i3, i4);
    }

    public void bI(boolean z) {
        if (this.aFM == null) {
            this.aFM = new b();
            this.aFM.bJ(z);
            this.aFM.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aFP;

        private b() {
            this.aFP = false;
        }

        protected void bJ(boolean z) {
            this.aFP = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return EB();
        }

        private ImageUploadResult EB() {
            a.this.aFO.a(this, null);
            ImageUploadResult p = a.this.aFO.p(a.this.mPath, this.aFP);
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
            if (numArr != null && numArr.length != 0 && a.this.aFK != null && a.this.aFK.get() != null) {
                ((InterfaceC0059a) a.this.aFK.get()).b(numArr[0].intValue(), a.this.aFN);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aFL != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.aFL.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aFM = null;
            a.this.aFO.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aFM = null;
            if (a.this.aFL != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aFL.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0059a<T> interfaceC0059a) {
        this.aFK = new WeakReference<>(interfaceC0059a);
    }

    public void a(c cVar) {
        this.aFL = cVar;
    }

    public void setGroupId(String str) {
        this.aFO.setGroupId(str);
    }

    public T Ez() {
        return this.aFN;
    }

    public void A(T t) {
        this.aFN = t;
    }

    public void EA() {
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        LocalViewSize.ImageSize uJ = LocalViewSize.uG().uJ();
        h(uJ.width, uJ.height, uI.width, uI.height);
    }
}
