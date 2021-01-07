package com.baidu.tbadk.pageInfo;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private TbPageTag fLf;
    private TbPageTag fLg;
    private BdUniqueId mId;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.mId = bdUniqueId;
        this.fLg = tbPageTag;
        J(intent);
    }

    private void J(Intent intent) {
        if (intent != null) {
            this.fLf = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }

    public TbPageTag bHq() {
        return this.fLg;
    }

    public TbPageTag getPrePageTag() {
        return this.fLf;
    }
}
