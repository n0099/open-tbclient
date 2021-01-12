package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag fGy;
    private TbPageTag fGz;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.fGz = tbPageTag;
        J(intent);
    }

    private void J(Intent intent) {
        if (intent != null) {
            this.fGy = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bDx() {
        return this.fGz;
    }

    public TbPageTag getPrePageTag() {
        return this.fGy;
    }
}
