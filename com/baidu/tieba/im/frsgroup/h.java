package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ e aXg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aXg = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.i.c cVar;
        FrsGroupActivity frsGroupActivity;
        int i2;
        cVar = this.aXg.aXc;
        GroupInfoData groupInfoData = (GroupInfoData) cVar.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.aXg.aWW;
            e eVar = this.aXg;
            i2 = this.aXg.index;
            com.baidu.tbadk.util.f.a(2008011, new GroupInfoActivityConfig(frsGroupActivity, groupInfoData.getGroupId(), eVar.fG(i2 + 4)));
        }
    }
}
