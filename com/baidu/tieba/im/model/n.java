package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestGroupLevelMessage;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.d {
    private long a;

    public long a() {
        return this.a;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.a = intent.getLongExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0L);
    }

    public void a(Bundle bundle) {
        this.a = bundle.getLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
    }

    private RequestGroupLevelMessage a(long j) {
        RequestGroupLevelMessage requestGroupLevelMessage = new RequestGroupLevelMessage();
        requestGroupLevelMessage.setGroupId(j);
        return requestGroupLevelMessage;
    }

    public void a(long j, int i) {
        RequestGroupLevelMessage a = a(j);
        if (a.getTag() == 0) {
            a.setTag(i);
        }
        super.sendMessage(a);
    }

    public void b(Bundle bundle) {
        bundle.putLong(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, this.a);
    }
}
