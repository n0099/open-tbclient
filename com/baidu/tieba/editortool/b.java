package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.model.h {
    final /* synthetic */ a aql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aql = aVar;
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
            this.aql.Cw().CA();
            return;
        }
        this.aql.aqg = bubbleListData.m252clone();
        eVar = this.aql.aqf;
        if (eVar.Th() > 0) {
            List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
            if (b_info != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        eVar3 = this.aql.aqf;
                        if (bcode == eVar3.Th()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            eVar4 = this.aql.aqf;
                            eVar5 = this.aql.aqf;
                            eVar4.gy(eVar5.Th());
                            eVar6 = this.aql.aqf;
                            eVar7 = this.aql.aqf;
                            int Th = eVar7.Th();
                            context = this.aql.mContext;
                            int n = com.baidu.adp.lib.util.m.n(context);
                            context2 = this.aql.mContext;
                            eVar6.p(Th, n, com.baidu.adp.lib.util.m.o(context2));
                        } else {
                            continue;
                        }
                    }
                }
                eVar2 = this.aql.aqf;
                eVar2.gz(-1);
            } else {
                return;
            }
        }
        this.aql.Bb();
        this.aql.Cw().b(this.aql);
    }

    @Override // com.baidu.tieba.model.h
    public void b(BubbleListData bubbleListData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        this.aql.aqj = false;
        this.aql.aqg = null;
        if (bubbleListData == null) {
            context = this.aql.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.y.neterror);
        } else if (bubbleListData.getError_code().equals("0")) {
            context2 = this.aql.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.y.neterror);
        } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
            context4 = this.aql.mContext;
            UtilHelper.showToast(context4, bubbleListData.getError_msg());
        } else {
            context3 = this.aql.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.y.neterror);
        }
        if (this.aql.Cw() != null) {
            this.aql.Cw().CA();
        }
    }
}
