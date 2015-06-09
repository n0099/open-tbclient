package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ e aDg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aDg = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        aVar = this.aDg.aDd;
        tinfo item = aVar.getItem(i);
        if (item != null) {
            TiebaStatic.eventStat(this.aDg.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.aDg.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aDg.getContext()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }
}
