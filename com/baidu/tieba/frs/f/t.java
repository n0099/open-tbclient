package com.baidu.tieba.frs.f;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f {
    final /* synthetic */ m cpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar) {
        this.cpZ = mVar;
    }

    @Override // com.baidu.adp.base.f
    public void g(Object obj) {
        LikeModel likeModel;
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.tbadkCore.t tVar;
        LikeModel likeModel2;
        LikeModel likeModel3;
        com.baidu.tieba.frs.r rVar2;
        LikeModel likeModel4;
        LikeModel likeModel5;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        boolean z;
        com.baidu.tieba.frs.r rVar5;
        LikeModel likeModel6;
        LikeModel likeModel7;
        likeModel = this.cpZ.bAL;
        if (!AntiHelper.sK(likeModel.getErrorCode())) {
            rVar = this.cpZ.cbE;
            com.baidu.tieba.tbadkCore.n aek = rVar.aek();
            if (aek != null && aek.aMt() != null && obj != null) {
                String name = aek.aMt().getName();
                String id = aek.aMt().getId();
                boolean z2 = false;
                if (!(obj instanceof com.baidu.tieba.tbadkCore.t)) {
                    tVar = null;
                } else {
                    tVar = (com.baidu.tieba.tbadkCore.t) obj;
                }
                if (tVar != null) {
                    likeModel6 = this.cpZ.bAL;
                    if (likeModel6.getErrorCode() == 0) {
                        z2 = true;
                    }
                }
                if (tVar == null || !z2) {
                    likeModel2 = this.cpZ.bAL;
                    if (likeModel2.getErrorCode() == 22) {
                        rVar3 = this.cpZ.cbE;
                        rVar3.showToast(this.cpZ.getPageContext().getString(w.l.had_liked_forum));
                    } else {
                        likeModel3 = this.cpZ.bAL;
                        if (!AntiHelper.sK(likeModel3.getErrorCode())) {
                            rVar2 = this.cpZ.cbE;
                            likeModel4 = this.cpZ.bAL;
                            rVar2.showToast(likeModel4.getErrorString());
                        } else {
                            Activity pageActivity = this.cpZ.getPageContext().getPageActivity();
                            likeModel5 = this.cpZ.bAL;
                            AntiHelper.ar(pageActivity, likeModel5.getErrorString());
                        }
                    }
                } else {
                    this.cpZ.kj(name);
                    tVar.setLike(1);
                    aek.c(tVar);
                    aek.cQ(tVar.bkv());
                    m mVar = this.cpZ;
                    z = this.cpZ.cpV;
                    mVar.a(aek, z);
                    this.cpZ.cpV = true;
                    rVar5 = this.cpZ.cbE;
                    rVar5.showToast(this.cpZ.getPageContext().getResources().getString(w.l.attention_success));
                    this.cpZ.d(true, id);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
                }
                rVar4 = this.cpZ.cbE;
                rVar4.Q(Boolean.valueOf(z2));
                return;
            }
            return;
        }
        Activity pageActivity2 = this.cpZ.getPageContext().getPageActivity();
        likeModel7 = this.cpZ.bAL;
        AntiHelper.ar(pageActivity2, likeModel7.getErrorString());
    }
}
