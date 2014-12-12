package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class l extends CustomMessageListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i) {
        super(i);
        this.aCV = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        bq bqVar;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        String str2;
        com.baidu.tieba.tbadkCore.e eVar3;
        String str3;
        String str4;
        bq bqVar2;
        bq bqVar3;
        String str5;
        bq bqVar4;
        String str6;
        String str7;
        bq bqVar5;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        bq bqVar6;
        String str8;
        bq bqVar7;
        com.baidu.tieba.tbadkCore.e eVar6;
        com.baidu.tieba.tbadkCore.e eVar7;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            str = this.aCV.mPageType;
            if (str != null) {
                bqVar = this.aCV.aBX;
                if (bqVar != null) {
                    eVar = this.aCV.aCh;
                    if (eVar != null) {
                        eVar2 = this.aCV.aCh;
                        if (eVar2.aej() != null) {
                            if (booleanValue) {
                                str6 = this.aCV.mPageType;
                                if (str6.equals("normal_page")) {
                                    bqVar7 = this.aCV.aBX;
                                    eVar6 = this.aCV.aCh;
                                    ForumData aej = eVar6.aej();
                                    eVar7 = this.aCV.aCh;
                                    bqVar7.b(1, aej, eVar7, false);
                                } else {
                                    str7 = this.aCV.mPageType;
                                    if (str7.equals("frs_page")) {
                                        bqVar5 = this.aCV.aBX;
                                        eVar4 = this.aCV.aCh;
                                        ForumData aej2 = eVar4.aej();
                                        eVar5 = this.aCV.aCh;
                                        bqVar5.a(1, aej2, eVar5, false);
                                    }
                                }
                                bqVar6 = this.aCV.aBX;
                                bqVar6.bR(true);
                                TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                                str8 = this.aCV.aBP;
                                m255getInst.addLikeForum(str8);
                                return;
                            }
                            com.baidu.tieba.tbadkCore.d aed = com.baidu.tieba.tbadkCore.d.aed();
                            str2 = this.aCV.aBP;
                            aed.C(str2, false);
                            eVar3 = this.aCV.aCh;
                            eVar3.aej().setLike(0);
                            str3 = this.aCV.mPageType;
                            if (str3.equals("normal_page")) {
                                bqVar4 = this.aCV.aBX;
                                bqVar4.eR(0);
                            } else {
                                str4 = this.aCV.mPageType;
                                if (str4.equals("frs_page")) {
                                    bqVar2 = this.aCV.aBX;
                                    bqVar2.eS(0);
                                }
                            }
                            bqVar3 = this.aCV.aBX;
                            bqVar3.bR(false);
                            TbadkCoreApplication m255getInst2 = TbadkCoreApplication.m255getInst();
                            str5 = this.aCV.aBP;
                            m255getInst2.delLikeForum(str5);
                        }
                    }
                }
            }
        }
    }
}
