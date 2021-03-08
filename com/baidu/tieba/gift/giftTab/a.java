package com.baidu.tieba.gift.giftTab;

import java.util.ArrayList;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes8.dex */
public class a {
    private String aHS;
    private ArrayList<Integer> aHT;
    private int categoryId;

    public void a(PresentCategoryList presentCategoryList) {
        if (presentCategoryList != null) {
            this.categoryId = presentCategoryList.category_id.intValue();
            this.aHS = presentCategoryList.category_name;
            if (presentCategoryList.gift_ids != null && presentCategoryList.gift_ids.size() > 0) {
                this.aHT = new ArrayList<>();
                this.aHT.addAll(presentCategoryList.gift_ids);
            }
        }
    }

    public String getCategoryName() {
        return this.aHS;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Bq() {
        return this.aHT;
    }
}
