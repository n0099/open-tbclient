package com.baidu.tieba.frs.worldcup.videotopic.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.videotopic.activity.a dNh;
    private com.baidu.tieba.frs.worldcup.videotopic.data.a dNi;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.activity.a aVar, Bundle bundle) {
        this.dNh = aVar;
        this.dNi = new com.baidu.tieba.frs.worldcup.videotopic.data.b(tbPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onRefresh() {
        if (this.dNi != null) {
            this.dNi.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void aBU() {
        if (this.dNi != null) {
            this.dNi.Tn();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.dNh != null) {
            this.dNh.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public boolean hasMore() {
        if (this.dNi != null) {
            return this.dNi.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onDestroy() {
        if (this.dNi != null) {
            this.dNi.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public String getForumId() {
        return this.dNi != null ? this.dNi.getForumId() : "";
    }
}
