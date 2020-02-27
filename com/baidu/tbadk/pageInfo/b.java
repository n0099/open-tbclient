package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag dCS;
    private TbPageTag dCT;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.dCT = tbPageTag;
        X(intent);
    }

    private void X(Intent intent) {
        if (intent != null) {
            this.dCS = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag aQS() {
        return this.dCT;
    }

    public TbPageTag getPrePageTag() {
        return this.dCS;
    }
}
