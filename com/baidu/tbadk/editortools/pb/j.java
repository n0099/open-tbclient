package com.baidu.tbadk.editortools.pb;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ c avv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar) {
        this.avv = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.avv.avc;
        com.baidu.tbadk.core.util.l.p(new File(append.append(str).toString()));
        return null;
    }
}
