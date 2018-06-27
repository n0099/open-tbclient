package com.baidu.tieba.frs.worldcup.videotopic.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.videotopic.activity.a dKr;
    private com.baidu.tieba.frs.worldcup.videotopic.data.a dKs;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.activity.a aVar, Bundle bundle) {
        this.dKr = aVar;
        this.dKs = new com.baidu.tieba.frs.worldcup.videotopic.data.b(tbPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onRefresh() {
        if (this.dKs != null) {
            this.dKs.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void aBl() {
        if (this.dKs != null) {
            this.dKs.Tf();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.dKr != null) {
            this.dKr.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public boolean hasMore() {
        if (this.dKs != null) {
            return this.dKs.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onDestroy() {
        if (this.dKs != null) {
            this.dKs.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public String getForumId() {
        return this.dKs != null ? this.dKs.getForumId() : "";
    }
}
