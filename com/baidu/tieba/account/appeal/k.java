package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.bs;
import java.lang.ref.WeakReference;
import org.apache.commons.io.IOUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<String, Object, ForbidReasonData> {
    private String a;
    private String b;
    private WeakReference<l> c;

    public k(String str, String str2, l lVar) {
        this.a = str;
        this.b = str2;
        this.c = new WeakReference<>(lVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForbidReasonData a(String... strArr) {
        String str;
        str = j.a;
        ba baVar = new ba(str);
        baVar.a("forum_id", this.a);
        baVar.a(PushConstants.EXTRA_USER_ID, this.b);
        String m = baVar.m();
        if (baVar.d()) {
            try {
                ForbidReasonData forbidReasonData = (ForbidReasonData) new GsonBuilder().create().fromJson(m, (Class<Object>) ForbidReasonData.class);
                forbidReasonData.reason = forbidReasonData.reason.replaceAll("\\\\n", IOUtils.LINE_SEPARATOR_UNIX);
                return forbidReasonData;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("ForbidReasonModel", "doInBackground", e.getMessage());
                ForbidReasonData forbidReasonData2 = new ForbidReasonData();
                forbidReasonData2.error.a = -1000;
                return forbidReasonData2;
            }
        }
        ForbidReasonData forbidReasonData3 = new ForbidReasonData();
        forbidReasonData3.error.a = baVar.f();
        forbidReasonData3.error.b = baVar.j();
        return forbidReasonData3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForbidReasonData forbidReasonData) {
        super.a((k) forbidReasonData);
        l lVar = this.c.get();
        if (lVar != null) {
            if (forbidReasonData.error.a == 0 && bs.c(forbidReasonData.error.b)) {
                lVar.a(forbidReasonData);
            } else {
                lVar.b(forbidReasonData);
            }
        }
    }
}
