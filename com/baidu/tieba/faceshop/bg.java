package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends BdAsyncTask<Object, FaceShopData, FaceShopData> {
    final /* synthetic */ be a;
    private int b;
    private com.baidu.tieba.util.ax c;
    private volatile boolean d;

    private bg(be beVar) {
        this.a = beVar;
        this.d = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public FaceShopData a(Object... objArr) {
        int i;
        int i2;
        float f;
        int i3;
        String str;
        this.b = ((Integer) objArr[0]).intValue();
        try {
            if (!this.d) {
                this.c = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/e/faces/getpacklist");
                if (this.b == 1) {
                    this.a.c = 0;
                } else if (this.b == 2) {
                    be.a(this.a);
                }
                com.baidu.tieba.util.ax axVar = this.c;
                i = this.a.f;
                axVar.a("scr_w", String.valueOf(i));
                com.baidu.tieba.util.ax axVar2 = this.c;
                i2 = this.a.g;
                axVar2.a("scr_h", String.valueOf(i2));
                com.baidu.tieba.util.ax axVar3 = this.c;
                f = this.a.h;
                axVar3.a("scr_dip", String.valueOf(f));
                com.baidu.tieba.util.ax axVar4 = this.c;
                i3 = this.a.c;
                axVar4.a("offset", String.valueOf(i3));
                this.c.a("limit", String.valueOf(10));
                com.baidu.tieba.util.ax axVar5 = this.c;
                str = this.a.d;
                axVar5.a("st_type", str);
                return (FaceShopData) new GsonBuilder().create().fromJson(this.c.m(), (Class<Object>) FaceShopData.class);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.toString());
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
        super.a((bg) faceShopData);
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
