package com.baidu.tieba.hottopic.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ k bCH;
    private final /* synthetic */ String bCI;
    private final /* synthetic */ String bCJ;
    private final /* synthetic */ String bCK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str, String str2, String str3) {
        this.bCH = kVar;
        this.bCI = str;
        this.bCJ = str2;
        this.bCK = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        HotTopicActivity hotTopicActivity;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bCH.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(this.bCI), this.bCJ)));
        av ab = new av("c10366").ab("post_id", this.bCK).ab("obj_type", "1");
        hotTopicActivity = this.bCH.bCu;
        TiebaStatic.log(ab.ab("obj_id", hotTopicActivity.Ul()));
    }
}
