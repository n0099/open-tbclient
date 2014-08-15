package com.baidu.tieba.im.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestLiveBlackMembersMessage;
import com.baidu.tieba.im.message.RequestLiveGroupOwnerGagMessage;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.e {
    private String a;
    private int b;
    private int c;
    private int d;

    public q(Context context) {
        super(context);
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public String b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int d() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
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

    public void a(String str, int i, int i2) {
        RequestLiveBlackMembersMessage requestLiveBlackMembersMessage = new RequestLiveBlackMembersMessage();
        requestLiveBlackMembersMessage.setGroupId(com.baidu.adp.lib.e.b.a(str, 0L));
        requestLiveBlackMembersMessage.setOffset(i);
        requestLiveBlackMembersMessage.setRn(i2);
        super.sendMessage(requestLiveBlackMembersMessage);
    }

    public void a(String str, int i, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2).append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            StringBuilder sb2 = new StringBuilder();
            if (strArr2 != null && strArr2.length > 0) {
                for (String str3 : strArr2) {
                    sb2.append(str3).append(",");
                }
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            }
            RequestLiveGroupOwnerGagMessage requestLiveGroupOwnerGagMessage = new RequestLiveGroupOwnerGagMessage();
            requestLiveGroupOwnerGagMessage.setGroupId(com.baidu.adp.lib.e.b.a(str, 0));
            requestLiveGroupOwnerGagMessage.setType(i);
            requestLiveGroupOwnerGagMessage.setUserIds(sb.toString());
            requestLiveGroupOwnerGagMessage.setUserNames(sb2.toString());
            sendMessage(requestLiveGroupOwnerGagMessage);
        }
    }

    public void a(Intent intent) {
        this.a = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
    }

    public void b(Bundle bundle) {
        this.a = bundle.getString(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
    }
}
