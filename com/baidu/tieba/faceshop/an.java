package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class an extends com.baidu.adp.base.b {
    private boolean a;
    private int b;
    private String c;
    private String d;
    private String f;
    private FacePackageDetailData h;
    private int j;
    private int k;
    private float l;
    private String e = null;
    private BaseActivity.LoadDataCallBack m = null;
    private ao i = null;
    private GsonBuilder g = new GsonBuilder();

    public an() {
        this.j = 0;
        this.k = 0;
        Context e = com.baidu.tieba.ai.c().e();
        this.j = com.baidu.adp.lib.util.k.b(e);
        this.k = com.baidu.adp.lib.util.k.c(e);
        this.l = e.getResources().getDisplayMetrics().density;
    }

    public FacePackageDetailData a() {
        return this.h;
    }

    public void a(String str) {
        this.e = str;
    }

    public String b() {
        return this.e;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    public void b(String str) {
        this.d = str;
    }

    public String e() {
        return this.d;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public String f() {
        return this.f;
    }

    public void g() {
        if (this.i == null) {
            this.i = new ao(this, null);
            this.i.setPriority(3);
            this.i.execute(new Object[0]);
        }
    }

    public void a(FacePackageData facePackageData) {
        if (facePackageData != null) {
            int i = facePackageData.buyStatus;
            int i2 = facePackageData.canDownload;
            int i3 = facePackageData.downloading;
            int i4 = facePackageData.downloaded;
            if (i3 == 1) {
                this.b = 5;
            } else if (i4 == 1) {
                this.b = 1;
            } else if (i == 2) {
                this.b = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    this.b = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    this.b = 3;
                } else {
                    this.b = 4;
                }
            }
        }
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.i != null) {
            this.i.cancel();
            return true;
        }
        return true;
    }

    public void a(BaseActivity.LoadDataCallBack loadDataCallBack) {
        this.m = loadDataCallBack;
    }
}
