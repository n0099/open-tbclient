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
    private NetModel<T, D, ActivityType> aeE;
    private com.baidu.tbadk.core.util.httpNet.c aeF;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.p<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public /* synthetic */ void onPostExecute(Object obj) {
        a((p<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
    }

    public p(NetModel<T, D, ActivityType> netModel) {
        this.aeE = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public D doInBackground(Object... objArr) {
        com.baidu.tbadk.mvc.b.h hVar;
        com.baidu.tbadk.mvc.b.h hVar2;
        com.baidu.tbadk.mvc.b.h hVar3;
        ((NetModel) this.aeE).aez = true;
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aeE.kF());
        hVar = ((NetModel) this.aeE).aes;
        for (Map.Entry<String, Object> entry : hVar.kJ().entrySet()) {
            adVar.o(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String or = adVar.or();
        this.aeF = adVar.oS();
        D q = q(this.aeE.getResponseDataClass());
        try {
            q.c(new JSONObject(or));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishProgress(q);
        if (this.aeE.isNeedCache() && this.aeF != null && this.aeF.qa() != null && this.aeF.qa().lT() && q != null) {
            hVar2 = ((NetModel) this.aeE).aes;
            if (hVar2 instanceof com.baidu.tbadk.mvc.b.e) {
                hVar3 = ((NetModel) this.aeE).aes;
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) hVar3;
                String cacheKey = eVar.getCacheKey();
                String lj = eVar.lj();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(lj) || q == null) {
                    return q;
                }
                com.baidu.adp.lib.cache.t<String> R = com.baidu.tbadk.core.a.a.nO().R(lj, currentAccount);
                if (R == null) {
                    return q;
                }
                R.f(cacheKey, or);
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
            ((NetModel) this.aeE).aez = false;
            runnable = ((NetModel) this.aeE).aeB;
            if (runnable != null) {
                com.baidu.adp.lib.g.i ej = com.baidu.adp.lib.g.i.ej();
                runnable2 = ((NetModel) this.aeE).aeB;
                ej.removeCallbacks(runnable2);
            }
            hVar = ((NetModel) this.aeE).aes;
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(hVar, this.aeE.kE());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aeE.kE());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            if (this.aeF != null && this.aeF.qa() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.aeF.qa().Ky, this.aeF.qa().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.aeF.qa().Kz);
                mvcJsonHttpResponsedMessage.setErrorString(this.aeF.qa().mErrorString);
                if (this.aeF.qa().KA != null) {
                    BdLog.e(this.aeF.qa().KA);
                }
            }
            this.aeE.xM();
            rVar = ((NetModel) this.aeE).aeq;
            if (rVar != null) {
                rVar2 = ((NetModel) this.aeE).aeq;
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
