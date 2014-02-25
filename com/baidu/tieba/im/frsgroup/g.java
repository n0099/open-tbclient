package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.a = cVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupListAdapter groupListAdapter;
        FrsGroupActivity frsGroupActivity;
        int e;
        groupListAdapter = this.a.i;
        GroupInfoData groupInfoData = (GroupInfoData) groupListAdapter.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.a.b;
            e = this.a.e();
            GroupInfoActivity.a(frsGroupActivity, groupInfoData.getGroupId(), e);
        }
    }
}
