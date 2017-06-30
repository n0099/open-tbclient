package com.baidu.tieba.enterForum.multiConcern;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.z;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ b bTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bTY = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        List list2;
        List list3;
        h hVar;
        List<g> list4;
        h hVar2;
        list = this.bTY.forumList;
        if (z.c(list, i) != null) {
            list2 = this.bTY.forumList;
            g gVar = (g) z.c(list2, i);
            list3 = this.bTY.forumList;
            gVar.isSelected = !((g) z.c(list3, i)).isSelected;
            hVar = this.bTY.bTV;
            list4 = this.bTY.forumList;
            hVar.setData(list4);
            hVar2 = this.bTY.bTV;
            hVar2.notifyDataSetChanged();
        }
    }
}
