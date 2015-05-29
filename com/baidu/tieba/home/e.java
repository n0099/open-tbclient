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
public class e extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ CreateBarActivity aYM;
    private aa aaG;
    private volatile boolean ayP;

    private e(CreateBarActivity createBarActivity) {
        this.aYM = createBarActivity;
        this.aaG = null;
        this.ayP = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(CreateBarActivity createBarActivity, e eVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.ayP = true;
        if (this.aaG != null) {
            this.aaG.gS();
        }
        progressBar = this.aYM.aYD;
        progressBar.setVisibility(8);
        this.aYM.aYF = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.aaG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.aaG.o(ImageViewerConfig.FORUM_ID, GameInfoData.NOT_FROM_DETAIL);
            this.aaG.o("pub_type", GameInfoData.NOT_FROM_DETAIL);
            this.aaG.o(ImageViewerConfig.FORUM_NAME, "");
            this.aaG.o("tid", GameInfoData.NOT_FROM_DETAIL);
            String sw = this.aaG.sw();
            if (this.aaG.sX().tT().qa()) {
                l lVar = new l();
                lVar.parserJson(sw);
                if (lVar.getVcode_pic_url() == null || lVar.getVcode_pic_url().length() <= 0) {
                    return null;
                }
                this.aYM.aYG = lVar.getVcode_md5();
                if (this.ayP) {
                    return null;
                }
                this.aaG = new aa(lVar.getVcode_pic_url());
                return com.baidu.tbadk.core.util.c.w(this.aaG.sx());
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
        super.onPostExecute((e) bitmap);
        progressBar = this.aYM.aYD;
        progressBar.setVisibility(8);
        this.aYM.aYF = null;
        if (bitmap != null) {
            imageView = this.aYM.avb;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.aYM.aYG = null;
        progressBar = this.aYM.aYD;
        progressBar.setVisibility(0);
        imageView = this.aYM.avb;
        imageView.setImageDrawable(null);
    }
}
