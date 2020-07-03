package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag eAk;
    private TbPageTag eAl;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.eAl = tbPageTag;
        G(intent);
    }

    private void G(Intent intent) {
        if (intent != null) {
            this.eAk = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bhy() {
        return this.eAl;
    }

    public TbPageTag getPrePageTag() {
        return this.eAk;
    }
}
