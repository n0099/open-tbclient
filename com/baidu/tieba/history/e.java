package com.baidu.tieba.history;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbHistoryActivity aNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbHistoryActivity pbHistoryActivity) {
        this.aNU = pbHistoryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.j.c cVar;
        cVar = this.aNU.asM;
        com.baidu.tbadk.b.b bVar = (com.baidu.tbadk.b.b) cVar.getItem(i);
        if (bVar != null) {
            this.aNU.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aNU.getPageContext().getPageActivity()).createHistoryCfg(bVar.getThreadId(), bVar.lt(), bVar.lu(), bVar.lv(), null)));
        }
    }
}
