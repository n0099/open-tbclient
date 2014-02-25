package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
    final /* synthetic */ bc a;
    private int b;
    private com.baidu.tieba.util.ba c;
    private volatile boolean d;

    private bd(bc bcVar) {
        this.a = bcVar;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(bc bcVar, bd bdVar) {
        this(bcVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
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
                this.c = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/e/faces/getpacklist");
                if (this.b == 1) {
                    this.a.c = 0;
                } else if (this.b == 2) {
                    bc bcVar = this.a;
                    i = bcVar.c;
                    bcVar.c = i + 1;
                }
                com.baidu.tieba.util.ba baVar = this.c;
                i2 = this.a.f;
                baVar.a("scr_w", String.valueOf(i2));
                com.baidu.tieba.util.ba baVar2 = this.c;
                i3 = this.a.g;
                baVar2.a("scr_h", String.valueOf(i3));
                com.baidu.tieba.util.ba baVar3 = this.c;
                f = this.a.h;
                baVar3.a("scr_dip", String.valueOf(f));
                com.baidu.tieba.util.ba baVar4 = this.c;
                i4 = this.a.c;
                baVar4.a("offset", String.valueOf(i4));
                this.c.a("limit", String.valueOf(10));
                com.baidu.tieba.util.ba baVar5 = this.c;
                str = this.a.d;
                baVar5.a("st_type", str);
                return (FaceShopData) new GsonBuilder().create().fromJson(this.c.m(), (Class<Object>) FaceShopData.class);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.toString());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(FaceShopData faceShopData) {
        com.baidu.adp.a.g gVar;
        FaceShopData faceShopData2;
        FaceShopData faceShopData3;
        super.a((bd) faceShopData);
        this.a.b = null;
        if (faceShopData != null) {
            this.a.e = faceShopData.hasMore == 1;
            if (this.b == 1) {
                this.a.a = faceShopData;
            } else if (this.b == 2) {
                faceShopData3 = this.a.a;
                faceShopData3.add(faceShopData);
            }
        }
        gVar = this.a.mLoadDataCallBack;
        faceShopData2 = this.a.a;
        gVar.a(faceShopData2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.d = true;
        if (this.c != null) {
            this.c.k();
            this.c = null;
        }
        this.a.b = null;
    }
}
