package com.baidu.tieba.graffiti;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.Error;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.util.e<Error> {
    final /* synthetic */ e cCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cCc = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: a */
    public void F(Error error) {
        this.cCc.cBZ = false;
        if (error != null && error.getCode() == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new j(null, 3)));
            com.baidu.adp.lib.util.k.showToast(this.cCc.getContext(), this.cCc.getContext().getString(r.j.save_success));
        } else if (error != null && error.getCode() == -1132) {
            com.baidu.adp.lib.util.k.showToast(this.cCc.getContext(), this.cCc.getContext().getString(r.j.graffiti_save_full));
        } else {
            com.baidu.adp.lib.util.k.showToast(this.cCc.getContext(), this.cCc.getContext().getString(r.j.save_error));
        }
    }
}
