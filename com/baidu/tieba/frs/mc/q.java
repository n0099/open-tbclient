package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p ceL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.ceL = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        y yVar6;
        y yVar7;
        y yVar8;
        y yVar9;
        y yVar10;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
            yVar = this.ceL.bVk;
            if (yVar != null) {
                yVar2 = this.ceL.bVk;
                if (yVar2.ZY() != null) {
                    yVar3 = this.ceL.bVk;
                    if (yVar3.ZY().acK() != null) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            yVar4 = this.ceL.bVk;
                            ArrayList<com.baidu.adp.widget.ListView.v> threadList = yVar4.ZY().acK().getThreadList();
                            this.ceL.e(optString, threadList);
                            p pVar = this.ceL;
                            yVar5 = this.ceL.bVk;
                            pVar.e(optString, yVar5.aad().getListView().getData());
                            yVar6 = this.ceL.bVk;
                            yVar6.ZY().je(optString);
                            yVar7 = this.ceL.bVk;
                            if (yVar7.aad() != null) {
                                yVar9 = this.ceL.bVk;
                                if (yVar9.aad().aaR() != null) {
                                    yVar10 = this.ceL.bVk;
                                    yVar10.aad().aaR().notifyDataSetChanged();
                                }
                            }
                            if (threadList != null && threadList.size() < 5) {
                                yVar8 = this.ceL.bVk;
                                yVar8.LS();
                            }
                        }
                    }
                }
            }
        }
    }
}
