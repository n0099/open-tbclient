package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String dyO;
    private final ArrayList<String> dyP = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.dyO = str;
        X(intent);
    }

    public void X(Intent intent) {
        this.dyP.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.dyP.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.dyO;
    }

    public ArrayList<String> aOz() {
        return this.dyP;
    }

    public ArrayList<String> aOA() {
        return c.d(this.dyP, this.dyO);
    }
}
