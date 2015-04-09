package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.game.GameInfoData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Bitmap> {
    private aa ZF;
    final /* synthetic */ CreateBarActivity aWh;
    private volatile boolean wb;

    private d(CreateBarActivity createBarActivity) {
        this.aWh = createBarActivity;
        this.ZF = null;
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
        if (this.ZF != null) {
            this.ZF.hh();
        }
        progressBar = this.aWh.aVY;
        progressBar.setVisibility(8);
        this.aWh.aWa = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.ZF = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.ZF.o(ImageViewerConfig.FORUM_ID, GameInfoData.NOT_FROM_DETAIL);
            this.ZF.o("pub_type", GameInfoData.NOT_FROM_DETAIL);
            this.ZF.o(ImageViewerConfig.FORUM_NAME, "");
            this.ZF.o("tid", GameInfoData.NOT_FROM_DETAIL);
            String rO = this.ZF.rO();
            if (this.ZF.sp().tq().pv()) {
                l lVar = new l();
                lVar.parserJson(rO);
                if (lVar.getVcode_pic_url() == null || lVar.getVcode_pic_url().length() <= 0) {
                    return null;
                }
                this.aWh.aWb = lVar.getVcode_md5();
                if (this.wb) {
                    return null;
                }
                this.ZF = new aa(lVar.getVcode_pic_url());
                return com.baidu.tbadk.core.util.c.w(this.ZF.rP());
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
        progressBar = this.aWh.aVY;
        progressBar.setVisibility(8);
        this.aWh.aWa = null;
        if (bitmap != null) {
            imageView = this.aWh.atD;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.aWh.aWb = null;
        progressBar = this.aWh.aVY;
        progressBar.setVisibility(0);
        imageView = this.aWh.atD;
        imageView.setImageDrawable(null);
    }
}
