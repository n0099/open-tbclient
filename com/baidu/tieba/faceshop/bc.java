package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.a.d {
    private String d;
    private int f;
    private int g;
    private float h;
    private bd b = null;
    private FaceShopData a = null;
    private boolean e = false;
    private int c = 0;

    public bc() {
        this.f = 0;
        this.g = 0;
        Context c = TiebaApplication.g().c();
        this.f = BdUtilHelper.b(c);
        this.g = BdUtilHelper.c(c);
        this.h = c.getResources().getDisplayMetrics().density;
    }

    public FaceShopData a() {
        return this.a;
    }

    public boolean b() {
        return this.e;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(int i) {
        if (this.b == null) {
            this.b = new bd(this, null);
            this.b.setPriority(3);
            this.b.execute(Integer.valueOf(i));
        }
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return true;
    }
}
