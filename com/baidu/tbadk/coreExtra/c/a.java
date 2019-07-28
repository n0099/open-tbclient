package com.baidu.tbadk.coreExtra.c;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private InterfaceC0246a cko;

    /* renamed from: com.baidu.tbadk.coreExtra.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0246a {
        void d(e eVar);
    }

    public void b(e eVar) {
        new BdAsyncTask<e, Integer, e>() { // from class: com.baidu.tbadk.coreExtra.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: a */
            public e doInBackground(e... eVarArr) {
                e eVar2;
                String str = null;
                if (eVarArr == null || eVarArr.length < 1 || (eVar2 = eVarArr[0]) == null) {
                    return null;
                }
                String str2 = eVar2.tid;
                x xVar = new x();
                xVar.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_SHARE_IMAGE);
                xVar.o("thread_id", str2);
                xVar.o("type", "3");
                String aig = xVar.aig();
                if (aq.isEmpty(aig)) {
                    return eVar2;
                }
                try {
                    str = new JSONObject(aig).optString(BigdayActivityConfig.IMG_URL);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                eVar2.ckZ = str;
                eVar2.imageUri = Uri.parse(str);
                return eVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public void onPostExecute(e eVar2) {
                super.onPostExecute(eVar2);
                if (a.this.cko != null) {
                    a.this.cko.d(eVar2);
                }
            }
        }.execute(eVar);
    }

    public void a(InterfaceC0246a interfaceC0246a) {
        this.cko = interfaceC0246a;
    }
}
