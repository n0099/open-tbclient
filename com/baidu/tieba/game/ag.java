package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* loaded from: classes.dex */
class ag extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ GameInstallReceiver a;
    private String b;

    public ag(GameInstallReceiver gameInstallReceiver, String str) {
        this.a = gameInstallReceiver;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        File a;
        com.baidu.tbadk.game.b c = ae.a().c(this.b);
        if (c != null && !TextUtils.isEmpty(c.a()) && (a = ae.a().a(c.a())) != null && a.exists()) {
            a.delete();
            return null;
        }
        return null;
    }
}
