package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.core.data.ai;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private String aHS;
    private List<ai> aXS;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aHS = str;
    }

    public List<ai> Ez() {
        return this.aXS;
    }

    public void G(List<ai> list) {
        this.aXS = list;
    }
}
