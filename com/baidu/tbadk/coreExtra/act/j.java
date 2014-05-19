package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Void, Bitmap> {
    final /* synthetic */ EditHeadActivity a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private j(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.d = false;
        this.e = false;
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
        PluginsConfig.PluginConfig d;
        Handler handler2;
        ProgressBar progressBar;
        TextView textView;
        if (((MotuPlugin) com.baidu.tbadk.tbplugin.m.a().b(MotuPlugin.class)) != null) {
            progressBar = this.a.n;
            progressBar.setVisibility(0);
            textView = this.a.j;
            textView.setEnabled(false);
            return;
        }
        try {
            intent = new Intent(this.a, Class.forName("com.baidu.tieba.plugins.PluginDownloadActivity"));
            d = com.baidu.tbadk.tbplugin.m.a().d("motusdk");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (d == null) {
            this.a.showToast("插件安装失败");
            handler2 = this.a.J;
            handler2.postDelayed(new k(this), 500L);
            return;
        }
        intent.putExtra("plugin_config", d);
        this.a.startActivity(intent);
        cancel();
        handler = this.a.J;
        handler.postDelayed(new l(this), 500L);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
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
        this.b = strArr[0];
        bitmap = this.a.h;
        if (bitmap == null) {
            bitmap9 = this.a.w;
            if (bitmap9 == null) {
                return null;
            }
        }
        if (this.b.equals("0") || this.b.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
            this.d = true;
        } else if (this.b.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) || this.b.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.e = true;
        }
        if (!this.d.booleanValue() && !this.e.booleanValue()) {
            bitmap7 = this.a.h;
            bitmap8 = this.a.h;
            this.c = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.a.w;
            if (bitmap2 == null) {
                bitmap3 = this.a.h;
                bitmap4 = this.a.h;
                this.c = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.a.w;
                bitmap6 = this.a.w;
                this.c = bitmap5.copy(bitmap6.getConfig(), true);
            }
        }
        if (this.d.booleanValue()) {
            this.c = com.baidu.tbadk.core.util.g.d(this.c, Integer.parseInt(this.b));
        } else if (this.e.booleanValue()) {
            this.c = com.baidu.tbadk.core.util.g.f(this.c, Integer.parseInt(this.b));
        } else {
            MotuPlugin motuPlugin = (MotuPlugin) com.baidu.tbadk.tbplugin.m.a().b(MotuPlugin.class);
            if (motuPlugin != null) {
                this.c = motuPlugin.createOneKeyFilterAndApply(this.a, this.b, this.c);
            }
        }
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.a.w;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        textView = this.a.j;
        textView.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r0.getHeight() > 750) goto L28;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
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
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        textView = this.a.j;
        textView.setClickable(true);
        textView2 = this.a.j;
        textView2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.D = true;
            if (this.d.booleanValue() || this.e.booleanValue()) {
                editHeadsImageView = this.a.g;
                editHeadsImageView.setImageBitmap(bitmap);
                bitmap2 = this.a.h;
                if (bitmap2.getWidth() <= 750) {
                    bitmap6 = this.a.h;
                }
                EditHeadActivity editHeadActivity = this.a;
                bitmap3 = this.a.h;
                editHeadActivity.h = com.baidu.tbadk.core.util.g.a(bitmap3, (int) TbConfig.POST_IMAGE_MIDDLE);
                if (this.d.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.a;
                    bitmap5 = this.a.h;
                    editHeadActivity2.h = com.baidu.tbadk.core.util.g.d(bitmap5, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.a;
                    bitmap4 = this.a.h;
                    editHeadActivity3.h = com.baidu.tbadk.core.util.g.f(bitmap4, Integer.parseInt(this.b));
                }
            } else {
                editHeadsImageView2 = this.a.g;
                editHeadsImageView2.a(bitmap);
            }
            bitmap7 = this.a.w;
            if (bitmap7 != null) {
                bitmap8 = this.a.w;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.a.w;
                    bitmap9.recycle();
                }
            }
            this.a.w = bitmap;
        }
    }
}
