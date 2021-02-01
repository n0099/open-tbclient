package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.core.data.ai;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private String aGs;
    private List<ai> aWs;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aGs = str;
    }

    public List<ai> Ew() {
        return this.aWs;
    }

    public void G(List<ai> list) {
        this.aWs = list;
    }
}
