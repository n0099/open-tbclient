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
    private ad CX;
    final /* synthetic */ CreateBarActivity aPx;
    private volatile boolean kN;

    private d(CreateBarActivity createBarActivity) {
        this.aPx = createBarActivity;
        this.CX = null;
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
        if (this.CX != null) {
            this.CX.dJ();
        }
        progressBar = this.aPx.aPo;
        progressBar.setVisibility(8);
        this.aPx.aPq = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.CX = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.CX.o(ImageViewerConfig.FORUM_ID, "0");
            this.CX.o("pub_type", "0");
            this.CX.o(ImageViewerConfig.FORUM_NAME, "");
            this.CX.o("tid", "0");
            String oy = this.CX.oy();
            if (this.CX.oZ().qh().ma()) {
                com.baidu.tbadk.coreExtra.data.j jVar = new com.baidu.tbadk.coreExtra.data.j();
                jVar.parserJson(oy);
                if (jVar.getVcode_pic_url() == null || jVar.getVcode_pic_url().length() <= 0) {
                    return null;
                }
                this.aPx.aPr = jVar.getVcode_md5();
                if (this.kN) {
                    return null;
                }
                this.CX = new ad(jVar.getVcode_pic_url());
                return com.baidu.tbadk.core.util.d.v(this.CX.oz());
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
        progressBar = this.aPx.aPo;
        progressBar.setVisibility(8);
        this.aPx.aPq = null;
        if (bitmap != null) {
            imageView = this.aPx.anr;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.aPx.aPr = null;
        progressBar = this.aPx.aPo;
        progressBar.setVisibility(0);
        imageView = this.aPx.anr;
        imageView.setImageDrawable(null);
    }
}
