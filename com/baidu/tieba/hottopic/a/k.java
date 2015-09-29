package com.baidu.tieba.hottopic.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bob;
    private final /* synthetic */ String boc;
    private final /* synthetic */ String bod;
    private final /* synthetic */ String boe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, String str2, String str3) {
        this.bob = iVar;
        this.boc = str;
        this.bod = str2;
        this.boe = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        HotTopicActivity hotTopicActivity;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bob.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(this.boc), this.bod)));
        ap ae = new ap("c10366").ae("post_id", this.boe).ae("obj_type", "1");
        hotTopicActivity = this.bob.bnS;
        TiebaStatic.log(ae.ae("obj_id", hotTopicActivity.QP()));
    }
}
