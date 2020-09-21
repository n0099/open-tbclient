package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag eUb;
    private TbPageTag eUc;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.eUc = tbPageTag;
        I(intent);
    }

    private void I(Intent intent) {
        if (intent != null) {
            this.eUb = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bvb() {
        return this.eUc;
    }

    public TbPageTag getPrePageTag() {
        return this.eUb;
    }
}
