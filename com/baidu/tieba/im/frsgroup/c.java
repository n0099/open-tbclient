package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsGroupListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGroupListFragment frsGroupListFragment) {
        this.a = frsGroupListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupListAdapter groupListAdapter;
        FrsGroupActivity frsGroupActivity;
        int I;
        groupListAdapter = this.a.h;
        GroupInfoData groupInfoData = (GroupInfoData) groupListAdapter.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.a.a;
            I = this.a.I();
            GroupInfoActivity.a(frsGroupActivity, groupInfoData.getGroupId(), I);
        }
    }
}
