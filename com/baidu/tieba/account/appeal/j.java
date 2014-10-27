package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j {
    private static final String agc = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/user/getreason";

    public static void a(String str, String str2, l lVar) {
        new k(str, str2, lVar).execute(new String[0]);
    }
}
