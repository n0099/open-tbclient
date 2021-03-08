package com.baidu.tieba.gift.giftTab;

import tbclient.GetGiftList.PresentNumInfo;
/* loaded from: classes8.dex */
public class e {
    private String name;
    private int number;

    public void a(PresentNumInfo presentNumInfo) {
        if (presentNumInfo != null) {
            this.number = presentNumInfo.num.intValue();
            this.name = presentNumInfo.name;
        }
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }
}
