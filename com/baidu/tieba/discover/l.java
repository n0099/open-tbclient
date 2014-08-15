package com.baidu.tieba.discover;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class l {
    private static final String a = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/found";
    private final n b;

    public l(n nVar) {
        this.b = nVar;
    }

    public void a() {
        new m(this.b).execute(new String[0]);
    }
}
