package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.d;
import com.baidu.tieba.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0058a<T>> aGt = null;
    private c aGu = null;
    private a<T>.b aGv = null;
    public T aGw;
    private final d aGx;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.aGx = new d(str2);
    }

    public void j(int i, int i2, int i3, int i4) {
        this.aGx.j(i, i2, i3, i4);
    }

    public void bP(boolean z) {
        if (this.aGv == null) {
            this.aGv = new b();
            this.aGv.bQ(z);
            this.aGv.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements d.a {
        private boolean aGy;

        private b() {
            this.aGy = false;
        }

        protected void bQ(boolean z) {
            this.aGy = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return EF();
        }

        private ImageUploadResult EF() {
            a.this.aGx.a(this, null);
            ImageUploadResult s = a.this.aGx.s(a.this.mPath, this.aGy);
            publishProgress(100);
            return s;
        }

        @Override // com.baidu.tbadk.img.d.a
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
            if (numArr != null && numArr.length != 0 && a.this.aGt != null && a.this.aGt.get() != null) {
                ((InterfaceC0058a) a.this.aGt.get()).b(numArr[0].intValue(), a.this.aGw);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aGu != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                a.this.aGu.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aGv = null;
            a.this.aGx.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aGv = null;
            if (a.this.aGu != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.l.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aGu.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0058a<T> interfaceC0058a) {
        this.aGt = new WeakReference<>(interfaceC0058a);
    }

    public void a(c cVar) {
        this.aGu = cVar;
    }

    public void setGroupId(String str) {
        this.aGx.setGroupId(str);
    }

    public T ED() {
        return this.aGw;
    }

    public void B(T t) {
        this.aGw = t;
    }

    public void EE() {
        LocalViewSize.ImageSize vg = LocalViewSize.ve().vg();
        LocalViewSize.ImageSize vh = LocalViewSize.ve().vh();
        j(vh.width, vh.height, vg.width, vg.height);
    }
}
