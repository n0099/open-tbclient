package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag fIK;
    private TbPageTag fIL;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.fIL = tbPageTag;
        J(intent);
    }

    private void J(Intent intent) {
        if (intent != null) {
            this.fIK = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bDP() {
        return this.fIL;
    }

    public TbPageTag getPrePageTag() {
        return this.fIK;
    }
}
