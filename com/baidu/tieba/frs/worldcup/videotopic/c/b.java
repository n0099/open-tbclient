package com.baidu.tieba.frs.worldcup.videotopic.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.videotopic.activity.a ekm;
    private com.baidu.tieba.frs.worldcup.videotopic.data.a ekn;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.activity.a aVar, Bundle bundle) {
        this.ekm = aVar;
        this.ekn = new com.baidu.tieba.frs.worldcup.videotopic.data.b(tbPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onRefresh() {
        if (this.ekn != null) {
            this.ekn.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void aIG() {
        if (this.ekn != null) {
            this.ekn.aab();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.ekm != null) {
            this.ekm.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public boolean hasMore() {
        if (this.ekn != null) {
            return this.ekn.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onDestroy() {
        if (this.ekn != null) {
            this.ekn.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public String getForumId() {
        return this.ekn != null ? this.ekn.getForumId() : "";
    }
}
