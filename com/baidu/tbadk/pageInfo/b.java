package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag eGA;
    private TbPageTag eGB;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.eGB = tbPageTag;
        G(intent);
    }

    private void G(Intent intent) {
        if (intent != null) {
            this.eGA = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag blj() {
        return this.eGB;
    }

    public TbPageTag getPrePageTag() {
        return this.eGA;
    }
}
