package com.baidu.tbadk.pageExtra;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private String fKd;
    private final ArrayList<String> fKe = new ArrayList<>();
    private BdUniqueId mId;

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.fKd = str;
        J(intent);
    }

    public void J(Intent intent) {
        this.fKe.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.fKe.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.fKd;
    }

    public ArrayList<String> bDN() {
        return this.fKe;
    }

    public ArrayList<String> bDO() {
        return d.d(this.fKe, this.fKd);
    }

    public String bDP() {
        return (String) y.getItem(this.fKe, y.getCount(this.fKe) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.fKd);
    }
}
