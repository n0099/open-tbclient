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
    private WeakReference<InterfaceC0059a<T>> aES = null;
    private c aET = null;
    private a<T>.b aEU = null;
    public T aEV;
    private final f aEW;
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
        this.aEW = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aEW.h(i, i2, i3, i4);
    }

    public void bM(boolean z) {
        if (this.aEU == null) {
            this.aEU = new b();
            this.aEU.bN(z);
            this.aEU.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aEX;

        private b() {
            this.aEX = false;
        }

        protected void bN(boolean z) {
            this.aEX = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Ec();
        }

        private ImageUploadResult Ec() {
            a.this.aEW.a(this, null);
            ImageUploadResult r = a.this.aEW.r(a.this.mPath, this.aEX);
            publishProgress(100);
            return r;
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
            if (numArr != null && numArr.length != 0 && a.this.aES != null && a.this.aES.get() != null) {
                ((InterfaceC0059a) a.this.aES.get()).b(numArr[0].intValue(), a.this.aEV);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aET != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                a.this.aET.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aEU = null;
            a.this.aEW.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aEU = null;
            if (a.this.aET != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aET.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0059a<T> interfaceC0059a) {
        this.aES = new WeakReference<>(interfaceC0059a);
    }

    public void a(c cVar) {
        this.aET = cVar;
    }

    public void setGroupId(String str) {
        this.aEW.setGroupId(str);
    }

    public T Ea() {
        return this.aEV;
    }

    public void A(T t) {
        this.aEV = t;
    }

    public void Eb() {
        LocalViewSize.ImageSize uB = LocalViewSize.uz().uB();
        LocalViewSize.ImageSize uC = LocalViewSize.uz().uC();
        h(uC.width, uC.height, uB.width, uB.height);
    }
}
