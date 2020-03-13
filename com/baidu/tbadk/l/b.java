package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String dDc;
    private final ArrayList<String> dDd = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.dDc = str;
        X(intent);
    }

    public void X(Intent intent) {
        this.dDd.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.dDd.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.dDc;
    }

    public ArrayList<String> aQR() {
        return this.dDd;
    }

    public ArrayList<String> aQS() {
        return c.d(this.dDd, this.dDc);
    }
}
