package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String edb;
    private final ArrayList<String> edc = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.edb = str;
        J(intent);
    }

    public void J(Intent intent) {
        this.edc.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.edc.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.edb;
    }

    public ArrayList<String> aZd() {
        return this.edc;
    }

    public ArrayList<String> aZe() {
        return c.d(this.edc, this.edb);
    }
}
