package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0052a<T>> auM = null;
    private c auN = null;
    private a<T>.b auO = null;
    public T auP;
    private final com.baidu.tbadk.img.c auQ;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0052a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.auQ = new com.baidu.tbadk.img.c(str2);
    }

    public void i(int i, int i2, int i3, int i4) {
        this.auQ.i(i, i2, i3, i4);
    }

    public void br(boolean z) {
        if (this.auO == null) {
            this.auO = new b(this, null);
            this.auO.bs(z);
            this.auO.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean auR;

        private b() {
            this.auR = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bs(boolean z) {
            this.auR = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(String... strArr) {
            return Db();
        }

        private ImageUploadResult Db() {
            a.this.auQ.a(this, null);
            ImageUploadResult s = a.this.auQ.s(a.this.mPath, this.auR);
            publishProgress(100);
            return s;
        }

        @Override // com.baidu.tbadk.img.c.a
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
            if (numArr != null && numArr.length != 0 && a.this.auM != null && a.this.auM.get() != null) {
                ((InterfaceC0052a) a.this.auM.get()).b(numArr[0].intValue(), a.this.auP);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.auN != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(n.i.send_error);
                a.this.auN.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.auO = null;
            a.this.auQ.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.auO = null;
            if (a.this.auN != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(n.i.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.auN.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0052a<T> interfaceC0052a) {
        this.auM = new WeakReference<>(interfaceC0052a);
    }

    public void a(c cVar) {
        this.auN = cVar;
    }

    public void setGroupId(String str) {
        this.auQ.setGroupId(str);
    }

    public T CZ() {
        return this.auP;
    }

    public void y(T t) {
        this.auP = t;
    }

    public void Da() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.uG().getMsgSPicMaxSize();
        LocalViewSize.ImageSize uI = LocalViewSize.uG().uI();
        i(uI.width, uI.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
