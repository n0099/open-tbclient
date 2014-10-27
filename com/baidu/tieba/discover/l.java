package com.baidu.tieba.discover;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class l {
    private static final String anS = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/found";
    private final n anT;

    public l(n nVar) {
        this.anT = nVar;
    }

    public void AO() {
        new m(this.anT).execute(new String[0]);
    }
}
