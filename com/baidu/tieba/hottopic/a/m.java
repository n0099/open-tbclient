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
    final /* synthetic */ k bGl;
    private final /* synthetic */ String bGm;
    private final /* synthetic */ String bGn;
    private final /* synthetic */ String bGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, String str, String str2, String str3) {
        this.bGl = kVar;
        this.bGm = str;
        this.bGn = str2;
        this.bGo = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        HotTopicActivity hotTopicActivity;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bGl.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, String.valueOf(this.bGm), this.bGn)));
        av aa = new av("c10366").aa("post_id", this.bGo).aa("obj_type", "1");
        hotTopicActivity = this.bGl.bFY;
        TiebaStatic.log(aa.aa("obj_id", hotTopicActivity.Vo()));
    }
}
