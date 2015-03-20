package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ d aBj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.aBj = dVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        aVar = this.aBj.aBh;
        tinfo item = aVar.getItem(i);
        if (item != null) {
            this.aBj.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aBj.getContext()).createNormalCfg(String.valueOf(item.thread_id), String.valueOf(item.forum_id), null)));
        }
    }
}
