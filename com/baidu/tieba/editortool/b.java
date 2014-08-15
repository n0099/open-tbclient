package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.model.h {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
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
            this.a.i().b();
            return;
        }
        this.a.c = bubbleListData.m253clone();
        eVar = this.a.b;
        if (eVar.b() > 0) {
            List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
            if (b_info != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null) {
                        int bcode = bubbleData.getBcode();
                        eVar3 = this.a.b;
                        if (bcode == eVar3.b()) {
                            if (!bubbleData.canUse() && !bubbleData.isFree()) {
                                break;
                            }
                            eVar4 = this.a.b;
                            eVar5 = this.a.b;
                            eVar4.a(eVar5.b());
                            eVar6 = this.a.b;
                            eVar7 = this.a.b;
                            int b = eVar7.b();
                            context = this.a.d;
                            int b2 = com.baidu.adp.lib.util.j.b(context);
                            context2 = this.a.d;
                            eVar6.a(b, b2, com.baidu.adp.lib.util.j.c(context2));
                        } else {
                            continue;
                        }
                    }
                }
                eVar2 = this.a.b;
                eVar2.b(-1);
            } else {
                return;
            }
        }
        this.a.k();
        this.a.i().a(this.a);
    }

    @Override // com.baidu.tieba.model.h
    public void b(BubbleListData bubbleListData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        this.a.g = false;
        this.a.c = null;
        if (bubbleListData == null) {
            context = this.a.d;
            UtilHelper.showToast(context, com.baidu.tieba.x.neterror);
        } else if (bubbleListData.getError_code().equals("0")) {
            context2 = this.a.d;
            UtilHelper.showToast(context2, com.baidu.tieba.x.neterror);
        } else if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
            context4 = this.a.d;
            UtilHelper.showToast(context4, bubbleListData.getError_msg());
        } else {
            context3 = this.a.d;
            UtilHelper.showToast(context3, com.baidu.tieba.x.neterror);
        }
        if (this.a.i() != null) {
            this.a.i().b();
        }
    }
}
