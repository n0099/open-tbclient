package com.baidu.tieba.discover;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/found";
    private l b;

    public j(l lVar) {
        this.b = lVar;
    }

    public void a() {
        new k(this.b).execute(new String[0]);
    }
}
