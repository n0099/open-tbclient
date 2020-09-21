package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes22.dex */
public class c {
    private SharedPreferences mSharedPreferences = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String bDo() {
        return this.mSharedPreferences.getString("splash", "");
    }

    public void Et(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
