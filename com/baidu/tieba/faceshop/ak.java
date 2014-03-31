package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.gson.GsonBuilder;
/* loaded from: classes.dex */
public final class ak extends com.baidu.adp.a.e {
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
    private com.baidu.tbadk.d m = null;
    private al i = null;
    private GsonBuilder g = new GsonBuilder();

    public ak() {
        this.j = 0;
        this.k = 0;
        com.baidu.tieba.r.c();
        Context e = com.baidu.tieba.r.e();
        this.j = com.baidu.adp.lib.util.i.b(e);
        this.k = com.baidu.adp.lib.util.i.c(e);
        this.l = e.getResources().getDisplayMetrics().density;
    }

    public final FacePackageDetailData a() {
        return this.h;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final String b() {
        return this.e;
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final boolean c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final String e() {
        return this.d;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.f = str;
    }

    public final String f() {
        return this.f;
    }

    public final void g() {
        if (this.i == null) {
            this.i = new al(this, (byte) 0);
            this.i.setPriority(3);
            this.i.execute(new Object[0]);
        }
    }

    public final void a(FacePackageData facePackageData) {
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

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.i != null) {
            this.i.cancel();
            return true;
        }
        return true;
    }

    public final void a(com.baidu.tbadk.d dVar) {
        this.m = dVar;
    }
}
