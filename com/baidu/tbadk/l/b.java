package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String ecW;
    private final ArrayList<String> ecX = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.ecW = str;
        W(intent);
    }

    public void W(Intent intent) {
        this.ecX.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.ecX.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.ecW;
    }

    public ArrayList<String> aZf() {
        return this.ecX;
    }

    public ArrayList<String> aZg() {
        return c.d(this.ecX, this.ecW);
    }
}
