package com.baidu.tbadk.pageExtra;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private String fIE;
    private final ArrayList<String> fIF = new ArrayList<>();
    private BdUniqueId mId;

    public c(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.fIE = str;
        J(intent);
    }

    public void J(Intent intent) {
        this.fIF.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.fIF.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.fIE;
    }

    public ArrayList<String> bDK() {
        return this.fIF;
    }

    public ArrayList<String> bDL() {
        return d.d(this.fIF, this.fIE);
    }

    public String bDM() {
        return (String) y.getItem(this.fIF, y.getCount(this.fIF) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.fIE);
    }
}
