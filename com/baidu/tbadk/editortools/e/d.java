package com.baidu.tbadk.editortools.e;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private a aww;
    private String filename;

    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.aww = null;
        this.filename = null;
    }

    public boolean fG(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        if (this.aww != null) {
            this.aww.cancel();
        }
        this.aww = new a(this.filename);
        this.aww.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.aww != null) {
            this.aww.cancel();
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
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            if (this.filename != null && !this.filename.equals(TbConfig.IMAGE_RESIZED_FILE)) {
                com.baidu.tbadk.core.util.m.Z("photos/" + this.filename, TbConfig.IMAGE_RESIZED_FILE);
            }
            return BitmapHelper.getRoundedCornerBitmap(BitmapHelper.getSquareBitmap(com.baidu.tbadk.core.util.m.X(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            d.this.aww = null;
            if (d.this.mLoadDataCallBack != null) {
                d.this.mLoadDataCallBack.g(null);
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
            d.this.aww = null;
            if (d.this.mLoadDataCallBack != null) {
                d.this.mLoadDataCallBack.g(bitmap);
            }
        }
    }
}
