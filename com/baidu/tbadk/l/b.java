package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String fuy;
    private final ArrayList<String> fuz = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.fuy = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.fuz.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.fuz.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.fuy;
    }

    public ArrayList<String> bBY() {
        return this.fuz;
    }

    public ArrayList<String> bBZ() {
        return c.d(this.fuz, this.fuy);
    }

    public String bCa() {
        return (String) y.getItem(this.fuz, y.getCount(this.fuz) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.fuy);
    }
}
