package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.model.h {
    final /* synthetic */ a aqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aqc = aVar;
    }

    @Override // com.baidu.tieba.model.h
    public void a(BubbleListData bubbleListData) {
        com.baidu.tieba.model.e eVar;
        com.baidu.tieba.model.e eVar2;
        com.baidu.tieba.model.e eVar3;
        com.baidu.tieba.model.e eVar4;
        com.baidu.tieba.model.e eVar5;
        com.baidu.tieba.model.e eVar6;
        com.baidu.tieba.model.e eVar7;
        Context context;
        Context context2;
        if (bubbleListData == null) {
            this.aqc.Cu().Cy();
            return;
        }
        this.aqc.apX = bubbleListData.m252clone();
        eVar = this.aqc.apW;
        if (eVar.Te() > 0) {
            List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
            if (b_info != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        eVar3 = this.aqc.apW;
                        if (bcode == eVar3.Te()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            eVar4 = this.aqc.apW;
                            eVar5 = this.aqc.apW;
                            eVar4.gy(eVar5.Te());
                            eVar6 = this.aqc.apW;
                            eVar7 = this.aqc.apW;
                            int Te = eVar7.Te();
                            context = this.aqc.mContext;
                            int n = com.baidu.adp.lib.util.m.n(context);
                            context2 = this.aqc.mContext;
                            eVar6.p(Te, n, com.baidu.adp.lib.util.m.o(context2));
                        } else {
                            continue;
                        }
                    }
                }
                eVar2 = this.aqc.apW;
                eVar2.gz(-1);
            } else {
                return;
            }
        }
        this.aqc.AZ();
        this.aqc.Cu().b(this.aqc);
    }

    @Override // com.baidu.tieba.model.h
    public void b(BubbleListData bubbleListData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        this.aqc.aqa = false;
        this.aqc.apX = null;
        if (bubbleListData == null) {
            context = this.aqc.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.y.neterror);
        } else if (bubbleListData.getError_code().equals("0")) {
            context2 = this.aqc.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.y.neterror);
        } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
            context4 = this.aqc.mContext;
            UtilHelper.showToast(context4, bubbleListData.getError_msg());
        } else {
            context3 = this.aqc.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.y.neterror);
        }
        if (this.aqc.Cu() != null) {
            this.aqc.Cu().Cy();
        }
    }
}
