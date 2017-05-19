package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p bYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.bYz = pVar;
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
            yVar = this.bYz.bPu;
            if (yVar != null) {
                yVar2 = this.bYz.bPu;
                if (yVar2.YU() != null) {
                    yVar3 = this.bYz.bPu;
                    if (yVar3.YU().abG() != null) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            yVar4 = this.bYz.bPu;
                            ArrayList<com.baidu.adp.widget.ListView.v> threadList = yVar4.YU().abG().getThreadList();
                            this.bYz.e(optString, threadList);
                            p pVar = this.bYz;
                            yVar5 = this.bYz.bPu;
                            pVar.e(optString, yVar5.YZ().getListView().getData());
                            yVar6 = this.bYz.bPu;
                            yVar6.YU().iW(optString);
                            yVar7 = this.bYz.bPu;
                            if (yVar7.YZ() != null) {
                                yVar9 = this.bYz.bPu;
                                if (yVar9.YZ().ZO() != null) {
                                    yVar10 = this.bYz.bPu;
                                    yVar10.YZ().ZO().notifyDataSetChanged();
                                }
                            }
                            if (threadList != null && threadList.size() < 5) {
                                yVar8 = this.bYz.bPu;
                                yVar8.Zs();
                            }
                        }
                    }
                }
            }
        }
    }
}
