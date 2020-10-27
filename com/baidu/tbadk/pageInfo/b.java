package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag foI;
    private TbPageTag foJ;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.foJ = tbPageTag;
        I(intent);
    }

    private void I(Intent intent) {
        if (intent != null) {
            this.foI = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bzE() {
        return this.foJ;
    }

    public TbPageTag getPrePageTag() {
        return this.foI;
    }
}
