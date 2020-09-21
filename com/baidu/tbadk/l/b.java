package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String eTW;
    private final ArrayList<String> eTX = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.eTW = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.eTX.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.eTX.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.eTW;
    }

    public ArrayList<String> buW() {
        return this.eTX;
    }

    public ArrayList<String> buX() {
        return c.d(this.eTX, this.eTW);
    }

    public String buY() {
        return (String) y.getItem(this.eTX, y.getCount(this.eTX) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.eTW);
    }
}
