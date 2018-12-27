package com.baidu.tieba.frs.worldcup.videotopic.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.videotopic.activity.a enc;
    private com.baidu.tieba.frs.worldcup.videotopic.data.a ene;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.videotopic.activity.a aVar, Bundle bundle) {
        this.enc = aVar;
        this.ene = new com.baidu.tieba.frs.worldcup.videotopic.data.b(tbPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onRefresh() {
        if (this.ene != null) {
            this.ene.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void aJv() {
        if (this.ene != null) {
            this.ene.aad();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void a(d.a aVar, ArrayList<h> arrayList) {
        if (this.enc != null) {
            this.enc.a(aVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public boolean hasMore() {
        if (this.ene != null) {
            return this.ene.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public void onDestroy() {
        if (this.ene != null) {
            this.ene.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.videotopic.c.a
    public String getForumId() {
        return this.ene != null ? this.ene.getForumId() : "";
    }
}
