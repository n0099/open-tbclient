package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.model.ForumListModel;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private Context f1204a;
    private ForumListModel.RequestParams b;
    private v c;
    private w d;
    private boolean e = true;
    private boolean f = false;

    public t(Context context, ForumListModel.RequestParams requestParams) {
        this.f1204a = context;
        this.b = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.b = requestParams;
    }

    public void a(v vVar) {
        this.c = vVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        this.d = new w(this);
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
