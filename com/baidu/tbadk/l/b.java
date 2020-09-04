package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String eRf;
    private final ArrayList<String> eRg = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.eRf = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.eRg.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.eRg.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.eRf;
    }

    public ArrayList<String> btS() {
        return this.eRg;
    }

    public ArrayList<String> btT() {
        return c.d(this.eRg, this.eRf);
    }

    public String btU() {
        return (String) y.getItem(this.eRg, y.getCount(this.eRg) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.eRf);
    }
}
