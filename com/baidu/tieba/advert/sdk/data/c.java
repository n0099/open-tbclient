package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class c {
    private SharedPreferences dca = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String aEy() {
        return this.dca.getString("splash", "");
    }

    public void tn(String str) {
        SharedPreferences.Editor edit = this.dca.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
