package com.baidu.tieba.editortool;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.model.g {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.model.g
    public void a(BubbleListData bubbleListData) {
        if (bubbleListData == null) {
            this.a.i().b();
            return;
        }
        this.a.b = bubbleListData.m253clone();
        if (this.a.a.b() > 0) {
            List<BubbleListData.BubbleData> b_info = bubbleListData.getB_info();
            if (b_info != null && b_info.size() != 0) {
                for (BubbleListData.BubbleData bubbleData : b_info) {
                    if (bubbleData != null && bubbleData.getBcode() == this.a.a.b()) {
                        if (!bubbleData.canUse() && !bubbleData.isFree()) {
                            break;
                        }
                        this.a.a.a(this.a.a.b());
                        this.a.a.a(this.a.a.b(), com.baidu.adp.lib.util.j.b(this.a.d), com.baidu.adp.lib.util.j.c(this.a.d));
                    }
                }
                this.a.a.b(-1);
            } else {
                return;
            }
        }
        this.a.k();
        this.a.i().a(this.a);
    }

    @Override // com.baidu.tieba.model.g
    public void b(BubbleListData bubbleListData) {
        this.a.h = false;
        this.a.b = null;
        if (bubbleListData != null) {
            if (!bubbleListData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    UtilHelper.showToast(this.a.d, bubbleListData.getError_msg());
                } else {
                    UtilHelper.showToast(this.a.d, com.baidu.tieba.y.neterror);
                }
            } else {
                UtilHelper.showToast(this.a.d, com.baidu.tieba.y.neterror);
            }
        } else {
            UtilHelper.showToast(this.a.d, com.baidu.tieba.y.neterror);
        }
        if (this.a.i() != null) {
            this.a.i().b();
        }
    }
}
