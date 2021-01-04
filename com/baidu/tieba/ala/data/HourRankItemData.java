package com.baidu.tieba.ala.data;

import java.io.Serializable;
/* loaded from: classes11.dex */
public class HourRankItemData implements Serializable {
    public String loc;
    public int position;
    public String type;

    public HourRankItemData() {
        this(null, null, 0);
    }

    public HourRankItemData(String str, String str2, int i) {
        this.type = str;
        this.loc = str2;
        this.position = i;
    }
}
