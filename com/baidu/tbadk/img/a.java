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
    private WeakReference<InterfaceC0086a<T>> bum = null;
    private c bun = null;
    private a<T>.b buo = null;
    public T bup;
    private final f buq;
    private String mPath;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0086a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.buq = new f(str2);
    }

    public void p(int i, int i2, int i3, int i4) {
        this.buq.p(i, i2, i3, i4);
    }

    public void cm(boolean z) {
        if (this.buo == null) {
            this.buo = new b();
            this.buo.cn(z);
            this.buo.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean bur;

        private b() {
            this.bur = false;
        }

        protected void cn(boolean z) {
            this.bur = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return Mj();
        }

        private ImageUploadResult Mj() {
            a.this.buq.a(this, null);
            ImageUploadResult p = a.this.buq.p(a.this.mPath, this.bur);
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
            if (numArr != null && numArr.length != 0 && a.this.bum != null && a.this.bum.get() != null) {
                ((InterfaceC0086a) a.this.bum.get()).d(numArr[0].intValue(), a.this.bup);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.bun != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                a.this.bun.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.buo = null;
            a.this.buq.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.buo = null;
            if (a.this.bun != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(d.j.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.bun.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0086a<T> interfaceC0086a) {
        this.bum = new WeakReference<>(interfaceC0086a);
    }

    public void a(c cVar) {
        this.bun = cVar;
    }

    public void setGroupId(String str) {
        this.buq.setGroupId(str);
    }

    public T Mh() {
        return this.bup;
    }

    public void aF(T t) {
        this.bup = t;
    }

    public void Mi() {
        LocalViewSize.ImageSize Ci = LocalViewSize.Cg().Ci();
        LocalViewSize.ImageSize Cj = LocalViewSize.Cg().Cj();
        p(Cj.width, Cj.height, Ci.width, Ci.height);
    }
}
