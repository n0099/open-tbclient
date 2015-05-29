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
    private NetModel<T, D, ActivityType> aoj;
    private com.baidu.tbadk.core.util.httpNet.a aok;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.p<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k, ActivityType> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public /* synthetic */ void onPostExecute(Object obj) {
        a((p<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.k) obj));
    }

    public p(NetModel<T, D, ActivityType> netModel) {
        this.aoj = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public D doInBackground(Object... objArr) {
        ((NetModel) this.aoj).aoe = true;
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aoj.oO());
        for (Map.Entry<String, Object> entry : this.aoj.anX.oS().entrySet()) {
            aaVar.o(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String sw = aaVar.sw();
        this.aok = aaVar.sX();
        D q = q(this.aoj.getResponseDataClass());
        try {
            q.c(new JSONObject(sw));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishProgress(q);
        if (this.aoj.isNeedCache() && this.aok != null && this.aok.tT() != null && this.aok.tT().qa() && q != null && (this.aoj.anX instanceof com.baidu.tbadk.mvc.b.e)) {
            com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.aoj.anX;
            String cacheKey = eVar.getCacheKey();
            String AJ = eVar.AJ();
            String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
            if (cacheKey == null || TextUtils.isEmpty(AJ) || q == null) {
                return q;
            }
            com.baidu.adp.lib.cache.t<String> W = com.baidu.tbadk.core.b.a.rI().W(AJ, currentAccount);
            if (W == null) {
                return q;
            }
            W.f(cacheKey, sw);
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
            ((NetModel) this.aoj).aoe = false;
            runnable = ((NetModel) this.aoj).aog;
            if (runnable != null) {
                com.baidu.adp.lib.g.i hs = com.baidu.adp.lib.g.i.hs();
                runnable2 = ((NetModel) this.aoj).aog;
                hs.removeCallbacks(runnable2);
            }
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.aoj.anX, this.aoj.oN());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aoj.oN());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            if (this.aok != null && this.aok.tT() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.aok.tT().WH, this.aok.tT().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.aok.tT().WI);
                mvcJsonHttpResponsedMessage.setErrorString(this.aok.tT().mErrorString);
                if (this.aok.tT().WJ != null) {
                    BdLog.e(this.aok.tT().WJ);
                }
            }
            this.aoj.BS();
            rVar = ((NetModel) this.aoj).anV;
            if (rVar != null) {
                rVar2 = ((NetModel) this.aoj).anV;
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
