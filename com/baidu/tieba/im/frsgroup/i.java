package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes.dex */
final class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupListAdapter groupListAdapter;
        FrsGroupActivity frsGroupActivity;
        FrsGroupActivity frsGroupActivity2;
        groupListAdapter = this.a.h;
        GroupInfoData groupInfoData = (GroupInfoData) groupListAdapter.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.a.a;
            com.baidu.tbadk.core.b.o oVar = new com.baidu.tbadk.core.b.o(frsGroupActivity, groupInfoData.getGroupId(), b.m(this.a));
            frsGroupActivity2 = this.a.a;
            frsGroupActivity2.a(new com.baidu.adp.framework.message.a(2008011, oVar));
        }
    }
}
