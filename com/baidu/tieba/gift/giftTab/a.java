package com.baidu.tieba.gift.giftTab;

import java.util.ArrayList;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes9.dex */
public class a {
    private String aGs;
    private ArrayList<Integer> aGt;
    private int categoryId;

    public void a(PresentCategoryList presentCategoryList) {
        if (presentCategoryList != null) {
            this.categoryId = presentCategoryList.category_id.intValue();
            this.aGs = presentCategoryList.category_name;
            if (presentCategoryList.gift_ids != null && presentCategoryList.gift_ids.size() > 0) {
                this.aGt = new ArrayList<>();
                this.aGt.addAll(presentCategoryList.gift_ids);
            }
        }
    }

    public String getCategoryName() {
        return this.aGs;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Bn() {
        return this.aGt;
    }
}
