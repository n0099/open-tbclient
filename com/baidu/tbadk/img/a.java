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
    private WeakReference<InterfaceC0052a<T>> awq = null;
    private c awr = null;
    private a<T>.b aws = null;
    public T awt;
    private final com.baidu.tbadk.img.c awu;
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
        this.awu = new com.baidu.tbadk.img.c(str2);
    }

    public void i(int i, int i2, int i3, int i4) {
        this.awu.i(i, i2, i3, i4);
    }

    public void br(boolean z) {
        if (this.aws == null) {
            this.aws = new b(this, null);
            this.aws.bs(z);
            this.aws.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements c.a {
        private boolean awv;

        private b() {
            this.awv = false;
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        protected void bs(boolean z) {
            this.awv = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public ImageUploadResult doInBackground(String... strArr) {
            return CQ();
        }

        private ImageUploadResult CQ() {
            a.this.awu.a(this, null);
            ImageUploadResult s = a.this.awu.s(a.this.mPath, this.awv);
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
            if (numArr != null && numArr.length != 0 && a.this.awq != null && a.this.awq.get() != null) {
                ((InterfaceC0052a) a.this.awq.get()).b(numArr[0].intValue(), a.this.awt);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.awr != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(n.j.send_error);
                a.this.awr.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aws = null;
            a.this.awu.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aws = null;
            if (a.this.awr != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.m411getInst().getApp().getString(n.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.awr.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0052a<T> interfaceC0052a) {
        this.awq = new WeakReference<>(interfaceC0052a);
    }

    public void a(c cVar) {
        this.awr = cVar;
    }

    public void setGroupId(String str) {
        this.awu.setGroupId(str);
    }

    public T CO() {
        return this.awt;
    }

    public void y(T t) {
        this.awt = t;
    }

    public void CP() {
        LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.uq().getMsgSPicMaxSize();
        LocalViewSize.ImageSize us = LocalViewSize.uq().us();
        i(us.width, us.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
    }
}
