package com.baidu.tieba.discover;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class l {
    private static final String aob = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/found";
    private final n aoc;

    public l(n nVar) {
        this.aoc = nVar;
    }

    public void AQ() {
        new m(this.aoc).execute(new String[0]);
    }
}
