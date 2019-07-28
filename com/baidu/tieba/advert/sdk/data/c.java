package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class c {
    private SharedPreferences dah = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String aDS() {
        return this.dah.getString("splash", "");
    }

    public void sO(String str) {
        SharedPreferences.Editor edit = this.dah.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
