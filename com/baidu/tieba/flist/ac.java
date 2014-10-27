package com.baidu.tieba.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.e {
    private ad awQ;
    private String id;
    private String stType;

    public ac(Bundle bundle) {
        super(null);
        this.id = null;
        this.awQ = null;
        this.stType = null;
        this.id = bundle.getString("id");
        this.stType = bundle.getString("st_type");
    }

    public ac(Intent intent) {
        super(null);
        this.id = null;
        this.awQ = null;
        this.stType = null;
        this.id = intent.getStringExtra("id");
        this.stType = intent.getStringExtra("st_type");
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString("id", this.id);
        bundle.putString("st_type", this.stType);
    }

    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.id == null) {
            return false;
        }
        if (this.awQ == null) {
            this.awQ = new ad(this, null);
            this.awQ.execute(new Void[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.awQ != null) {
            this.awQ.cancel();
            return false;
        }
        return false;
    }

    public ForumRankData DW() {
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumsquarelist");
        acVar.k("list_id", this.id);
        acVar.k("st_type", this.stType);
        return (ForumRankData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(acVar.lA(), ForumRankData.class);
    }
}
