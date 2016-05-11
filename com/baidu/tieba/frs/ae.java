package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.b {
    final /* synthetic */ FrsActivity bhl;
    private final /* synthetic */ String bht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity, String str) {
        this.bhl = frsActivity;
        this.bht = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        if (StringUtils.isNull(this.bht)) {
            this.bhl.showToast(t.j.error_tid);
            return;
        }
        aVar.dismiss();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bhl.getPageContext().getPageActivity(), this.bht).oq()));
    }
}
