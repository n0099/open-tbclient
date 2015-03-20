package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k, ActivityType> extends BdAsyncTask<Object, D, D> {
    private NetModel<T, D, ActivityType> amY;
    private com.baidu.tbadk.core.util.httpNet.a amZ;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.p<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k, ActivityType> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public /* synthetic */ void onPostExecute(Object obj) {
        a((p<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.k) obj));
    }

    public p(NetModel<T, D, ActivityType> netModel) {
        this.amY = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public D doInBackground(Object... objArr) {
        ((NetModel) this.amY).amT = true;
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.amY.oy());
        for (Map.Entry<String, Object> entry : this.amY.amM.oC().entrySet()) {
            aaVar.o(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String rO = aaVar.rO();
        this.amZ = aaVar.sp();
        D q = q(this.amY.getResponseDataClass());
        try {
            q.c(new JSONObject(rO));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishProgress(q);
        if (this.amY.isNeedCache() && this.amZ != null && this.amZ.tq() != null && this.amZ.tq().pv() && q != null && (this.amY.amM instanceof com.baidu.tbadk.mvc.b.e)) {
            com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.amY.amM;
            String cacheKey = eVar.getCacheKey();
            String zR = eVar.zR();
            String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
            if (cacheKey == null || TextUtils.isEmpty(zR) || q == null) {
                return q;
            }
            com.baidu.adp.lib.cache.t<String> S = com.baidu.tbadk.core.b.a.rc().S(zR, currentAccount);
            if (S == null) {
                return q;
            }
            S.f(cacheKey, rO);
        }
        return q;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(D... dArr) {
        Runnable runnable;
        r rVar;
        r rVar2;
        Runnable runnable2;
        super.onProgressUpdate(dArr);
        if (dArr != null && dArr.length > 0) {
            ((NetModel) this.amY).amT = false;
            runnable = ((NetModel) this.amY).amV;
            if (runnable != null) {
                com.baidu.adp.lib.g.i hI = com.baidu.adp.lib.g.i.hI();
                runnable2 = ((NetModel) this.amY).amV;
                hI.removeCallbacks(runnable2);
            }
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.amY.amM, this.amY.ox());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.amY.ox());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            if (this.amZ != null && this.amZ.tq() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.amZ.tq().VY, this.amZ.tq().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.amZ.tq().VZ);
                mvcJsonHttpResponsedMessage.setErrorString(this.amZ.tq().mErrorString);
                if (this.amZ.tq().Wa != null) {
                    BdLog.e(this.amZ.tq().Wa);
                }
            }
            this.amY.Ba();
            rVar = ((NetModel) this.amY).amK;
            if (rVar != null) {
                rVar2 = ((NetModel) this.amY).amK;
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
