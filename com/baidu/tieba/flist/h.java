package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ ForumListActivity avY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.avY = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(this.avY, "forumlist_catalog", "catalogclick", 1, new Object[0]);
        com.baidu.adp.lib.g.j.a(this.avY.avH.awI, this.avY);
        this.avY.menu_choose = i;
        this.avY.avH.DX();
        ArrayList<com.baidu.tieba.square.q> arrayList = this.avY.avH.awM.DK().bMJ;
        this.avY.n(arrayList.get(i).avi, arrayList.get(i).avk, arrayList.get(i).avj);
    }
}
