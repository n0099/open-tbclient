package com.baidu.tieba.applist;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.e;
import com.baidu.tbadk.coreExtra.data.f;
import com.baidu.tieba.recapp.s;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BdAsyncTask<e, Integer, String> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(e... eVarArr) {
        e eVar = eVarArr[0];
        if (eVar == null) {
            return "";
        }
        List<String> cf = s.cf(TbadkCoreApplication.getInst().getContext());
        for (f fVar : eVar.FD()) {
            if (fVar != null) {
                String packageName = fVar.getPackageName();
                Iterator<String> it = cf.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().startsWith(packageName)) {
                            fVar.bD(true);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return eVar.FC();
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
