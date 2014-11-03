package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.game.GameInfoData;
import java.io.File;
/* loaded from: classes.dex */
class ad extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ GameInstallReceiver aHV;
    private String packageName;

    public ad(GameInstallReceiver gameInstallReceiver, String str) {
        this.aHV = gameInstallReceiver;
        this.packageName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        File fo;
        GameInfoData fr = ab.Hu().fr(this.packageName);
        if (fr != null && !TextUtils.isEmpty(fr.getGameId()) && (fo = ab.Hu().fo(fr.getGameId())) != null && fo.exists()) {
            fo.delete();
            return null;
        }
        return null;
    }
}
