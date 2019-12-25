package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String dyG;
    private final ArrayList<String> dyH = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.dyG = str;
        X(intent);
    }

    public void X(Intent intent) {
        this.dyH.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.dyH.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.dyG;
    }

    public ArrayList<String> aOg() {
        return this.dyH;
    }

    public ArrayList<String> aOh() {
        return c.e(this.dyH, this.dyG);
    }
}
