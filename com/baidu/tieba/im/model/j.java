package com.baidu.tieba.im.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestFrsLiveListMessage;
import com.baidu.tieba.im.message.RequestOperateFrsLiveListMessage;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private String a;
    private boolean b;
    private int c;
    private int d;

    public j(Context context) {
        super(context);
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int d() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Bundle bundle) {
    }

    private RequestFrsLiveListMessage b(String str, int i, int i2, int i3) {
        RequestFrsLiveListMessage requestFrsLiveListMessage = new RequestFrsLiveListMessage();
        requestFrsLiveListMessage.setForumId(com.baidu.adp.lib.e.b.a(str, 0));
        requestFrsLiveListMessage.setType(i3);
        requestFrsLiveListMessage.setOffset(i);
        requestFrsLiveListMessage.setRn(i2);
        return requestFrsLiveListMessage;
    }

    public void a(String str, int i, int i2, int i3) {
        super.sendMessage(b(str, i, i2, i3));
    }

    public void a(String str, String str2, int i, int i2) {
        RequestOperateFrsLiveListMessage requestOperateFrsLiveListMessage = new RequestOperateFrsLiveListMessage();
        requestOperateFrsLiveListMessage.setForumId(com.baidu.adp.lib.e.b.a(str, 0));
        requestOperateFrsLiveListMessage.setGroupId(com.baidu.adp.lib.e.b.a(str2, 0));
        requestOperateFrsLiveListMessage.setType(i);
        requestOperateFrsLiveListMessage.setOldType(i2);
        super.sendMessage(requestOperateFrsLiveListMessage);
    }

    public void a(Intent intent) {
        this.a = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID);
        this.b = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.FRS_MANAGER, false);
    }

    public void b(Bundle bundle) {
    }
}
