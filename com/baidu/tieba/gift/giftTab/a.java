package com.baidu.tieba.gift.giftTab;

import java.util.ArrayList;
import tbclient.GetGiftList.PresentCategoryList;
/* loaded from: classes8.dex */
public class a {
    private String aEF;
    private ArrayList<Integer> aEG;
    private int categoryId;

    public void a(PresentCategoryList presentCategoryList) {
        if (presentCategoryList != null) {
            this.categoryId = presentCategoryList.category_id.intValue();
            this.aEF = presentCategoryList.category_name;
            if (presentCategoryList.gift_ids != null && presentCategoryList.gift_ids.size() > 0) {
                this.aEG = new ArrayList<>();
                this.aEG.addAll(presentCategoryList.gift_ids);
            }
        }
    }

    public String getCategoryName() {
        return this.aEF;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> AD() {
        return this.aEG;
    }
}
