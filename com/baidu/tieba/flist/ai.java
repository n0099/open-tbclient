package com.baidu.tieba.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tieba.util.ap;
import com.google.gson.GsonBuilder;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.a.d {

    /* renamed from: a */
    private String f1244a;
    private ak b = null;
    private String c;

    public ai(Bundle bundle) {
        this.f1244a = null;
        this.c = null;
        this.f1244a = bundle.getString(LocaleUtil.INDONESIAN);
        this.c = bundle.getString("st_type");
    }

    public ai(Intent intent) {
        this.f1244a = null;
        this.c = null;
        this.f1244a = intent.getStringExtra(LocaleUtil.INDONESIAN);
        this.c = intent.getStringExtra("st_type");
    }

    public void a(Bundle bundle) {
        bundle.putString(LocaleUtil.INDONESIAN, this.f1244a);
        bundle.putString("st_type", this.c);
    }

    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.f1244a == null) {
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
        ap apVar = new ap(com.baidu.tieba.data.h.f1196a + "c/f/forum/forumsquarelist");
        apVar.a("list_id", this.f1244a);
        apVar.a("st_type", this.c);
        return (ForumRankData) new GsonBuilder().create().fromJson(apVar.j(), (Class<Object>) ForumRankData.class);
    }
}
