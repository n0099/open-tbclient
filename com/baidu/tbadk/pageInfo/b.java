package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag edg;
    private TbPageTag edh;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.edh = tbPageTag;
        J(intent);
    }

    private void J(Intent intent) {
        if (intent != null) {
            this.edg = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag aZh() {
        return this.edh;
    }

    public TbPageTag getPrePageTag() {
        return this.edg;
    }
}
