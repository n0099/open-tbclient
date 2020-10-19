package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String fge;
    private final ArrayList<String> fgf = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.fge = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.fgf.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.fgf.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.fge;
    }

    public ArrayList<String> bxG() {
        return this.fgf;
    }

    public ArrayList<String> bxH() {
        return c.d(this.fgf, this.fge);
    }

    public String bxI() {
        return (String) y.getItem(this.fgf, y.getCount(this.fgf) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.fge);
    }
}
