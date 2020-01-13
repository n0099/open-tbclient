package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag dyQ;
    private TbPageTag dyR;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.dyR = tbPageTag;
        X(intent);
    }

    private void X(Intent intent) {
        if (intent != null) {
            this.dyQ = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag aOC() {
        return this.dyR;
    }

    public TbPageTag getPrePageTag() {
        return this.dyQ;
    }
}
