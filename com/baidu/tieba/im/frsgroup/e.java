package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
/* loaded from: classes.dex */
class e implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1560a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsGroupListFragment frsGroupListFragment) {
        this.f1560a = frsGroupListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupListAdapter groupListAdapter;
        FrsGroupActivity frsGroupActivity;
        int G;
        groupListAdapter = this.f1560a.h;
        GroupInfoData groupInfoData = (GroupInfoData) groupListAdapter.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.f1560a.f1546a;
            G = this.f1560a.G();
            GroupInfoActivity.a(frsGroupActivity, groupInfoData.getGroupId(), G);
        }
    }
}
