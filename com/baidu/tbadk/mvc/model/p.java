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
    private NetModel<T, D, ActivityType> ang;
    private com.baidu.tbadk.core.util.httpNet.a anh;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.p<T extends com.baidu.tbadk.mvc.b.i, D extends com.baidu.tbadk.mvc.b.k, ActivityType> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public /* synthetic */ void onPostExecute(Object obj) {
        a((p<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.k) obj));
    }

    public p(NetModel<T, D, ActivityType> netModel) {
        this.ang = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public D doInBackground(Object... objArr) {
        ((NetModel) this.ang).anb = true;
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ang.oy());
        for (Map.Entry<String, Object> entry : this.ang.amU.oC().entrySet()) {
            aaVar.o(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String rO = aaVar.rO();
        this.anh = aaVar.sp();
        D q = q(this.ang.getResponseDataClass());
        try {
            q.c(new JSONObject(rO));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishProgress(q);
        if (this.ang.isNeedCache() && this.anh != null && this.anh.tq() != null && this.anh.tq().pv() && q != null && (this.ang.amU instanceof com.baidu.tbadk.mvc.b.e)) {
            com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.ang.amU;
            String cacheKey = eVar.getCacheKey();
            String zX = eVar.zX();
            String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
            if (cacheKey == null || TextUtils.isEmpty(zX) || q == null) {
                return q;
            }
            com.baidu.adp.lib.cache.t<String> S = com.baidu.tbadk.core.b.a.rc().S(zX, currentAccount);
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
            ((NetModel) this.ang).anb = false;
            runnable = ((NetModel) this.ang).and;
            if (runnable != null) {
                com.baidu.adp.lib.g.i hI = com.baidu.adp.lib.g.i.hI();
                runnable2 = ((NetModel) this.ang).and;
                hI.removeCallbacks(runnable2);
            }
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.ang.amU, this.ang.ox());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.ang.ox());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            if (this.anh != null && this.anh.tq() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.anh.tq().Wa, this.anh.tq().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.anh.tq().Wb);
                mvcJsonHttpResponsedMessage.setErrorString(this.anh.tq().mErrorString);
                if (this.anh.tq().Wc != null) {
                    BdLog.e(this.anh.tq().Wc);
                }
            }
            this.ang.Bg();
            rVar = ((NetModel) this.ang).amS;
            if (rVar != null) {
                rVar2 = ((NetModel) this.ang).amS;
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
