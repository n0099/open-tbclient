package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0053a<T>> axO = null;
    private c axP = null;
    private a<T>.b axQ = null;
    public T axR;
    private final com.baidu.tbadk.img.c axS;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0053a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.axS = new com.baidu.tbadk.img.c(str2);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.axS.f(i, i2, i3, i4);
    }

    public void by(boolean z) {
        if (this.axQ == null) {
            this.axQ = new b(this, null);
            this.axQ.bz(z);
            this.axQ.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean axT;

        private b() {
            this.axT = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bz(boolean z) {
            this.axT = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public ImageUploadResult doInBackground(String... strArr) {
            return ES();
        }

        private ImageUploadResult ES() {
            a.this.axS.a(this, null);
            ImageUploadResult r = a.this.axS.r(a.this.mPath, this.axT);
            publishProgress(100);
            return r;
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.axO != null && a.this.axO.get() != null) {
                ((InterfaceC0053a) a.this.axO.get()).b(numArr[0].intValue(), a.this.axR);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.axP != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.j.send_error);
                a.this.axP.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.axQ = null;
            a.this.axS.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.axQ = null;
            if (a.this.axP != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(t.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.axP.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0053a<T> interfaceC0053a) {
        this.axO = new WeakReference<>(interfaceC0053a);
    }

    public void a(c cVar) {
        this.axP = cVar;
    }

    public void setGroupId(String str) {
        this.axS.setGroupId(str);
    }

    public T EQ() {
        return this.axR;
    }

    public void y(T t) {
        this.axR = t;
    }

    public void ER() {
        LocalViewSize.ImageSize vP = LocalViewSize.vN().vP();
        LocalViewSize.ImageSize vQ = LocalViewSize.vN().vQ();
        f(vQ.width, vQ.height, vP.width, vP.height);
    }
}
