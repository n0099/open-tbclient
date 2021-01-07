package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes8.dex */
public class c {
    private SharedPreferences mSharedPreferences = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String bPO() {
        return this.mSharedPreferences.getString("splash", "");
    }

    public void FX(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
