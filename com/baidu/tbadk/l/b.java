package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String eAf;
    private final ArrayList<String> eAg = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.eAf = str;
        G(intent);
    }

    public void G(Intent intent) {
        this.eAg.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!w.isEmpty(stringArrayListExtra)) {
                this.eAg.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.eAf;
    }

    public ArrayList<String> bht() {
        return this.eAg;
    }

    public ArrayList<String> bhu() {
        return c.d(this.eAg, this.eAf);
    }

    public String bhv() {
        return (String) w.getItem(this.eAg, w.getCount(this.eAg) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.eAf);
    }
}
