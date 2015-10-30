package com.baidu.tbadk.editortools.c;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ d asm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.asm = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.asm.arU;
        com.baidu.tbadk.core.util.n.q(new File(append.append(str).toString()));
        return null;
    }
}
