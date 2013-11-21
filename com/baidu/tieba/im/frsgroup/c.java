package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsGroupListFragment f1637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGroupListFragment frsGroupListFragment) {
        this.f1637a = frsGroupListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        GroupListAdapter groupListAdapter;
        FrsGroupActivity frsGroupActivity;
        int I;
        groupListAdapter = this.f1637a.h;
        GroupInfoData groupInfoData = (GroupInfoData) groupListAdapter.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.f1637a.f1627a;
            I = this.f1637a.I();
            GroupInfoActivity.a(frsGroupActivity, groupInfoData.getGroupId(), I);
        }
    }
}
