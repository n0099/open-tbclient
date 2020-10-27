package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String foD;
    private final ArrayList<String> foE = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.foD = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.foE.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.foE.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.foD;
    }

    public ArrayList<String> bzz() {
        return this.foE;
    }

    public ArrayList<String> bzA() {
        return c.d(this.foE, this.foD);
    }

    public String bzB() {
        return (String) y.getItem(this.foE, y.getCount(this.foE) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.foD);
    }
}
