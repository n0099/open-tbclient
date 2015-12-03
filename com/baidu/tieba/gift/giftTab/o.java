package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ GiftTabActivity bvt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(GiftTabActivity giftTabActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.bvt = giftTabActivity;
        this.bvu = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.bvu.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(this.bvt.getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 17)));
    }
}
