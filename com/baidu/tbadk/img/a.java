package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.u;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0044a<T>> auF = null;
    private c auG = null;
    private a<T>.b auH = null;
    public T auI;
    private final com.baidu.tbadk.img.c auJ;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0044a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.auJ = new com.baidu.tbadk.img.c(str2);
    }

    public void f(int i, int i2, int i3, int i4) {
        this.auJ.f(i, i2, i3, i4);
    }

    public void bD(boolean z) {
        if (this.auH == null) {
            this.auH = new b(this, null);
            this.auH.bE(z);
            this.auH.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean auK;

        private b() {
            this.auK = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bE(boolean z) {
            this.auK = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public ImageUploadResult doInBackground(String... strArr) {
            return CU();
        }

        private ImageUploadResult CU() {
            a.this.auJ.a(this, null);
            ImageUploadResult s = a.this.auJ.s(a.this.mPath, this.auK);
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.auF != null && a.this.auF.get() != null) {
                ((InterfaceC0044a) a.this.auF.get()).b(numArr[0].intValue(), a.this.auI);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.auG != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(u.j.send_error);
                a.this.auG.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.auH = null;
            a.this.auJ.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.auH = null;
            if (a.this.auG != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m9getInst().getApp().getString(u.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.auG.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0044a<T> interfaceC0044a) {
        this.auF = new WeakReference<>(interfaceC0044a);
    }

    public void a(c cVar) {
        this.auG = cVar;
    }

    public void setGroupId(String str) {
        this.auJ.setGroupId(str);
    }

    public T CS() {
        return this.auI;
    }

    public void y(T t) {
        this.auI = t;
    }

    public void CT() {
        LocalViewSize.ImageSize tt = LocalViewSize.tr().tt();
        LocalViewSize.ImageSize tu = LocalViewSize.tr().tu();
        f(tu.width, tu.height, tt.width, tt.height);
    }
}
