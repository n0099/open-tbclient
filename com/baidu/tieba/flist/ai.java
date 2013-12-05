package com.baidu.tieba.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.util.am;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.a.d {

    /* renamed from: a */
    private String f1296a;
    private ak b = null;
    private String c;

    public ai(Bundle bundle) {
        this.f1296a = null;
        this.c = null;
        this.f1296a = bundle.getString(LocaleUtil.INDONESIAN);
        this.c = bundle.getString("st_type");
    }

    public ai(Intent intent) {
        this.f1296a = null;
        this.c = null;
        this.f1296a = intent.getStringExtra(LocaleUtil.INDONESIAN);
        this.c = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        bundle.putString(LocaleUtil.INDONESIAN, this.f1296a);
        bundle.putString("st_type", this.c);
    }

    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.f1296a == null) {
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
        am amVar = new am(com.baidu.tieba.data.h.f1248a + "c/f/forum/forumsquarelist");
        amVar.a("list_id", this.f1296a);
        amVar.a("st_type", this.c);
        return (ForumRankData) new GsonBuilder().create().fromJson(amVar.l(), (Class<Object>) ForumRankData.class);
    }
}
