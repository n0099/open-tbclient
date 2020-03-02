package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag dCT;
    private TbPageTag dCU;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.dCU = tbPageTag;
        X(intent);
    }

    private void X(Intent intent) {
        if (intent != null) {
            this.dCT = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag aQU() {
        return this.dCU;
    }

    public TbPageTag getPrePageTag() {
        return this.dCT;
    }
}
