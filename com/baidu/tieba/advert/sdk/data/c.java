package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class c {
    private SharedPreferences dao = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String aDU() {
        return this.dao.getString("splash", "");
    }

    public void sO(String str) {
        SharedPreferences.Editor edit = this.dao.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
