package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupListAdapter groupListAdapter;
        FrsGroupActivity frsGroupActivity;
        int h;
        FrsGroupActivity frsGroupActivity2;
        groupListAdapter = this.a.i;
        GroupInfoData groupInfoData = (GroupInfoData) groupListAdapter.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.a.b;
            h = this.a.h();
            com.baidu.tbadk.core.atomData.q qVar = new com.baidu.tbadk.core.atomData.q(frsGroupActivity, groupInfoData.getGroupId(), h);
            frsGroupActivity2 = this.a.b;
            frsGroupActivity2.a(new CustomMessage(2010011, qVar));
        }
    }
}
