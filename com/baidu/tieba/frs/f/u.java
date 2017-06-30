package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ae.a {
    final /* synthetic */ m cpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(m mVar) {
        this.cpZ = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void i(String str, long j) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        rVar = this.cpZ.cbE;
        com.baidu.tieba.tbadkCore.n aek = rVar.aek();
        if (aek != null && aek.aMt() != null) {
            String name = aek.aMt().getName();
            String id = aek.aMt().getId();
            if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                this.cpZ.kj(str);
                aek.aMt().setLike(0);
                this.cpZ.jn(0);
                rVar2 = this.cpZ.cbE;
                rVar2.P(true);
                this.cpZ.d(false, id);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, id));
                com.baidu.tieba.tbadkCore.t tVar = new com.baidu.tieba.tbadkCore.t();
                tVar.setLike(0);
                tVar.setFid(id);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void j(String str, long j) {
    }
}
