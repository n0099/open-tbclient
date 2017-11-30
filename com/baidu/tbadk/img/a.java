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
    private WeakReference<InterfaceC0059a<T>> aGl = null;
    private c aGm = null;
    private a<T>.b aGn = null;
    public T aGo;
    private final f aGp;
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
        this.aGp = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aGp.h(i, i2, i3, i4);
    }

    public void bH(boolean z) {
        if (this.aGn == null) {
            this.aGn = new b();
            this.aGn.bI(z);
            this.aGn.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aGq;

        private b() {
            this.aGq = false;
        }

        protected void bI(boolean z) {
            this.aGq = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return EI();
        }

        private ImageUploadResult EI() {
            a.this.aGp.a(this, null);
            ImageUploadResult p = a.this.aGp.p(a.this.mPath, this.aGq);
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
            if (numArr != null && numArr.length != 0 && a.this.aGl != null && a.this.aGl.get() != null) {
                ((InterfaceC0059a) a.this.aGl.get()).b(numArr[0].intValue(), a.this.aGo);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aGm != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.aGm.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aGn = null;
            a.this.aGp.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aGn = null;
            if (a.this.aGm != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aGm.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0059a<T> interfaceC0059a) {
        this.aGl = new WeakReference<>(interfaceC0059a);
    }

    public void a(c cVar) {
        this.aGm = cVar;
    }

    public void setGroupId(String str) {
        this.aGp.setGroupId(str);
    }

    public T EG() {
        return this.aGo;
    }

    public void A(T t) {
        this.aGo = t;
    }

    public void EH() {
        LocalViewSize.ImageSize uL = LocalViewSize.uJ().uL();
        LocalViewSize.ImageSize uM = LocalViewSize.uJ().uM();
        h(uM.width, uM.height, uL.width, uL.height);
    }
}
