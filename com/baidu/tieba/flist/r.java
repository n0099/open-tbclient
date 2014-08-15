package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e {
    private Context a;
    private ForumListModel.RequestParams b;
    private s c;
    private t d;
    private boolean e = true;
    private boolean f = false;

    public r(Context context, ForumListModel.RequestParams requestParams) {
        this.a = context;
        this.b = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.b = requestParams;
    }

    public void a(s sVar) {
        this.c = sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.d = new t(this, null);
        this.d.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.d == null) {
            return false;
        }
        this.d.cancel();
        return true;
    }
}
