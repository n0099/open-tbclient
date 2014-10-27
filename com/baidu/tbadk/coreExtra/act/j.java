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
    private String Kb;
    private Bitmap Kc;
    private Boolean Kd;
    private Boolean Ke;
    final /* synthetic */ EditHeadActivity this$0;

    private j(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
        this.Kd = false;
        this.Ke = false;
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
            textView = this.this$0.JB;
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
            this.this$0.showToast("插件安装失败");
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
        this.Kb = strArr[0];
        bitmap = this.this$0.mBitmap;
        if (bitmap == null) {
            bitmap9 = this.this$0.JN;
            if (bitmap9 == null) {
                return null;
            }
        }
        if (this.Kb.equals("0") || this.Kb.equals("1")) {
            this.Kd = true;
        } else if (this.Kb.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) || this.Kb.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.Ke = true;
        }
        if (!this.Kd.booleanValue() && !this.Ke.booleanValue()) {
            bitmap7 = this.this$0.mBitmap;
            bitmap8 = this.this$0.mBitmap;
            this.Kc = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.this$0.JN;
            if (bitmap2 == null) {
                bitmap3 = this.this$0.mBitmap;
                bitmap4 = this.this$0.mBitmap;
                this.Kc = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.this$0.JN;
                bitmap6 = this.this$0.JN;
                this.Kc = bitmap5.copy(bitmap6.getConfig(), true);
            }
        }
        if (this.Kd.booleanValue()) {
            this.Kc = com.baidu.tbadk.core.util.d.d(this.Kc, Integer.parseInt(this.Kb));
        } else if (this.Ke.booleanValue()) {
            this.Kc = com.baidu.tbadk.core.util.d.f(this.Kc, Integer.parseInt(this.Kb));
        } else {
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK);
            if (pluginByName != null && (motuPlugin = (MotuPlugin) pluginByName.getClassInstance(MotuPlugin.class)) != null) {
                this.Kc = motuPlugin.createOneKeyFilterAndApply(this.this$0, this.Kb, this.Kc);
            }
        }
        return this.Kc;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.Kc != null && !this.Kc.isRecycled()) {
            bitmap = this.this$0.JN;
            if (bitmap != this.Kc) {
                this.Kc.recycle();
            }
        }
        this.Kc = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        textView = this.this$0.JB;
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
        textView = this.this$0.JB;
        textView.setClickable(true);
        textView2 = this.this$0.JB;
        textView2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.this$0.JU = true;
            if (this.Kd.booleanValue() || this.Ke.booleanValue()) {
                editHeadsImageView = this.this$0.Jz;
                editHeadsImageView.setImageBitmap(bitmap);
                bitmap2 = this.this$0.mBitmap;
                if (bitmap2.getWidth() <= 750) {
                    bitmap6 = this.this$0.mBitmap;
                }
                EditHeadActivity editHeadActivity = this.this$0;
                bitmap3 = this.this$0.mBitmap;
                editHeadActivity.mBitmap = com.baidu.tbadk.core.util.d.a(bitmap3, (int) TbConfig.POST_IMAGE_MIDDLE);
                if (this.Kd.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.this$0;
                    bitmap5 = this.this$0.mBitmap;
                    editHeadActivity2.mBitmap = com.baidu.tbadk.core.util.d.d(bitmap5, Integer.parseInt(this.Kb));
                } else if (this.Ke.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.this$0;
                    bitmap4 = this.this$0.mBitmap;
                    editHeadActivity3.mBitmap = com.baidu.tbadk.core.util.d.f(bitmap4, Integer.parseInt(this.Kb));
                }
            } else {
                editHeadsImageView2 = this.this$0.Jz;
                editHeadsImageView2.g(bitmap);
            }
            bitmap7 = this.this$0.JN;
            if (bitmap7 != null) {
                bitmap8 = this.this$0.JN;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.this$0.JN;
                    bitmap9.recycle();
                }
            }
            this.this$0.JN = bitmap;
        }
    }
}
