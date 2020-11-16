package com.baidu.tbadk.l;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private String ftI;
    private final ArrayList<String> ftJ = new ArrayList<>();
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, String str, Intent intent) {
        this.mId = bdUniqueId;
        this.ftI = str;
        I(intent);
    }

    public void I(Intent intent) {
        this.ftJ.clear();
        if (intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tb_page_extar_source_list");
            if (!y.isEmpty(stringArrayListExtra)) {
                this.ftJ.addAll(stringArrayListExtra);
            }
        }
    }

    public String getCurrentPageKey() {
        return this.ftI;
    }

    public ArrayList<String> bBo() {
        return this.ftJ;
    }

    public ArrayList<String> bBp() {
        return c.d(this.ftJ, this.ftI);
    }

    public String bBq() {
        return (String) y.getItem(this.ftJ, y.getCount(this.ftJ) - 1);
    }

    public boolean isDirtyData() {
        return StringUtils.isNull(this.ftI);
    }
}
