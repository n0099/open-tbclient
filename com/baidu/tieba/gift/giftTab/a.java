package com.baidu.tieba.gift.giftTab;

import java.util.ArrayList;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes9.dex */
public class a {
    private String aJs;
    private ArrayList<Integer> aJt;
    private int categoryId;

    public void a(PresentCategoryList presentCategoryList) {
        if (presentCategoryList != null) {
            this.categoryId = presentCategoryList.category_id.intValue();
            this.aJs = presentCategoryList.category_name;
            if (presentCategoryList.gift_ids != null && presentCategoryList.gift_ids.size() > 0) {
                this.aJt = new ArrayList<>();
                this.aJt.addAll(presentCategoryList.gift_ids);
            }
        }
    }

    public String getCategoryName() {
        return this.aJs;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Ey() {
        return this.aJt;
    }
}
