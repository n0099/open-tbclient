package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Bitmap> {
    private aa ZD;
    final /* synthetic */ CreateBarActivity aVR;
    private volatile boolean wb;

    private d(CreateBarActivity createBarActivity) {
        this.aVR = createBarActivity;
        this.ZD = null;
        this.wb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, d dVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.wb = true;
        if (this.ZD != null) {
            this.ZD.hh();
        }
        progressBar = this.aVR.aVI;
        progressBar.setVisibility(8);
        this.aVR.aVK = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.ZD = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.ZD.o(ImageViewerConfig.FORUM_ID, GameInfoData.NOT_FROM_DETAIL);
            this.ZD.o("pub_type", GameInfoData.NOT_FROM_DETAIL);
            this.ZD.o(ImageViewerConfig.FORUM_NAME, "");
            this.ZD.o("tid", GameInfoData.NOT_FROM_DETAIL);
            String rO = this.ZD.rO();
            if (this.ZD.sp().tq().pv()) {
                k kVar = new k();
                kVar.parserJson(rO);
                if (kVar.getVcode_pic_url() == null || kVar.getVcode_pic_url().length() <= 0) {
                    return null;
                }
                this.aVR.aVL = kVar.getVcode_md5();
                if (this.wb) {
                    return null;
                }
                this.ZD = new aa(kVar.getVcode_pic_url());
                return com.baidu.tbadk.core.util.c.w(this.ZD.rP());
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
        progressBar = this.aVR.aVI;
        progressBar.setVisibility(8);
        this.aVR.aVK = null;
        if (bitmap != null) {
            imageView = this.aVR.atv;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.aVR.aVL = null;
        progressBar = this.aVR.aVI;
        progressBar.setVisibility(0);
        imageView = this.aVR.atv;
        imageView.setImageDrawable(null);
    }
}
