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
    private ad CV;
    final /* synthetic */ CreateBarActivity aOo;
    private volatile boolean kK;

    private d(CreateBarActivity createBarActivity) {
        this.aOo = createBarActivity;
        this.CV = null;
        this.kK = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, d dVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.kK = true;
        if (this.CV != null) {
            this.CV.dL();
        }
        progressBar = this.aOo.aOf;
        progressBar.setVisibility(8);
        this.aOo.aOh = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.CV.o(ImageViewerConfig.FORUM_ID, "0");
            this.CV.o("pub_type", "0");
            this.CV.o(ImageViewerConfig.FORUM_NAME, "");
            this.CV.o("tid", "0");
            String ov = this.CV.ov();
            if (this.CV.oW().pW().ma()) {
                com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                jVar.parserJson(ov);
                if (jVar.getVcode_pic_url() == null || jVar.getVcode_pic_url().length() <= 0) {
                    return null;
                }
                this.aOo.aOi = jVar.getVcode_md5();
                if (this.kK) {
                    return null;
                }
                this.CV = new ad(jVar.getVcode_pic_url());
                return com.baidu.tbadk.core.util.d.v(this.CV.ow());
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
        progressBar = this.aOo.aOf;
        progressBar.setVisibility(8);
        this.aOo.aOh = null;
        if (bitmap != null) {
            imageView = this.aOo.akv;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.aOo.aOi = null;
        progressBar = this.aOo.aOf;
        progressBar.setVisibility(0);
        imageView = this.aOo.akv;
        imageView.setImageDrawable(null);
    }
}
