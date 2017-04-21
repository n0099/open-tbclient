package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p caH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.caH = pVar;
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
            yVar = this.caH.bQu;
            if (yVar != null) {
                yVar2 = this.caH.bQu;
                if (yVar2.ZU() != null) {
                    yVar3 = this.caH.bQu;
                    if (yVar3.ZU().adz() != null) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            yVar4 = this.caH.bQu;
                            ArrayList<com.baidu.adp.widget.ListView.v> threadList = yVar4.ZU().adz().getThreadList();
                            this.caH.e(optString, threadList);
                            p pVar = this.caH;
                            yVar5 = this.caH.bQu;
                            pVar.e(optString, yVar5.aab().getListView().getData());
                            yVar6 = this.caH.bQu;
                            yVar6.ZU().iP(optString);
                            yVar7 = this.caH.bQu;
                            if (yVar7.aab() != null) {
                                yVar9 = this.caH.bQu;
                                if (yVar9.aab().abf() != null) {
                                    yVar10 = this.caH.bQu;
                                    yVar10.aab().abf().notifyDataSetChanged();
                                }
                            }
                            if (threadList != null && threadList.size() < 5) {
                                yVar8 = this.caH.bQu;
                                yVar8.aaw();
                            }
                        }
                    }
                }
            }
        }
    }
}
