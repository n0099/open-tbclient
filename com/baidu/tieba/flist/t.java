package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.b {
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

    public void a(ForumListModel.RequestParams requestParams) {
        this.b = requestParams;
    }

    public void a(u uVar) {
        this.c = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.b
    public boolean LoadData() {
        this.d = new v(this, null);
        this.d.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.d == null) {
            return false;
        }
        this.d.cancel();
        return true;
    }
}
