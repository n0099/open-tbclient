package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.pluginArch.exception.InstallException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ s a;
    private String b = null;
    private int c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public synchronized Void doInBackground(Void... voidArr) {
        String str;
        try {
            try {
                str = this.a.d;
                a(n.e(str));
                this.c = 0;
                this.b = null;
            } catch (InstallException e) {
                this.b = e.getMessage();
                this.c = e.getErr();
            }
        } catch (StackOverflowError e2) {
            this.b = e2.getMessage();
            this.c = -1;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Void r4) {
        b bVar;
        b bVar2;
        String str;
        bVar = this.a.e;
        if (bVar != null) {
            bVar2 = this.a.e;
            bVar2.a(this.c, this.b);
            if (this.c != 0) {
                String str2 = this.b;
                str = this.a.d;
                u.a("plugin_install", str2, str);
            } else {
                u.a("plugin_install");
            }
        }
        super.onPostExecute(r4);
    }

    private void a(File file) {
        String str;
        Context context;
        String str2;
        String str3;
        String str4;
        Context context2;
        String str5;
        publishProgress(1, 0);
        InputStream inputStream = null;
        try {
            context = this.a.c;
            if (context == null) {
                str2 = this.a.b;
                if (str2 != null) {
                    str3 = this.a.b;
                    inputStream = new FileInputStream(new File(str3));
                }
            } else {
                context2 = this.a.c;
                AssetManager assets = context2.getAssets();
                str5 = this.a.d;
                inputStream = assets.open(String.valueOf(str5) + ".tbplugin");
            }
            if (inputStream == null) {
                str4 = this.a.d;
                throw new InstallException(str4, 2);
            }
            new a(inputStream, file.getAbsolutePath()).a();
            publishProgress(1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        } catch (IOException e) {
            str = this.a.d;
            throw new InstallException(str, 3);
        }
    }
}
