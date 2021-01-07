package com.baidu.tbadk.img;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a<T> {
    private final f fIC;
    private int fID;
    private String mPath;
    public T progessObject;
    private WeakReference<InterfaceC0597a<T>> mUploadProgressCallback = null;
    private c fIA = null;
    private a<T>.b fIB = null;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0597a<T> {
        void onImageProgessInUI(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public void sL(int i) {
        this.fID = i;
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.fIC = new f(str2);
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.fIC.setServersideResize(i, i2, i3, i4);
    }

    public void loadPic(boolean z) {
        if (this.fIB == null) {
            this.fIB = new b();
            this.fIB.setIsNeedAddWater(z);
            this.fIB.sL(this.fID);
            this.fIB.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private int fID;
        private boolean isNeedAddWater;

        private b() {
            this.isNeedAddWater = false;
        }

        public void sL(int i) {
            this.fID = i;
        }

        protected void setIsNeedAddWater(boolean z) {
            this.isNeedAddWater = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: P */
        public ImageUploadResult doInBackground(String... strArr) {
            return bGr();
        }

        private ImageUploadResult bGr() {
            a.this.fIC.a(this, (Object) null);
            a.this.fIC.sL(this.fID);
            ImageUploadResult ay = a.this.fIC.ay(a.this.mPath, this.isNeedAddWater);
            publishProgress(100);
            return ay;
        }

        @Override // com.baidu.tbadk.img.f.a
        public void onImageDataSentInBackground(String str, Object obj, long j, long j2) {
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
            if (numArr != null && numArr.length != 0 && a.this.mUploadProgressCallback != null && a.this.mUploadProgressCallback.get() != null) {
                ((InterfaceC0597a) a.this.mUploadProgressCallback.get()).onImageProgessInUI(numArr[0].intValue(), a.this.progessObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.fIA != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.fIA.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.fIB = null;
            a.this.fIC.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.fIB = null;
            if (a.this.fIA != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(-1002, imageUploadResult.error_msg, "");
                }
                a.this.fIA.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0597a<T> interfaceC0597a) {
        this.mUploadProgressCallback = new WeakReference<>(interfaceC0597a);
    }

    public void a(c cVar) {
        this.fIA = cVar;
    }

    public void setGroupId(String str) {
        this.fIC.setGroupId(str);
    }

    public T getProgessObject() {
        return this.progessObject;
    }

    public void setProgessObject(T t) {
        this.progessObject = t;
    }

    public void setServerResizeForIMImage() {
        LocalViewSize.ImageSize bvP = LocalViewSize.bvO().bvP();
        LocalViewSize.ImageSize bvQ = LocalViewSize.bvO().bvQ();
        setServersideResize(bvQ.width, bvQ.height, bvP.width, bvP.height);
    }
}
