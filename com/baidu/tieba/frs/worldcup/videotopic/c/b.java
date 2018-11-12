package com.baidu.tieba.frs.worldcup.videotopic.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.videotopic.activity.a edJ;
    private com.baidu.tieba.frs.worldcup.videotopic.data.a edK;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.activity.a aVar, Bundle bundle) {
        this.edJ = aVar;
        this.edK = new com.baidu.tieba.frs.worldcup.videotopic.data.b(tbPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onRefresh() {
        if (this.edK != null) {
            this.edK.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void aGU() {
        if (this.edK != null) {
            this.edK.YV();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.edJ != null) {
            this.edJ.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public boolean hasMore() {
        if (this.edK != null) {
            return this.edK.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onDestroy() {
        if (this.edK != null) {
            this.edK.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public String getForumId() {
        return this.edK != null ? this.edK.getForumId() : "";
    }
}
