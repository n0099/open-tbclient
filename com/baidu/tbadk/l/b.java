package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private String eRb;
    private final ArrayList<String> eRc = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.eRb = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.eRc.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.eRc.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.eRb;
    }

    public ArrayList<String> btR() {
        return this.eRc;
    }

    public ArrayList<String> btS() {
        return c.d(this.eRc, this.eRb);
    }

    public String btT() {
        return (String) y.getItem(this.eRc, y.getCount(this.eRc) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.eRb);
    }
}
