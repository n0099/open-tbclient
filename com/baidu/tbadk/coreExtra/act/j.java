package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Void, Bitmap> {
    private String Kc;
    private Bitmap Kd;
    private Boolean Ke;
    private Boolean Kf;
    final /* synthetic */ EditHeadActivity this$0;

    private j(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
        this.Ke = false;
        this.Kf = false;
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
        ConfigInfos.PluginConfig netConfigInfo;
        Handler handler2;
        ProgressBar progressBar;
        TextView textView;
        if (PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK) != null) {
            progressBar = this.this$0.mProgress;
            progressBar.setVisibility(0);
            textView = this.this$0.JC;
            textView.setEnabled(false);
            return;
        }
        try {
            intent = new Intent(this.this$0, Class.forName("com.baidu.tieba.plugins.PluginDownloadActivity"));
            netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_MOTUSDK);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (netConfigInfo == null) {
            handler2 = this.this$0.mHandler;
            handler2.postDelayed(new k(this), 500L);
            return;
        }
        intent.putExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG, netConfigInfo);
        this.this$0.startActivity(intent);
        cancel();
        handler = this.this$0.mHandler;
        handler.postDelayed(new l(this), 500L);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public Bitmap doInBackground(String... strArr) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        MotuPlugin motuPlugin;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        this.Kc = strArr[0];
        bitmap = this.this$0.mBitmap;
        if (bitmap == null) {
            bitmap9 = this.this$0.JO;
            if (bitmap9 == null) {
                return null;
            }
        }
        if (this.Kc.equals("0") || this.Kc.equals("1")) {
            this.Ke = true;
        } else if (this.Kc.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) || this.Kc.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.Kf = true;
        }
        if (!this.Ke.booleanValue() && !this.Kf.booleanValue()) {
            bitmap7 = this.this$0.mBitmap;
            bitmap8 = this.this$0.mBitmap;
            this.Kd = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.this$0.JO;
            if (bitmap2 == null) {
                bitmap3 = this.this$0.mBitmap;
                bitmap4 = this.this$0.mBitmap;
                this.Kd = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.this$0.JO;
                bitmap6 = this.this$0.JO;
                this.Kd = bitmap5.copy(bitmap6.getConfig(), true);
            }
        }
        if (this.Ke.booleanValue()) {
            this.Kd = com.baidu.tbadk.core.util.d.d(this.Kd, Integer.parseInt(this.Kc));
        } else if (this.Kf.booleanValue()) {
            this.Kd = com.baidu.tbadk.core.util.d.f(this.Kd, Integer.parseInt(this.Kc));
        } else {
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK);
            if (pluginByName != null && (motuPlugin = (MotuPlugin) pluginByName.getClassInstance(MotuPlugin.class)) != null) {
                this.Kd = motuPlugin.createOneKeyFilterAndApply(this.this$0, this.Kc, this.Kd);
            }
        }
        return this.Kd;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.Kd != null && !this.Kd.isRecycled()) {
            bitmap = this.this$0.JO;
            if (bitmap != this.Kd) {
                this.Kd.recycle();
            }
        }
        this.Kd = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        textView = this.this$0.JC;
        textView.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r0.getHeight() > 750) goto L28;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
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
        textView = this.this$0.JC;
        textView.setClickable(true);
        textView2 = this.this$0.JC;
        textView2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.this$0.JV = true;
            if (this.Ke.booleanValue() || this.Kf.booleanValue()) {
                editHeadsImageView = this.this$0.JA;
                editHeadsImageView.setImageBitmap(bitmap);
                bitmap2 = this.this$0.mBitmap;
                if (bitmap2.getWidth() <= 750) {
                    bitmap6 = this.this$0.mBitmap;
                }
                EditHeadActivity editHeadActivity = this.this$0;
                bitmap3 = this.this$0.mBitmap;
                editHeadActivity.mBitmap = com.baidu.tbadk.core.util.d.a(bitmap3, (int) TbConfig.POST_IMAGE_MIDDLE);
                if (this.Ke.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.this$0;
                    bitmap5 = this.this$0.mBitmap;
                    editHeadActivity2.mBitmap = com.baidu.tbadk.core.util.d.d(bitmap5, Integer.parseInt(this.Kc));
                } else if (this.Kf.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.this$0;
                    bitmap4 = this.this$0.mBitmap;
                    editHeadActivity3.mBitmap = com.baidu.tbadk.core.util.d.f(bitmap4, Integer.parseInt(this.Kc));
                }
            } else {
                editHeadsImageView2 = this.this$0.JA;
                editHeadsImageView2.g(bitmap);
            }
            bitmap7 = this.this$0.JO;
            if (bitmap7 != null) {
                bitmap8 = this.this$0.JO;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.this$0.JO;
                    bitmap9.recycle();
                }
            }
            this.this$0.JO = bitmap;
        }
    }
}
