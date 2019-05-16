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
    private WeakReference<InterfaceC0254a<T>> cuT = null;
    private c cuU = null;
    private a<T>.b cuV = null;
    public T cuW;
    private final f cuX;
    private String wV;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0254a<T> {
        void d(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public a(String str, String str2) {
        this.wV = null;
        this.wV = str;
        this.cuX = new f(str2);
    }

    public void l(int i, int i2, int i3, int i4) {
        this.cuX.l(i, i2, i3, i4);
    }

    public void fn(boolean z) {
        if (this.cuV == null) {
            this.cuV = new b();
            this.cuV.fo(z);
            this.cuV.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private boolean cuY;

        private b() {
            this.cuY = false;
        }

        protected void fo(boolean z) {
            this.cuY = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public ImageUploadResult doInBackground(String... strArr) {
            return asx();
        }

        private ImageUploadResult asx() {
            a.this.cuX.a(this, null);
            ImageUploadResult R = a.this.cuX.R(a.this.wV, this.cuY);
            publishProgress(100);
            return R;
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
            if (numArr != null && numArr.length != 0 && a.this.cuT != null && a.this.cuT.get() != null) {
                ((InterfaceC0254a) a.this.cuT.get()).d(numArr[0].intValue(), a.this.cuW);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.cuU != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.cuU.a(a.this.wV, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.cuV = null;
            a.this.cuX.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.cuV = null;
            if (a.this.cuU != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_SEND, imageUploadResult.error_msg, "");
                }
                a.this.cuU.a(a.this.wV, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0254a<T> interfaceC0254a) {
        this.cuT = new WeakReference<>(interfaceC0254a);
    }

    public void a(c cVar) {
        this.cuU = cVar;
    }

    public void setGroupId(String str) {
        this.cuX.setGroupId(str);
    }

    public T asv() {
        return this.cuW;
    }

    public void ac(T t) {
        this.cuW = t;
    }

    public void asw() {
        LocalViewSize.ImageSize ahx = LocalViewSize.ahv().ahx();
        LocalViewSize.ImageSize ahy = LocalViewSize.ahv().ahy();
        l(ahy.width, ahy.height, ahx.width, ahx.height);
    }
}
