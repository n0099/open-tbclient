package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> extends BdAsyncTask<Object, D, D> {
    private NetModel<T, D, ActivityType> aeH;
    private com.baidu.tbadk.core.util.httpNet.c aeI;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.p<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public /* synthetic */ void onPostExecute(Object obj) {
        a((p<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
    }

    public p(NetModel<T, D, ActivityType> netModel) {
        this.aeH = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public D doInBackground(Object... objArr) {
        com.baidu.tbadk.mvc.b.h hVar;
        com.baidu.tbadk.mvc.b.h hVar2;
        com.baidu.tbadk.mvc.b.h hVar3;
        ((NetModel) this.aeH).aeC = true;
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aeH.kM());
        hVar = ((NetModel) this.aeH).aev;
        for (Map.Entry<String, Object> entry : hVar.kQ().entrySet()) {
            adVar.o(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String oy = adVar.oy();
        this.aeI = adVar.oZ();
        D q = q(this.aeH.getResponseDataClass());
        try {
            q.c(new JSONObject(oy));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishProgress(q);
        if (this.aeH.isNeedCache() && this.aeI != null && this.aeI.qh() != null && this.aeI.qh().ma() && q != null) {
            hVar2 = ((NetModel) this.aeH).aev;
            if (hVar2 instanceof com.baidu.tbadk.mvc.b.e) {
                hVar3 = ((NetModel) this.aeH).aev;
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) hVar3;
                String cacheKey = eVar.getCacheKey();
                String lq = eVar.lq();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(lq) || q == null) {
                    return q;
                }
                com.baidu.adp.lib.cache.t<String> R = com.baidu.tbadk.core.a.a.nV().R(lq, currentAccount);
                if (R == null) {
                    return q;
                }
                R.f(cacheKey, oy);
            }
        }
        return q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(D... dArr) {
        Runnable runnable;
        com.baidu.tbadk.mvc.b.h hVar;
        r rVar;
        r rVar2;
        Runnable runnable2;
        super.onProgressUpdate(dArr);
        if (dArr != null && dArr.length > 0) {
            ((NetModel) this.aeH).aeC = false;
            runnable = ((NetModel) this.aeH).aeE;
            if (runnable != null) {
                com.baidu.adp.lib.g.i ej = com.baidu.adp.lib.g.i.ej();
                runnable2 = ((NetModel) this.aeH).aeE;
                ej.removeCallbacks(runnable2);
            }
            hVar = ((NetModel) this.aeH).aev;
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(hVar, this.aeH.kL());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aeH.kL());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            if (this.aeI != null && this.aeI.qh() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.aeI.qh().KB, this.aeI.qh().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.aeI.qh().KC);
                mvcJsonHttpResponsedMessage.setErrorString(this.aeI.qh().mErrorString);
                if (this.aeI.qh().KD != null) {
                    BdLog.e(this.aeI.qh().KD);
                }
            }
            this.aeH.xS();
            rVar = ((NetModel) this.aeH).aet;
            if (rVar != null) {
                rVar2 = ((NetModel) this.aeH).aet;
                rVar2.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
            }
        }
    }

    protected void a(D d) {
        super.onPostExecute(d);
    }

    protected D q(Class<D> cls) {
        try {
            return cls.newInstance();
        } catch (ExceptionInInitializerError e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
