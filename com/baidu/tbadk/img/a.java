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
    private final f fri;
    private int frj;
    private String mPath;
    public T progessObject;
    private WeakReference<InterfaceC0593a<T>> mUploadProgressCallback = null;
    private c frg = null;
    private a<T>.b frh = null;

    /* renamed from: com.baidu.tbadk.img.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0593a<T> {
        void onImageProgessInUI(int i, T t);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public void rY(int i) {
        this.frj = i;
    }

    public a(String str, String str2) {
        this.mPath = null;
        this.mPath = str;
        this.fri = new f(str2);
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.fri.setServersideResize(i, i2, i3, i4);
    }

    public void loadPic(boolean z) {
        if (this.frh == null) {
            this.frh = new b();
            this.frh.setIsNeedAddWater(z);
            this.frh.rY(this.frj);
            this.frh.execute(new String[0]);
        }
    }

    /* loaded from: classes.dex */
    private class b extends BdAsyncTask<String, Integer, ImageUploadResult> implements f.a {
        private int frj;
        private boolean isNeedAddWater;

        private b() {
            this.isNeedAddWater = false;
        }

        public void rY(int i) {
            this.frj = i;
        }

        protected void setIsNeedAddWater(boolean z) {
            this.isNeedAddWater = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public ImageUploadResult doInBackground(String... strArr) {
            return bAu();
        }

        private ImageUploadResult bAu() {
            a.this.fri.a(this, null);
            a.this.fri.rY(this.frj);
            ImageUploadResult ax = a.this.fri.ax(a.this.mPath, this.isNeedAddWater);
            publishProgress(100);
            return ax;
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
                ((InterfaceC0593a) a.this.mUploadProgressCallback.get()).onImageProgessInUI(numArr[0].intValue(), a.this.progessObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            super.onPreCancel();
            if (a.this.frg != null) {
                ImageUploadResult imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                a.this.frg.a(a.this.mPath, imageUploadResult);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            a.this.frh = null;
            a.this.fri.cancel();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            super.onPostExecute(imageUploadResult);
            a.this.frh = null;
            if (a.this.frg != null) {
                if (imageUploadResult == null) {
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_error);
                    TiebaStatic.imgError(-1002, imageUploadResult.error_msg, "");
                }
                a.this.frg.a(a.this.mPath, imageUploadResult);
            }
        }
    }

    public void a(InterfaceC0593a<T> interfaceC0593a) {
        this.mUploadProgressCallback = new WeakReference<>(interfaceC0593a);
    }

    public void a(c cVar) {
        this.frg = cVar;
    }

    public void setGroupId(String str) {
        this.fri.setGroupId(str);
    }

    public T getProgessObject() {
        return this.progessObject;
    }

    public void setProgessObject(T t) {
        this.progessObject = t;
    }

    public void setServerResizeForIMImage() {
        LocalViewSize.ImageSize bpY = LocalViewSize.bpX().bpY();
        LocalViewSize.ImageSize bpZ = LocalViewSize.bpX().bpZ();
        setServersideResize(bpZ.width, bpZ.height, bpY.width, bpY.height);
    }
}
