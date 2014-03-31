package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bt extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
    final /* synthetic */ bs a;
    private int b;
    private com.baidu.tbadk.core.util.ak c;
    private volatile boolean d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(FaceShopData faceShopData) {
        com.baidu.adp.a.h hVar;
        FaceShopData faceShopData2;
        FaceShopData faceShopData3;
        FaceShopData faceShopData4 = faceShopData;
        super.a((bt) faceShopData4);
        this.a.b = null;
        if (faceShopData4 != null) {
            this.a.e = faceShopData4.hasMore == 1;
            if (this.b == 1) {
                this.a.a = faceShopData4;
            } else if (this.b == 2) {
                faceShopData3 = this.a.a;
                faceShopData3.add(faceShopData4);
            }
        }
        hVar = this.a.mLoadDataCallBack;
        faceShopData2 = this.a.a;
        hVar.a(faceShopData2);
    }

    private bt(bs bsVar) {
        this.a = bsVar;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bt(bs bsVar, byte b) {
        this(bsVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FaceShopData a(Object... objArr) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        String str;
        this.b = ((Integer) objArr[0]).intValue();
        try {
            if (!this.d) {
                this.c = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/e/faces/getpacklist");
                if (this.b == 1) {
                    this.a.c = 0;
                } else if (this.b == 2) {
                    bs bsVar = this.a;
                    i = bsVar.c;
                    bsVar.c = i + 1;
                }
                com.baidu.tbadk.core.util.ak akVar = this.c;
                i2 = this.a.f;
                akVar.a("scr_w", String.valueOf(i2));
                com.baidu.tbadk.core.util.ak akVar2 = this.c;
                i3 = this.a.g;
                akVar2.a("scr_h", String.valueOf(i3));
                com.baidu.tbadk.core.util.ak akVar3 = this.c;
                f = this.a.h;
                akVar3.a("scr_dip", String.valueOf(f));
                com.baidu.tbadk.core.util.ak akVar4 = this.c;
                i4 = this.a.c;
                akVar4.a("offset", String.valueOf(i4));
                this.c.a("limit", String.valueOf(10));
                com.baidu.tbadk.core.util.ak akVar5 = this.c;
                str = this.a.d;
                akVar5.a("st_type", str);
                return (FaceShopData) new GsonBuilder().create().fromJson(this.c.i(), (Class<Object>) FaceShopData.class);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.d = true;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        this.a.b = null;
    }
}
