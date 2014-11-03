package com.baidu.tbadk.mvc.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.mvc.b.g;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h<T extends com.baidu.tbadk.mvc.b.g, D extends com.baidu.tbadk.mvc.b.i> extends BdAsyncTask<Object, Object, D> {
    private NetModel<T, D> XY;

    public h(NetModel<T, D> netModel) {
        this.XY = netModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public D doInBackground(Object... objArr) {
        com.baidu.tbadk.mvc.b.g gVar;
        ac acVar = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + this.XY.tM());
        gVar = ((NetModel) this.XY).XQ;
        for (Map.Entry<String, Object> entry : gVar.tq().entrySet()) {
            acVar.k(entry.getKey(), String.valueOf(entry.getValue()));
        }
        String lA = acVar.lA();
        D g = g(this.XY.getResponseDataClass());
        try {
            g.d(new JSONObject(lA));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(D d) {
        com.baidu.tbadk.mvc.b.g gVar;
        j jVar;
        j jVar2;
        super.onPostExecute(d);
        gVar = ((NetModel) this.XY).XQ;
        MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(gVar, this.XY.tK());
        MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.XY.tK());
        jVar = ((NetModel) this.XY).XO;
        if (jVar != null) {
            jVar2 = ((NetModel) this.XY).XO;
            jVar2.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    protected D g(Class<D> cls) {
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
