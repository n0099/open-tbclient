package com.baidu.tieba.gift.giftTab;

import java.util.ArrayList;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes.dex */
public class c {
    private String buW;
    private ArrayList<Integer> buX;
    private int categoryId;

    public void a(PresentCategoryList presentCategoryList) {
        if (presentCategoryList != null) {
            this.categoryId = presentCategoryList.category_id.intValue();
            this.buW = presentCategoryList.category_name;
            if (presentCategoryList.gift_ids != null && presentCategoryList.gift_ids.size() > 0) {
                this.buX = new ArrayList<>();
                this.buX.addAll(presentCategoryList.gift_ids);
            }
        }
    }

    public String getCategoryName() {
        return this.buW;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Tc() {
        return this.buX;
    }
}
