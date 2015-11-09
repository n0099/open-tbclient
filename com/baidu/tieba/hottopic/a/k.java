package com.baidu.tieba.hottopic.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i boQ;
    private final /* synthetic */ String boR;
    private final /* synthetic */ String boS;
    private final /* synthetic */ String boT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, String str2, String str3) {
        this.boQ = iVar;
        this.boR = str;
        this.boS = str2;
        this.boT = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        HotTopicActivity hotTopicActivity;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.boQ.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(this.boR), this.boS)));
        aq ae = new aq("c10366").ae("post_id", this.boT).ae("obj_type", "1");
        hotTopicActivity = this.boQ.boH;
        TiebaStatic.log(ae.ae("obj_id", hotTopicActivity.Rh()));
    }
}
