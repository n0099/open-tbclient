package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e {
    private ForumListModel.RequestParams avI;
    private boolean avm;
    private s awo;
    private t awp;
    private boolean isFirst;
    private Context mContext;

    public r(Context context, ForumListModel.RequestParams requestParams) {
        super(context);
        this.isFirst = true;
        this.avm = false;
        this.mContext = context;
        this.avI = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.avI = requestParams;
    }

    public void a(s sVar) {
        this.awo = sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.awp = new t(this, null);
        this.awp.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.awp == null) {
            return false;
        }
        this.awp.cancel();
        return true;
    }
}
