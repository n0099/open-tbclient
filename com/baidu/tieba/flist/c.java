package com.baidu.tieba.flist;

import android.content.Context;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private d avg;
    private e avh;
    private String avi;
    private String avj;
    private String avk;
    private boolean avl;
    private boolean avm;

    public c(Context context, String str, String str2, String str3) {
        super(context);
        this.avl = false;
        this.avm = false;
        this.avi = str;
        this.avj = str2;
        this.avk = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.avg = new d(this, null);
        this.avg.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.avg != null) {
            this.avg.cancel();
            return false;
        }
        return false;
    }

    public void a(e eVar) {
        this.avh = eVar;
    }
}
