package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag fuD;
    private TbPageTag fuE;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.fuE = tbPageTag;
        I(intent);
    }

    private void I(Intent intent) {
        if (intent != null) {
            this.fuD = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bCd() {
        return this.fuE;
    }

    public TbPageTag getPrePageTag() {
        return this.fuD;
    }
}
