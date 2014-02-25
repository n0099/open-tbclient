package com.baidu.tieba.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.ba;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.a.d {
    private String a;
    private ah b = null;
    private String c;

    public ag(Bundle bundle) {
        this.a = null;
        this.c = null;
        this.a = bundle.getString("id");
        this.c = bundle.getString("st_type");
    }

    public ag(Intent intent) {
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
            this.b = new ah(this, null);
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
        ba baVar = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/forumsquarelist");
        baVar.a("list_id", this.a);
        baVar.a("st_type", this.c);
        return (ForumRankData) new GsonBuilder().create().fromJson(baVar.m(), (Class<Object>) ForumRankData.class);
    }
}
