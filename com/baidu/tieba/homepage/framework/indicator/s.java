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
public class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ r coh;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, Context context) {
        this.coh = rVar;
        this.val$context = context;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        qVar = this.coh.cog;
        TagInfo item = qVar.getItem(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB_FROM_POP_WINDOW));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB, item));
        this.coh.aT(this.val$context);
    }
}
