package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<Object, g, JSONObject> {
    ArrayList<BasicNameValuePair> a;
    j b;
    final /* synthetic */ g c;
    private com.baidu.tbadk.core.util.ak d = null;
    private String e;
    private String f;
    private int g;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ JSONObject a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(JSONObject jSONObject) {
        cx cxVar;
        cx cxVar2;
        JSONObject jSONObject2 = jSONObject;
        if (this.d != null) {
            this.b.a = true;
            this.b.b = this.d.c();
            this.b.c = this.d.d();
            this.b.d = this.d.f();
            this.b.e = this.d.b();
        }
        cxVar = this.c.j;
        if (cxVar != null) {
            cxVar2 = this.c.j;
            cxVar2.a(this.g, jSONObject2, this.b);
        }
        this.c.m = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(g... gVarArr) {
        cx cxVar;
        cx cxVar2;
        g[] gVarArr2 = gVarArr;
        cxVar = this.c.j;
        if (cxVar != null) {
            cxVar2 = this.c.j;
            cxVar2.a(gVarArr2.length > 0 ? gVarArr2[0] : null);
        }
    }

    public k(g gVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.c = gVar;
        this.e = null;
        this.f = null;
        this.g = 3;
        this.a = null;
        this.b = new j(gVar);
        this.e = str;
        this.f = str2;
        this.a = arrayList;
        this.g = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        cx cxVar;
        cx cxVar2;
        cxVar = this.c.j;
        if (cxVar != null) {
            cxVar2 = this.c.j;
            cxVar2.a(this.g);
        }
    }

    private JSONObject a() {
        JSONObject jSONObject;
        Exception e;
        boolean z;
        boolean z2;
        ForumData forumData;
        ForumData forumData2;
        try {
            z = this.c.o;
            if (z && f.a().a(this.f)) {
                if (!f.a().c(String.valueOf(TbadkApplication.E()) + this.f)) {
                    f.a().b().f().getSignData().setIsSigned(0);
                }
                c((Object[]) new g[]{f.a().b()});
            }
            this.c.p = System.currentTimeMillis();
            this.d = new com.baidu.tbadk.core.util.ak(this.e);
            this.d.a(this.a);
            String i = this.d.i();
            jSONObject = new JSONObject(i);
            try {
                this.c.q = this.d.a().c().a.d;
                this.c.r = this.d.a().c().a.c;
                this.c.s = System.currentTimeMillis();
                if (this.d.a().b().b()) {
                    this.c.a(i);
                    z2 = this.c.o;
                    if (z2) {
                        forumData = this.c.a;
                        if (forumData != null) {
                            f a = f.a();
                            forumData2 = this.c.a;
                            a.a(forumData2.getName(), i);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "FrsAsyncTask.doInBackground error = " + e.getMessage());
                return jSONObject;
            }
        } catch (Exception e3) {
            jSONObject = null;
            e = e3;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        super.d();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        cx cxVar;
        cx cxVar2;
        super.cancel(true);
        if (this.d != null) {
            this.d.g();
        }
        cxVar = this.c.j;
        if (cxVar != null) {
            cxVar2 = this.c.j;
            cxVar2.a(this.g, null, null);
        }
    }
}
