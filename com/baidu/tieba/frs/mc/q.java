package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p bYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.bYq = pVar;
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
            yVar = this.bYq.bOd;
            if (yVar != null) {
                yVar2 = this.bYq.bOd;
                if (yVar2.YT() != null) {
                    yVar3 = this.bYq.bOd;
                    if (yVar3.YT().acy() != null) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            yVar4 = this.bYq.bOd;
                            ArrayList<com.baidu.adp.widget.ListView.v> threadList = yVar4.YT().acy().getThreadList();
                            this.bYq.e(optString, threadList);
                            p pVar = this.bYq;
                            yVar5 = this.bYq.bOd;
                            pVar.e(optString, yVar5.Za().getListView().getData());
                            yVar6 = this.bYq.bOd;
                            yVar6.YT().iO(optString);
                            yVar7 = this.bYq.bOd;
                            if (yVar7.Za() != null) {
                                yVar9 = this.bYq.bOd;
                                if (yVar9.Za().aae() != null) {
                                    yVar10 = this.bYq.bOd;
                                    yVar10.Za().aae().notifyDataSetChanged();
                                }
                            }
                            if (threadList != null && threadList.size() < 5) {
                                yVar8 = this.bYq.bOd;
                                yVar8.Zv();
                            }
                        }
                    }
                }
            }
        }
    }
}
