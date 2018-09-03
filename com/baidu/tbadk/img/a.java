package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.f;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private WeakReference<InterfaceC0114a<T>> aQs = null;
    private c aQt = null;
    private a<T>.b aQu = null;
    public T aQv;
    private final f aQw;
    private String wg;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0114a<T> {
        void b(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.wg = null;
        this.wg = str;
        this.aQw = new f(str2);
    }

    public void g(int i, int i2, int i3, int i4) {
        this.aQw.g(i, i2, i3, i4);
    }

    public void bN(boolean z) {
        if (this.aQu == null) {
            this.aQu = new b();
            this.aQu.bO(z);
            this.aQu.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean aQx;

        private b() {
            this.aQx = false;
        }

        protected void bO(boolean z) {
            this.aQx = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public ImageUploadResult doInBackground(String... strArr) {
            return IY();
        }

        private ImageUploadResult IY() {
            a.this.aQw.a(this, null);
            ImageUploadResult l = a.this.aQw.l(a.this.wg, this.aQx);
            publishProgress(100);
            return l;
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
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            if (numArr != null && numArr.length != 0 && a.this.aQs != null && a.this.aQs.get() != null) {
                ((InterfaceC0114a) a.this.aQs.get()).b(numArr[0].intValue(), a.this.aQv);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.aQt != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(f.j.send_error);
                a.this.aQt.a(a.this.wg, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.aQu = null;
            a.this.aQw.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.aQu = null;
            if (a.this.aQt != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(f.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.aQt.a(a.this.wg, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0114a<T> interfaceC0114a) {
        this.aQs = new WeakReference<>(interfaceC0114a);
    }

    public void a(c cVar) {
        this.aQt = cVar;
    }

    public void setGroupId(String str) {
        this.aQw.setGroupId(str);
    }

    public T IW() {
        return this.aQv;
    }

    public void D(T t) {
        this.aQv = t;
    }

    public void IX() {
        LocalViewSize.ImageSize yH = LocalViewSize.yF().yH();
        LocalViewSize.ImageSize yI = LocalViewSize.yF().yI();
        g(yI.width, yI.height, yH.width, yH.height);
    }
}
