package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String dDp;
    private final ArrayList<String> dDq = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.dDp = str;
        X(intent);
    }

    public void X(Intent intent) {
        this.dDq.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.dDq.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.dDp;
    }

    public ArrayList<String> aQV() {
        return this.dDq;
    }

    public ArrayList<String> aQW() {
        return c.d(this.dDq, this.dDp);
    }
}
