package com.baidu.tbadk.editortools.pb;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.k;
/* loaded from: classes.dex */
public class ImageModel extends BdBaseModel {
    private a brO;
    private String filename;

    public ImageModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.brO = null;
        this.filename = null;
    }

    public boolean gj(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        if (this.brO != null) {
            this.brO.cancel();
        }
        this.brO = new a(this.filename);
        this.brO.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.brO != null) {
            this.brO.cancel();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private String filename;

        public a(String str) {
            this.filename = null;
            this.filename = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public Bitmap doInBackground(Object... objArr) {
            if (this.filename != null && !this.filename.equals(TbConfig.IMAGE_RESIZED_FILE)) {
                k.Y("photos/" + this.filename, TbConfig.IMAGE_RESIZED_FILE);
            }
            return BitmapHelper.getRoundedCornerBitmap(BitmapHelper.getSquareBitmap(k.W(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ImageModel.this.brO = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.ak(null);
            }
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            ImageModel.this.brO = null;
            if (ImageModel.this.mLoadDataCallBack != null) {
                ImageModel.this.mLoadDataCallBack.ak(bitmap);
            }
        }
    }
}
