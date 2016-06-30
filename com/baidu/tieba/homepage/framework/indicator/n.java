package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ m cpr;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, Context context) {
        this.cpr = mVar;
        this.val$context = context;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        lVar = this.cpr.cpq;
        TagInfo item = lVar.getItem(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB, item));
        this.cpr.ay(this.val$context);
    }
}
