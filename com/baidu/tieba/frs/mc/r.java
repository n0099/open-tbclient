package com.baidu.tieba.frs.mc;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ q cmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(q qVar, int i) {
        super(i);
        this.cmZ = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        ab abVar6;
        ab abVar7;
        ab abVar8;
        ab abVar9;
        ab abVar10;
        ab abVar11;
        ab abVar12;
        ab abVar13;
        int a;
        ab abVar14;
        ab abVar15;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
            abVar = this.cmZ.cdt;
            if (abVar != null) {
                abVar2 = this.cmZ.cdt;
                if (abVar2.adP() != null) {
                    abVar3 = this.cmZ.cdt;
                    if (abVar3.adP().agC() != null) {
                        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
                        if (!StringUtils.isNull(optString)) {
                            boolean z = false;
                            abVar4 = this.cmZ.cdt;
                            if (abVar4.adU() != null) {
                                abVar12 = this.cmZ.cdt;
                                if (abVar12.adU().aeI() != null) {
                                    q qVar = this.cmZ;
                                    abVar13 = this.cmZ.cdt;
                                    a = qVar.a(optString, abVar13.adU().getListView());
                                    abVar14 = this.cmZ.cdt;
                                    View childAt = abVar14.adU().getListView().getChildAt(a);
                                    if (childAt == null) {
                                        abVar15 = this.cmZ.cdt;
                                        abVar15.adU().aeI().notifyDataSetChanged();
                                    } else {
                                        this.cmZ.ai(childAt);
                                        z = true;
                                    }
                                }
                            }
                            abVar5 = this.cmZ.cdt;
                            ArrayList<com.baidu.adp.widget.ListView.v> threadList = abVar5.adP().agC().getThreadList();
                            this.cmZ.e(optString, threadList);
                            q qVar2 = this.cmZ;
                            abVar6 = this.cmZ.cdt;
                            qVar2.e(optString, abVar6.adU().getListView().getData());
                            abVar7 = this.cmZ.cdt;
                            abVar7.adP().kb(optString);
                            if (!z) {
                                abVar9 = this.cmZ.cdt;
                                if (abVar9.adU() != null) {
                                    abVar10 = this.cmZ.cdt;
                                    if (abVar10.adU().aeI() != null) {
                                        abVar11 = this.cmZ.cdt;
                                        abVar11.adU().aeI().notifyDataSetChanged();
                                    }
                                }
                            }
                            if (threadList != null && threadList.size() < 5) {
                                abVar8 = this.cmZ.cdt;
                                abVar8.MG();
                            }
                        }
                    }
                }
            }
        }
    }
}
