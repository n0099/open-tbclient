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
    private WeakReference<InterfaceC0073a<T>> aGp = null;
    private c aGq = null;
    private a<T>.b aGr = null;
    public T aGs;
    private final f aGt;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aGt = new f(str2);
    }

    public void h(int i, int i2, int i3, int i4) {
        this.aGt.h(i, i2, i3, i4);
    }

    public void bI(boolean z) {
        if (this.aGr == null) {
            this.aGr = new b();
            this.aGr.bJ(z);
            this.aGr.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aGu;

        private b() {
            this.aGu = false;
        }

        protected void bJ(boolean z) {
            this.aGu = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return EJ();
        }

        private ImageUploadResult EJ() {
            a.this.aGt.a(this, null);
            ImageUploadResult q = a.this.aGt.q(a.this.mPath, this.aGu);
            publishProgress(100);
            return q;
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
            if (numArr != null && numArr.length != 0 && a.this.aGp != null && a.this.aGp.get() != null) {
                ((InterfaceC0073a) a.this.aGp.get()).b(numArr[0].intValue(), a.this.aGs);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aGq != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.aGq.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aGr = null;
            a.this.aGt.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aGr = null;
            if (a.this.aGq != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aGq.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0073a<T> interfaceC0073a) {
        this.aGp = new WeakReference<>(interfaceC0073a);
    }

    public void a(c cVar) {
        this.aGq = cVar;
    }

    public void setGroupId(String str) {
        this.aGt.setGroupId(str);
    }

    public T EH() {
        return this.aGs;
    }

    public void A(T t) {
        this.aGs = t;
    }

    public void EI() {
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        LocalViewSize.ImageSize uJ = LocalViewSize.uG().uJ();
        h(uJ.width, uJ.height, uI.width, uI.height);
    }
}
