package com.baidu.tieba.im.live.room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.im.message.RequestLiveGroupLikeListMessage;
import java.util.LinkedList;
import java.util.List;
import protobuf.QueryLiveGroupLikeList.LikeUserInfo;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.e {
    private String a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private RequestLiveGroupLikeListMessage g;
    private List<LikeUserInfo> h;

    public d(Context context) {
        super(context);
        this.d = 0;
        this.e = 20;
        this.h = new LinkedList();
    }

    public LikeUserInfo a(int i) {
        if (this.h == null) {
            return null;
        }
        return this.h.get(i);
    }

    public int a() {
        return this.d + 1;
    }

    public List<LikeUserInfo> b() {
        return this.h;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public int e() {
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

    public void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getString(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
            this.b = bundle.getInt("likers");
            this.c = bundle.getInt(com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
            return;
        }
        this.a = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
        this.b = intent.getIntExtra("likers", 0);
        this.c = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0);
    }

    public void f() {
        if (this.g == null) {
            this.g = new RequestLiveGroupLikeListMessage();
            this.g.mGroupId = this.c;
            this.g.mOffset = this.d;
            this.g.mRn = this.e;
            sendMessage(this.g);
        }
    }

    public void g() {
        this.g = null;
    }

    public boolean h() {
        return this.d == 0;
    }

    public void i() {
        this.d++;
        this.d *= this.e;
        f();
    }
}
