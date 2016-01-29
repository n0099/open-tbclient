package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import tbclient.HotThread.tinfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ e aTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aTp = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        aVar = this.aTp.aTk;
        tinfo item = aVar.getItem(i);
        if (item != null) {
            TiebaStatic.eventStat(this.aTp.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.aTp.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aTp.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }
}
