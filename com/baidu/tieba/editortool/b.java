package com.baidu.tieba.editortool;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.model.i {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.model.i
    public void a(BubbleListData bubbleListData) {
        if (bubbleListData == null) {
            this.a.i().b();
            return;
        }
        this.a.b = bubbleListData.m253clone();
        if (this.a.a.b() > 0) {
            this.a.a.a(this.a.a.b());
            this.a.a.a(this.a.a.b(), 0, 0);
            this.a.a.b(-1);
        }
        this.a.k();
        this.a.i().a(this.a);
    }

    @Override // com.baidu.tieba.model.i
    public void b(BubbleListData bubbleListData) {
        this.a.h = false;
        this.a.b = null;
        if (bubbleListData != null) {
            if (!bubbleListData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(bubbleListData.getError_msg())) {
                    UtilHelper.showToast(this.a.d, bubbleListData.getError_msg());
                } else {
                    UtilHelper.showToast(this.a.d, com.baidu.tieba.u.neterror);
                }
            } else {
                UtilHelper.showToast(this.a.d, com.baidu.tieba.u.neterror);
            }
        } else {
            UtilHelper.showToast(this.a.d, com.baidu.tieba.u.neterror);
        }
        if (this.a.i() != null) {
            this.a.i().b();
        }
    }
}
