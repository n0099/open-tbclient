package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import com.baidu.adp.base.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.s;
import java.io.Serializable;
/* loaded from: classes.dex */
public class LocalPicModel extends f implements Serializable {
    private static final long serialVersionUID = -339604626740227228L;
    private String mDName;
    private String mDPath;
    private GetImageTask mImageTask;
    private String mSName;
    private String mSPath;

    public LocalPicModel(String str, String str2, String str3, String str4) {
        super(null);
        this.mImageTask = null;
        this.mSPath = null;
        this.mSName = null;
        this.mDPath = null;
        this.mDName = null;
        this.mSPath = str;
        this.mSName = str2;
        this.mDPath = str3;
        this.mDName = str4;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    public boolean getData() {
        if (this.mImageTask != null) {
            return false;
        }
        this.mImageTask = new GetImageTask(this, null);
        this.mImageTask.setSelfExecute(true);
        this.mImageTask.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.mImageTask != null) {
            this.mImageTask.cancel();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class GetImageTask extends BdAsyncTask<Object, Integer, ResponseData> {
        private GetImageTask() {
        }

        /* synthetic */ GetImageTask(LocalPicModel localPicModel, GetImageTask getImageTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public ResponseData doInBackground(Object... objArr) {
            String str = "im_" + String.valueOf(System.currentTimeMillis());
            String d = s.d(LocalPicModel.this.mSPath, LocalPicModel.this.mSName, TiebaIMConfig.POST_IMAGE_PATH, String.valueOf(str) + "_send");
            String str2 = String.valueOf(str) + "_display";
            String d2 = s.d(LocalPicModel.this.mDPath, LocalPicModel.this.mDName, TiebaIMConfig.POST_IMAGE_PATH, str2);
            Bitmap U = s.U(TiebaIMConfig.POST_IMAGE_PATH, str2);
            if (d == null || d2 == null || U == null) {
                return null;
            }
            return new ResponseData(U, d, d2);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            LocalPicModel.this.mImageTask = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(ResponseData responseData) {
            super.onPostExecute((GetImageTask) responseData);
            LocalPicModel.this.mImageTask = null;
            if (LocalPicModel.this.mLoadDataCallBack != null) {
                LocalPicModel.this.mLoadDataCallBack.c(responseData);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ResponseData implements Serializable {
        private static final long serialVersionUID = -9099542245580007084L;
        private Bitmap mBitmap;
        private String mDPathGen;
        private String mSPathGen;

        public ResponseData(Bitmap bitmap, String str, String str2) {
            this.mBitmap = null;
            this.mSPathGen = null;
            this.mDPathGen = null;
            this.mBitmap = bitmap;
            this.mSPathGen = str;
            this.mDPathGen = str2;
        }

        public String getSPathGen() {
            return this.mSPathGen;
        }

        public String getDPathGen() {
            return this.mDPathGen;
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }
    }
}
