package com.baidu.tieba.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public final class ag extends com.baidu.adp.a.e {
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

    public final void a(Bundle bundle) {
        bundle.putString("id", this.a);
        bundle.putString("st_type", this.c);
    }

    @Override // com.baidu.adp.a.e
    public final boolean LoadData() {
        if (this.a == null) {
            return false;
        }
        if (this.b == null) {
            this.b = new ah(this, (byte) 0);
            this.b.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }

    public static /* synthetic */ ForumRankData a(ag agVar) {
        ak akVar = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/forumsquarelist");
        akVar.a("list_id", agVar.a);
        akVar.a("st_type", agVar.c);
        return (ForumRankData) new GsonBuilder().create().fromJson(akVar.i(), (Class<Object>) ForumRankData.class);
    }
}
