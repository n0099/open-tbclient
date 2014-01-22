package com.baidu.tieba.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ax;
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.a.d {
    private String a;
    private ak b = null;
    private String c;

    public ai(Bundle bundle) {
        this.a = null;
        this.c = null;
        this.a = bundle.getString("id");
        this.c = bundle.getString("st_type");
    }

    public ai(Intent intent) {
        this.a = null;
        this.c = null;
        this.a = intent.getStringExtra("id");
        this.c = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        bundle.putString("id", this.a);
        bundle.putString("st_type", this.c);
    }

    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.a == null) {
            return false;
        }
        if (this.b == null) {
            this.b = new ak(this);
            this.b.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }

    public ForumRankData a() {
        ax axVar = new ax(com.baidu.tieba.data.h.a + "c/f/forum/forumsquarelist");
        axVar.a("list_id", this.a);
        axVar.a("st_type", this.c);
        return (ForumRankData) new GsonBuilder().create().fromJson(axVar.m(), (Class<Object>) ForumRankData.class);
    }
}
