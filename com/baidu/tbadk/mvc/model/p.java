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
    private NetModel<T, D, ActivityType> aek;
    private com.baidu.tbadk.core.util.httpNet.c ael;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.p<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public /* synthetic */ void onPostExecute(Object obj) {
        a((p<T, D, ActivityType>) ((com.baidu.tbadk.mvc.b.j) obj));
    }

    public p(NetModel<T, D, ActivityType> netModel) {
        this.aek = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public D doInBackground(Object... objArr) {
        com.baidu.tbadk.mvc.b.h hVar;
        com.baidu.tbadk.mvc.b.h hVar2;
        com.baidu.tbadk.mvc.b.h hVar3;
        ((NetModel) this.aek).aef = true;
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aek.kM());
        hVar = ((NetModel) this.aek).adY;
        for (Map.Entry<String, Object> entry : hVar.kQ().entrySet()) {
            adVar.o(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String ov = adVar.ov();
        this.ael = adVar.oW();
        D q = q(this.aek.getResponseDataClass());
        try {
            q.c(new JSONObject(ov));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishProgress(q);
        if (this.aek.isNeedCache() && this.ael != null && this.ael.pW() != null && this.ael.pW().ma() && q != null) {
            hVar2 = ((NetModel) this.aek).adY;
            if (hVar2 instanceof com.baidu.tbadk.mvc.b.e) {
                hVar3 = ((NetModel) this.aek).adY;
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) hVar3;
                String cacheKey = eVar.getCacheKey();
                String lq = eVar.lq();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(lq) || q == null) {
                    return q;
                }
                com.baidu.adp.lib.cache.t<String> O = com.baidu.tbadk.core.a.a.nS().O(lq, currentAccount);
                if (O == null) {
                    return q;
                }
                O.f(cacheKey, ov);
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
            ((NetModel) this.aek).aef = false;
            runnable = ((NetModel) this.aek).aeh;
            if (runnable != null) {
                com.baidu.adp.lib.g.i el = com.baidu.adp.lib.g.i.el();
                runnable2 = ((NetModel) this.aek).aeh;
                el.removeCallbacks(runnable2);
            }
            hVar = ((NetModel) this.aek).adY;
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(hVar, this.aek.kL());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.aek.kL());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            if (this.ael != null && this.ael.pW() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.ael.pW().Ki, this.ael.pW().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.ael.pW().Kj);
                mvcJsonHttpResponsedMessage.setErrorString(this.ael.pW().mErrorString);
                if (this.ael.pW().Kk != null) {
                    BdLog.e(this.ael.pW().Kk);
                }
            }
            this.aek.xC();
            rVar = ((NetModel) this.aek).adW;
            if (rVar != null) {
                rVar2 = ((NetModel) this.aek).adW;
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
