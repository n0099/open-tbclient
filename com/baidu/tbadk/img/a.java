package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0265a<T>> cxl = null;
    private c cxm = null;
    private a<T>.b cxn = null;
    public T cxo;
    private final f cxp;
    private String wX;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0265a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.wX = null;
        this.wX = str;
        this.cxp = new f(str2);
    }

    public void p(int i, int i2, int i3, int i4) {
        this.cxp.p(i, i2, i3, i4);
    }

    public void fu(boolean z) {
        if (this.cxn == null) {
            this.cxn = new b();
            this.cxn.fv(z);
            this.cxn.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean cxq;

        private b() {
            this.cxq = false;
        }

        protected void fv(boolean z) {
            this.cxq = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return atS();
        }

        private ImageUploadResult atS() {
            a.this.cxp.a(this, null);
            ImageUploadResult T = a.this.cxp.T(a.this.wX, this.cxq);
            publishProgress(100);
            return T;
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
            if (numArr != null && numArr.length != 0 && a.this.cxl != null && a.this.cxl.get() != null) {
                ((InterfaceC0265a) a.this.cxl.get()).d(numArr[0].intValue(), a.this.cxo);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.cxm != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.cxm.a(a.this.wX, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.cxn = null;
            a.this.cxp.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.cxn = null;
            if (a.this.cxm != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.cxm.a(a.this.wX, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0265a<T> interfaceC0265a) {
        this.cxl = new WeakReference<>(interfaceC0265a);
    }

    public void a(c cVar) {
        this.cxm = cVar;
    }

    public void setGroupId(String str) {
        this.cxp.setGroupId(str);
    }

    public T atQ() {
        return this.cxo;
    }

    public void ac(T t) {
        this.cxo = t;
    }

    public void atR() {
        LocalViewSize.ImageSize aiF = LocalViewSize.aiD().aiF();
        LocalViewSize.ImageSize aiG = LocalViewSize.aiD().aiG();
        p(aiG.width, aiG.height, aiF.width, aiF.height);
    }
}
