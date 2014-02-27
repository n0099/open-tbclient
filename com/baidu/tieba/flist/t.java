package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
public final class t extends com.baidu.adp.a.d {
    private Context a;
    private ForumListModel.RequestParams b;
    private u c;
    private v d;
    private boolean e = true;
    private boolean f = false;

    public t(Context context, ForumListModel.RequestParams requestParams) {
        this.a = context;
        this.b = requestParams;
    }

    public final void a(ForumListModel.RequestParams requestParams) {
        this.b = requestParams;
    }

    public final void a(u uVar) {
        this.c = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public final boolean LoadData() {
        this.d = new v(this, (byte) 0);
        this.d.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.d == null) {
            return false;
        }
        this.d.cancel();
        return true;
    }
}
