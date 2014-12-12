package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Void, Bitmap> {
    private Boolean Pm;
    private Boolean Pn;
    private Bitmap bitmap;
    private String mLabel;
    final /* synthetic */ EditHeadActivity this$0;

    private j(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
        this.Pm = false;
        this.Pn = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(EditHeadActivity editHeadActivity, j jVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Handler handler;
        Intent intent;
        Handler handler2;
        ProgressBar progressBar;
        View view;
        PluginPackageManager.PluginStatus bm = PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu");
        if (bm == PluginPackageManager.PluginStatus.NROMAL) {
            progressBar = this.this$0.mProgress;
            progressBar.setVisibility(0);
            view = this.this$0.OL;
            view.setEnabled(false);
            return;
        }
        try {
            intent = new Intent(this.this$0.getPageContext().getPageActivity(), Class.forName("com.baidu.tieba.plugins.PluginDownloadActivity"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (bm != PluginPackageManager.PluginStatus.DISABLE) {
            handler2 = this.this$0.mHandler;
            handler2.postDelayed(new k(this), 500L);
            return;
        }
        intent.putExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG, PluginPackageManager.ic().getPluginConfig("com.baidu.tieba.pluginMotu"));
        this.this$0.startActivity(intent);
        cancel();
        handler = this.this$0.mHandler;
        handler.postDelayed(new l(this), 500L);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        this.mLabel = strArr[0];
        bitmap = this.this$0.mBitmap;
        if (bitmap == null) {
            bitmap9 = this.this$0.OZ;
            if (bitmap9 == null) {
                return null;
            }
        }
        if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
            this.Pm = true;
        } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.Pn = true;
        }
        if (!this.Pm.booleanValue() && !this.Pn.booleanValue()) {
            bitmap7 = this.this$0.mBitmap;
            bitmap8 = this.this$0.mBitmap;
            this.bitmap = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.this$0.OZ;
            if (bitmap2 == null) {
                bitmap3 = this.this$0.mBitmap;
                bitmap4 = this.this$0.mBitmap;
                this.bitmap = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.this$0.OZ;
                bitmap6 = this.this$0.OZ;
                this.bitmap = bitmap5.copy(bitmap6.getConfig(), true);
            }
        }
        if (this.Pm.booleanValue()) {
            this.bitmap = com.baidu.tbadk.core.util.d.g(this.bitmap, Integer.parseInt(this.mLabel));
        } else if (this.Pn.booleanValue()) {
            this.bitmap = com.baidu.tbadk.core.util.d.i(this.bitmap, Integer.parseInt(this.mLabel));
        } else {
            MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.gX().hd();
            if (motuPlugin != null) {
                this.bitmap = motuPlugin.createOneKeyFilterAndApply(this.this$0.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
            }
        }
        return this.bitmap;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        View view;
        Bitmap bitmap;
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            bitmap = this.this$0.OZ;
            if (bitmap != this.bitmap) {
                this.bitmap.recycle();
            }
        }
        this.bitmap = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.OL;
        view.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r0.getHeight() > 750) goto L28;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        View view;
        View view2;
        EditHeadsImageView editHeadsImageView;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        EditHeadsImageView editHeadsImageView2;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.OL;
        view.setClickable(true);
        view2 = this.this$0.OL;
        view2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.this$0.Pg = true;
            if (this.Pm.booleanValue() || this.Pn.booleanValue()) {
                editHeadsImageView = this.this$0.OH;
                editHeadsImageView.setImageBitmap(bitmap);
                bitmap2 = this.this$0.mBitmap;
                if (bitmap2.getWidth() <= 750) {
                    bitmap6 = this.this$0.mBitmap;
                }
                EditHeadActivity editHeadActivity = this.this$0;
                bitmap3 = this.this$0.mBitmap;
                editHeadActivity.mBitmap = com.baidu.tbadk.core.util.d.d(bitmap3, TbConfig.POST_IMAGE_MIDDLE);
                if (this.Pm.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.this$0;
                    bitmap5 = this.this$0.mBitmap;
                    editHeadActivity2.mBitmap = com.baidu.tbadk.core.util.d.g(bitmap5, Integer.parseInt(this.mLabel));
                } else if (this.Pn.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.this$0;
                    bitmap4 = this.this$0.mBitmap;
                    editHeadActivity3.mBitmap = com.baidu.tbadk.core.util.d.i(bitmap4, Integer.parseInt(this.mLabel));
                }
            } else {
                editHeadsImageView2 = this.this$0.OH;
                editHeadsImageView2.replaceImageBitmap(bitmap);
            }
            bitmap7 = this.this$0.OZ;
            if (bitmap7 != null) {
                bitmap8 = this.this$0.OZ;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.this$0.OZ;
                    bitmap9.recycle();
                }
            }
            this.this$0.OZ = bitmap;
        }
    }
}
