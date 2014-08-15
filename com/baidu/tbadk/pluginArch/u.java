package com.baidu.tbadk.pluginArch;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
/* loaded from: classes.dex */
public class u {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PLUGIN_NET_CONFIGS;
    private ConfigInfos b;
    private v c;
    private boolean d;

    public ConfigInfos a() {
        return this.b;
    }

    public void a(ConfigInfos configInfos) {
        this.b = configInfos;
    }

    public ConfigInfos a(v vVar) {
        this.c = vVar;
        if (this.b == null && !this.d) {
            this.d = true;
            new w(this, null).execute(new Void[0]);
        }
        return this.b;
    }
}
