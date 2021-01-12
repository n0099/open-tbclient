package com.baidu.tbadk.pageExtra;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private String fGs;
    private final ArrayList<String> fGt = new ArrayList<>();
    private BdUniqueId mId;

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.fGs = str;
        J(intent);
    }

    public void J(Intent intent) {
        this.fGt.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!x.isEmpty(stringArrayListExtra)) {
                this.fGt.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.fGs;
    }

    public ArrayList<String> bDs() {
        return this.fGt;
    }

    public ArrayList<String> bDt() {
        return d.d(this.fGt, this.fGs);
    }

    public String bDu() {
        return (String) x.getItem(this.fGt, x.getCount(this.fGt) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.fGs);
    }
}
