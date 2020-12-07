package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag fBA;
    private TbPageTag fBz;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.fBA = tbPageTag;
        I(intent);
    }

    private void I(Intent intent) {
        if (intent != null) {
            this.fBz = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bEW() {
        return this.fBA;
    }

    public TbPageTag getPrePageTag() {
        return this.fBz;
    }
}
