package com.baidu.tieba.im.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.im.message.RequestGroupLevelMessage;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.e {
    private long a;
    private boolean b;

    public l(Context context) {
        super(context);
    }

    public long a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        if (intent != null) {
            this.a = intent.getLongExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0L);
            this.b = intent.getBooleanExtra("is_mem", false);
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
            this.b = bundle.getBoolean("is_mem");
        }
    }

    private RequestGroupLevelMessage a(long j) {
        RequestGroupLevelMessage requestGroupLevelMessage = new RequestGroupLevelMessage();
        requestGroupLevelMessage.setGroupId(j);
        return requestGroupLevelMessage;
    }

    public void a(long j, BdUniqueId bdUniqueId) {
        RequestGroupLevelMessage a = a(j);
        if (a.getTag() == null) {
            a.setTag(bdUniqueId);
        }
        super.sendMessage(a);
    }

    public void b(Bundle bundle) {
        if (bundle != null) {
            bundle.putLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, this.a);
            bundle.putBoolean("is_mem", this.b);
        }
    }
}
