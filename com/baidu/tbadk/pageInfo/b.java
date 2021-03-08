package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag fKj;
    private TbPageTag fKk;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.fKk = tbPageTag;
        J(intent);
    }

    private void J(Intent intent) {
        if (intent != null) {
            this.fKj = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bDS() {
        return this.fKk;
    }

    public TbPageTag getPrePageTag() {
        return this.fKj;
    }
}
