package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class b {
    private TbPageTag eRg;
    private TbPageTag eRh;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.eRh = tbPageTag;
        I(intent);
    }

    private void I(Intent intent) {
        if (intent != null) {
            this.eRg = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag btW() {
        return this.eRh;
    }

    public TbPageTag getPrePageTag() {
        return this.eRg;
    }
}
