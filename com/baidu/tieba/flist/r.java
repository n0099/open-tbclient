package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.tieba.flist.ForumListModel;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.e {
    private boolean avd;
    private ForumListModel.RequestParams avz;
    private s awf;
    private t awg;
    private boolean isFirst;
    private Context mContext;

    public r(Context context, ForumListModel.RequestParams requestParams) {
        super(context);
        this.isFirst = true;
        this.avd = false;
        this.mContext = context;
        this.avz = requestParams;
    }

    public void a(ForumListModel.RequestParams requestParams) {
        this.avz = requestParams;
    }

    public void a(s sVar) {
        this.awf = sVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.awg = new t(this, null);
        this.awg.execute(new Void[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.awg == null) {
            return false;
        }
        this.awg.cancel();
        return true;
    }
}
