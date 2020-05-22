package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String ern;
    private final ArrayList<String> ero = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.ern = str;
        G(intent);
    }

    public void G(Intent intent) {
        this.ero.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!v.isEmpty(stringArrayListExtra)) {
                this.ero.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.ern;
    }

    public ArrayList<String> bfn() {
        return this.ero;
    }

    public ArrayList<String> bfo() {
        return c.d(this.ero, this.ern);
    }
}
