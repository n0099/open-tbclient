package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag dyI;
    private TbPageTag dyJ;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.dyJ = tbPageTag;
        X(intent);
    }

    private void X(Intent intent) {
        if (intent != null) {
            this.dyI = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag aOj() {
        return this.dyJ;
    }

    public TbPageTag getPrePageTag() {
        return this.dyI;
    }
}
