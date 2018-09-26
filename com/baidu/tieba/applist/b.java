package com.baidu.tieba.applist;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.f;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tieba.recapp.s;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BdAsyncTask<f, Integer, String> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(f... fVarArr) {
        f fVar = fVarArr[0];
        if (fVar == null) {
            return "";
        }
        List<String> cK = s.cK(TbadkCoreApplication.getInst().getContext());
        for (g gVar : fVar.Dj()) {
            if (gVar != null) {
                String packageName = gVar.getPackageName();
                Iterator<String> it = cK.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().startsWith(packageName)) {
                            gVar.bn(true);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return fVar.Di();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        TbadkCoreApplication.getInst().setInstalledAppIds(str);
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putString("applist_intalled_apk_ids", str);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("applist_intalled_apk_ids_timestamp", System.currentTimeMillis());
        }
    }
}
