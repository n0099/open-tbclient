package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String eGv;
    private final ArrayList<String> eGw = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.eGv = str;
        G(intent);
    }

    public void G(Intent intent) {
        this.eGw.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!x.isEmpty(stringArrayListExtra)) {
                this.eGw.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.eGv;
    }

    public ArrayList<String> ble() {
        return this.eGw;
    }

    public ArrayList<String> blf() {
        return c.d(this.eGw, this.eGv);
    }

    public String blg() {
        return (String) x.getItem(this.eGw, x.getCount(this.eGw) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.eGv);
    }
}
