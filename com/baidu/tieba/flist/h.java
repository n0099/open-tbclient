package com.baidu.tieba.flist;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ ForumListActivity avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.avP = forumListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TiebaStatic.eventStat(this.avP, "forumlist_catalog", "catalogclick", 1, new Object[0]);
        com.baidu.adp.lib.g.j.a(this.avP.avy.awz, this.avP);
        this.avP.menu_choose = i;
        this.avP.avy.DV();
        ArrayList<com.baidu.tieba.square.q> arrayList = this.avP.avy.awD.DI().bMu;
        this.avP.n(arrayList.get(i).auZ, arrayList.get(i).avb, arrayList.get(i).ava);
    }
}
