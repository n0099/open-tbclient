package com.baidu.tbadk.editortools.c;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private a arO;
    private String filename;

    public c(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.arO = null;
        this.filename = null;
    }

    public boolean eW(String str) {
        this.filename = str;
        return LoadData();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        if (this.arO != null) {
            this.arO.cancel();
        }
        this.arO = new a(this.filename);
        this.arO.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.arO != null) {
            this.arO.cancel();
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
                com.baidu.tbadk.core.util.n.ac("photos/" + this.filename, TbConfig.IMAGE_RESIZED_FILE);
            }
            return com.baidu.tbadk.core.util.c.a(com.baidu.tbadk.core.util.c.g(com.baidu.tbadk.core.util.n.aa(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            c.this.arO = null;
            if (c.this.mLoadDataCallBack != null) {
                c.this.mLoadDataCallBack.d(null);
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
            c.this.arO = null;
            if (c.this.mLoadDataCallBack != null) {
                c.this.mLoadDataCallBack.d(bitmap);
            }
        }
    }
}
