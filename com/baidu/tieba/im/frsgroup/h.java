package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes.dex */
class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ e aWS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aWS = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.i.c cVar;
        FrsGroupActivity frsGroupActivity;
        int i2;
        cVar = this.aWS.aWO;
        GroupInfoData groupInfoData = (GroupInfoData) cVar.getItem(i);
        if (groupInfoData != null) {
            frsGroupActivity = this.aWS.aWI;
            e eVar = this.aWS;
            i2 = this.aWS.index;
            com.baidu.tbadk.util.f.a(2008011, new GroupInfoActivityConfig(frsGroupActivity, groupInfoData.getGroupId(), eVar.fG(i2 + 4)));
        }
    }
}
