package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* loaded from: classes.dex */
class ae extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ GameInstallReceiver a;
    private String b;

    public ae(GameInstallReceiver gameInstallReceiver, String str) {
        this.a = gameInstallReceiver;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        File a;
        ab c = ac.a().c(this.b);
        if (c != null && !TextUtils.isEmpty(c.a()) && (a = ac.a().a(c.a())) != null && a.exists()) {
            a.delete();
            return null;
        }
        return null;
    }
}
