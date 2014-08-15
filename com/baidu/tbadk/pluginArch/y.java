package com.baidu.tbadk.pluginArch;

import android.text.TextUtils;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* loaded from: classes.dex */
public class y {
    public static boolean a(String str) {
        ConfigInfos.PluginConfig b;
        c a;
        return (TextUtils.isEmpty(str) || (b = d.a().b(str)) == null || b.newest == null || (a = d.a().a(str)) == null || b.newest.version <= a.e()) ? false : true;
    }
}
