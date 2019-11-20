package com.baidu.tieba.advert.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes5.dex */
public class c {
    private SharedPreferences dkG = TbadkCoreApplication.getInst().getContext().getSharedPreferences("bc_splash_info", 0);

    public c(Context context) {
    }

    public String aEG() {
        return this.dkG.getString("splash", "");
    }

    public void rW(String str) {
        SharedPreferences.Editor edit = this.dkG.edit();
        edit.putString("splash", str);
        edit.commit();
    }
}
