package com.baidu.tieba.gift.giftTab;

import com.baidu.tbadk.core.data.ah;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private String aJs;
    private List<ah> aYa;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aJs = str;
    }

    public List<ah> Hb() {
        return this.aYa;
    }

    public void G(List<ah> list) {
        this.aYa = list;
    }
}
