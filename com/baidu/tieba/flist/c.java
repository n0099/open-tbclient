package com.baidu.tieba.flist;

import android.content.Context;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private d auX;
    private e auY;
    private String auZ;
    private String ava;
    private String avb;
    private boolean avc;
    private boolean avd;

    public c(Context context, String str, String str2, String str3) {
        super(context);
        this.avc = false;
        this.avd = false;
        this.auZ = str;
        this.ava = str2;
        this.avb = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.auX = new d(this, null);
        this.auX.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.auX != null) {
            this.auX.cancel();
            return false;
        }
        return false;
    }

    public void a(e eVar) {
        this.auY = eVar;
    }
}
