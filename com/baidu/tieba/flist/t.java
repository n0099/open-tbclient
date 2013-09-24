package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.model.ForumListModel;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f1072a;
    private ForumListModel.RequestParams b;
    private u c;
    private v d;
    private boolean e = true;
    private boolean f = false;

    public t(Context context, ForumListModel.RequestParams requestParams) {
        this.f1072a = context;
        this.b = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.b = requestParams;
    }

    public void a(u uVar) {
        this.c = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.c
    public boolean LoadData() {
        this.d = new v(this, null);
        this.d.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.d == null) {
            return false;
        }
        this.d.cancel();
        return true;
    }
}
