package com.baidu.tieba.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.e {
    private String a;
    private ah b = null;
    private String c;

    public ag(Bundle bundle) {
        this.a = null;
        this.c = null;
        this.a = bundle.getString("id");
        this.c = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
    }

    public ag(Intent intent) {
        this.a = null;
        this.c = null;
        this.a = intent.getStringExtra("id");
        this.c = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
    }

    public void a(Bundle bundle) {
        bundle.putString("id", this.a);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.c);
    }

    @Override // com.baidu.adp.base.e
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

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }

    public ForumRankData a() {
        aq aqVar = new aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumsquarelist");
        aqVar.a("list_id", this.a);
        aqVar.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.c);
        return (ForumRankData) new GsonBuilder().create().fromJson(aqVar.i(), (Class<Object>) ForumRankData.class);
    }
}
