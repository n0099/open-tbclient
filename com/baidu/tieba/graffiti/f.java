package com.baidu.tieba.graffiti;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.Error;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.util.g<Error> {
    final /* synthetic */ d cBh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.cBh = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: a */
    public void F(Error error) {
        this.cBh.cBd = false;
        if (error != null && error.getCode() == 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new i(null, 3)));
            k.showToast(this.cBh.getContext(), this.cBh.getContext().getString(w.l.save_success));
        } else if (error != null && error.getCode() == -1132) {
            k.showToast(this.cBh.getContext(), this.cBh.getContext().getString(w.l.graffiti_save_full));
        } else {
            k.showToast(this.cBh.getContext(), this.cBh.getContext().getString(w.l.save_error));
        }
    }
}
