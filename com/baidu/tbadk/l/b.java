package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String dCP;
    private final ArrayList<String> dCQ = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.dCP = str;
        X(intent);
    }

    public void X(Intent intent) {
        this.dCQ.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.dCQ.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.dCP;
    }

    public ArrayList<String> aQQ() {
        return this.dCQ;
    }

    public ArrayList<String> aQR() {
        return c.d(this.dCQ, this.dCP);
    }
}
