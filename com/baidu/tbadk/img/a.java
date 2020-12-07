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
    private final f fyX;
    private int fyY;
    private String mPath;
    public T progessObject;
    private WeakReference<InterfaceC0606a<T>> mUploadProgressCallback = null;
    private c fyV = null;
    private a<T>.b fyW = null;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0606a<T> {
        void onImageProgessInUI(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public void sz(int i) {
        this.fyY = i;
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.fyX = new f(str2);
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.fyX.setServersideResize(i, i2, i3, i4);
    }

    public void loadPic(boolean z) {
        if (this.fyW == null) {
            this.fyW = new b();
            this.fyW.setIsNeedAddWater(z);
            this.fyW.sz(this.fyY);
            this.fyW.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private int fyY;
        private boolean isNeedAddWater;

        private b() {
            this.isNeedAddWater = false;
        }

        public void sz(int i) {
            this.fyY = i;
        }

        protected void setIsNeedAddWater(boolean z) {
            this.isNeedAddWater = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public ImageUploadResult doInBackground(String... strArr) {
            return bDW();
        }

        private ImageUploadResult bDW() {
            a.this.fyX.a(this, null);
            a.this.fyX.sz(this.fyY);
            ImageUploadResult ay = a.this.fyX.ay(a.this.mPath, this.isNeedAddWater);
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
                ((InterfaceC0606a) a.this.mUploadProgressCallback.get()).onImageProgessInUI(numArr[0].intValue(), a.this.progessObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.fyV != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.fyV.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.fyW = null;
            a.this.fyX.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.fyW = null;
            if (a.this.fyV != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(-1002, imageUploadResult.error_msg, "");
                }
                a.this.fyV.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0606a<T> interfaceC0606a) {
        this.mUploadProgressCallback = new WeakReference<>(interfaceC0606a);
    }

    public void a(c cVar) {
        this.fyV = cVar;
    }

    public void setGroupId(String str) {
        this.fyX.setGroupId(str);
    }

    public T getProgessObject() {
        return this.progessObject;
    }

    public void setProgessObject(T t) {
        this.progessObject = t;
    }

    public void setServerResizeForIMImage() {
        LocalViewSize.ImageSize btt = LocalViewSize.bts().btt();
        LocalViewSize.ImageSize btu = LocalViewSize.bts().btu();
        setServersideResize(btu.width, btu.height, btt.width, btt.height);
    }
}
