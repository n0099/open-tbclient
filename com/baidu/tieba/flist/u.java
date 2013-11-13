package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private Context f1263a;
    private ForumListModel.RequestParams b;
    private w c;
    private x d;
    private boolean e = true;
    private boolean f = false;

    public u(Context context, ForumListModel.RequestParams requestParams) {
        this.f1263a = context;
        this.b = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.b = requestParams;
    }

    public void a(w wVar) {
        this.c = wVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        this.d = new x(this);
        this.d.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.d == null) {
            return false;
        }
        this.d.cancel();
        return true;
    }
}
