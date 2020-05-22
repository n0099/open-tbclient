package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag ert;
    private TbPageTag eru;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.eru = tbPageTag;
        G(intent);
    }

    private void G(Intent intent) {
        if (intent != null) {
            this.ert = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bfr() {
        return this.eru;
    }

    public TbPageTag getPrePageTag() {
        return this.ert;
    }
}
