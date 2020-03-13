package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag dDg;
    private TbPageTag dDh;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.dDh = tbPageTag;
        X(intent);
    }

    private void X(Intent intent) {
        if (intent != null) {
            this.dDg = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag aQV() {
        return this.dDh;
    }

    public TbPageTag getPrePageTag() {
        return this.dDg;
    }
}
