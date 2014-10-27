package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ CreateBarActivity aMa;
    private volatile boolean kJ;
    private ac yV;

    private d(CreateBarActivity createBarActivity) {
        this.aMa = createBarActivity;
        this.yV = null;
        this.kJ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, d dVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.kJ = true;
        if (this.yV != null) {
            this.yV.dM();
        }
        progressBar = this.aMa.aLR;
        progressBar.setVisibility(8);
        this.aMa.aLT = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.yV = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.yV.k(ImageViewerConfig.FORUM_ID, "0");
            this.yV.k("pub_type", "0");
            this.yV.k(ImageViewerConfig.FORUM_NAME, "");
            this.yV.k("tid", "0");
            String lA = this.yV.lA();
            if (this.yV.mc().nb().jq()) {
                com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                fVar.parserJson(lA);
                if (fVar.getVcode_pic_url() == null || fVar.getVcode_pic_url().length() <= 0) {
                    return null;
                }
                this.aMa.aLU = fVar.getVcode_md5();
                if (this.kJ) {
                    return null;
                }
                this.yV = new ac(fVar.getVcode_pic_url());
                return com.baidu.tbadk.core.util.d.w(this.yV.lB());
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
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute(bitmap);
        progressBar = this.aMa.aLR;
        progressBar.setVisibility(8);
        this.aMa.aLT = null;
        if (bitmap != null) {
            imageView = this.aMa.acF;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.aMa.aLU = null;
        progressBar = this.aMa.aLR;
        progressBar.setVisibility(0);
        imageView = this.aMa.acF;
        imageView.setImageDrawable(null);
    }
}
