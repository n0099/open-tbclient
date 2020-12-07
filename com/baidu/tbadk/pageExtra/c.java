package com.baidu.tbadk.pageExtra;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private String fBt;
    private final ArrayList<String> fBu = new ArrayList<>();
    private BdUniqueId mId;

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.fBt = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.fBu.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.fBu.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.fBt;
    }

    public ArrayList<String> bER() {
        return this.fBu;
    }

    public ArrayList<String> bES() {
        return d.d(this.fBu, this.fBt);
    }

    public String bET() {
        return (String) y.getItem(this.fBu, y.getCount(this.fBu) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.fBt);
    }
}
