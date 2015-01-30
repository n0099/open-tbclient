package com.baidu.tieba.friendfeed;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.aBV.aBK;
        com.baidu.tbadk.core.util.s.deleteFile(new File(append.append(str).toString()));
        return null;
    }
}
