package com.baidu.tieba.frs.worldcup.videotopic.b;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.videotopic.activity.a dGY;
    private com.baidu.tieba.frs.worldcup.videotopic.data.a dGZ;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.activity.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.dGY = aVar;
        this.dGZ = new com.baidu.tieba.frs.worldcup.videotopic.data.b(this.mPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.b.a
    public void onRefresh() {
        if (this.dGZ != null) {
            this.dGZ.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.b.a
    public void aAE() {
        if (this.dGZ != null) {
            this.dGZ.SJ();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.b.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.dGY != null) {
            this.dGY.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.b.a
    public boolean hasMore() {
        if (this.dGZ != null) {
            return this.dGZ.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.b.a
    public void onDestroy() {
        if (this.dGZ != null) {
            this.dGZ.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.b.a
    public String getForumId() {
        return this.dGZ != null ? this.dGZ.getForumId() : "";
    }
}
