package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag edb;
    private TbPageTag edc;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.edc = tbPageTag;
        W(intent);
    }

    private void W(Intent intent) {
        if (intent != null) {
            this.edb = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag aZj() {
        return this.edc;
    }

    public TbPageTag getPrePageTag() {
        return this.edb;
    }
}
