package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ o bZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, int i) {
        super(i);
        this.bZP = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        w wVar7;
        w wVar8;
        w wVar9;
        w wVar10;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
            wVar = this.bZP.bOo;
            if (wVar != null) {
                wVar2 = this.bZP.bOo;
                if (wVar2.Yx() != null) {
                    wVar3 = this.bZP.bOo;
                    if (wVar3.Yx().acc() != null) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            wVar4 = this.bZP.bOo;
                            ArrayList<com.baidu.adp.widget.ListView.v> threadList = wVar4.Yx().acc().getThreadList();
                            this.bZP.e(optString, threadList);
                            o oVar = this.bZP;
                            wVar5 = this.bZP.bOo;
                            oVar.e(optString, wVar5.YE().getListView().getData());
                            wVar6 = this.bZP.bOo;
                            wVar6.Yx().iK(optString);
                            wVar7 = this.bZP.bOo;
                            if (wVar7.YE() != null) {
                                wVar9 = this.bZP.bOo;
                                if (wVar9.YE().ZG() != null) {
                                    wVar10 = this.bZP.bOo;
                                    wVar10.YE().ZG().notifyDataSetChanged();
                                }
                            }
                            if (threadList != null && threadList.size() < 5) {
                                wVar8 = this.bZP.bOo;
                                wVar8.YZ();
                            }
                        }
                    }
                }
            }
        }
    }
}
