package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Bitmap> {
    private ad CU;
    final /* synthetic */ CreateBarActivity aPw;
    private volatile boolean kN;

    private d(CreateBarActivity createBarActivity) {
        this.aPw = createBarActivity;
        this.CU = null;
        this.kN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, d dVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.kN = true;
        if (this.CU != null) {
            this.CU.dJ();
        }
        progressBar = this.aPw.aPn;
        progressBar.setVisibility(8);
        this.aPw.aPp = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.CU = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.CU.o(ImageViewerConfig.FORUM_ID, "0");
            this.CU.o("pub_type", "0");
            this.CU.o(ImageViewerConfig.FORUM_NAME, "");
            this.CU.o("tid", "0");
            String or = this.CU.or();
            if (this.CU.oS().qa().lT()) {
                com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                jVar.parserJson(or);
                if (jVar.getVcode_pic_url() == null || jVar.getVcode_pic_url().length() <= 0) {
                    return null;
                }
                this.aPw.aPq = jVar.getVcode_md5();
                if (this.kN) {
                    return null;
                }
                this.CU = new ad(jVar.getVcode_pic_url());
                return com.baidu.tbadk.core.util.d.v(this.CU.os());
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute((d) bitmap);
        progressBar = this.aPw.aPn;
        progressBar.setVisibility(8);
        this.aPw.aPp = null;
        if (bitmap != null) {
            imageView = this.aPw.ano;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.aPw.aPq = null;
        progressBar = this.aPw.aPn;
        progressBar.setVisibility(0);
        imageView = this.aPw.ano;
        imageView.setImageDrawable(null);
    }
}
