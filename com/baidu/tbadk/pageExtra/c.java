package com.baidu.tbadk.pageExtra;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private String fKZ;
    private final ArrayList<String> fLa = new ArrayList<>();
    private BdUniqueId mId;

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.fKZ = str;
        J(intent);
    }

    public void J(Intent intent) {
        this.fLa.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!x.isEmpty(stringArrayListExtra)) {
                this.fLa.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.fKZ;
    }

    public ArrayList<String> bHl() {
        return this.fLa;
    }

    public ArrayList<String> bHm() {
        return d.d(this.fLa, this.fKZ);
    }

    public String bHn() {
        return (String) x.getItem(this.fLa, x.getCount(this.fLa) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.fKZ);
    }
}
